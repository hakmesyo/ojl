/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jazari.deep_learning.ai.djl.examples.denemeler.pistachio_classification;

import ai.djl.Model;
import ai.djl.basicdataset.cv.classification.ImageFolder;
import ai.djl.metric.Metrics;
import ai.djl.modality.cv.transform.Resize;
import ai.djl.modality.cv.transform.ToTensor;
import ai.djl.ndarray.types.Shape;
import ai.djl.training.DefaultTrainingConfig;
import ai.djl.training.EasyTrain;
import ai.djl.training.Trainer;
import ai.djl.training.TrainingConfig;
import ai.djl.training.TrainingResult;
import ai.djl.training.dataset.RandomAccessDataset;
import ai.djl.training.evaluator.Accuracy;
import ai.djl.training.listener.TrainingListener;
import ai.djl.training.loss.Loss;
import ai.djl.translate.TranslateException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * In training, multiple passes (or epochs) are made over the training data
 * trying to find patterns and trends in the data, which are then stored in the
 * model. During the process, the model is evaluated for accuracy using the
 * validation data. The model is updated with findings over each epoch, which
 * improves the accuracy of the model.
 */
public final class Train {

    // represents number of training samples processed before the model is updated
//    private static final int BATCH_SIZE = 8;
//    private static final int BATCH_SIZE = 16;
    private static final int BATCH_SIZE = 64;

    // the number of passes over the complete dataset
    private static final int EPOCHS = 10;

    public static void main(String[] args) throws IOException, TranslateException {
        System.setProperty("DJL_CACHE_DIR", "c:/ai/djl");
        // the location to save the model
        Path modelDir = Paths.get("models");

        // create ImageFolder dataset from directory
        ImageFolder dataset = initDataset("c:/ai/djl/pistachio_train");
        // Split the dataset set into training dataset and validate dataset
        RandomAccessDataset[] datasets = dataset.randomSplit(10, 0);

        Model model = Models.getModel(Models.NUM_OF_OUTPUT, Models.IMAGE_WIDTH, Models.IMAGE_HEIGHT); // empty model instance to hold patterns
        
        Trainer trainer = Models.getTrainer();// 
        // metrics collect and report key performance indicators, like accuracy
        trainer.setMetrics(new Metrics());

        System.out.println("model:" + model.getBlock());

        Shape inputShape = new Shape(1, 3, Models.IMAGE_HEIGHT, Models.IMAGE_HEIGHT);

        // initialize trainer with proper input shape
        trainer.initialize(inputShape);

        // find the patterns in data
        EasyTrain.fit(trainer, EPOCHS, datasets[0], datasets[1]);

        // set model properties
        TrainingResult result = trainer.getTrainingResult();
        model.setProperty("Epoch", String.valueOf(EPOCHS));
        model.setProperty(
                "Accuracy", String.format("%.5f", result.getValidateEvaluation("Accuracy")));
        model.setProperty("Loss", String.format("%.5f", result.getValidateLoss()));

        // save the model after done training for inference later
        // model saved as shoeclassifier-0000.params
        model.save(modelDir, Models.MODEL_NAME);

        // save labels into model directory
        Models.saveSynset(modelDir, dataset.getSynset());
    }

    private static ImageFolder initDataset(String datasetRoot) throws IOException, TranslateException {
        ImageFolder dataset
                = ImageFolder.builder()
                        // retrieve the data
                        .setRepositoryPath(Paths.get(datasetRoot))
                        .optMaxDepth(10)
                        .addTransform(new Resize(Models.IMAGE_WIDTH, Models.IMAGE_HEIGHT))
                        .addTransform(new ToTensor())
                        // random sampling; don't process the data in order
                        .setSampling(BATCH_SIZE, true)
                        .build();

        dataset.prepare();
        return dataset;
    }

    private static TrainingConfig setupTrainingConfig(Loss loss) {
        return new DefaultTrainingConfig(loss)
                .addEvaluator(new Accuracy())
                .addTrainingListeners(TrainingListener.Defaults.logging());
    }

}

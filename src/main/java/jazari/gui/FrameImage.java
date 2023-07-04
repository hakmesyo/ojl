/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jazari.gui;

import jazari.utils.DataAnalytics;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import jazari.matrix.CMatrix;
import jazari.factory.FactoryUtils;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jazari.image_processing.ImageProcess;

/**
 *
 * @author BAP1
 */
public class FrameImage extends javax.swing.JFrame {

    static {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FlatLaf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BufferedImage img;
    int pw = 100;
    int ph = 150;
    public String imagePath;
    public String imageFolderPath;

    /**
     * Creates new form FrameImage
     */
    public FrameImage() {
        initComponents();
        eventListener();
        //isSequence.setVisible(false);

//        getPicturePanel().setFrame(this);
    }

    /**
     * Draws A Picture Frame
     *
     * @param cm : image to be drawn
     * @param imagePath : image path
     */
    public FrameImage(CMatrix cm, String imagePath, String caption) {
        initComponents();
        imageFolderPath = FactoryUtils.getFolderPath(imagePath);
        loadImage(cm, imagePath, caption);
        eventListener();
        isPolygon.setSelected(true);
        isLabelVisible.setSelected(true);
    }

    public void setImage(BufferedImage img, String imagePath, String caption) {
        this.img = img;
        this.imagePath = imagePath;
        imageFolderPath = FactoryUtils.getFolderPath(imagePath);
        getPicturePanel().setImage(this.img, imagePath, caption);
        getPicturePanel().setFrame(this);
        //this.setSize(img.getWidth() + 300, img.getHeight() + 183);
        String[] s = FactoryUtils.splitPath(imagePath);
        this.setTitle(s[s.length - 1]);
        //this.setTitle(imagePath + "/" + caption);
    }

    public void setImage(BufferedImage img) {
        this.img = img;
        setImage(this.img, "", "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPicture = new jazari.gui.PanelPicture(this);
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        btn_dataGrid = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        txt_dpi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        isBBox = new javax.swing.JCheckBox();
        isSequence = new javax.swing.JCheckBox();
        isPolygon = new javax.swing.JCheckBox();
        lbl_zoom_factor = new javax.swing.JLabel();
        btn_dashedLineColor = new javax.swing.JButton();
        isLabelVisible = new javax.swing.JCheckBox();
        btn_analytics = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        panelPicture.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelPicture.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelPictureKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelPictureLayout = new javax.swing.GroupLayout(panelPicture);
        panelPicture.setLayout(panelPictureLayout);
        panelPictureLayout.setHorizontalGroup(
            panelPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelPictureLayout.setVerticalGroup(
            panelPictureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_dataGrid.setText("Data Grid");
        btn_dataGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dataGridActionPerformed(evt);
            }
        });

        btn_save.setText("Save As");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        txt_dpi.setText("96");

        jLabel2.setText("dpi");

        isBBox.setText("bbox");
        isBBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                isBBoxItemStateChanged(evt);
            }
        });
        isBBox.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                isBBoxMouseMoved(evt);
            }
        });
        isBBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isBBoxActionPerformed(evt);
            }
        });

        isSequence.setText("sequence");
        isSequence.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                isSequenceItemStateChanged(evt);
            }
        });
        isSequence.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                isSequenceMouseMoved(evt);
            }
        });
        isSequence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isSequenceActionPerformed(evt);
            }
        });

        isPolygon.setText("polygon");
        isPolygon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                isPolygonItemStateChanged(evt);
            }
        });
        isPolygon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                isPolygonMouseMoved(evt);
            }
        });
        isPolygon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isPolygonActionPerformed(evt);
            }
        });

        lbl_zoom_factor.setText("zoom factor:1");

        btn_dashedLineColor.setText("color");
        btn_dashedLineColor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_dashedLineColorMouseMoved(evt);
            }
        });
        btn_dashedLineColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dashedLineColorActionPerformed(evt);
            }
        });

        isLabelVisible.setText("show label");
        isLabelVisible.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                isLabelVisibleİtemStateChanged(evt);
            }
        });
        isLabelVisible.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                isLabelVisibleMouseMoved(evt);
            }
        });

        btn_analytics.setText("analytics");
        btn_analytics.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_analyticsMouseMoved(evt);
            }
        });
        btn_analytics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_analyticsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btn_dataGrid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dpi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(isBBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isPolygon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isSequence)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isLabelVisible)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_dashedLineColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_analytics)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_zoom_factor)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dataGrid)
                    .addComponent(btn_save)
                    .addComponent(txt_dpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(isBBox)
                    .addComponent(isSequence)
                    .addComponent(isPolygon)
                    .addComponent(lbl_zoom_factor)
                    .addComponent(btn_dashedLineColor)
                    .addComponent(isLabelVisible)
                    .addComponent(btn_analytics))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dataGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dataGridActionPerformed
        CMatrix cm = CMatrix.getInstance(((PanelPicture) panelPicture).getImage());
//        CMatrix cm = CMatrix.getInstance(img);
        new FrameDataGrid(cm).setVisible(true);
    }//GEN-LAST:event_btn_dataGridActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        saveImageAs();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void panelPictureKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelPictureKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelPictureKeyPressed

    private void isBBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_isBBoxItemStateChanged
        getPicturePanel().activateBoundingBox = isBBox.isSelected();
        getPicturePanel().activatePolygon = isPolygon.isSelected();
        getPicturePanel().setImage(this.img, imagePath, this.getTitle());
        //isSequence.setVisible(isBBox.isSelected());
        getPicturePanel().requestFocus();
    }//GEN-LAST:event_isBBoxItemStateChanged

    private void isBBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isBBoxActionPerformed
        if (isBBox.isSelected()) {
            //FactoryUtils.showMessage("Use Arrow Keys to locate prev and next images.\nPress S to save bboxes and go to next image.\nDouble click on bbox to change attributes");
            isPolygon.setSelected(false);
        }
    }//GEN-LAST:event_isBBoxActionPerformed

    private void isSequenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isSequenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isSequenceActionPerformed

    private void isSequenceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_isSequenceItemStateChanged
        getPicturePanel().isSeqenceVideoFrame = isSequence.isSelected();
        getPicturePanel().requestFocus();
    }//GEN-LAST:event_isSequenceItemStateChanged

    private void isBBoxMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_isBBoxMouseMoved
        isBBox.setToolTipText("Activates BoundingBox annotation for object detection\nUse Arrow Keys to locate prev and next images.\nPress S to save bboxes and go to next image.\nDouble click on bbox to change attributes\nPress Delete key to delete");
    }//GEN-LAST:event_isBBoxMouseMoved

    private void isSequenceMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_isSequenceMouseMoved
        isSequence.setToolTipText("Check if your images are similar to the video sequences/frames.\nPreserves bboxes or polygons from previous image");
    }//GEN-LAST:event_isSequenceMouseMoved

    private void isPolygonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_isPolygonItemStateChanged
        getPicturePanel().activatePolygon = isPolygon.isSelected();
        getPicturePanel().activateBoundingBox = isBBox.isSelected();
        getPicturePanel().setImage(this.img, imagePath, this.getTitle());
        getPicturePanel().requestFocus();
    }//GEN-LAST:event_isPolygonItemStateChanged

    private void isPolygonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_isPolygonMouseMoved
        isPolygon.setToolTipText("Activates Polygon annotation for image segmentation\nUse Arrow Keys to locate prev and next images.\nPress S to save polygon and go to next image.\nDouble click on polygon to change attributes\nPress Delete key to delete");
    }//GEN-LAST:event_isPolygonMouseMoved

    private void isPolygonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isPolygonActionPerformed
        if (isPolygon.isSelected()) {
            isBBox.setSelected(false);
        }
    }//GEN-LAST:event_isPolygonActionPerformed

    private void btn_dashedLineColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashedLineColorActionPerformed
        changeDashedLineColor();
    }//GEN-LAST:event_btn_dashedLineColorActionPerformed

    private void isLabelVisibleMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_isLabelVisibleMouseMoved
        isLabelVisible.setToolTipText("Hide or show labels on annotations");
    }//GEN-LAST:event_isLabelVisibleMouseMoved

    private void isLabelVisibleİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_isLabelVisibleİtemStateChanged
        getPicturePanel().activateLabelVisibility = isLabelVisible.isSelected();
        getPicturePanel().repaint();
        getPicturePanel().requestFocus();
    }//GEN-LAST:event_isLabelVisibleİtemStateChanged

    private void btn_dashedLineColorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashedLineColorMouseMoved
        btn_dashedLineColor.setToolTipText("Changes the dashed line color");
    }//GEN-LAST:event_btn_dashedLineColorMouseMoved

    private void btn_analyticsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_analyticsMouseMoved
        isPolygon.setToolTipText("show number of classes and percentages annotated so far");
    }//GEN-LAST:event_btn_analyticsMouseMoved

    private void btn_analyticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_analyticsActionPerformed
        if (FactoryUtils.isFileExist(imageFolderPath + "/class_labels.txt")) {
            List<DataAnalytics> lst = FactoryUtils.getDataAnalytics(imageFolderPath);
            FrameDataAnalytics frm = new FrameDataAnalytics(this, imageFolderPath, lst);
            frm.setVisible(true);

        }
    }//GEN-LAST:event_btn_analyticsActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    public PanelPicture getPicturePanel() {
        return ((PanelPicture) panelPicture);
    }

    public void saveImageAs() {
        String imagePath = FactoryUtils.saveImageAs(getPicturePanel().getImage(), txt_dpi.getText());
        CMatrix cm = CMatrix.getInstance().imread(imagePath);
        loadImage(cm, imagePath, imagePath);
    }

    public void setZoomFactor(double z) {
        lbl_zoom_factor.setText("zoom factor:" + FactoryUtils.formatFloat((float) z, 4));
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrameImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrameImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrameImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrameImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrameImage().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_analytics;
    private javax.swing.JButton btn_dashedLineColor;
    private javax.swing.JButton btn_dataGrid;
    private javax.swing.JButton btn_save;
    private javax.swing.JCheckBox isBBox;
    private javax.swing.JCheckBox isLabelVisible;
    private javax.swing.JCheckBox isPolygon;
    private javax.swing.JCheckBox isSequence;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_zoom_factor;
    private javax.swing.JPanel panelPicture;
    private javax.swing.JTextField txt_dpi;
    // End of variables declaration//GEN-END:variables

//    public void setFrameSize(BufferedImage img) {
//        if (img.getWidth() * img.getHeight() < 550 * 550) {
//            return;
//        }
//        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
//        pw = 30;
//        //pw = 70;
//        int w = img.getWidth() + 2 * pw + 90;
//        int h = img.getHeight() + 190;
//        if (w < size.width && h < size.height) {
//            this.setSize(w, h);
//        } else {
//            setMaximumSize(size);
//            setExtendedState(JFrame.MAXIMIZED_BOTH);
//        }
//        //this.pack();
//    }
    private void changeDashedLineColor() {
        getPicturePanel().setDashedLineColor();
    }

    private void loadImage(CMatrix cm, String imagePath, String caption) {
        String[] s = FactoryUtils.splitPath(imagePath);
        this.setTitle(s[s.length - 1]);

        this.img = cm.getImage();
        this.imagePath = imagePath;
        getPicturePanel().activateBoundingBox = isBBox.isSelected();
        if (img.getHeight() > 950) {
            float zoom_factor = 950.0f / img.getHeight();
            int w = (int) (img.getWidth() * zoom_factor);
            int h = (int) (img.getHeight() * zoom_factor);
            this.lbl_zoom_factor.setText("zoom factor:" + FactoryUtils.formatFloat(zoom_factor, 4));
            getPicturePanel().original_zoom_factor = FactoryUtils.formatFloat(zoom_factor, 4);
            getPicturePanel().rawImage = ImageProcess.clone(img);
            img = ImageProcess.resizeAspectRatio(img, w, h);
        }
        getPicturePanel().setImage(img, imagePath, caption);
        getPicturePanel().setFrame(this);
        //setFrameSize(img);
        getPicturePanel().setFocusable(true);
        getPicturePanel().requestFocusInWindow();
        //isSequence.setVisible(false);
    }

    private void eventListener() {
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent ev) {
                getPicturePanel().updateImageLocation();
            }
        });
    }
}

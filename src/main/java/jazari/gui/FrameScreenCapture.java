/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jazari.gui;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jazari.factory.FactoryUtils;
import jazari.image_processing.ImageProcess;
import jazari.interfaces.call_back_interface.CallBackTrigger;

/**
 *
 * @author cezerilab
 */
public class FrameScreenCapture extends javax.swing.JFrame {

    private BufferedImage screenshot;
    //private PanelPicture panel;
    public List<BufferedImage> listImage;
    public int fps = 10;
    public boolean isCaptureFromVideo = false;
    String tempDirName="a";

    /**
     * Creates new form FrameScreeCap
     *
     * @param panel
     */
    public FrameScreenCapture() {
        this.fps = 300;
        this.initComponents();
        //this.panel = panel;
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_capture_single_image = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_use = new javax.swing.JButton();
        btn_capture_video = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_fps = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        canvas = new PanelScreenCapture();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FrameScreenCapture");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_capture_single_image.setText("Capture Image");
        btn_capture_single_image.setToolTipText("Select region with mouse dragging");
        btn_capture_single_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capture_single_imageActionPerformed(evt);
            }
        });

        btn_save.setText("Save Images");
        btn_save.setToolTipText("Save image list to desired folder");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_use.setText("Copy / Use");
        btn_use.setToolTipText("You can copy image to clipboard and then use for other application by pasting there");
        btn_use.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_useActionPerformed(evt);
            }
        });

        btn_capture_video.setText("Capture from video");
        btn_capture_video.setToolTipText("Capture sequence images from videos or animations");
        btn_capture_video.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capture_videoActionPerformed(evt);
            }
        });

        jLabel1.setText("FPS:");
        jLabel1.setToolTipText("Sleep time per capture each frame");

        txt_fps.setText("10");
        txt_fps.setToolTipText("Sleep time per capture each frame");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_capture_video)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_fps, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_capture_single_image)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_use)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_use, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(txt_fps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_capture_single_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_capture_video)
                    .addComponent(btn_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        canvas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(canvas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_capture_single_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capture_single_imageActionPerformed
        isCaptureFromVideo = false;
        if (listImage != null) {
            listImage.clear();
        }
        setState(Frame.ICONIFIED);
        new FrameCaptureImage(this);
        this.toFront();
    }//GEN-LAST:event_btn_capture_single_imageActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if (isCaptureFromVideo) {
            String path = FactoryUtils.browseDirectory().getAbsolutePath();
            FactoryUtils.makeDirectory(path);
            File[] images = FactoryUtils.getFileArrayInFolderByExtension("images/temp/" + tempDirName, "jpg");
            for (File image : images) {
                FactoryUtils.copyFile(image, new File(path + "/" + image.getName()));
            }
//            for (BufferedImage img : listImage) {
//                ImageProcess.saveImage(img, path + "/" + System.currentTimeMillis() + ".jpg");
//            }
            //listImage.clear();
            FactoryUtils.removeDirectory("images/temp/" + tempDirName);
            screenshot = null;
            FactoryUtils.showMessage("Captured Video Frames saved successfully");
        } else if (screenshot != null) {
            if (ImageProcess.saveImage(screenshot)) {
                FactoryUtils.showMessage("Captured Image saved successfully");
            }
            screenshot = null;
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_useActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_useActionPerformed
        //panel.setImage(screenshot);
        FactoryUtils.copyImage2ClipBoard(screenshot);
        dispose();
    }//GEN-LAST:event_btn_useActionPerformed

    private void btn_capture_videoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capture_videoActionPerformed
        isCaptureFromVideo = true;
        tempDirName=System.currentTimeMillis()+"";
        FactoryUtils.makeDirectory("images");
        FactoryUtils.makeDirectory("images/temp");
        FactoryUtils.makeDirectory("images/temp/"+tempDirName);
        FrameScreenCapture frame = this;
        FactoryUtils.showMessage("For capturing with a specified fps\n"
                + "select a bounding box rectangle with mouse press --> drag --> release\n"
                + "type esc if you want to stop");
        setState(Frame.ICONIFIED);
        listImage = new ArrayList<>();
        fps = Integer.parseInt(txt_fps.getText());
        FrameCaptureVideo frm = new FrameCaptureVideo(frame);
        frm.setVisible(true);
        screenshot = null;

//        FrameScreenCapture scr = this;
//        FactoryUtils.showMessageTemp("For capturing with a specified fps"
//                + "select a bounding box rectangle with mouse press --> drag --> release"
//                + "type esc if you want to stop", 2000, new CallBackTrigger() {
//            @Override
//            public void trigger() {
//                setState(Frame.ICONIFIED);
//                listImage = new ArrayList<>();
//                tpf = Integer.parseInt(txt_tpf.getText());
//                FrameCaptureVideo frm = new FrameCaptureVideo(scr);
//                frm.setVisible(true);
//                screenshot = null;
//            }
//        });

    }//GEN-LAST:event_btn_capture_videoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        FactoryUtils.removeDirectory("images/temp/" + tempDirName);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        FactoryUtils.removeDirectory("images/temp/" + tempDirName);
    }//GEN-LAST:event_formWindowClosed

    public void setImage(final BufferedImage screenshot) {
        this.setState(0);
        this.screenshot = screenshot;
        this.getPanel().setImage(screenshot);
        if (screenshot.getWidth() > 480) {
            this.setPreferredSize(new Dimension(screenshot.getWidth() + 30, screenshot.getHeight() + 110));
        } else {
            this.setPreferredSize(new Dimension(500, 250));
        }
        this.invalidate();
        this.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public PanelScreenCapture getPanel() {
        return (PanelScreenCapture) this.canvas;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel((LookAndFeel) new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FrameScreenCapture.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameScreenCapture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_capture_single_image;
    private javax.swing.JButton btn_capture_video;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_use;
    private javax.swing.JPanel canvas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_fps;
    // End of variables declaration//GEN-END:variables
}

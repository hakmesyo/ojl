package jazari.app;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Component;
import javax.swing.TransferHandler;
import jazari.factory.FactoryUtils;
import jazari.matrix.CMatrix;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.JButton;
import java.awt.Image;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jazari.gui.FlatLaf;
import jazari.gui.FrameScreenCapture;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cezerilab
 */
public class Jazo extends javax.swing.JFrame {

    static {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FlatLaf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form JAnnotate
     */
    public Jazo() {
        initComponents();
        btn_open.setTransferHandler(new ImageTransferHandler());
        this.setTitle("Jazari Annotation Tool  [21.11.2024]");
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_open = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btn_screen_capture = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jazari Annotation Tool Version:21.11.2024");

        btn_open.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btn_open.setText("Open | Drag & Drop Image|Folder");
        btn_open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_screen_capture.setText("Screen Capture");
        btn_screen_capture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_screen_captureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_screen_capture, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_screen_capture, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_open, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_open, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openActionPerformed
        File pathFile = FactoryUtils.browseFileForImage();
        if (pathFile != null) {
            CMatrix cm = CMatrix.getInstance()
                    .imread(pathFile)
                    .imshow();
        }
    }//GEN-LAST:event_btn_openActionPerformed

    private void btn_screen_captureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_screen_captureActionPerformed
        FrameScreenCapture frm = new FrameScreenCapture();
        frm.setVisible(true);
    }//GEN-LAST:event_btn_screen_captureActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //FlatDarculaLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Jazo jazo = new Jazo();
                jazo.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_open;
    private javax.swing.JButton btn_screen_capture;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public static class ImageTransferHandler extends TransferHandler {

        public static final DataFlavor[] SUPPORTED_DATA_FLAVORS = new DataFlavor[]{
            DataFlavor.javaFileListFlavor,
            DataFlavor.imageFlavor
        };

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            boolean canImport = false;
            for (DataFlavor flavor : SUPPORTED_DATA_FLAVORS) {
                if (support.isDataFlavorSupported(flavor)) {
                    canImport = true;
                    break;
                }
            }
            return canImport;
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            boolean accept = false;
            if (canImport(support)) {
                try {
                    Transferable t = support.getTransferable();
                    Component component = support.getComponent();
                    if (component instanceof JButton) {
                        Image image = null;
                        if (support.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                            image = (Image) t.getTransferData(DataFlavor.imageFlavor);
                        } else if (support.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                            List files = (List) t.getTransferData(DataFlavor.javaFileListFlavor);
                            if (files.size() > 0) {
                                //image = ImageIO.read((File) files.get(0));
                                CMatrix cm = CMatrix.getInstance().imread((File) files.get(0)).imshow();

                            }
                        }
                        accept = true;
                    }
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
            return accept;
        }
    }
}

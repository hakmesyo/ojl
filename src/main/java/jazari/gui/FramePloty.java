/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jazari.gui;

import jazari.types.TFigureAttribute;
import jazari.image_processing.ImageProcess;
import jazari.matrix.CMatrix;
import jazari.factory.FactoryMatrix;
import jazari.factory.FactoryUtils;
import java.io.File;

/**
 *
 * @author BAP1
 */
public final class FramePloty extends javax.swing.JFrame {

    private CMatrix cm;
    private TFigureAttribute figureAttribute;
    private boolean isSort = true;

    public FramePloty(CMatrix cm) {
        this.cm = cm;
        initComponents();
        getPlotPanel().setRandomSeed(System.currentTimeMillis());
        getPlotPanel().setMatrix(cm);
        this.setTitle(cm.name+" :: Plot");
        cm.plotPanel=getPlotPanel();
    }
    
    public FramePloty(CMatrix cm,TFigureAttribute attr) {
        this.cm = cm;
        this.figureAttribute=attr;
        initComponents();
        getPlotPanel().setRandomSeed(System.currentTimeMillis());
        getPlotPanel().setMatrix(cm);
        getPlotPanel().setFigureAttribute(this.figureAttribute);
        this.setTitle(cm.name+" :: "+attr.figureCaption);
        cm.plotPanel=getPlotPanel();
    }
    
    public void setMatrix(CMatrix cm) {
        this.cm = cm;
        getPlotPanel().setRandomSeed(System.currentTimeMillis());
        getPlotPanel().setMatrix(cm);
        getPlotPanel().setFigureAttribute(this.figureAttribute);
        this.setTitle(cm.name+" :: "+"Ploty");
        cm.plotPanel=getPlotPanel();
    }
    
    public void setFigureAttribute(TFigureAttribute attr) {
        this.figureAttribute=attr;
        getPlotPanel().setRandomSeed(System.currentTimeMillis());
        getPlotPanel().setMatrix(cm);
        getPlotPanel().setFigureAttribute(this.figureAttribute);
        this.setTitle(cm.name+" :: "+attr.figureCaption);
        cm.plotPanel=getPlotPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_blob = new jazari.gui.PanelPloty();
        jPanel2 = new javax.swing.JPanel();
        btn_dataGrid = new javax.swing.JButton();
        btn_plot = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        txt_dpi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSort = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel_blob.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panel_blobLayout = new javax.swing.GroupLayout(panel_blob);
        panel_blob.setLayout(panel_blobLayout);
        panel_blobLayout.setHorizontalGroup(
            panel_blobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_blobLayout.setVerticalGroup(
            panel_blobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_dataGrid.setText("Data Grid");
        btn_dataGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dataGridActionPerformed(evt);
            }
        });

        btn_plot.setText("Plot");
        btn_plot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_plotActionPerformed(evt);
            }
        });

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        txt_dpi.setText("300");

        jLabel2.setText("dpi");

        btnSort.setText("sort");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btn_dataGrid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_plot, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_dpi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 353, Short.MAX_VALUE)
                .addComponent(btnSort)
                .addGap(89, 89, 89))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_save)
                .addComponent(txt_dpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_dataGrid)
                .addComponent(btn_plot)
                .addComponent(btnSort))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_blob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_blob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dataGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dataGridActionPerformed
        CMatrix cm = getPlotPanel().getMatrix();
        new FrameDataGrid(cm.toFloatArray2D(),false).setVisible(true);
    }//GEN-LAST:event_btn_dataGridActionPerformed

    private void btn_plotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_plotActionPerformed
        TFigureAttribute attr=new TFigureAttribute();
        attr.figureCaption=this.getTitle();
        getPlotPanel().getMatrix().plot(attr);
    }//GEN-LAST:event_btn_plotActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        savePanel();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        sort();
    }//GEN-LAST:event_btnSortActionPerformed

    private void sort() {
        if (isSort) {
            CMatrix m2 = cm.clone(cm);
            float[][] d = m2.toFloatArray2D();
            float[] d2 = FactoryMatrix.clone(d[0]);
            int[] index = FactoryUtils.sortArrayAndReturnIndex(d2, "desc");
            CMatrix cmx = FactoryUtils.sortRows(m2, index);
            getPlotPanel().setMatrix(cmx);
            isSort = false;
            btnSort.setText("unsort");
            return;
        } else {
            getPlotPanel().setMatrix(cm);
            btnSort.setText("sort");
            isSort = true;
        }
    }

    public PanelPloty getPlotPanel() {
        return (PanelPloty) panel_blob;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePlot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePlot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePlot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePlot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FramePloty frm = new FramePloty(CMatrix.getInstance().randn(2, 130).timesScalar(1));
                frm.setVisible(true);
                String[] s = {"Observed", "Simulated"};
//                frm.getScatterPlotPanel().setAxisText(s);
            }
        });
    }

    private void savePanel() {
        FactoryUtils.savePanel(getPlotPanel(),txt_dpi.getText());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSort;
    private javax.swing.JButton btn_dataGrid;
    private javax.swing.JButton btn_plot;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panel_blob;
    private javax.swing.JTextField txt_dpi;
    // End of variables declaration//GEN-END:variables



}

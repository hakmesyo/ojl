/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jazari.gui;

import com.formdev.flatlaf.FlatDarkLaf;
import jazari.utils.DataAnalytics;
//import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import jazari.matrix.CMatrix;
import jazari.factory.FactoryUtils;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jazari.image_processing.ImageProcess;
import jazari.interfaces.call_back_interface.CallBackTrigger;

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
    public String titleImageInfo;
    public CMatrix cm;
    public String caption = "";
    private boolean noPaint = false;
    public float maxHeight=730;

    /**
     * Creates new form FrameImage
     */
    public FrameImage() {
        initComponents();
        eventListener();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * Draws A Picture Frame
     *
     * @param cm : image to be drawn
     * @param imagePath : image path
     * @param caption
     */
    public FrameImage(CMatrix cm, String imagePath, String caption) {
        initComponents();
        this.caption = caption;
        this.cm = cm;
        this.imageFolderPath = FactoryUtils.getFolderPath(imagePath);
        this.imagePath = imagePath;
        if (caption != null && !caption.isEmpty()) {
            setTitle(caption);
        }
        loadImage(cm, imagePath, caption, chk_stretch.isSelected());
        eventListener();
        chkLabelVisible.setSelected(true);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void setImage(BufferedImage img, String imagePath, String caption) {
        this.img = img;
        this.imagePath = imagePath;
        imageFolderPath = FactoryUtils.getFolderPath(imagePath);
        getPicturePanel().setFrame(this);
        getPicturePanel().setImage(this.img, imagePath, caption);
        //this.setSize(img.getWidth() + 300, img.getHeight() + 183);
        String[] s = FactoryUtils.splitPath(imagePath);
        titleImageInfo = (s[s.length - 1]);
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
        chkBBox = new javax.swing.JCheckBox();
        chkSequence = new javax.swing.JCheckBox();
        chkPolygon = new javax.swing.JCheckBox();
        lbl_zoom_factor = new javax.swing.JLabel();
        btn_dashedLineColor = new javax.swing.JButton();
        chkLabelVisible = new javax.swing.JCheckBox();
        btn_analytics = new javax.swing.JButton();
        chkLane = new javax.swing.JCheckBox();
        btn_screen_capture = new javax.swing.JButton();
        chk_stretch = new javax.swing.JCheckBox();
        combo_format = new javax.swing.JComboBox<>();
        slider = new javax.swing.JSlider();
        lbl_index = new javax.swing.JLabel();
        chk_customZoom = new javax.swing.JCheckBox();

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
            .addGap(0, 545, Short.MAX_VALUE)
        );

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_dataGrid.setText("Data Grid");
        btn_dataGrid.setToolTipText("Show Pixels As Data Grid Table");
        btn_dataGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dataGridActionPerformed(evt);
            }
        });

        btn_save.setText("Save As");
        btn_save.setToolTipText("Save Image As");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        txt_dpi.setText("96");

        jLabel2.setText("dpi");

        chkBBox.setText("bbox");
        chkBBox.setToolTipText("Activate Bounding Box for Object Detection");
        chkBBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBBoxItemStateChanged(evt);
            }
        });
        chkBBox.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkBBoxMouseMoved(evt);
            }
        });
        chkBBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBBoxActionPerformed(evt);
            }
        });

        chkSequence.setText("sequence");
        chkSequence.setToolTipText("Remember previous lane, bbox or ploygons for fast annotations");
        chkSequence.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkSequenceItemStateChanged(evt);
            }
        });
        chkSequence.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkSequenceMouseMoved(evt);
            }
        });
        chkSequence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSequenceActionPerformed(evt);
            }
        });

        chkPolygon.setText("polygon");
        chkPolygon.setToolTipText("Activate Polygonal Region Drawing for Semnatic Segmentation and Object Detection");
        chkPolygon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkPolygonItemStateChanged(evt);
            }
        });
        chkPolygon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkPolygonMouseMoved(evt);
            }
        });
        chkPolygon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPolygonActionPerformed(evt);
            }
        });

        lbl_zoom_factor.setText("1");

        btn_dashedLineColor.setText("color");
        btn_dashedLineColor.setToolTipText("Change Dashed Line Color");
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

        chkLabelVisible.setText("label");
        chkLabelVisible.setToolTipText("Show Specified Labels on Annotations");
        chkLabelVisible.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkLabelVisibleİtemStateChanged(evt);
            }
        });
        chkLabelVisible.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                chkLabelVisibleMouseMoved(evt);
            }
        });

        btn_analytics.setText("analytics");
        btn_analytics.setToolTipText("Show histogram of annotations for achieving balanced classes");
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

        chkLane.setText("lane");
        chkLane.setToolTipText("Activate Lane Detection based on splines");
        chkLane.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkLaneİtemStateChanged(evt);
            }
        });
        chkLane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkLaneActionPerformed(evt);
            }
        });

        btn_screen_capture.setText("Screen Capture");
        btn_screen_capture.setToolTipText("Open Screen Capture App");
        btn_screen_capture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_screen_captureActionPerformed(evt);
            }
        });

        chk_stretch.setText("stretch");
        chk_stretch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chk_stretchİtemStateChanged(evt);
            }
        });

        combo_format.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PascalVOC", "Yolo" }));
        combo_format.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_formatİtemStateChanged(evt);
            }
        });

        slider.setValue(0);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });
        slider.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                sliderCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        lbl_index.setText("...");

        chk_customZoom.setText("custom zoom");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_dataGrid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_screen_capture)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_dpi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chk_customZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_zoom_factor, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chk_stretch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                        .addComponent(combo_format, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkLane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkBBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkPolygon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkSequence)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkLabelVisible)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_analytics)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_dashedLineColor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_index, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13)))
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
                    .addComponent(chkBBox)
                    .addComponent(chkSequence)
                    .addComponent(chkPolygon)
                    .addComponent(lbl_zoom_factor)
                    .addComponent(btn_dashedLineColor)
                    .addComponent(chkLabelVisible)
                    .addComponent(btn_analytics)
                    .addComponent(chkLane)
                    .addComponent(btn_screen_capture)
                    .addComponent(chk_stretch)
                    .addComponent(combo_format, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_customZoom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_index))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPicture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dataGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dataGridActionPerformed
        FrameDataGrid frm = null;
        BufferedImage img = null;
        if (getPicturePanel().selectionRect == null) {
            img = getPicturePanel().getImage();
        } else {
            img = getPicturePanel().selectionRectImage;
        }
        if (cm == null) {
            cm = CMatrix.getInstance(img);
        } else {
            cm = cm.setImage(img);
        }
        if (img.getType() == BufferedImage.TYPE_BYTE_GRAY) {
            frm = new FrameDataGrid(cm.toFloatArray2D(), true);
        } else {
            frm = new FrameDataGrid(cm.getARGB());
        }
        frm.frameImage = this;
        frm.setVisible(true);

        //frm.setAlwaysOnTop(true);
        //getPicturePanel().requestFocus();
    }//GEN-LAST:event_btn_dataGridActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        saveImageAs();
        getPicturePanel().requestFocus();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void panelPictureKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelPictureKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelPictureKeyPressed

    private void chkBBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBBoxItemStateChanged
        getPicturePanel().activateBoundingBox = chkBBox.isSelected();
        getPicturePanel().activatePolygon = chkPolygon.isSelected();
        getPicturePanel().activateLaneDetection = chkLane.isSelected();
        getPicturePanel().activateCrop = !(chkLane.isSelected() || chkPolygon.isSelected() || chkBBox.isSelected());
        getPicturePanel().setImage(this.img, imagePath, this.getTitle());
        getPicturePanel().requestFocus();
    }//GEN-LAST:event_chkBBoxItemStateChanged

    private void chkBBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBBoxActionPerformed
        if (chkBBox.isSelected()) {
            FactoryUtils.showMessageTemp("Use Arrow Keys to locate prev and next images.\n"
                    + "Press S to save bboxes and go to next image.\nDouble click on bbox to change attributes",
                    3000, new CallBackTrigger() {
                @Override
                public void trigger() {
                }
            });
            chkPolygon.setSelected(false);
            chkLane.setSelected(false);
        }
    }//GEN-LAST:event_chkBBoxActionPerformed

    private void chkSequenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSequenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkSequenceActionPerformed

    private void chkSequenceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkSequenceItemStateChanged
        getPicturePanel().isSeqenceVideoFrame = chkSequence.isSelected();
        getPicturePanel().requestFocus();
    }//GEN-LAST:event_chkSequenceItemStateChanged

    private void chkBBoxMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkBBoxMouseMoved
        chkBBox.setToolTipText("Activates BoundingBox annotation for object detection\nUse Arrow Keys to locate prev and next images.\nPress S to save bboxes and go to next image.\nDouble click on bbox to change attributes\nPress Delete key to delete");
    }//GEN-LAST:event_chkBBoxMouseMoved

    private void chkSequenceMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkSequenceMouseMoved
        chkSequence.setToolTipText("Check if your images are similar to the video sequences/frames.\nPreserves bboxes or polygons from previous image");
    }//GEN-LAST:event_chkSequenceMouseMoved

    private void chkPolygonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkPolygonItemStateChanged
        getPicturePanel().activatePolygon = chkPolygon.isSelected();
        getPicturePanel().activateBoundingBox = chkBBox.isSelected();
        getPicturePanel().activateLaneDetection = chkLane.isSelected();
        getPicturePanel().activateCrop = !(chkLane.isSelected() || chkPolygon.isSelected() || chkBBox.isSelected());
        getPicturePanel().setImage(this.img, imagePath, this.getTitle());
        getPicturePanel().requestFocus();
    }//GEN-LAST:event_chkPolygonItemStateChanged

    private void chkPolygonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkPolygonMouseMoved
        chkPolygon.setToolTipText("Activates Polygon annotation for image segmentation\nUse Arrow Keys to locate prev and next images.\nPress S to save polygon and go to next image.\nDouble click on polygon to change attributes\nPress Delete key to delete");
    }//GEN-LAST:event_chkPolygonMouseMoved

    private void chkPolygonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPolygonActionPerformed
        if (chkPolygon.isSelected()) {
            FactoryUtils.showMessageTemp("Use Arrow Keys to locate prev and next images.\n"
                    + "Press S to save polygons and go to next image.\nDouble click on polygons to change attributes",
                    3000, () -> {
                    });
            chkBBox.setSelected(false);
            chkLane.setSelected(false);
        }
    }//GEN-LAST:event_chkPolygonActionPerformed

    private void btn_dashedLineColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashedLineColorActionPerformed
        changeDashedLineColor();
    }//GEN-LAST:event_btn_dashedLineColorActionPerformed

    private void chkLabelVisibleMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkLabelVisibleMouseMoved
        chkLabelVisible.setToolTipText("Hide or show labels on annotations");
    }//GEN-LAST:event_chkLabelVisibleMouseMoved

    private void chkLabelVisibleİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkLabelVisibleİtemStateChanged
        getPicturePanel().activateLabelVisibility = chkLabelVisible.isSelected();
        getPicturePanel().repaint();
        getPicturePanel().requestFocus();
    }//GEN-LAST:event_chkLabelVisibleİtemStateChanged

    private void btn_dashedLineColorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dashedLineColorMouseMoved
        btn_dashedLineColor.setToolTipText("Changes the dashed line color");
    }//GEN-LAST:event_btn_dashedLineColorMouseMoved

    private void btn_analyticsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_analyticsMouseMoved
        chkPolygon.setToolTipText("show number of classes and percentages annotated so far");
    }//GEN-LAST:event_btn_analyticsMouseMoved

    private void btn_analyticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_analyticsActionPerformed
        if (FactoryUtils.isFileExist(imageFolderPath + "/class_labels.txt")) {
            List<DataAnalytics> lst = FactoryUtils.getDataAnalytics(imageFolderPath, (combo_format.getSelectedIndex() == 0) ? "xml" : "txt");
            FrameDataAnalytics frm = new FrameDataAnalytics(this, imageFolderPath, lst);
            frm.setVisible(true);

        }
    }//GEN-LAST:event_btn_analyticsActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void btn_screen_captureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_screen_captureActionPerformed
        CMatrix.getInstance().robotCapture();
        //getPicturePanel().requestFocus();
    }//GEN-LAST:event_btn_screen_captureActionPerformed

    private void chkLaneİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkLaneİtemStateChanged
        getPicturePanel().activateLaneDetection = chkLane.isSelected();
        getPicturePanel().activatePolygon = chkPolygon.isSelected();
        getPicturePanel().activateBoundingBox = chkBBox.isSelected();
        getPicturePanel().activateCrop = !(chkLane.isSelected() || chkPolygon.isSelected() || chkBBox.isSelected());
        getPicturePanel().setImage(this.img, imagePath, this.getTitle());
        getPicturePanel().requestFocus();
    }//GEN-LAST:event_chkLaneİtemStateChanged

    private void chkLaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkLaneActionPerformed
        if (chkLane.isSelected()) {
            FactoryUtils.showMessageTemp("Use Arrow Keys to locate prev and next images.\n"
                    + "Press S to save lanes and go to next image.\nDouble click on lane to change attributes",
                    3000, () -> {
                    });
            chkPolygon.setSelected(false);
            chkBBox.setSelected(false);
        }
    }//GEN-LAST:event_chkLaneActionPerformed

    private void chk_stretchİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chk_stretchİtemStateChanged
        stretchFrame();
        getPicturePanel().requestFocus();
    }//GEN-LAST:event_chk_stretchİtemStateChanged

    private void combo_formatİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_formatİtemStateChanged
        getPicturePanel().listPascalVocObject.clear();
        getPicturePanel().setImage(this.img, imagePath, this.getTitle());
        getPicturePanel().requestFocus();
    }//GEN-LAST:event_combo_formatİtemStateChanged

    boolean isFirst = true;
    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        if (isFirst) {
            isFirst = false;
            return;
        }
        //System.out.println("slider index:"+slider.getValue());
        getPicturePanel().imageIndex = slider.getValue();
        if (!noPaint) {
            BufferedImage bf = ImageProcess.readImage(getPicturePanel().imageFiles[getPicturePanel().imageIndex]);
            getPicturePanel().rawImage = ImageProcess.clone(bf);
            getPicturePanel().adjustImageToPanel(bf, true);
        } else {
            noPaint = false;
        }
        lbl_index.setText("[ " + (getPicturePanel().imageIndex + 1) + " / " + getPicturePanel().imageFiles.length + " ]");
    }//GEN-LAST:event_sliderStateChanged

    private void sliderCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_sliderCaretPositionChanged
        //System.out.println("caret pos slider index:"+slider.getValue());
    }//GEN-LAST:event_sliderCaretPositionChanged

    public PanelPicture getPicturePanel() {
        return ((PanelPicture) panelPicture);
    }

    public void saveImageAs() {
        imagePath = FactoryUtils.saveImageAs(getPicturePanel().getImage(), txt_dpi.getText());
        if (imagePath != null && !imagePath.isEmpty()) {
            CMatrix cm = CMatrix.getInstance().imread(imagePath);
            loadImage(cm, imagePath, imagePath, chk_stretch.isSelected());
        }
    }

    public void setZoomFactor(double z) {
        lbl_zoom_factor.setText(""+FactoryUtils.formatFloat((float) z, 4));
    }

//    /**
//     * @param args the command line arguments
//     */
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
    private javax.swing.JButton btn_screen_capture;
    public javax.swing.JCheckBox chkBBox;
    private javax.swing.JCheckBox chkLabelVisible;
    public javax.swing.JCheckBox chkLane;
    public javax.swing.JCheckBox chkPolygon;
    private javax.swing.JCheckBox chkSequence;
    public javax.swing.JCheckBox chk_customZoom;
    public javax.swing.JCheckBox chk_stretch;
    public javax.swing.JComboBox<String> combo_format;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_index;
    public javax.swing.JLabel lbl_zoom_factor;
    private javax.swing.JPanel panelPicture;
    public javax.swing.JSlider slider;
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

    private void loadImage(CMatrix cm, String imagePath, String caption, boolean isFullSize) {
        String[] s = FactoryUtils.splitPath(imagePath);
        if (imagePath != null && !imagePath.isEmpty()) {
            titleImageInfo = (s[s.length - 1]);
        }

        this.img = cm.getImage();
        this.imagePath = imagePath;
        getPicturePanel().activateBoundingBox = chkBBox.isSelected();
        if (!isFullSize && img.getHeight() > maxHeight) {
            float zoom_factor = maxHeight / img.getHeight();
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
        if (getPicturePanel().imageFiles == null) {
            return;
        }
        titleImageInfo = (getPicturePanel().imageFiles[getPicturePanel().imageIndex].getName() + "      [ " + (getPicturePanel().imageIndex + 1) + " / " + getPicturePanel().imageFiles.length + " ]");
        slider.setMaximum(getPicturePanel().imageFiles.length - 1);
        noPaint = true;
        slider.setValue(getPicturePanel().imageIndex);
        //isSequence.setVisible(false);
    }

    private void eventListener() {
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent ev) {
                getPicturePanel().updateImageLocation();
            }
        });
    }

    public void setPixelInfo(String str) {
        if ("".equals(caption) || caption == null) {
            setTitle(this.titleImageInfo + "  " + str);
        } else {
            setTitle("[" + caption + "] " + this.titleImageInfo + "  " + str);
        }
    }

    public void stretchFrame() {
        if (chk_stretch.isSelected()) {
            int w = getPicturePanel().getImage().getWidth();
            int h = getPicturePanel().getImage().getHeight() + 80;
            setSize(new Dimension(w, h));
        } else {
            if ((getExtendedState() & JFrame.MAXIMIZED_BOTH) != JFrame.MAXIMIZED_BOTH) {
                setLocationRelativeTo(null);
                setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        }
    }

    public void fullSizeFrame() {
        if ((getExtendedState() & JFrame.MAXIMIZED_BOTH) != JFrame.MAXIMIZED_BOTH) {
            setLocationRelativeTo(null);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        loadImage(cm, imagePath, caption, chk_stretch.isSelected());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageeditorprogram;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Maha
 */
public class ImageReader extends javax.swing.JFrame {

    /**
     * Creates new form ImageReader
     */
    private final JFileChooser openFileChooser;
    private final JFileChooser saveFileChooser;
    protected BufferedImage loadedImage;
    private JFrame f;
    private ImageIcon icon;
    private JLabel label;
    protected static int blurCounter = 1; 


    public ImageReader() {
        initComponents();

        openFileChooser = new JFileChooser();
        //to be edited (set path dynamically)
        openFileChooser.setCurrentDirectory(new File("c:\\temp"));
        //TODO  be edited (more image types) 
        openFileChooser.setFileFilter(new FileNameExtensionFilter("JPEG images", "jpg"));
        saveFileChooser = new JFileChooser();
        //to be edited (set path dynamically)
        saveFileChooser.setCurrentDirectory(new File("c:\\temp"));
        //TODO  be edited (more image types) 
        saveFileChooser.setFileFilter(new FileNameExtensionFilter("JPEG images", "jpg"));
        f = new JFrame();

    }

    public BufferedImage getImageLoaded() {
        return loadedImage;
    }

    public void setImageLoaded(BufferedImage imageLoaded) {
        this.loadedImage = imageLoaded;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openFileButton = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();
        darkenImageButton = new javax.swing.JButton();
        brightenImageButton = new javax.swing.JButton();
        rotateImageButton = new javax.swing.JButton();
        blurImage = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        undoEdit = new javax.swing.JButton();
        saveImageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Editor");
        setIconImages(null);

        openFileButton.setBackground(java.awt.Color.white);
        openFileButton.setText("Open image...");
        openFileButton.setMaximumSize(new java.awt.Dimension(120, 25));
        openFileButton.setMinimumSize(new java.awt.Dimension(120, 25));
        openFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileButtonActionPerformed(evt);
            }
        });

        darkenImageButton.setText("Darken Image");
        darkenImageButton.setMaximumSize(new java.awt.Dimension(120, 25));
        darkenImageButton.setMinimumSize(new java.awt.Dimension(120, 25));
        darkenImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkenImageButtonActionPerformed(evt);
            }
        });

        brightenImageButton.setText("Brighten Image");
        brightenImageButton.setMaximumSize(new java.awt.Dimension(120, 25));
        brightenImageButton.setMinimumSize(new java.awt.Dimension(120, 25));
        brightenImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brightenImageButtonActionPerformed(evt);
            }
        });

        rotateImageButton.setText("Rotate Image");
        rotateImageButton.setMaximumSize(new java.awt.Dimension(120, 25));
        rotateImageButton.setMinimumSize(new java.awt.Dimension(120, 25));
        rotateImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotateImageButtonActionPerformed(evt);
            }
        });

        blurImage.setText("Blur Image");
        blurImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blurImageActionPerformed(evt);
            }
        });

        undoEdit.setText("Undo Edit");
        undoEdit.setMaximumSize(new java.awt.Dimension(120, 25));
        undoEdit.setMinimumSize(new java.awt.Dimension(120, 25));
        undoEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoEditActionPerformed(evt);
            }
        });

        saveImageButton.setText("Save changes...");
        saveImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(openFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(brightenImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(darkenImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rotateImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(imageLabel)
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(undoEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(blurImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(openFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(brightenImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(darkenImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(imageLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rotateImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(blurImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(undoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveImageButton)
                .addGap(30, 30, 30)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileButtonActionPerformed

        int returnValue = openFileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {

            try {

                loadedImage = ImageIO.read(openFileChooser.getSelectedFile());
                ImageEditor editor = new ImageEditor();
                editor.loadImage(loadedImage);

                messageLabel.setForeground(Color.BLACK);
                messageLabel.setText("Image file successfuly loaded!");
             //   ImageEditor.stack.push(loadedImage);
//                icon = new ImageIcon(loadedImage);
//                label = new JLabel(icon);
                // f = new JFrame();
//                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                f.getContentPane().add(new JScrollPane(label));
//                f.setSize(500, 500);
//                f.setLocation(400, 400);
//                f.setVisible(true);

                //    JFrame frame = new JFrame();
                icon = new ImageIcon(loadedImage);
                label = new JLabel(icon);
//                imageLabel = new JLabel (icon); 
//                imageLabel.setText("helllllllllllllo");
                f.add(label);
               f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setVisible(true);

            } catch (IOException ioe) {
                messageLabel.setText("Failed to load image file!");
            }

        } else {
            messageLabel.setForeground(Color.BLACK);
            messageLabel.setText("No file chosen!");
        }


    }//GEN-LAST:event_openFileButtonActionPerformed

    private void darkenImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkenImageButtonActionPerformed

        if (loadedImage != null) {
            BufferedImage newImage = ImageEditor.darkenImage(loadedImage);
            if (ImageEditor.writeImage(newImage)) {
                messageLabel.setText("Image successfully darkened!");
//                f.doClick();
//               f.getContentPane().removeAll();
//               f.invalidate();
//                icon = new ImageIcon(newImage);
//                label = new JLabel(icon);
                System.out.println("Here bitch!");
                label.setIcon(new ImageIcon(newImage));
//                 f = new JFrame();
//                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                f.getContentPane().add(label);
//                f.add(new JLabel(new ImageIcon(newImage)));
//                f.setSize(500, 500);
//                f.setLocation(400, 400);
//                f.setVisible(true);

//                ImageIcon icon = new ImageIcon(newImage);
//                JLabel label = new JLabel(icon);
//                f.add(label);
//                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                f.pack();
//                f.setVisible(true);
            }
        } else {
            noImageLoadedErrorMessage();
        }


    }//GEN-LAST:event_darkenImageButtonActionPerformed

    private void brightenImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brightenImageButtonActionPerformed

        if (loadedImage != null) {
            BufferedImage newImage = ImageEditor.brightenImage(loadedImage);
            if (ImageEditor.writeImage(newImage)) {
                messageLabel.setText("Image successfully brightened!");
                label.setIcon(new ImageIcon(newImage));
            }

        } else {
            noImageLoadedErrorMessage();
        }
    }//GEN-LAST:event_brightenImageButtonActionPerformed

    private void rotateImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotateImageButtonActionPerformed
        if (loadedImage != null) {
            BufferedImage newImage = ImageEditor.rotateImage(loadedImage);
            loadedImage = newImage;
            if (ImageEditor.writeImage(newImage)) {
                messageLabel.setText("Image successfuly rotated!");
                label.setIcon(new ImageIcon(newImage));

            }

        } else {
            noImageLoadedErrorMessage();
        }
    }//GEN-LAST:event_rotateImageButtonActionPerformed

    private void blurImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blurImageActionPerformed
        if (loadedImage != null) {
            
            BufferedImage newImage = ImageEditor.blurImage(blurCounter * 2).filter(loadedImage, null);
            loadedImage = newImage; 
          //  loadedImage = newImage; 
            ImageEditor.imageStack.push(ImageEditor.deepCopy(newImage));
            blurCounter++;
            if (ImageEditor.writeImage(newImage)) {
                messageLabel.setText("Image successfuly blurred!");
                label.setIcon(new ImageIcon(newImage));

            }

        } else {
            noImageLoadedErrorMessage();
        }
    }//GEN-LAST:event_blurImageActionPerformed

    private void undoEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoEditActionPerformed

        if (loadedImage != null) {
            BufferedImage editedImage = ImageEditor.undo();
            if (editedImage != null) {
                label.setIcon(new ImageIcon(editedImage));
                System.out.println("top of the stack not equal null");
                        
            }
            
            else{
                messageLabel.setText("ERROR!");
            }

        } else {
            noImageLoadedErrorMessage();

        }
        
    }//GEN-LAST:event_undoEditActionPerformed

    private void saveImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveImageButtonActionPerformed
        int returnValue = saveFileChooser.showSaveDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {

            try {
                File finalImage = saveFileChooser.getSelectedFile();
                String filePath = finalImage.getAbsolutePath();
                if (!filePath.endsWith(".jpg")) {
                    finalImage = new File(filePath + ".jpg");
}
                ImageIO.write(ImageEditor.imageStack.peek(), "jpg", finalImage);
                                saveFileChooser.setFileFilter(new FileNameExtensionFilter(".jpg", "jpg"));

                messageLabel.setText("Image file successfuly saved!");

            } catch (IOException ioe) {
                messageLabel.setText("Failed to save image file!");
            }

        } else {
            messageLabel.setText("No file chosen!");
        }    }//GEN-LAST:event_saveImageButtonActionPerformed

    public void noImageLoadedErrorMessage() {

        messageLabel.setForeground(Color.RED);
        messageLabel.setText("No image loaded!");

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImageReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageReader().setVisible(true);
            }
        });

//        ImageEditor.load
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blurImage;
    private javax.swing.JButton brightenImageButton;
    private javax.swing.JButton darkenImageButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JButton openFileButton;
    private javax.swing.JButton rotateImageButton;
    private javax.swing.JButton saveImageButton;
    private javax.swing.JButton undoEdit;
    // End of variables declaration//GEN-END:variables
}

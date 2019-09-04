package imageeditorprogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import java.util.Stack;

public class ImageEditor {

    protected static BufferedImage image;
    protected static BufferedImage originalImage;
    private boolean blurredBefore;

    protected static Stack<BufferedImage> imageStack = new Stack();
    protected static Stack<String> operationStack = new Stack();

    public static ConvolveOp blurImage(int radius) {
        if (radius < 1) {
            throw new IllegalArgumentException("Radius must be >= 1");
        }
        int size = radius * 2 + 1;
        float weight = 1f / (size * size);
        float[] data = new float[size * size];
        for (int i = 0; i < data.length; i++) {
            data[i] = weight;
        }

        Kernel kernel = new Kernel(size, size, data);
        operationStack.push("blur");
        return new ConvolveOp(kernel);
    }

    public static BufferedImage rotateImage(BufferedImage image) {
        
        int width, height; 
        BufferedImage newImage; 
        if (imageStack.size() == 1 && originalImage != null) {

             width = originalImage.getWidth();
            height = originalImage.getHeight();
            newImage = new BufferedImage(height, width, originalImage.getType());
        }
        
        
        else {
            width = image.getWidth();
            height = image.getHeight();
            newImage = new BufferedImage(height, width, image.getType());
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                newImage.setRGB(height - 1 - j, i, image.getRGB(i, j));
            }
        }
        imageStack.push(deepCopy(image));
        operationStack.push("rotate");
        System.out.println("In rotate " + imageStack.size());

        //   image = newImage;
        return newImage;

    }

    static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    protected static BufferedImage brightenImage(BufferedImage image) {
        RescaleOp rescaleOp = new RescaleOp(1.125f, 0, null);
        if (imageStack.size() == 1 && originalImage != null){
         rescaleOp.filter(originalImage, image);
        }
        else {
                rescaleOp.filter(image, image);
}
        BufferedImage newImage = image;
        imageStack.push(deepCopy(image));
        operationStack.push("brighten");
        System.out.println("In brighten " + imageStack.size());
        //image = newImage;

        return image;

    }

    protected static BufferedImage undo() {

        if (imageStack.size() > 1) {
            if (operationStack.peek().equals("blur")) {
                ImageReader.blurCounter--;
            }
            imageStack.pop();
            operationStack.pop();
            System.out.println("In undo stack peek " + imageStack.size());
            return imageStack.peek();
        } else if (imageStack.size() == 1) {
            System.out.println("In undo " + imageStack.size());
            System.out.println("In undo stack original " + imageStack.size());
            return originalImage;
            //  return stack.peek();
        } else {
            return image;
        }
//        else if (image != null) {
//            return image;
//        } else {
//            return null;
//        }
    }

    protected static BufferedImage darkenImage(BufferedImage image) {
        RescaleOp rescaleOp = new RescaleOp(0.875f, 0, null);
        
        if (imageStack.size() == 1 && originalImage != null){
            rescaleOp.filter(originalImage , image); 
        }
        
        else {
            rescaleOp.filter(image, image);
           }
//             rescaleOp = new RescaleOp(0.75f, 0, null);
//        rescaleOp.filter(image, image);
        //    BufferedImage newImage = image; 
        imageStack.push(deepCopy(image));
        operationStack.push("darken");
        System.out.println("In darken " + imageStack.size());

        return image;

    }

    protected void loadImage(BufferedImage image) throws IOException {

        this.image = image;
        this.originalImage = deepCopy(image);
        imageStack.push(originalImage);
        operationStack.push("original");
        System.out.println("In load Image " + imageStack.size());

        //     BufferedImage editedImage;
//        editedImage = rotateImage(image);
//        ImageIO.write(editedImage, "jpg", new File("C:\\Users\\lostm\\Downloads\\new_image.jpg"));
    }

    protected static boolean writeImage(BufferedImage image) {

        try {

            //TO DO: set path dynamically 
            ImageIO.write(image, "jpg", new File("C:\\Users\\lostm\\Downloads\\your_new_image.jpg"));
            return true;

        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }

    }
//    public static void main(String[] args) {
//
////        File file = new File("C:\\Users\\lostm\\Downloads\\olena.jpg");
////        BufferedImage image = null;
////        
////        
////
////        try {
////            image = ImageIO.read(file);
////
////            //        ImageEditor.brightenImage(image);
////           // image = ImageEditor.rotate(image);
////
////           image = blurImage(10).filter(image, null);
////           ImageIO.write(image, "jpg", new File("C:\\Users\\lostm\\Downloads\\blur_olena.jpg"));
////
////        } catch (IOException e) {
////
////            e.printStackTrace();
////        }
//
//          if (ImageEditor.image != null){
//              ImageEditor.brightenImage(image);
//              System.out.println("");
//              
//          } else {
//              System.out.println("Not set");
//          }
//    }

}

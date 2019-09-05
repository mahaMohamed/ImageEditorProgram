package imageeditorprogram;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Image.*;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import java.util.Stack;

public class ImageEditor {

    protected static BufferedImage image;

    /*A variable in which the original image will be stored*/
    protected static BufferedImage originalImage;

    /*A stack thay will contain all edits done to the image to be used in the undo operation*/
    protected static Stack<BufferedImage> imageStack = new Stack();

    /*A stack thay will contain all edit operations done to the image to be used in the undo operation*/
    protected static Stack<String> operationStack = new Stack();

    /* A function that loads the image*/
    protected void loadImage(BufferedImage image) throws IOException {

        this.image = image;
        this.originalImage = deepCopy(image);
        imageStack.push(originalImage);
        operationStack.push("original");

    }
    
    
    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    /* A function that blurs the image*/
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

    /* A function that rotates the image*/
    public static BufferedImage rotateImage(BufferedImage image) {

        int width, height;
        BufferedImage newImage;
        if (imageStack.size() == 1 && originalImage != null) {

            width = originalImage.getWidth();
            height = originalImage.getHeight();
            newImage = new BufferedImage(height, width, originalImage.getType());
        } else {
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

        return newImage;

    }

    /* A function that creates and returns a copy of the passed image*/
    static BufferedImage deepCopy(BufferedImage bufferedImage) {
        ColorModel colorModel = bufferedImage.getColorModel();
        boolean isAlphaPremultiplied = colorModel.isAlphaPremultiplied();
        WritableRaster raster = bufferedImage.copyData(null);
        return new BufferedImage(colorModel, raster, isAlphaPremultiplied, null);
    }

    /*A function that brightens image*/
    protected static BufferedImage brightenImage(BufferedImage image) {
        RescaleOp rescaleOp = new RescaleOp(1.125f, 0, null);
        if (imageStack.size() == 1 && originalImage != null) {
            image = deepCopy(originalImage);
            rescaleOp.filter(originalImage, image);
        } else {
            rescaleOp.filter(image, image);
        }
        BufferedImage newImage = image;
        imageStack.push(deepCopy(image));
        operationStack.push("brighten");

        return image;

    }

    /* A functio that darkens the image*/
    protected static BufferedImage darkenImage(BufferedImage image) {
        RescaleOp rescaleOp = new RescaleOp(0.875f, 0, null);

        if (imageStack.size() == 1 && originalImage != null) {
            image = deepCopy(originalImage);
            rescaleOp.filter(originalImage, image);
        } else {
            rescaleOp.filter(image, image);
        }
        imageStack.push(deepCopy(image));
        operationStack.push("darken");

        return image;

    }

    protected static BufferedImage cropImage(int x, int y, int width, int height, BufferedImage src) {
        BufferedImage dest = src.getSubimage(0, 0, width, height);
        return dest;
    }

    /* A function that undoes past actions done by the user and returns the image to a previous state*/
    protected static BufferedImage undo() {

        if (imageStack.size() > 1) {
            if (operationStack.peek().equals("blur")) {
                ImageReader.blurCounter--;
            }
            imageStack.pop();
            operationStack.pop();
            return imageStack.peek();
        } else if (imageStack.size() == 1) {
            return originalImage;
        } else {
            return image;
        }

    }

//    protected static boolean writeImage(BufferedImage image) {
//
//        try {
//
//            //TO DO: set path dynamically 
//            ImageIO.write(image, "jpg", new File("C:\\Users\\lostm\\Downloads\\your_new_image.jpg"));
//            return true;
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//            return false;
//        }
//    }
}

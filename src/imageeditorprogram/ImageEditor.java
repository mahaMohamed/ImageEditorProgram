package imageeditorprogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.RescaleOp;

public class ImageEditor {
    
    BufferedImage image;

    public static ConvolveOp blurImage(int radius) {
        if (radius < 1) {
            throw new IllegalArgumentException("Radius must be >= 1");
        }
        int size = radius * 2 + 1;
        float weight = 1f/ (size * size);
        float[] data = new float[size * size];
        for (int i = 0; i < data.length; i++) {
            data[i] = weight;
        }
        Kernel kernel = new Kernel(size, size, data);
        return new ConvolveOp(kernel);
    }

    public static BufferedImage rotateImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage newImage = new BufferedImage(height, width, image.getType());

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                newImage.setRGB(height - 1 - j, i, image.getRGB(i, j));
            }
        }

        return newImage;
    }

    private static void brightenImage(BufferedImage image) {
        RescaleOp rescaleOp = new RescaleOp(1.5f, 15, null);
        rescaleOp.filter(image, image);

    }

    private static void darkenImage(BufferedImage image) {
        RescaleOp rescaleOp = new RescaleOp(0.5f, 15, null);
        rescaleOp.filter(image, image);

    }

    
    public  void loadImage (BufferedImage image) throws IOException{
        
        System.out.println("In load Image");
        
        this.image = image; 
       BufferedImage editedImage;
       editedImage = rotateImage(image);
       ImageIO.write(editedImage, "jpg", new File("C:\\Users\\lostm\\Downloads\\new_image.jpg"));
        
        
    }
    public static void main(String[] args) {

        File file = new File("C:\\Users\\lostm\\Downloads\\olena.jpg");
        BufferedImage image = null;
        
        

        try {
            image = ImageIO.read(file);

            //        ImageEditor.brightenImage(image);
           // image = ImageEditor.rotate(image);

           image = blurImage(10).filter(image, null);
           ImageIO.write(image, "jpg", new File("C:\\Users\\lostm\\Downloads\\blur_olena.jpg"));

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}

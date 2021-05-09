package GUIComponents;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageResizer {

    public static BufferedImage resize(BufferedImage img, double percent) {

        BufferedImage inputImage = img;

        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);

        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        return outputImage;
    }
}
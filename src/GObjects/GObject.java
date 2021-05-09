package GObjects;

import GUIComponents.IDrawable;
import GUIComponents.ImageResizer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GObject implements IDrawable {

    protected BufferedImage texture;

    protected ImageResizer imgRes;

    //Represents a button which can be drawn multiple times
    protected JButton object;

    //Constructor for GObject
    public GObject(){
        //Initialize ImageResizer
        imgRes = new ImageResizer();
    }

    public void Draw(Graphics2D g, int x, int y) {
        //TODO
    }

    //Function to load an image from filepath and make a button with init
    //Parameters:
    //path:     where the image is found
    //scale:    the scale of the image (scale = 1 means that the image will be loaded in original size)
    //x, y:     coordinates of the image
    protected void loadImage(String path, double scale, int x, int y) throws IOException {
        BufferedImage image = ImageIO.read(new File(path));         //load image from path
        if(scale != 1)
            image = imgRes.resize(image, scale);                        //resize image if necessary
        object = new JButton(new ImageIcon(image));
        object.setOpaque(false);
        object.setContentAreaFilled(false);
        object.setBounds(x,y,image.getWidth(),image.getHeight());
        object.setBorderPainted(false);                                 //disable border
        //object.setVisible(true);
    }

    //Get the button from the class
    public JButton getButton(){
        return object;
    }

    //Get texture
    public BufferedImage getTexture(){
        return texture;
    }

}

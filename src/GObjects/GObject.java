package GObjects;

import Graphics.IDrawable;
import Graphics.ImageResizer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GObject implements IDrawable {

    private BufferedImage texture;
    private int x, y;
    protected ImageResizer imgRes;
    protected JButton object;

    public GObject(){
        imgRes = new ImageResizer();
    }

    public void Draw(Graphics2D g, int x, int y) {
        //TODO
    }

    protected void loadImage(String path, double scale, int x, int y) throws IOException {
        BufferedImage image = ImageIO.read(new File(path));
        image = imgRes.resize(image, scale);
        object = new JButton(new ImageIcon(image));
        object.setOpaque(false);
        object.setContentAreaFilled(false);
        object.setBounds(x,y,image.getWidth(),image.getHeight());
        object.setBorderPainted(false);
    }

    public JButton getButton(){
        return object;
    }

}

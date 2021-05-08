package GObjects;

import Graphics.IDrawable;
import Graphics.ImageResizer;

import Graphics.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GObject implements IDrawable {

    protected BufferedImage texture;
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


    public void rajzolok(Graphics g, int x, int y, GamePanel panel){
        g.drawImage(texture , 0, 0, panel); // see javadoc for more info on the parameters


    }
    public BufferedImage getTexture(){
        return texture;
    }

}

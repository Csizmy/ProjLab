package Graphics;

import Game_parts.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {

    private Game game;
    private Controller controller; //ez így van itt?
    private BufferedImage image;
    public GamePanel(){
        try {
            image = ImageIO.read(new File("pictures\\background.png"));
        } catch (IOException ex) {

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
    }

    public void exit() {
        //TODO
    }

    public void start() {
        //TODO
    }

    public void drawAll() {
        //TODO
    }

}

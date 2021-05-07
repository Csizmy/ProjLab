package GObjects;

import javax.swing.*;
import java.awt.*;

public class GAsteroid extends GObject{
    private JButton asteroid;

    public GAsteroid(int x, int y){
        asteroid = new JButton(new ImageIcon("pictures\\asteroid414x405.png"));
        asteroid.setFocusable(false);
        asteroid.setBounds(x,y,414,405);
    }

    public JButton getGAsteroid(){
        return asteroid;
    }
}
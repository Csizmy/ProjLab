package GObjects;

import javax.swing.*;
import java.awt.*;

public class GAsteroid extends GObject{
    private JLabel asteroid;

    public GAsteroid(int x, int y){
        asteroid = new JLabel(new ImageIcon("pictures\\asteroid414x405.png"));
        asteroid.setFocusable(false);
        asteroid.setBounds(x,y,414,405);
    }

    @Override
    public void Draw(Graphics2D g) {

    }
}
package GObjects;

import GUIComponents.MapView;
import Objects.Asteroid;

import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GAsteroid extends GObject{

    //Default scale for image resize
    public double scale = 0.05;

    //Constructor for asteroid graphical object without scale (default scale will be used)
    public GAsteroid(int x, int y) throws IOException {
        loadImage("pictures\\a_teli_tavol.png", scale, x, y);
    }

    //Constructor for asteroid graphical object with scale
    public GAsteroid(int x, int y, int s) throws IOException {
        loadImage("pictures\\a_teli_tavol.png", s, x, y);
    }

    //Constructor for asteroid graphical object with Asteroid and scale
    public GAsteroid(Asteroid a, double s) throws IOException{
        loadImage("pictures\\a_teli_tavol.png", s, a.getX(), a.getY());
    }
}
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

    //Constructor for asteroid graphical object with Asteroid and scale
    public GAsteroid(Asteroid a, double s) throws IOException{
        if(a.getLayer() == a.getDigged() && a.getMaterial() == null){
            if(a.getPerihelion())
                loadImage("pictures\\a_ures_kozel.png", s, a.getX(), a.getY());
            else
                loadImage("pictures\\a_ures_tavol.png", s, a.getX(), a.getY());
        }
        else{
            if(a.getPerihelion())
                loadImage("pictures\\a_teli_kozel.png", s, a.getX(), a.getY());
            else
                loadImage("pictures\\a_teli_tavol.png", s, a.getX(), a.getY());
        }//

    }
}
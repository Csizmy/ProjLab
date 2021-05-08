package GObjects;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GAsteroid extends GObject{

    public double scale = 0.05;

    public GAsteroid(int x, int y) throws IOException {
        loadImage("pictures\\a_teli_tavol.png", scale, x, y);
    }

    public GAsteroid(int x, int y, int s) throws IOException {
        loadImage("pictures\\a_teli_tavol.png", s, x, y);
    }

}
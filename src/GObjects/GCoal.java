package GObjects;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GCoal extends GObject{
    public double scale = 0.05;

    public GCoal()throws IOException {
        texture= ImageIO.read(new File("pictures\\coal70x70.png"));
    }

    public GCoal(int x, int y) throws IOException {
        loadImage("pictures\\coal70x70.png", scale, x, y);

    }

    public GCoal(int x, int y, int s) throws IOException {
        loadImage("pictures\\coal70x70.png", s, x, y);
    }
}
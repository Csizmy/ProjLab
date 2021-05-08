package GObjects;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GUranium extends GObject{
    public double scale = 0.05;

    public GUranium()throws IOException {
        texture= ImageIO.read(new File("pictures\\uranium70x70.png"));
    }
    public GUranium(int x, int y) throws IOException {
        loadImage("pictures\\uranium70x70.png", scale, x, y);
    }

    public GUranium(int x, int y, int s) throws IOException {
        loadImage("pictures\\uranium70x70.png", s, x, y);
    }
}
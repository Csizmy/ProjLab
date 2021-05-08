package GObjects;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GUranium extends GObject{
    public double scale = 1;

    public GUranium(int x, int y) throws IOException {
        loadImage("pictures\\uranium70x70.png", scale, x, y);
    }

    public GUranium(int x, int y, int s) throws IOException {
        loadImage("pictures\\uranium70x70.png", s, x, y);
    }
}
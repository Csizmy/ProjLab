package GObjects;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GUranium extends GObject{

    //Default scale for image resize
    public double scale = 1;

    //Constructor for uranium graphical object without scale (default scale will be used)
    public GUranium(int x, int y) throws IOException {
        loadImage("pictures\\uranium70x70.png", scale, x, y);
    }

    //Constructor for uranium graphical object with scale
    public GUranium(int x, int y, int s) throws IOException {
        loadImage("pictures\\uranium70x70.png", s, x, y);
    }
}
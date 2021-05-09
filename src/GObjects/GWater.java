package GObjects;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GWater extends GObject{

    //Default scale for image resize
    public double scale = 1;

    //Constructor for water graphical object without scale (default scale will be used)
    public GWater(int x, int y) throws IOException {
        loadImage("pictures\\water70x70.png", scale, x, y);
    }

    //Constructor for water graphical object with scale
    public GWater(int x, int y, int s) throws IOException {
        loadImage("pictures\\water70x70.png", s, x, y);
    }
}

package GObjects;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GCoal extends GObject{

    //Default scale for image resize
    public double scale = 1;

    //Constructor for coal graphical object without scale (default scale will be used)
    public GCoal(int x, int y) throws IOException {
        loadImage("pictures\\coal70x70.png", scale, x, y);

    }
}
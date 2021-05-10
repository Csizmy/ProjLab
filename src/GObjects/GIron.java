package GObjects;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GIron extends GObject{

    //Default scale for image resize
    public double scale = 1;

    //Constructor for iron graphical object without scale (default scale will be used)
    public GIron(int x, int y) throws IOException {
        loadImage("pictures\\iron70x70.png", scale, x, y);

    }
}
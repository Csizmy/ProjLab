package GObjects;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GIron extends GObject{
    public double scale = 1;

    public GIron(int x, int y) throws IOException {
        loadImage("pictures\\iron70x70.png", scale, x, y);

    }

    public GIron(int x, int y, int s) throws IOException {
        loadImage("pictures\\iron70x70.png", s, x, y);
    }


}
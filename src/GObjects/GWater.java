package GObjects;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GWater extends GObject{
    public double scale = 0.05;

    public GWater()throws IOException {
        texture= ImageIO.read(new File("pictures\\water70x70.png"));
    }

    public GWater(int x, int y) throws IOException {
        loadImage("pictures\\water.png", scale, x, y);
    }

    public GWater(int x, int y, int s) throws IOException {
        loadImage("pictures\\water.png", s, x, y);
    }
}

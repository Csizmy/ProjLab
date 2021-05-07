package GObjects;

import java.io.IOException;

public class GWater extends GObject{
    public double scale = 0.05;

    public GWater(int x, int y) throws IOException {
        loadImage("pictures\\water.png", scale, x, y);
    }

    public GWater(int x, int y, int s) throws IOException {
        loadImage("pictures\\water.png", s, x, y);
    }
}

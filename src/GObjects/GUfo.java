package GObjects;

import java.io.IOException;

public class GUfo extends GObject{
    public double scale = 0.05;

    public GUfo(int x, int y) throws IOException {
        loadImage("pictures\\ufo.png", scale, x, y);
    }

    public GUfo(int x, int y, int s) throws IOException {
        loadImage("pictures\\ufo.png", s, x, y);
    }
}

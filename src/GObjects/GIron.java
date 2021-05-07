package GObjects;

import java.io.IOException;

public class GIron extends GObject{
    public double scale = 0.05;

    public GIron(int x, int y) throws IOException {
        loadImage("pictures\\ufo.png", scale, x, y);
    }

    public GIron(int x, int y, int s) throws IOException {
        loadImage("pictures\\iron.png", s, x, y);
    }
}
package GObjects;

import java.io.IOException;

public class GUranium extends GObject{
    public double scale = 0.05;

    public GUranium(int x, int y) throws IOException {
        loadImage("pictures\\uranium.png", scale, x, y);
    }

    public GUranium(int x, int y, int s) throws IOException {
        loadImage("pictures\\uuranium.png", s, x, y);
    }
}
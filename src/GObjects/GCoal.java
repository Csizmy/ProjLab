package GObjects;

import java.io.IOException;

public class GCoal extends GObject{
    public double scale = 0.05;

    public GCoal(int x, int y) throws IOException {
        loadImage("pictures\\coal.png", scale, x, y);
    }

    public GCoal(int x, int y, int s) throws IOException {
        loadImage("pictures\\coal.png", s, x, y);
    }
}
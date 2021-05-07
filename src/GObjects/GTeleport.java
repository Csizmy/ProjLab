package GObjects;

import java.io.IOException;

public class GTeleport extends GObject{
    public double scale = 0.05;

    public GTeleport(int x, int y) throws IOException {
        loadImage("pictures\\tp.png", scale, x, y);
    }

    public GTeleport(int x, int y, int s) throws IOException {
        loadImage("pictures\\tp.png", s, x, y);
    }
}
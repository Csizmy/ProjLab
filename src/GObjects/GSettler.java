package GObjects;

import java.io.IOException;

public class GSettler extends GObject{
    public double scale = 0.05;

    public GSettler(int x, int y) throws IOException {
        loadImage("pictures\\settler.png", scale, x, y);
    }

    public GSettler(int x, int y, int s) throws IOException {
        loadImage("pictures\\settler.png", s, x, y);
    }
}

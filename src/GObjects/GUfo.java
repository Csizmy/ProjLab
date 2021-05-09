package GObjects;

import java.io.IOException;

public class GUfo extends GObject{

    //Default scale for image resize
    public double scale = 0.05;

    //Constructor for ufo graphical object without scale (default scale will be used)
    public GUfo(int x, int y) throws IOException {
        loadImage("pictures\\ufo.png", scale, x, y);
    }

    //Constructor for ufo graphical object with scale
    public GUfo(int x, int y, int s) throws IOException {
        loadImage("pictures\\ufo.png", s, x, y);
    }
}

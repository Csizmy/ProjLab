package GObjects;

import java.io.IOException;

public class GTeleport extends GObject{

    //Default scale for image resize
    public double scale = 0.05;

    //Constructor for teleport graphical object without scale (default scale will be used)
    public GTeleport(int x, int y) throws IOException {
        loadImage("pictures\\tp.png", scale, x, y);
    }

    //Constructor for teleport graphical object with scale
    public GTeleport(int x, int y, int s) throws IOException {
        loadImage("pictures\\tp.png", s, x, y);
    }
}
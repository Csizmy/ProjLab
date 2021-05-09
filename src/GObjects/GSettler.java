package GObjects;

import java.io.IOException;

public class GSettler extends GObject{

    //Default scale for image resize
    public double scale = 0.05;

    //Constructor for settler graphical object without scale (default scale will be used)
    public GSettler(int x, int y) throws IOException {
        loadImage("pictures\\settler.png", scale, x, y);
    }

    //Constructor for settler graphical object with scale
    public GSettler(int x, int y, int s) throws IOException {
        loadImage("pictures\\settler.png", s, x, y);
    }
}

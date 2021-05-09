package GObjects;

import java.io.IOException;

public class GRobot extends GObject{

    //Default scale for image resize
    public double scale = 0.05;

    //Constructor for robot graphical object without scale (default scale will be used)
    public GRobot(int x, int y) throws IOException {
        loadImage("pictures\\robot.png", scale, x, y);
    }

    //Constructor for robot graphical object with scale
    public GRobot(int x, int y, int s) throws IOException {
        loadImage("pictures\\robot.png", s, x, y);
    }
}
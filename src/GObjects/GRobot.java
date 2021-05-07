package GObjects;

import java.io.IOException;

public class GRobot extends GObject{
    public double scale = 0.05;

    public GRobot(int x, int y) throws IOException {
        loadImage("pictures\\robot.png", scale, x, y);
    }

    public GRobot(int x, int y, int s) throws IOException {
        loadImage("pictures\\robot.png", s, x, y);
    }
}
package Materials;

import GObjects.GCoal;
import Objects.Asteroid;

import java.io.IOException;

public class Coal extends Material{

    //Coal constructor
    public Coal(Asteroid a)  {
        setName("Coal");
        setAsteroid(a);
    }
}
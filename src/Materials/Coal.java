package Materials;

import GObjects.GCoal;
import Objects.Asteroid;

import java.io.IOException;

//Class to represent coal material
public class Coal extends Material{

    //Coal constructor
    public Coal(Asteroid a)  {
        setName("Coal");
        setAsteroid(a);         //Containing asteroid
    }
}
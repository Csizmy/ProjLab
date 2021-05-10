
package Materials;

import GObjects.GWater;
import Objects.Asteroid;

import java.io.IOException;

//Class to represent water material
public class Water extends Material{

    //Water constructor
    public Water(Asteroid a){
        setName("Water");
        setAsteroid(a);         //Containing asteroid
    }


    //Water disapears if it is near sun
    @Override
    public boolean PeriMining(){
        asteroid.RemoveMaterial();
        return false;
    }
}
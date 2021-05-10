package Materials;


import GObjects.GUranium;
import Objects.Asteroid;

import java.io.IOException;

//Class to represent uranium material
public class Uranium extends Material{
    //Counting to 3 then explodes if the asteroid is near to sun
    private int charged;

    //Constructor
    public Uranium(Asteroid a){
        setName("Uranium");
        setAsteroid(a);
        charged = 0;
    }

    //Uranium explodes perihelion at the 3rd time
    @Override
    public boolean PeriMining(){
        charged++;

        if (charged == 3) {
            return true;
        }
        return false;
    }
}
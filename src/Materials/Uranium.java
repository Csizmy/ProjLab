package Materials;


import GObjects.GUranium;
import Objects.Asteroid;

import java.io.IOException;

public class Uranium extends Material{
    //3ig számol, majd 3nál felrobban napközelben.
    private int charged;

    //Konstuktor
    public Uranium(Asteroid a){
        setName("Uranium");
        setAsteroid(a);
        charged = 0;
    }

    //uranium explodes perihelion at the 3rd time
    @Override
    public void PeriMining(){
        charged++;

        if (charged == 3) {
            asteroid.Explode();
        }

    }
}
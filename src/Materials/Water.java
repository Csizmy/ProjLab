
package Materials;

import GObjects.GWater;
import Objects.Asteroid;

import java.io.IOException;

public class Water extends Material{
    public Water(Asteroid a){
        setName("Water");
        setAsteroid(a);
    }

    @Override
    public void PeriMining(){
        asteroid.RemoveMaterial();
    }
}
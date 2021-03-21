package Materials;

import Objects.Asteroid;

public class Water extends Material{
    public Water(Asteroid a){
        setName("Water");
        setAsteroid(a);
    }

    @Override
    void periMining(){
        asteroid.RemoveMaterial();      //water evaporates perihelion
    }
}
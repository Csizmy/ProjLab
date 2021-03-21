package Materials;

import Objects.Asteroid;

public class Uranium extends Material{
    public Uranium(Asteroid a){
        setName("Uranium");
        setAsteroid(a);
    }

    @Override
    void periMining(){
        asteroid.Explode();             //uranium explodes perihelion
    }
}
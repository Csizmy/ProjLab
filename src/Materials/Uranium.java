package Materials;

import Objects.Asteroid;

public class Uranium extends Material{
    public Uranium(Asteroid a){
        setName("Uranium");
        setAsteroid(a);
    }

    @Override
    public void PeriMining(){                           //uranium explodes perihelion
        System.out.println("Felrobban az uránium");
        asteroid.Explode();

    }
}
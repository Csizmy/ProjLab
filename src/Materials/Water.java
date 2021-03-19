package Materials;

import Objects.Asteroid;

public class Water extends Material{
    Water(Asteroid a){
        this.setName("Water");
        this.setAsteroid(a);
    }

    @Override
    void periMining(){

    }
}
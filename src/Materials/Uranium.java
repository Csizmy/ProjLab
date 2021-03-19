package Materials;

import Objects.Asteroid;

public class Uranium extends Material{
    Uranium(Asteroid a){
        this.setName("Uranium");
        this.setAsteroid(a);
    }

    @Override
    void periMining(){

    }
}
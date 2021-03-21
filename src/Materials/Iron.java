package Materials;

import Objects.Asteroid;

public class Iron extends Material{
    public Iron(Asteroid a){
        setName("Iron");
        setAsteroid(a);
    }

    @Override
    public Material PeriMining() {
        return this;
    }
}
package Materials;

import Objects.Asteroid;

public class Water extends Material{
    public Water(Asteroid a){
        this.setName("Water");
    }

    @Override
    public Material PeriMining() {
        return null;
    }
}
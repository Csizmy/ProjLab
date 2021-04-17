
package Materials;

import Objects.Asteroid;

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
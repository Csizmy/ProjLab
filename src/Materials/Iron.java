package Materials;

import Objects.Asteroid;

public class Iron extends Material{
    Iron(Asteroid a){
        this.setName("Iron");
        this.setAsteroid(a);
    }
}
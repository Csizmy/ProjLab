package Materials;

import Objects.*;

public abstract class Material {
    protected String name;
    protected Asteroid asteroid;        //(?)The asteroid this material is in.



    void setName(String n){
        name = n;
    }

    Asteroid getAsteroid(){return asteroid;}

    void setAsteroid(Asteroid a){asteroid = a;}

    //Virtual
    public void periMining(){          //water and uranium behave differently perihelion
    }

    public String getName() {
        return name;
    }
}

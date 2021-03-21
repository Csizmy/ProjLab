package Materials;

import Objects.Asteroid;

public abstract class Material {
    protected String name;
    protected Asteroid asteroid;        //(?)The asteroid this material is in.

    String getName(){
        return name;
    }

    void setName(String n){
        name = n;
    }

    Asteroid getAsteroid(){return asteroid;}

    void setAsteroid(Asteroid a){asteroid = a;}

    //Virtual
    void periMining(){          //water and uranium behave differently perihelion
    }
}

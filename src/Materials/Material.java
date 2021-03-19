package Materials;

import Objects.Asteroid;

public class Material {
    private String name;
    private Asteroid asteroid;

    String getName(){
        return name;
    }

    void setName(String n){
        name = n;
    }

    Asteroid getAsteroid(){
        return asteroid;
    }

    void setAsteroid(Asteroid a){
        asteroid = a;
    }

    void periMining(){
    }
}

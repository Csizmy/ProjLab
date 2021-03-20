package Materials;

import Objects.Asteroid;

public class Material {
    private String name;
    private Asteroid asteroid;      //(?)The asteroid this material is in.

    String getName(){
        return name;
    }

    void setName(String n){
        name = n;
    }

    //Virtual
    void periMining(){
    }
}

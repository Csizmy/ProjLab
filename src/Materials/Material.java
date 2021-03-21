package Materials;

import Objects.Asteroid;

public abstract class Material {
    private String name;
    private Asteroid asteroid;      //(?)The asteroid this material is in.

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }

    //Virtual
    public abstract Material PeriMining();
}

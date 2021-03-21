package Miners;

import Materials.Material;
import Objects.Asteroid;
import Objects.Spacething;

import java.util.ArrayList;

public class Miner {
    private ArrayList<Material> backpack;
    private Spacething spacething;
    private String type;    //Type of miner (Robot or Settler)

    public void setName(String t){
        type = t;
    }

    public String getName(){
        return type;
    }

    //Miner constructor
    public Miner(){
        backpack = new ArrayList<Material>();
    }

    //Miner moves
    public void Move(Spacething s){
        spacething = s;
    }

    //Miner dies
    public void die(){
        System.out.println("Meghalt");
    };

    //Miner drills
    public void drill(){
        System.out.println("Fúr");
        if(this.spacething.getName() == "Asteroid"){
            spacething.
        }
    }
}

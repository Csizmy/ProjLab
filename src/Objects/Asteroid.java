package Objects;

import Materials.*;
import Miners.Miner;

import java.util.ArrayList;

public class Asteroid {
    private int layer;
    private boolean digged;
    private boolean perihelion;
    private Material material;
    private ArrayList<Miner> miners;
    
    public Asteroid() {
        //Set layer number
        layer = (int) Math.random()%7+3; //Min: 3 layer, Max: 10 layer

        digged = false; //Not digged

        miners = new ArrayList<Miner>();

        //Random anyag kerül az aszteroida közepébe
        int mat = (int) Math.random()%5;
        switch (mat){
            case 0: material = new Coal(this);
            case 1: material = new Iron(this);
            case 2: material = new Uranium(this);
            case 3: material = new Water(this);
            case 4: material = null;
        }
        
    }

    public void removeLayer(){
        layer--;
    }

    public void RemoveMaterial() {
        digged = true;
        material = null;
    }

    public void removeMiner(Miner m){
        miners.remove(m);
    }

    public void addMiner(Miner m){
        miners.add(m);
    }

    public void Explode(){
        for (Miner m: miners) {
            m.die();
        }
    }

}

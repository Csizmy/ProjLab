package Miners;

import Materials.*;
import Objects.*;

import java.util.ArrayList;

public abstract class Miner {

    // tárolja, hogy melyik aszteroidán van éppen a játékos
    protected Asteroid asteroid;
    // ez a raktár
    protected ArrayList<Material> backpack;

    //Miner konstruktor
    public Miner(Asteroid a){
        asteroid = a;
        backpack = new ArrayList<Material>();
    }

    //Miner mozgás függvénye aszteroidára
    public void Move(int asteroidID){
        if(asteroid.isNeigbour(asteroidID)){
            Spacething to;
            for (Spacething s: asteroid.getNeighbours()) {
                if(s.getId() == asteroid.getId()){
                    to = s;
                }
            }
            asteroid.removeMiner(this);
            to.


        }
    }




    //Miner meghal
    public void Die(){
        System.out.println("Meghalt");
        asteroid.removeMiner(this);
        asteroid=null;
    };

    //Miner fúr
    public boolean Drill(){
        System.out.println("Fúr");
        if(asteroid.getLayer() > 0){
            asteroid.removeLayer();
            return true;
        }
        return false;
    }

    // aszteroida robbanásnál a Minerek máshogy viselkednek
    public abstract void Explode();

    // backpack getter-e
    public ArrayList<Material> getBackpack() {
        return backpack;
    }
}

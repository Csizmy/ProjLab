package Miners;

import Materials.*;
import Objects.*;

import java.util.ArrayList;

public abstract class Miner {

    // tárolja, hogy melyik aszteroidán van éppen a játékos
    protected Spacething spacething;
    // ez a raktár
    protected ArrayList<Material> backpack;

    //Miner konstruktor
    public Miner(Spacething s){
        spacething = s;
        backpack = new ArrayList<Material>();
        s.addMiner(this);
    }

    //Miner mozgás függvénye aszteroidára
    public void Move(int asteroidID){
        System.out.println("Move start");
        if(spacething.isNeigbour(asteroidID)){
            Spacething to = null;
            for (Spacething s: spacething.getNeighbours()) {
                if(s.getId() == asteroidID){
                    to = s;
                }
            }
            if(to.getId()!=-1){
                spacething.removeMiner(this);
                to.addMiner(this);
                spacething = to;
                System.out.println("Move successfull");
            }
        }
        System.out.println("Move end");
    }

    public Spacething getSpacething(){
        return spacething;
    }


    //Miner meghal
    public void Die(){
        System.out.println("Meghalt");
        spacething.removeMiner(this);
        spacething=null;
    };

    //Miner fúr
    public boolean Drill(){
        if(spacething.getAsteroid()){
            System.out.println("Fúrni próbál");
            Asteroid a = (Asteroid) spacething;
            if(a.getLayer() > 0){
                a.removeLayer();
                System.out.println("Eggyel kisebb lett a réteg");
                return true;
            }
            System.out.println("Ez már ki van fúrva");
            return false;
        }
        System.out.println("Itt nem lehet fúrni");
        return false;
    }

    // aszteroida robbanásnál a Minerek máshogy viselkednek
    public abstract void Explode();

    // backpack getter-e
    public ArrayList<Material> getBackpack() {
        return backpack;
    }
}

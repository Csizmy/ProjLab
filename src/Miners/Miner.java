package Miners;

import Game_parts.Moveable;
import Materials.*;
import Objects.*;

import java.util.ArrayList;

public abstract class Miner implements Moveable {

    // tárolja, hogy melyik aszteroidán van éppen a játékos
    protected Spacething spacething;
    // ez a raktár
    protected ArrayList<Material> backpack;
    protected int id;

    public Miner(Spacething s, int _id){
        spacething = s;
        backpack = new ArrayList<Material>();
        s.addMiner(this);
        id = _id;
    }

    //Miner konstruktor
    public Miner(Spacething s){
        spacething = s;
        backpack = new ArrayList<Material>();
        s.addMiner(this);
    }

    //Miner mozgás függvénye aszteroidára
    @Override
    public void Move(int asteroidID){
        if(spacething.isNeigbour(asteroidID)){
            Spacething to = null;
            for (Spacething s: spacething.getNeighbours()) {
                if(s.getId() == asteroidID){
                    to = s;
                }
            }
            if(to.getId()!=-1){ /// ezmi? csak kivancsi vagyok-axel !!!!!!!!!
                spacething.removeMiner(this);
                to.addMiner(this);
                spacething = to;
            }
        }
    }

    //Miner meghal
    public void Die(){
        spacething.removeMiner(this);
        spacething=null;
    }

    //Miner fúr
    public boolean Drill(){
        if(spacething.isAsteroid()){
            Asteroid a = (Asteroid) spacething;
            if(a.getLayer()-a.getDigged()!= 0){
                a.removeLayer();
                return true;
            }
            return false;
        }
        return false;
    }

    // aszteroida robbanásnál a Minerek máshogy viselkednek
    public abstract void Explode();

    // backpack getter-e
    public ArrayList<Material> getBackpack() {
        return backpack;
    }

    // spacething getter-e
    public Spacething getSpacething(){
        return spacething;
    }

    public int getId(){return id;}

    public int getAsteroid(){return spacething.getId();}

}

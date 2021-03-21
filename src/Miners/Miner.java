package Miners;

import Materials.*;
import Objects.*;

import java.util.ArrayList;

public abstract class Miner {

    // tárolja, hogy melyik aszteroidán van éppen a játékos
    protected Asteroid asteroid;

    //Miner konstruktor
    public Miner(Asteroid a){
        asteroid = a;
    }

    //Miner mozgás függvénye
    public void Move(Spacething s){

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
}

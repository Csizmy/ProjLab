package Miners;

import Game_parts.Steppable;
import Objects.Spacething;

public class Ufo extends Miner implements Steppable {


    public Ufo(Spacething s, int _id) {
        super(s, _id);
    }

    public Ufo(Spacething s) {
        super(s);
    }

    //Az ufó nem tud fúrni, igy nála ez egy üres függvény.
    public boolean Drill() {
        return false;
    }

    //Az ufó ellopja a nyersanyagot a  kibányászatlan aszteroidáról, ha nincs felette köpeny.
    public void Steal() {
        //remove material, ha felvesz valamit.
        //TODO

    }

    //Aszteroida felrobbanásánál ...
    @Override
    public void Explode() {
        //TODO
    }

    //Az ufó mozog/helyben marad/nyersanyagot lop.
    @Override
    public void Step() {
        //TODO
    }
}

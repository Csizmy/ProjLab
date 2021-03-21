package Objects;

import java.util.ArrayList;

public abstract class Spacething {   //Az égitesteket reprezentálja (a játékban aszteroidák és teleportkapuk).
    protected ArrayList<Spacething> neighbours;


    //ha a megadott égitest az adott égitest szomszédja, akkor igaz értéket vesz fel, ha nem, akkor hamis
    public boolean isNeigbour(Spacething s){
        System.out.println("isNeighbour végrehajtodik.");
        for (Spacething n: neighbours) {
            if(n == s) return true;
        }
        return false;
    }
}

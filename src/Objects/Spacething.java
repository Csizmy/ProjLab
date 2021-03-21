package Objects;

import Miners.Miner;

import java.util.ArrayList;

public abstract class Spacething {   //Az égitesteket reprezentálja (a játékban aszteroidák és teleportkapuk).

    protected ArrayList<Spacething> neighbours = new ArrayList<Spacething>();
    private int id;                 //ID

    public Spacething(){

    }

    public Spacething(int asteroidID){
        id = asteroidID;
    }
    //ha a megadott égitest az adott égitest szomszédja, akkor igaz értéket vesz fel, ha nem, akkor hamis
    public boolean isNeigbour(int spacethingID){
        System.out.println("isNeighbour végrehajtodik.");
        for (Spacething n: neighbours) {
            if(n.getId() == spacethingID) return true;
        }
        return false;
    }

    public ArrayList<Spacething> getNeighbours() {
        return neighbours;
    }

    public void AddNeighbor(Spacething s){neighbours.add(s);}

    public void RemoveNeighbor(){};

    public int getId(){
        return id;
    }

    public abstract void removeMiner(Miner m);
    public abstract void  addMiner(Miner m);
}

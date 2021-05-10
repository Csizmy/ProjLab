package Objects;

import Miners.Miner;
import java.util.ArrayList;

/**
 * It represents the celestial bodies (asteroids and teleport gates in the game)
 * @author mzperx
 */
public abstract class Spacething {

    /**
     * List of neighbors
     */
    protected ArrayList<Spacething> neighbours = new ArrayList<Spacething>();
    /**
     * ID of the spacething
     */
    protected int id;


    /**
     * Spacething konstruktor
     */
    public Spacething(){}

    /**
     * Spacething konstruktor
     * @param asteroidID id of asteroid
     */
    public Spacething(int asteroidID){
        id = asteroidID;
    }

    /**
     * If the Spacething is a neighbor of that celestial body, it assumes a true value, if not, it is false
     * @param spacethingID id
     * @return true or false
     */
    public boolean isNeigbour(int spacethingID){
        for (Spacething n: neighbours) {
            if(n.getId() == spacethingID) return true;
        }
        return false;
    }

    /**
     * Getter of neighbor
     * @return list of neighbors
     */
    public ArrayList<Spacething> getNeighbours() {
        return neighbours;
    }

    /**
     * Add a new neighbor
     * @param s the new neighbor
     */
    public void AddNeighbor(Spacething s){neighbours.add(s);}

    /**
     * Remove a neighbor
     * @param s the neighbor
     */
    public void RemoveNeighbor(Spacething s){

        for (int i = 0; i < neighbours.size(); i++){
            if(s== neighbours.get(i)){
                neighbours.remove(i);
            }
        }
    }

    /**
     * Getter of ID
     * @return id
     */
    public int getId(){
        return id;
    }

    /**
     * Remove a miner from a spacething
     * @param m miner
     */
    public abstract void removeMiner(Miner m);

    /**
     * Add a newa miner to the spacething
     * @param m miner
     */
    public abstract void  addMiner(Miner m);

    /**
     * If the spacething is asteroid it's true, if it's not, false
     * @return true or false
     */
    public boolean isAsteroid(){return false;}

    /**
     * Getter of x coordinate
     * @return x coordinate
     */
    public abstract int getX();
    /**
     * Getter of y coordinate
     * @return y coordinate
     */
    public abstract int getY();
}

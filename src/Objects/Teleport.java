package Objects;

import Game_parts.*;
import Miners.*;

import java.util.Random;
/**
 * It represents the teleports
 * @author mzperx
 */
public class Teleport extends Spacething implements Moveable, Steppable {
    /**
     * the pair of the teleport
     */
    private Teleport pair;
    /**
     * if the sunstorm reaches the teleport, it goes crazy
     */
    boolean megkergult;

    // Teleport konstruktor

    /**
     * Constructor of the teleport
     * @param teleportID id
     */
    public Teleport(int teleportID){
        super(teleportID);
    }

    @Override
    public void removeMiner(Miner m) {}

    @Override
    public void addMiner(Miner m) {}

    /**
     * Set the pair of the teleport
     * @param pair the teleport pair
     */
    public void setPair(Teleport pair) {
        this.pair = pair;
    }

    /**
     * Get the pair of the teleport
     * @return pair
     */
    public Teleport getPair() {
        return pair;
    }

    /**
     * If (megkergult) then it can move
     * @param asteroidID id of asteroid
     */
    @Override
    public void Move(int asteroidID) {
        if (asteroidID == neighbours.get(0).getId()){
            return;
        }

        for (int i = 0; i < neighbours.get(0).neighbours.size(); i++)
            if (neighbours.get(0).neighbours.get(i).getId() == asteroidID) {
                neighbours.get(0).neighbours.get(i).AddNeighbor(this);
                this.AddNeighbor(neighbours.get(0).neighbours.get(i));

                neighbours.get(0).RemoveNeighbor(this);
                this.RemoveNeighbor(neighbours.get(0));
                return;
            }
    }

    /**
     * If (megkergult) then it can move
     * @param step type of move
     */
    @Override
    public void Step(String step) {
        Random r = new Random();
        if (megkergult)
            Move(r.nextInt(neighbours.get(0).neighbours.size()));
    }

    /**
     * Get x cooredinate of teleport
     * @return x coordinate
     */
    public int getX(){
        Asteroid a = (Asteroid) neighbours.get(0);
        return a.getX();
    }
    /**
     * Get y cooredinate of teleport
     * @return y coordinate
     */
    public int getY(){
        Asteroid a = (Asteroid) neighbours.get(0);
        return a.getY();
    }
}

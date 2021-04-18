package Objects;

import Game_parts.Moveable;
import Game_parts.Steppable;
import Miners.Miner;
import Miners.Settler;

public class Teleport extends Spacething implements Moveable, Steppable {

    private boolean enable;         //igaz, ha használható
    private Teleport pair;          //a teleport párja

    // Teleport konstruktor
    public Teleport(int teleportID){
        super(teleportID);
    }

    public Teleport(int teleportID, Asteroid a){
        super(teleportID);
        a.AddNeighbor(this);
        this.AddNeighbor(a);
    }

    @Override
    public void removeMiner(Miner m) {}

    @Override
    public void addMiner(Miner m) {}

    //Teleport továbbküldi az embert
    public void MoveForward() {}

    public void disable(){
        enable = false;
    }


    //Felrobban a teleport 2 párja
    public void OnExplode() {}

    // egy telepes táskájához adja
    public void AddToSettler(Settler s) {}

    // pair settere
    public void setPair(Teleport pair) {
        this.pair = pair;
    }

    // pair gettere
    public Teleport getPair() {
        return pair;
    }

    //Ha napvihar éri a teleportot, akkor néha mozog aszteroidáról aszteroidára.
    public void Megkergul() {
        //TODO
    }
    //ha megkergült, meghívódik és random mozog.
    @Override
    public void Move(int asteroidID) {
        //TODO
    }

    //ha megkergült, meghívódik és random mozog.
    @Override
    public void Step(String step) {
        //TODO
    }
}

package Objects;

import Miners.Settler;

public class Teleport extends  Spacething {

    private boolean enable;         //True when the Teleport can be used.
    private Teleport pair;          //The other part of this Teleport

    //Teleports to the other side.
    public void MoveForward() {
        System.out.println("MoveForward");
        //TODO
    }

    //Explode both Teleports connected.
    public void OnExplode() {
        System.out.println("OnExplode");
        //TODO
    }

    public void AddToSettler(Settler s) {
        System.out.println("AddToSettler");
        //TODO
    }

    public void setPair(Teleport pair) {
        this.pair = pair;
    }

    public Teleport getPair() {
        return pair;
    }
}

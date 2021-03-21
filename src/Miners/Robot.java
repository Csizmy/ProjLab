package Miners;

import Game_parts.*;
import Objects.*;

public class Robot extends Miner /*implements Steppable*/ {

    // Robot konstuktor
    Robot(Asteroid a) {
        super(a);
    }

    // ha felrobban az aszteroida (radioaktív anyag bányászásánál) a robot egy véletlenszerű szomszédos aszteroidásra kerül
    public void Explode() {
        Spacething s = asteroid.getNeighbor().get(Math.random()%(asteroid.getNeighbor().size()));
        Move(s);
    }

    //@Override
    public void Step() {
        // TODO
    }
}

package Miners;

import Game_parts.*;
import Materials.Coal;
import Materials.Iron;
import Materials.Uranium;
import Materials.Water;
import Objects.*;

public class Robot extends Miner implements Steppable {

    // Robot konstuktor
    public Robot(Asteroid a) {
        super(a);
    }

    // ha felrobban az aszteroida (radioaktív anyag bányászásánál) a robot egy véletlenszerű szomszédos aszteroidásra kerül
    public void Explode() {
        int i = (int) (Math.random()%(asteroid.getNeighbours().size()));
        Spacething s = asteroid.getNeighbours().get(i);
        Move(s);
    }

    //@Override
    public void Step() {
        int mat = (int) Math.random()%5;
        switch (mat){
            case 0:
                int i = (int) (Math.random()%(asteroid.getNeighbours().size()));
                Spacething s = asteroid.getNeighbours().get(i);
                Move(s);
                break;
            case 1:
                Drill();
                break;
        }
    }
}

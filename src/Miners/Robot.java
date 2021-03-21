package Miners;

import Game_parts.*;
import Materials.Coal;
import Materials.Iron;
import Materials.Uranium;
import Materials.Water;
import Objects.*;

public class Robot extends Miner implements Steppable {

    // Robot konstuktor
    public Robot(Spacething s) {
        super(s);
    }

    // ha felrobban az aszteroida (radioaktív anyag bányászásánál) a robot egy véletlenszerű szomszédos aszteroidásra kerül
    public void Explode() {
        int i = (int) (Math.random()%(spacething.getNeighbours().size()));
        Spacething s = spacething.getNeighbours().get(i);
        Move(s.getId());
    }

    @Override
    public void Step() {
        int mat = (int) Math.random() * 2;
        switch (mat){
            case 0:
                int i = (int) (Math.random()%(spacething.getNeighbours().size()));
                Spacething s = spacething.getNeighbours().get(i);
                Move(s.getId());
                break;
            case 1:
                Drill();
                break;
        }
    }
}

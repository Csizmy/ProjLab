package Miners;

import Game_parts.*;
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
    public void Step() {  // a robot lépése, vagy lép, vagy fúr
        int mat = (int) (Math.random()*2);
        switch (mat){
            case 0:  // mozgás
                System.out.println("Robot mozogni akar");
                int i = (int) (Math.random()%(spacething.getNeighbours().size()));
                Spacething s = spacething.getNeighbours().get(i);
                Move(s.getId());
                break;
            case 1:  // fúrás
                System.out.println("Robor fúrni akar");
                Drill();
                break;
        }
    }
}

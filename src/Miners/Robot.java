package Miners;

import Game_parts.*;
import Objects.*;

public class Robot extends Miner implements Steppable {

    // Robot konstuktor
    public Robot(Spacething s, int _id) {
        super(s,_id);
    }

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
                int i = (int) (Math.random()%(spacething.getNeighbours().size()));
                Spacething s = spacething.getNeighbours().get(i);
                Move(s.getId());
                break;
            case 1:  // fúrás
                Drill();
                break;
        }
    }

    //A case0 esetben lehetne ez a fv. ha kell a Moveable fv. felülírása. - Bence

}

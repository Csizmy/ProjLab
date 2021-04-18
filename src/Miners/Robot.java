package Miners;

import Game_parts.*;
import Objects.*;

import java.util.Random;

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
    public void Step(String step) {  // a robot lépése, vagy lép, vagy fúr
        Random r = new Random();
        int randomNeighbor_id = spacething.getNeighbours().get(r.nextInt(spacething.getNeighbours().size())).getId();
        switch (step) {
            case "Move":
                Move(randomNeighbor_id);
                System.out.println("Robot " + id + " A mozgás sikeres ide: Asteroid " + randomNeighbor_id + ".");
                break;


            case "Drill":
                if (Drill()) {
                    Asteroid a = (Asteroid) spacething;
                    System.out.println("Robot " + id + " A fúrás sikeres " + (a.getLayer() - a.getDigged()) + " réteg maradt Asteroid " + a.getId());
                }
                else
                    System.out.println("Robot " + id + " A fúrás sikertelen Asteroid " + spacething.getId());
                break;


            case "":
                if (r.nextInt(2) == 0){
                    Move(randomNeighbor_id);
                    System.out.println("Robot " + id + " A mozgás sikeres ide: Asteroid " + randomNeighbor_id + ".");
                }
                else{
                    if (Drill()) {
                        Asteroid a = (Asteroid) spacething;
                        System.out.println("Robot " + id + " A fúrás sikeres " + (a.getLayer() - a.getDigged()) + " réteg maradt Asteroid " + a.getId());
                    }
                    else
                        System.out.println("Robot " + id + " A fúrás sikertelen Asteroid " + spacething.getId());
                }
                break;


            default: System.out.println("Helytelen parancs! Formatum: ehh nem tudom hol a parancsbeolvasos resz"); break;
        }
    }

    //A case0 esetben lehetne ez a fv. ha kell a Moveable fv. felülírása. - Bence

}

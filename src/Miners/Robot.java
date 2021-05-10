package Miners;

import Game_parts.*;
import Objects.*;

import java.util.Random;

public class Robot extends Miner implements Steppable {

    /**
     *  Robot constructor with id
     * @param s the Spacething that the robot is on.
     * @parma _id the id of the robot.
     */
    public Robot(Spacething s, int _id) {
        super(s,_id);
    }

    /**
     *  Robot constructor without id
     * @param s the Spacething that the robot is on.
     */
    public Robot(Spacething s) {
        super(s);
        name = "robot";
    }

    /**
     *  If asteroid explodes, robot moves to another asteroid wich is in the neighbourhood
     */
    public void Explode() {
        int i = (int) (Math.random()%(spacething.getNeighbours().size()));      //get a random asteroid in the neighbourhood
        Spacething s = spacething.getNeighbours().get(i);
        Move(s.getId());                                    //Move robot to this asteroid
    }

    /**
     *  Robot moves (drill or move)
     */
    @Override
    public void Step(String step) {
        Random r = new Random();
        int randomNeighbor_id = spacething.getNeighbours().get(r.nextInt(spacething.getNeighbours().size())).getId();      //Moves to random asteroid
        switch (step) {

            //Robot moves
            case "Move":
                Move(randomNeighbor_id);
                System.out.println("Robot " + id + " A mozgás sikeres ide: Asteroid " + randomNeighbor_id + ".");
                break;

            //Robot drills
            case "Drill":
                if (Drill()) {
                    Asteroid a = (Asteroid) spacething;     //Get the asteroid
                    System.out.println("Robot " + id + " A fúrás sikeres " + (a.getLayer() - a.getDigged()) + " réteg maradt Asteroid " + a.getId());       //Remove the layer of the asteroid
                }
                else
                    System.out.println("Robot " + id + " A fúrás sikertelen Asteroid " + spacething.getId());       //Drill unsuccessfull
                break;

            //Without parameters the robot makes a random move
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

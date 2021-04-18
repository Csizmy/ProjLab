package Miners;

import Game_parts.Steppable;
import Objects.Asteroid;
import Objects.Spacething;

import java.util.Random;

public class Ufo extends Miner implements Steppable {


    public Ufo(Spacething s, int _id) {
        super(s, _id);
    }

    public Ufo(Spacething s) {
        super(s);
    }

    //Az ufó nem tud fúrni, igy nála ez egy üres függvény.
    public boolean Drill() {
        return false;
    }

    //Az ufó ellopja a nyersanyagot a  kibányászatlan aszteroidáról, ha nincs felette köpeny.
    public boolean Steal() {
        //remove material, ha felvesz valamit.
        if(spacething.getAsteroid()) {
            Asteroid asteroid = (Asteroid) spacething;
            System.out.println("Lopas elkezdése");

            //ha nincs kibányászva és nem üres
            if (asteroid.getLayer() == asteroid.getDigged() && asteroid.getMaterial() != null) {
                asteroid.setMaterial(null);
                System.out.println("Lopas megtörtént");
                return true;
            }
            System.out.println("Ki van bányászva vagy nincs benne semmi.");
            return false;
        }
        System.out.println("Itt nem lehet bányászni");
        return false;
    }

    //Aszteroida felrobbanásánál ...
    @Override
    public void Explode() {
        //TODO
    }

    //Az ufó mozog/helyben marad/nyersanyagot lop.
    @Override
    public void Step(String step) {
        Random r = new Random();
        int randomNeighbor_id = spacething.getNeighbours().get(r.nextInt(spacething.getNeighbours().size())).getId();
        switch (step) {
            case "Move":
                Move(randomNeighbor_id);
                System.out.println("Ufo " + id + " A mozgás sikeres ide: Asteroid " + randomNeighbor_id + ".");
                break;


            case "Steal":
                if (Steal()) {
                    Asteroid a = (Asteroid) spacething;
                    System.out.println("Ufo " + id + " A lopás sikeres Asteroid " + a.getId());
                }
                else
                    System.out.println("Ufo " + id + " A lopás sikertelen Asteroid " + spacething.getId());
                break;


            case "":
                if (r.nextInt(2) == 0){
                    Move(randomNeighbor_id);
                    System.out.println("Ufo " + id + " A mozgás sikeres ide: Asteroid " + randomNeighbor_id + ".");
                }
                else{
                    if (Steal()) {
                        Asteroid a = (Asteroid) spacething;
                        System.out.println("Ufo " + id + " A lopás sikeres Asteroid " + a.getId());
                    }
                    else
                        System.out.println("Ufo " + id + " A lopás sikertelen Asteroid " + spacething.getId());
                }
                break;


            default: System.out.println("Helytelen parancs! Formatum: ehh nem tudom hol a parancsbeolvasos resz"); break;
        }
    }
}

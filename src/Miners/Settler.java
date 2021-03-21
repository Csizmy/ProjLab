package Miners;

import Game_parts.*;
import Materials.*;
import Objects.*;

import java.util.ArrayList;

public class Settler extends Miner{

    // a telepesnél lévő telepotokat tárolja
    private ArrayList<Teleport> teleports;

    // Settler konstruktor
    public Settler(Asteroid a){
        super(a);

        teleports = new ArrayList<Teleport>();

        //asteroid.addMiner(this);
    }

    // ha felrobban az aszteroida (radioaktív anyag bányászásánál) a telepes meghal
    @Override
    public void Explode() {
        Die();
    }

    // ha nincs még kiásva az aszteroida, akkor egy rétegnyit ás rajta
    public boolean Mine(){
        if(spacething.getAsteroid()) {
            Asteroid asteroid = (Asteroid) spacething;
            System.out.println("Bányászás elkezdése");

            if (asteroid.getLayer() == asteroid.getDigged() && asteroid.getMaterial() != null) {

                if (asteroid.getPerihelion()) {
                    asteroid.getMaterial().PeriMining();
                    System.out.println("Valami baj van a napközelség miatt\n");
                } else {
                    AddMaterial(asteroid.getMaterial());
                    System.out.println("Nincs baj, bekerült a táskába a " + asteroid.getMaterial().getName());
                }
                System.out.println("Bányászás megtörtént");
                return true;
            }
            System.out.println("Ki van bányászva vagy nincs benne semmi.");
            return false;
        }
        System.out.println("Itt nem lehet bányászni");
        return false;
    }

    //ellenőrzi a teleport építéséhez szükséges nyersanyagot, és ha tudja, megépíti
    public boolean BuildTp(){

        if(teleports.size()==0){
            int iron = 0;
            int water = 0;
            int uranium = 0;

            for(int i = 0; i < backpack.size(); i++){  //keresi

                if(backpack.get(i).getName()=="Uranium"){
                    uranium++;
                }
                else if(backpack.get(i).getName()=="Water"){
                    water++;
                }
                if(backpack.get(i).getName()=="Iron"){
                    iron++;
                }
            }

            if(iron>=2 && water>=1 && uranium>=1){

                System.out.println("Van elég nyersanyag");
                for (int i = 0; i < backpack.size(); i++){ // kiveszi

                    if(backpack.get(i).getName()=="Uranium"){
                        backpack.remove(i);
                        break;
                    }
                }

                for (int i = 0; i < backpack.size(); i++){ // kiveszi

                    if(backpack.get(i).getName()=="Uranium"){
                        backpack.remove(i);
                        break;
                    }
                }

                for (int i = 0; i < backpack.size(); i++){ // kiveszi

                    if(backpack.get(i).getName()=="Water"){
                        backpack.remove(i);
                        break;
                    }
                }

                for (int i = 0; i < backpack.size(); i++){ // kiveszi

                    if(backpack.get(i).getName()=="Iron"){
                        backpack.remove(i);
                        break;
                    }
                }

                Teleport t1 = new Teleport(0);
                Teleport t2 = new Teleport(0);

                t1.setPair(t2);
                t2.setPair(t1);

                teleports.add(t1);
                teleports.add(t2);

                System.out.println("A táskába került a teleportkapu-pár.");

                return true;
            }
            System.out.println("Hiba, nincs elég anyag.");
            return false;
        }
        System.out.println("Hiba, nem fér a táskába a teleportkapu-pár.");
        return false;
    }

    //ellenőrzi, hogy az adott aszteroidán van-e a lerakni kívánt telepotkapu párja, ha nem, akkor lerakja
    public boolean PlaceTp(Teleport t) {

        if(spacething.getAsteroid()) {
            Asteroid a = (Asteroid) spacething;
            if (!t.getPair().isNeigbour(a.getId())) {
                t.AddNeighbor(spacething);
                spacething.AddNeighbor(t);
                System.out.println("Leraktam a teleportkaput");
                return true;
            }
            System.out.println("Itt van a teleportkapu párja is, nem lehet ide lerakni");
            return false;
        }
        System.out.println("Ide nem tudsz teleportot kapni");
        return false;
    }

    //  ellenőzi a nyersanyagokat és megépíti a robotot
    public boolean BuildRobot(){

        int iron = 0;
        int coal = 0;
        int uranium = 0;

        for(int i = 0; i < backpack.size(); i++){  //keresi

            if(backpack.get(i).getName()=="Uranium"){
                uranium++;
            }
            else if(backpack.get(i).getName()=="Coal"){
                coal++;
            }
            if(backpack.get(i).getName()=="Iron"){
                iron++;
            }
        }

        if(iron>0 && coal>0 && uranium>0){
            System.out.println("Van hozzá elég anyag");

            for (int i = 0; i < backpack.size(); i++){ // kiveszi

                if(backpack.get(i).getName()=="Uranium"){
                    backpack.remove(i);
                    break;
                }
            }
            for (int i = 0; i < backpack.size(); i++){ // kiveszi

                if(backpack.get(i).getName()=="Coal"){
                    backpack.remove(i);
                    break;
                }
            }
            for (int i = 0; i < backpack.size(); i++){ // kiveszi

                if(backpack.get(i).getName()=="Iron"){
                    backpack.remove(i);
                    break;
                }
            }

            Robot r = new Robot(spacething);
            spacething.addMiner(r);
            System.out.println("Kész a robot");
            return true;
        }

        System.out.println("Nem sikerült a robot építés");
        return false;
    }

    // ha kap be valódi anyagot, akkor hozzáadja a táskához
    public boolean AddMaterial(Material m){

        if(backpack.size()<10 && m != null) {
            backpack.add(m);
            System.out.println("Van elég hely a táskában, bele lett rakva az anyag");
            return true;
        }
        System.out.println("Nincs anyag vagy tele a táska");
        return false;
    }


}

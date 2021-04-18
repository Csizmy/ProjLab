package Miners;

import Materials.*;
import Objects.*;

import java.util.ArrayList;

public class Settler extends Miner{

    // a telepesnél lévő telepotokat tárolja
    private ArrayList<Teleport> teleports;

    public Settler(Asteroid a, int _id){
        super(a, _id);
        teleports = new ArrayList<Teleport>();
    }

    // Settler konstruktor
    public Settler(Asteroid a){
        super(a);
        teleports = new ArrayList<Teleport>();
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

            //ha nincs kibányászva és nem üres
            if (asteroid.getLayer() == asteroid.getDigged() && asteroid.getMaterial() != null) {

                if (asteroid.getPerihelion()) {  // napközelben van
                    asteroid.getMaterial().PeriMining();
                    System.out.println("Valami baj van a napközelség miatt\n");
                }
                else {
                    AddMaterial(asteroid.getMaterial());
                    System.out.println("Nincs baj, bekerült a táskába a " + asteroid.getMaterial().getName());
                    asteroid.setMaterial(null);
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
    public boolean BuildTp(int id1, int id2){

        if(teleports.size()<=1){  // csak akkor tud építeni, ha nulla vagy egy teleport van a táskájában
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

            if(iron>=2 && water>=1 && uranium>=1){  // ha megvan az anyagmennyiség

                System.out.println("Van elég nyersanyag");
                for (int i = 0; i < backpack.size(); i++){ // kiveszi

                    if(backpack.get(i).getName()=="Uranium"){
                        backpack.remove(i);
                        break;
                    }
                }

                for (int i = 0; i < backpack.size(); i++){

                    if(backpack.get(i).getName()=="Uranium"){
                        backpack.remove(i);
                        break;
                    }
                }

                for (int i = 0; i < backpack.size(); i++){

                    if(backpack.get(i).getName()=="Water"){
                        backpack.remove(i);
                        break;
                    }
                }

                for (int i = 0; i < backpack.size(); i++){

                    if(backpack.get(i).getName()=="Iron"){
                        backpack.remove(i);
                        break;
                    }
                }

                Teleport t1 = new Teleport(id1);
                Teleport t2 = new Teleport(id2);

                t1.setPair(t2); // egymmás párjai lesznek
                t2.setPair(t1);

                teleports.add(t1); //bekerül a táskába
                teleports.add(t2);

                return true;
            }
            return false;
        }
        return false;
    }

    //ellenőrzi, hogy az adott aszteroidán van-e a lerakni kívánt telepotkapu párja, ha nem, akkor lerakja
    public boolean PlaceTp(Teleport t) {

        if(spacething.getAsteroid()) {  // ha aszteroidán van
            Asteroid a = (Asteroid) spacething;
            if (!t.getPair().isNeigbour(a.getId())) {  // ha a párja nincs az adott aszteroidán
                t.AddNeighbor(spacething);
                spacething.AddNeighbor(t);
                return true;
            }
            return false;
        }
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

            for (int i = 0; i < backpack.size(); i++){ // kiveszi

                if(backpack.get(i).getName()=="Uranium"){
                    backpack.remove(i);
                    break;
                }
            }
            for (int i = 0; i < backpack.size(); i++){

                if(backpack.get(i).getName()=="Coal"){
                    backpack.remove(i);
                    break;
                }
            }
            for (int i = 0; i < backpack.size(); i++){

                if(backpack.get(i).getName()=="Iron"){
                    backpack.remove(i);
                    break;
                }
            }

            Robot r = new Robot(spacething);
            spacething.addMiner(r); // lerakja az adott aszteroidára a robotot
            return true;
        }
        return false;
    }

    // ha kap be valódi anyagot, akkor hozzáadja a táskához
    public boolean AddMaterial(Material m){

        if(backpack.size()<10 && m != null) {  // csak akkor adja be, ha van hely még neki
            backpack.add(m);
            return true;
        }
        return false;
    }

    public Teleport getTP () {
        return teleports.get(0);
    }

    public void listBackPack(){
        if(backpack.isEmpty()==true){
            System.out.println("-");
            return;
        }
        System.out.print(this.getId()+"Taska tartalma: ");
        for(Material m: backpack){
            System.out.print(m.getName()+" ");
        }
    }
}

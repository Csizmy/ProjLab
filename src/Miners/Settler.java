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
        name = "settler";

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
        if(spacething.isAsteroid()) {
            Asteroid asteroid = (Asteroid) spacething;

            //ha nincs kibányászva és nem üres
            if (asteroid.getLayer() == asteroid.getDigged() && asteroid.getMaterial() != null) {

                if (asteroid.getPerihelion()) {  // napközelben van
                    asteroid.getMaterial().PeriMining();
                }
                AddMaterial(asteroid.getMaterial());
                System.out.println("truevagyfalselol"+AddMaterial(asteroid.getMaterial()));
                asteroid.setMaterial(null);

                System.out.println("helloooka"+getBackpack().size());

                System.out.println("Settler " + id + " A bányászat sikeres Asteroid " + getAsteroid() + " " + getBackpack().get(getBackpack().size()-1).getName());
                return true;
            }
            System.out.println("Settler " + id + " A bányászat sikertelen Asteroid " + getAsteroid());
            return false;
        }
        System.out.println("Settler " + id + " A bányászat sikertelen Asteroid " + getAsteroid());
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
    public boolean PlaceTp(Teleport t, int asteroid_id) {

        if(spacething.isAsteroid()) {  // ha aszteroidán van
            Asteroid a = (Asteroid) spacething;
            if (t.getPair().getNeighbours().size()==0 || asteroid_id!=t.getPair().getNeighbours().get(0).getId()) {  // ha a párja nincs az adott aszteroidán
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

    //  ellenőzi a nyersanyagokat és megépíti a robotot megadott ID-val
    public boolean BuildRobot(int _id){

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

            Robot r = new Robot(spacething, _id);
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
    @Override
    public void Move(int asteroidID){
        Teleport t;
        boolean tpkapcsolat = false;
        for (int i = 0; i < spacething.getNeighbours().size(); i++){
            if (!spacething.getNeighbours().get(i).isAsteroid()) {
                t = (Teleport) spacething.getNeighbours().get(i);
                t = t.getPair();
                if (t.getNeighbours().get(0).getId() == asteroidID)
                    tpkapcsolat = true;
            }
        }
        if(spacething.isNeigbour(asteroidID) || tpkapcsolat){
            Spacething to = null;
            for (Spacething s: spacething.getNeighbours()) {
                if(s.getId() == asteroidID){
                    to = s;
                }
            }
            if(tpkapcsolat){
                for (int i = 0; i < spacething.getNeighbours().size(); i++) {
                    if (!spacething.getNeighbours().get(i).isAsteroid()) {
                        t = (Teleport) spacething.getNeighbours().get(i);
                        t = t.getPair();
                        to = t.getNeighbours().get(0);
                    }
                }

            }

            if(to.getId()!=-1){
                spacething.removeMiner(this);
                to.addMiner(this);
                spacething = to;
            }
        }

    }

    public Teleport getTP () {
        return teleports.get(0);
    }

    public ArrayList<Teleport> getTeleports(){return teleports;}

    public void listBackPack(){
        if(backpack.isEmpty()==true&& teleports.isEmpty()==true){
            System.out.println("-");
            return;
        }
        System.out.print(this.getId()+"Taska tartalma: ");
        for(Material m: backpack){
            System.out.print(m.getName()+" ");
        }

        for(Teleport t: teleports){
            System.out.print("Teleport "+t.getId()+" ");
        }
    }
}

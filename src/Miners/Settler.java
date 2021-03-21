package Miners;

import Game_parts.*;
import Materials.*;
import Objects.*;

import java.util.ArrayList;

public class Settler extends Miner{

    // ez a telepes raktára, max 10 nyersanyag lehet benne
    private ArrayList<Material> backpack;
    // a telepesnél lévő telepotokat tárolja
    private ArrayList<Teleport> teleports;

    // Settler konstruktor
    public Settler(Asteroid a){
        super(a);
        backpack = new ArrayList<Material>();
        teleports = new ArrayList<Teleport>();
    }

    // ha felrobban az aszteroida (radioaktív anyag bányászásánál) a telepes meghal
    @Override
    public void Explode() {
        Die();
    }

    // backpack getter-e
    public ArrayList<Material> getBackpack(){return backpack;}

    // ha nincs még kiásva az aszteroida, akkor egy rétegnyit ás rajta
    public boolean Mine(){

        if(asteroid.getLayer() == asteroid.getDigged() && asteroid.getMaterial()!=null){

            if(asteroid.getPerihelion()){
                asteroid.getMaterial().PeriMining();
            }

            else{
                AddMaterial(asteroid.getMaterial());
            }
            return true;
        }
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

                Teleport t1 = new Teleport();
                Teleport t2 = new Teleport();

                t1.setPair(t2);
                t2.setPair(t1);

                teleports.add(t1);
                teleports.add(t2);

                return true;
            }
            return false;
        }
        return false;
    }

    //ellenőrzi, hogy az adott aszteroidán van-e a lerakni kívánt telepotkapu párja, ha nem, akkor lerakja
    public boolean PlaceTp(Teleport t) {
        if (t.getPair().IsNeigbour(t)) {
            t.AddNeighbor(asteroid);
            asteroid.AddNeighbor(t);
            return true;
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

            Robot r = new Robot(asteroid);
            asteroid.addMiner(r);

            return true;
        }

        return false;
    }

    // ha kap be valódi anyagot, akkor hozzáadja a táskához
    public boolean AddMaterial(Material m){

        if(backpack.size()<10 && m != null) {
            backpack.add(m);
            return true;
        }
        return false;
    }
}

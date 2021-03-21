package Objects;

import Materials.*;
import Miners.Miner;

import java.util.ArrayList;

public class Asteroid extends Spacething {
    private int layer;              //Maximum layers.
    private int digged;             // Removed layers.
    private boolean perihelion;     //Close to Sun or not.
    private Material material;
    private ArrayList<Miner> miners;
    
    public Asteroid() {
        //Set layer number
        layer = (int) Math.random()%7+3;    //Min: 3 layer, Max: 10 layer

        digged = 0;     //0 layers dug yet.

        miners = new ArrayList<Miner>();

        //Random anyag kerül az aszteroida közepébe
        int mat = (int) Math.random()%5;
        switch (mat){
            case 0: material = new Coal(this);
            case 1: material = new Iron(this);
            case 2: material = new Uranium(this);
            case 3: material = new Water(this);
            case 4: material = null;
        }
        
    }

    //csökkenti a sziklarétegek számát az adott aszteroidán
    public void removeLayer(){
        digged++;
        System.out.println("Csökkent a rétegem.");          //layer--;
    }

    // Ha nem üres az aszteroida (és a napközelség nem zavar bele a műveletbe), kiveszi belőle az adott nyersanyagot
    public void RemoveMaterial() {
        digged = layer;
        material = null;
    }

    //Egy játékost "eltávolít" a rajta tartózkodók közül
    public void removeMiner(Miner m){
        miners.remove(m);
        System.out.println("Töröltem a minert.");
    }


    //Egy játékost "hozzáad" a rajta tartózkodókhoz
    public void addMiner(Miner m){ miners.add(m);}

    //Az aszteroida felrobban ha uránt napközelben bányásznak, ekkor a rajta levő Miner-ekre különbözően hat
    public void Explode(){
        System.out.println("Explode start.");
        for (Miner m: miners) {
            m.Explode();
        }
        System.out.println("Explode done.");
    }

    //Visszatér a bolygón lévő telepesek nyersanyag listájával.
    public ArrayList<Material> CountDiffMat(){
        System.out.println("Countdifmat start.");
        ArrayList<Material> materials = new ArrayList<Material>();
        for(int i = 0; i < miners.size(); i++) {
            ArrayList<Material> backpack = miners.get(i).getBackpack();
            for (int j = 0; j < backpack.size(); j++) {
                materials.add(backpack.get(j));
            }
        }
        System.out.println("Countdifmat done.");
        return materials;
    }

    //A játék elején, beállítja az aktuális szomszédokat és a napközelség értékét.
    public void Init(){
        System.out.println("Init végrehajtodik.");
    }

    //A napközelséget vizsgálom és irom felül.
    public void Step(){
        System.out.println("Step végrehajtodik.");
    }

    // a megadott teleportot az aszteroidához köti
    public void SetUpTeleport(Teleport t){
        System.out.println("setupteleport");
    }

    public int getLayer() {
        return layer;
    }

    public Material getMaterial() {
        return material;
    }

    public boolean getPerihelion(){return perihelion;}

    public int getDigged() {
        return digged;
    }
}

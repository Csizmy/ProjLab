package Objects;

import Game_parts.Game;
import Materials.*;
import Miners.Miner;

import java.util.ArrayList;
import java.util.Random;

public class Asteroid extends Spacething {
    private int layer;              //Maximum layers.
    private int digged;             // Removed layers.
    private boolean perihelion;     //Close to Sun or not.
    private Material material;
    private ArrayList<Miner> miners;
    private int id;                 //ID

    private Random rand = new Random();
    
    public Asteroid(int asteroidID) {
        super(asteroidID);
        //Set layer number
        layer = (int) rand.nextInt(7)+3;    //Min: 3 layer, Max: 10 layer

        digged = 0;     //0 layers dug yet.

        miners = new ArrayList<Miner>();

        id = asteroidID;

        //Random anyag kerül az aszteroida közepébe
        int mat = (int) rand.nextInt(5);
        switch (mat){
            case 0: material = new Coal(this); break;
            case 1: material = new Iron(this); break;
            case 2: material = new Uranium(this); break;
            case 3: material = new Water(this); break;
            case 4: material = null;
        }

        if(material!=null)
            System.out.println(id + ". Asteroida létrehozva, nyersanyag:" + material.getName() + " : " + digged + " : " + layer);
        else
            System.out.println(id + ". Asteroida létrehozva, nyersanyag: Üres : " + digged + " : " + layer);
        
    }

    public Asteroid(int asteroidID, int layer, boolean perihelion, Material material) {
        super(asteroidID);

        this.layer = layer;
        this.digged = 0;
        this.miners = new ArrayList<Miner>();
        this.id = asteroidID;
        this.perihelion = perihelion;

        if(material!=null)
            System.out.println(id + ". Asteroida létrehozva, nyersanyag:" + material.getName() + " : " + digged + " : " + layer);
        else
            System.out.println(id + ". Asteroida létrehozva, nyersanyag: Üres : " + digged + " : " + layer);
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
    public void addMiner(Miner m){ miners.add(m);
    System.out.println("Addoltam a minert.");
    }

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

    public boolean getPerihelion(){
        return perihelion;
    }

    public int getDigged() {
        return digged;
    }

    public int getId(){
        return id;
    }

    public ArrayList<Miner> getMiners(){
        return  miners;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
}

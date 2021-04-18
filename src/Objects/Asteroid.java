package Objects;

import Game_parts.Game;
import Materials.*;
import Miners.Miner;

import java.util.ArrayList;
import java.util.Random;

public class Asteroid extends Spacething {
    private int layer;              // Sziklaréteg
    private int digged;             // Kiásott rétegek
    private boolean perihelion;     // napközelség
    private Material material;
    private ArrayList<Miner> miners;

    private Random rand = new Random();

    public Asteroid(int asteroidID, int lay, int d, String mat){
        super(asteroidID);
        layer = lay;
        digged = d;
        miners = new ArrayList<Miner>();
        if(mat == "Coal"){material = new Coal(this);}
        if(mat == "Iron"){material = new Iron(this);}
        if(mat == "Water"){material = new Water(this);}
        if(mat == "Uranium"){material = new Uranium(this);}
        if(mat == "null"){material = null;}
        asteroid = true;
    }
    // Asteroid konstruktor
    public Asteroid(int asteroidID) {
        super(asteroidID);
        layer = (int) rand.nextInt(7)+3;    //Min: 3, Max: 9

        digged = 0;     //0 réteg van eddig ásva

        miners = new ArrayList<Miner>();

        //Random anyag kerül az aszteroida közepébe
        int mat = (int) rand.nextInt(5);
        switch (mat){
            case 0: material = new Coal(this); break;
            case 1: material = new Iron(this); break;
            case 2: material = new Uranium(this); break;
            case 3: material = new Water(this); break;
            case 4: material = null;
        }

        asteroid = true;
    }

    // Asteroid konstruktor
    public Asteroid(int asteroidID, int layer, boolean perihelion, Material material) {
        super(asteroidID);

        this.material = material;
        this.layer = layer;
        this.digged = 0;
        this.miners = new ArrayList<Miner>();
        this.id = asteroidID;
        this.perihelion = perihelion;

        asteroid = true;
    }

    //csökkenti a sziklarétegek számát az adott aszteroidán
    public void removeLayer(){
        digged++;
    }

    // Ha nem üres az aszteroida (és a napközelség nem zavar bele a műveletbe), kiveszi belőle az adott nyersanyagot
    public void RemoveMaterial() {
        digged = layer;
        material = null;
    }

    //Egy játékost "eltávolít" a rajta tartózkodók közül
    public void removeMiner(Miner m){
        miners.remove(m);
    }


    //Egy játékost "hozzáad" a rajta tartózkodókhoz
    public void addMiner(Miner m){
        miners.add(m);
    }

    //Az aszteroida felrobban ha uránt napközelben bányásznak, ekkor a rajta levő Miner-ekre különbözően hat
    public void Explode(){
        for (Miner m: miners) {
            m.Explode();
        }
    }

    //Visszatér a bolygón lévő telepesek nyersanyag listájával.
    public ArrayList<Material> CountDiffMat(){
        ArrayList<Material> materials = new ArrayList<Material>();
        for(int i = 0; i < miners.size(); i++) {
            ArrayList<Material> backpack = miners.get(i).getBackpack();
            for (int j = 0; j < backpack.size(); j++) {
                materials.add(backpack.get(j));
            }
        }
        return materials;
    }

    //A napközelséget vizsgálom és irom felül.
    public void Step(){}

    // a megadott teleportot az aszteroidához köti
    public void SetUpTeleport(Teleport t){}

    // getterek és setterek a megadott változókhoz
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

    public void setMaterial(Material m){
        this.material = m;
    }

    @Override
    public void AddNeighbor(Spacething s) {
        super.AddNeighbor(s);
    }

    public void listNeighbors(){
        if(neighbours.isEmpty()==true){
            System.out.println("Hiba: nincs szomszed "+this.getId());
        }
        for(Spacething s: neighbours){
            System.out.println(s.getId());
        }
    }

}

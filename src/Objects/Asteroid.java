package Objects;

import Game_parts.Steppable;
import Materials.*;
import Miners.Miner;

import java.util.ArrayList;
import java.util.Random;

/**
 *  Object for Asteroid
 * @author Mzperx
 */
public class Asteroid extends Spacething implements Steppable {
    /**
     *  Sziklaréteg
     */
    private int layer;
    /**
     *  Kiásott rétegek
     */
    private int digged;
    /**
     *  napközelséget jelzi
     */
    private boolean perihelion;
    /**
     *  Material that is inside of the Asteroid
     */
    private Material material;
    /**
     *  Contains the miners that are on the Asteroid
     */
    private ArrayList<Miner> miners;
    /**
     *  x for graphics
     */
    private int x;
    /**
     *  y for graphics
     */
    private int y;

    /**
     *  random number
     */
    private Random rand = new Random();

    /**
     *  Asteroid constructor with id
     * @param asteroidID the id of the asteroid
     * @param lay layer of the asteroid.
     * @param d number of digged layers
     * @param mat material of the asteroid
     */
    public Asteroid(int asteroidID, int lay, int d, String mat){
        super(asteroidID);
        layer = lay;
        digged = d;
        miners = new ArrayList<Miner>();
        if(mat.equals( "Coal")){material = new Coal(this);}
        if(mat.equals("Iron")){material = new Iron(this);}
        if(mat.equals("Water")){material = new Water(this);}
        if(mat.equals("Uranium")){material = new Uranium(this);}
        if(mat.equals("null")){material = null;}
    }
    /**
     *  Asteroid constructor with id
     * @param asteroidID the id of the asteroid
     */
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

    }

    /**
     *  Asteroid constructor with id
     * @param asteroidID the id of the asteroid
     * @param lay layer of the asteroid.
     * @param d number of digged layers
     * @param mat material of the asteroid
     * @param x x for graphics
     * @param y y for graphics
     */
    public Asteroid(int asteroidID, int lay, int d, String mat, int x, int y){
        super(asteroidID);
        layer = lay;
        digged = d;
        miners = new ArrayList<Miner>();
        if(mat.equals( "Coal")){material = new Coal(this);}
        if(mat.equals("Iron")){material = new Iron(this);}
        if(mat.equals("Water")){material = new Water(this);}
        if(mat.equals("Uranium")){material = new Uranium(this);}
        if(mat.equals("null")){material = null;}
        this.x = x;
        this.y = y;
    }

    // Asteroid konstruktor

    /**
     *  Asteroid constructor with id
     * @param asteroidID the id of the asteroid
     * @param layer layer of the asteroid.
     * @param perihelion sets the asteroid near sun or not
     * @param material material of the asteroid
     */
    public Asteroid(int asteroidID, int layer, boolean perihelion, Material material) {
        super(asteroidID);

        this.material = material;
        this.layer = layer;
        this.digged = 0;
        this.miners = new ArrayList<Miner>();
        this.id = asteroidID;
        this.perihelion = perihelion;
    }

    /**
     *  csökkenti a sziklarétegek számát az adott aszteroidán
     */
    public void removeLayer(){
        digged++;
    }

    /**
     *  Ha nem üres az aszteroida (és a napközelség nem zavar bele a műveletbe), kiveszi belőle az adott nyersanyagot
     */
    public void RemoveMaterial() {
        digged = layer;
        material = null;
    }

    /**
     *  Egy játékost "eltávolít" a rajta tartózkodók közül
     */
    public void removeMiner(Miner m){
        miners.remove(m);
    }


    /**
     *  Egy játékost "hozzáad" a rajta tartózkodókhoz
     * @param m az aminer amit hozzáad
     */
    public void addMiner(Miner m){
        miners.add(m);
    }

    /**
     *  Az aszteroida felrobban ha uránt napközelben bányásznak, ekkor a rajta levő Miner-ekre különbözően hat
     */
    public void Explode(){
        for (int i = 0; i < miners.size(); i++) {
            miners.get(i).Explode();
        }
    }


    /**
     *  Sets up a teleport on the Asteroid
     * @param t the teleport that is added
     */
    public void SetUpTeleport(Teleport t){}

    /**
     *  Getter of the layers
     *  @return layer
     */
    public int getLayer() {
        return layer;
    }

    /**
     *  Getter of the material that is inside of the Asteroid
     *  @return material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     *  Getter of perihelion
     *  @return perihelion
     */
    public boolean getPerihelion(){
        return perihelion;
    }

    /**
     *  Getter of digged layers
     *  @return digged
     */
    public int getDigged() {
        return digged;
    }

    /**
     *  Getter of id
     *  @return id
     */
    public int getId(){
        return id;
    }

    /**
     *  Getter of miners on asteroid
     *  @return list of miners
     */
    public ArrayList<Miner> getMiners(){
        return  miners;
    }
    /**
     *  Getter of layers
     */
    public void setLayer(int layer) {
        this.layer = layer;
    }
    /**
     *  Setter of material
     */
    public void setMaterial(Material m){
        this.material = m;
    }
    /**
     *  setter of perihelion
     */
    public void setPerihelion(boolean b){
        this.perihelion = b;
    }

    /**
     * Adds a neighbour to its list
     * @param s The Spacething that is added
     */
    @Override
    public void AddNeighbor(Spacething s) {
        super.AddNeighbor(s);
    }

    /**
     * Returns that it is an asteroid
     * @return true because its an asteroid
     */
    @Override
    public boolean isAsteroid(){return true;}

    /**
     * Makes the Asteroid perihelion or not
     * @param step it is not used here.
     */
    @Override
    public void Step(String step){
        Random r = new Random();
        if (r.nextInt(2) == 0) {
            perihelion = true;
        }
        else {
            perihelion = false;
        }
    }

    /**
     * Checks if the game is won or not
     * @return the game is won or not
     */
    public boolean checkWin(){
        ArrayList<Material> bolygon= new ArrayList<>();
        for(Miner m: miners){
            for(Material mat: m.getBackpack()){
                bolygon.add(mat);
            }
        }
        int[] matTomb =new int[]{ 0,0,0,0 };
        for (Material mat: bolygon){
            if (mat.getName().equals("Uranium")){
                matTomb[0]++;
            }
            else if(mat.getName().equals("Water")){
                matTomb[1]++;
            }
            else if(mat.getName().equals("Coal")){
                matTomb[2]++;
            }
            else if(mat.getName().equals("Iron")){
                matTomb[3]++;
            }
        }
        for(int i=0; i<4; i++){
            if(matTomb[i]<3){
                return false;
            }
        }
        return true;
    }


    /**
     * getter of x
     * @return y
     */
    public int getX(){return x;}
    /**
     * getter of y
     * @return x
     */
    public int getY(){return y;}

    /**
     * setter of x
     * @param value sets x
     */
    public void setX(int value){x=value;}
    /**
     * setter of y
     * @param value sets y
     */
    public void setY(int value){y=value;}


}

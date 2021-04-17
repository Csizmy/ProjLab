package Game_parts;


import Miners.*;
import Objects.Asteroid;
import Objects.Spacething;
import Objects.Teleport;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map implements Steppable {

    private ArrayList<Settler> settlers;         //Settlerek listája
    private ArrayList<Robot> robots;             //Robotok listája
    private ArrayList<Ufo> ufos;                 //Ufók listája
    private ArrayList<Asteroid> asteroids;       //Aszteroidák listája
    private ArrayList<Teleport> teleports;       //Teleportok listája
    private int diffMat;                    //A pályán lévő különböző anyagok száma

    private Random rand = new Random();

    //Map konstruktor
    public Map(){
        asteroids = new ArrayList<Asteroid>();
        settlers = new ArrayList<Settler>();
        ufos = new ArrayList<Ufo>();
        robots = new ArrayList<Robot>();
        teleports = new ArrayList<Teleport>();
    };
    //Map konstruktor, felveszi a telepesek és az aszteroidák listáját.
    public Map(int noAsteroids, int noSettler) {
        asteroids = new ArrayList<Asteroid>();
        settlers = new ArrayList<Settler>();
        ufos = new ArrayList<Ufo>();
        robots = new ArrayList<Robot>();
        teleports = new ArrayList<Teleport>();


        //Aszteroidák létrehozása
        for (int i = 0; i < noAsteroids; i++) {
            System.out.print("\t");
            Asteroid ball = new Asteroid(i);
            asteroids.add(ball);
        }

        //Telepesek létrehozása
        for (int i = 0; i < noSettler; i++){
            System.out.print("\t");
            int r = rand.nextInt(noAsteroids);
            Settler s = new Settler(asteroids.get(r));
            settlers.add(s);
        }

        //Szomszédok feltöltése (itt még a tesztek miatt körkörösen)
        for (int i = 0;i < noAsteroids; i++){
            if(i!=0 && i!=noAsteroids-1){
                asteroids.get(i).AddNeighbor(asteroids.get(i-1));
                asteroids.get(i).AddNeighbor(asteroids.get(i+1));
            }else if(i == noAsteroids-1){
                asteroids.get(i).AddNeighbor(asteroids.get(i-1));
                asteroids.get(i).AddNeighbor(asteroids.get(0));
                asteroids.get(0).AddNeighbor(asteroids.get(i));
                asteroids.get(0).AddNeighbor(asteroids.get(1));
            }
        }

        //Szomszédok kiíratása
        System.out.println("Szomszédok:");
        for (Asteroid a: asteroids) {
            System.out.print("\t");
            System.out.print(a.getId() + ". aszteroida szomszédjai: ");
            for (Spacething n: a.getNeighbours()){
                System.out.print(n.getId() + ", ");
            }
            System.out.println();
        }

        diffMat = 4;
    }

    //A napvihar működése.
    public void SolarStorm() {

        for (int i = 0; i < asteroids.size(); i++) {  // az aszteroidákon átmenő napvihar nézi ki van elbújva
            if (asteroids.get(i).getLayer() != asteroids.get(i).getDigged() || asteroids.get(i).getMaterial() != null) {
                for (int j = 0; j < asteroids.get(i).getMiners().size(); j++) {
                    asteroids.get(i).getMiners().get(j).Die();

                }
            }
        }
        for (int i = 0; i < teleports.size(); i++)  // egy körig nem lehet használni semelyik kaput se
            teleports.get(i).disable();
    }

    //Az AI elindít véletlenszerűen egy napvihart, ennek az algoritmusát később írjuk meg
    @Override
    public void Step() {

    }

    //getterek és setterek a megfelelő értékekhez
    public  ArrayList<Settler> getSettlers(){return settlers;}
    public ArrayList<Robot> getRobots(){return robots;}
    public ArrayList<Asteroid> getAsteroids(){return asteroids;}
    public ArrayList<Teleport> getTeleports(){return teleports;}
    public int getDiffMat(){return diffMat;}
    public void setDiffMat(int mat){this.diffMat=mat;}


    //Kilistázza a pályán található dolgokat a beadott string megadja, hogy mit listázzon ki
    public void list(String n){
        boolean vandolog=false;
        if( n.equals("Settlers") || n.equals("Map")){
            for (Settler s: settlers){
                System.out.println("Settler "+s.getId()+", "+s.getAsteroid());
                vandolog=true;
            }
        }
        if( n.equals("Asteroids") || n.equals("Map")){
            for (Asteroid a: asteroids){
                System.out.println("Asteroid "+a.getId()+", "+a.getLayer()+"/"+a.getDigged());
                vandolog=true;
            }
        }
        if( n.equals("Robots") || n.equals("Map")){
            for (Robot r: robots){
                System.out.println("Robot "+r.getId()+", "+r.getAsteroid());
                vandolog=true;
            }
        }
        if( n.equals("Ufos") || n.equals("Map")){
            for (Ufo u: ufos){
                System.out.println("Ufo "+u.getId()+", "+u.getAsteroid());
                vandolog=true;
            }
        }
        if(vandolog==false){
            System.out.println("Nincs semmi a palyan.");
        }
    }

    public void setAsteroids(ArrayList<Asteroid> asteroids) {
        this.asteroids = asteroids;
    }

    public void setRobots(ArrayList<Robot> robots) {
        this.robots = robots;
    }

    public void setSettlers(ArrayList<Settler> settlers) {
        this.settlers = settlers;
    }

    public void setTeleports(ArrayList<Teleport> teleports) {
        this.teleports = teleports;
    }

    public void setUfos(ArrayList<Ufo> ufos) {
        this.ufos = ufos;
    }
}

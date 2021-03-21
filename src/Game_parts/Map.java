package Game_parts;

import Miners.Robot;
import Miners.Settler;
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
    private ArrayList<Asteroid> asteroids;       //Aszteroidák listája
    private ArrayList<Teleport> teleports;       //Teleportok listája
    private int diffMat;                    //A pályán lévő különböző anyagok száma

    private Random rand = new Random();

    //Map konstruktor, felveszi a telepesek és az aszteroidák listáját.
    public Map(int noAsteroids, int noSettler) {
        asteroids = new ArrayList<Asteroid>();
        settlers = new ArrayList<Settler>();
        robots = new ArrayList<Robot>();
        teleports = new ArrayList<Teleport>();


        //Aszteroidák létrehozása
        System.out.println("Aszteroidák:");
        for (int i = 0; i < noAsteroids; i++) {
            System.out.print("\t");
            Asteroid ball = new Asteroid(i);
            asteroids.add(ball);
        }

        //Telepesek létrehozása
        System.out.println("Telepesek:");
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

        System.out.println("Napvihar jön");

        for (int i = 0; i < asteroids.size(); i++) {  // az aszteroidákon átmenő napvihar nézi ki van elbújva
            if (asteroids.get(i).getLayer() != asteroids.get(i).getDigged() || asteroids.get(i).getMaterial() != null) {
                for (int j = 0; j < asteroids.get(i).getMiners().size(); j++) {
                    asteroids.get(i).getMiners().get(j).Die();

                }
            }
        }
        for (int i = 0; i < teleports.size(); i++)  // egy körig nem lehet használni semelyik kaput se
            teleports.get(i).disable();

        System.out.println("Napvihar elmúlik");
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

}

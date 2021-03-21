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

    private ArrayList<Settler> settlers;         //List of Settlers.
    private ArrayList<Robot> robots;             //List of Robots.
    private ArrayList<Asteroid> asteroids;       //List of Asteroids
    private ArrayList<Teleport> teleports;       //teleports.
    private int diffMat;                    //Count of the different materials.

    private Random rand = new Random();

    //Felveszi a telepesek és az aszteroidák listáját.
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

        //Szomszédok feltöltése
        for (int i = 0;i < noAsteroids; i++){
            if(i!=0&&i!=noAsteroids-1){
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

        System.out.println("napvihar");

        for (int i = 0; i < asteroids.size(); i++) {
            if (asteroids.get(i).getLayer() != asteroids.get(i).getDigged() || asteroids.get(i).getMaterial() != null) {
                for (int j = 0; j < asteroids.get(i).getMiners().size(); j++) {
                    asteroids.get(i).getMiners().get(i).Die();

                }
            }
        }
        for (int i = 0; i < teleports.size(); i++)
            teleports.get(i).disable();
    }//

    //Az AI elindít véletlenszerűen egy napvihart.
    @Override
    public void Step() {

    }

    public  ArrayList<Settler> getSettlers(){return settlers;}
    public ArrayList<Robot> getRobots(){return robots;}
    public ArrayList<Asteroid> getAsteroids(){return asteroids;}
    public ArrayList<Teleport> getTeleports(){return teleports;}
    public int getDiffMat(){return diffMat;}
    public void setDiffMat(int mat){this.diffMat=mat;}







}

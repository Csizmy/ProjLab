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

    //Felveszi a telepesek (3) és az aszteroidák (3) listáját.
    public Map() {
        asteroids = new ArrayList<Asteroid>();
        settlers = new ArrayList<Settler>();
        robots = new ArrayList<Robot>();
        teleports = new ArrayList<Teleport>();

        //Teszteléshez
        int noAsteroids = 10;
        int noSettler = 5;

        for (int i = 0; i < noAsteroids; i++) {
            Asteroid ball = new Asteroid(i);
            asteroids.add(ball);
        }

        for (int i = 0; i < noSettler; i++){
            int r = rand.nextInt(noAsteroids);
            Settler s = new Settler(asteroids.get(r));
            settlers.add(s);
        }

        diffMat = 4;
    }

    //A napvihar működése.                      //!!!!!    for ciklus feltételek és tartalmai (getterek is lehet kellenek még)  !!!!!
    public void SolarStorm() {
        //List of
        /*for (int i = 0; i < settlers.size(); i++){
            if (miners.get(i).getAsteroid().getMaterial() == miners.get(i).getAsteroid().getLayer())
                miners.get(i).die();
        }
        for (int i = 0; i < robots.size(); i++){
            if (miners.get(i).getAsteroid().getMaterial() == miners.get(i).getAsteroid().getLayer())
                miners.get(i).die();
        }

        for (int i = 0; i < spacethings.size(); i++){
            spacethings.get(i).SolarStormHappens();
        }*/

    }

    //Az AI elindít véletlenszerűen egy napvihart.
    @Override
    public void Step() {

    }
}

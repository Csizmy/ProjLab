package Game_parts;

import Miners.Miner;
import Miners.Robot;
import Miners.Settler;
import Objects.Asteroid;
import Objects.Spacething;
import Objects.Teleport;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Map extends Steppable {

    private List<Settler> settlers;         //List of Settlers.
    private List<Robot> robots;             //List of Robots.
    private List<Asteroid> asteroids;
    private List<Teleport> teleports;   //List of Asteroids and teleports.
    private int diffMat;                    //Count of the different materials.

    //Felveszi a telepesek (10) és az aszteroidák (10) listáját.
    public Map() {
        for (int i = 0; i < 10; i++) {
            Asteroid ball = new Asteroid();
            asteroids.add(ball);
            Settler born = new Settler(asteroids.get(i));
            settlers.add(born);
        }
        diffMat = 4;
    }

    //A napvihar működése.
    public void SolarStorm() {
        //TODO
    }

    //Az AI elindít véletlenszerűen egy napvihart.
    @Override
    public void Step() {

    }

}

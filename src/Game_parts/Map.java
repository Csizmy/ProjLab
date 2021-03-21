package Game_parts;

import Miners.Miner;
import Miners.Settler;
import Objects.Asteroid;
import Objects.Spacething;

import java.util.List;

public class Map extends Steppable {

    private List<Miner> miners;             //List of Settlers and Robots.
    private List<Spacething> spacethings;   //List of Asteroids and teleports.
    private int diffMat;                    //Count of the different materials.

    //Felveszi a telepesek (10) és az aszteroidák (10) listáját.
    public Map() {
        for (int i = 0; i < 10; i++) {
            Settler born = new Settler();
            miners.add(born);
            Asteroid ball = new Asteroid();
            spacethings.add(ball);
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

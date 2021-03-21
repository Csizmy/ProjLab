package Game_parts;

import Miners.Miner;
import Objects.Spacething;

import java.util.List;

public class Map extends Steppable {

    private List<Miner> miners;
    private List<Spacething> spacethings;
    private int diffMat;                    //Count of the different materials.


    public void SolarStorm() {
        //TODO
        for (int i = 0; i < miners.size(); i++){
            if (miners.get(i).getAsteroid().getMaterial() == miners.get(i).getAsteroid().getLayer())
                miners.get(i).die();
        }

        for (int i = 0; i < spacethings.size(); i++){
            spacethings.get(i).SolarStormHappens();
        }

    }

    @Override
    public void Step() {

    }

}

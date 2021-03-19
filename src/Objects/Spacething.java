package Objects;

import java.util.ArrayList;

public class Spacething {
    private String type;    //Type of spacething (Asteroid or Teleport)
    private ArrayList<Spacething> neighbours;

    public void setName(String t){
        type = t;
    }

    public String getName(){
        return type;
    }

    public boolean isNeigbour(Spacething s){
        for (Spacething n: neighbours) {
            if(n == s) return true;
        }
        return false;
    }
}

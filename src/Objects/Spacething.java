package Objects;

import java.util.ArrayList;

public class Spacething {
    private String type;    //Type of spacething (Asteroid or Teleport)
    private ArrayList<Spacething> neighbors;

    public void setName(String t){
        type = t;
    }

    public String getName(){
        return type;
    }

    public boolean IsNeigbor(Spacething s){
        for (Spacething n: neighbors) {
            if(n == s) return true;
        }
        return false;
    }
}

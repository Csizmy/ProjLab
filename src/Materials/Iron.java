
package Materials;

import GObjects.GCoal;
import GObjects.GIron;
import Objects.Asteroid;

import java.io.IOException;

public class Iron extends Material{
    public Iron(Asteroid a){
        setName("Iron");
        setAsteroid(a);
        try {
            gObject= new GIron();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
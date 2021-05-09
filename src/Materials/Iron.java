
package Materials;

import GObjects.GCoal;
import GObjects.GIron;
import Objects.Asteroid;

import java.io.IOException;

//Class to represent iron material
public class Iron extends Material{

    //Iron constructor
    public Iron(Asteroid a){
        setName("Iron");
        setAsteroid(a);         //Containing asteroid
    }
}
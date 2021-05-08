package Materials;

import GObjects.GObject;
import Objects.Asteroid;
import Graphics.GamePanel;

import java.awt.*;

public abstract class Material {
    protected String name;              // a nyersanyag neve
    protected Asteroid asteroid;        //tárolja melyik aszteroidán van a nyersanyag
    protected GObject gObject;

    // getterek és setterek a megfelelő értékekhez
    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }

    Asteroid getAsteroid(){return asteroid;}

    public void setAsteroid(Asteroid a){asteroid = a;}

    //Virtuális függvény, ami a víznél és az urániumnál fontos
    public void PeriMining(){
    }
    public GObject getGobject(){
        return gObject;
    }

    public void rajzoljkocsog(Graphics g, int x, int y, GamePanel panel) {
        gObject.rajzolok(g,x,y,panel);
    }
}
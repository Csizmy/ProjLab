package Materials;

import GObjects.*;
import Objects.Asteroid;

import javax.swing.*;
import java.io.IOException;

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

    public JButton drawMaterial(int x, int y,  Material mat) throws IOException {

        JButton toDraw = new JButton();

        switch(mat.getName()){
            case("Iron"):{
                GIron iron = new GIron(x, y);
                toDraw = iron.getButton();
            }break;

            case("Uranium"):{
                GUranium uranium = new GUranium(x, y);
                toDraw = uranium.getButton();
            }break;

            case("Water"):{
                GWater water = new GWater(x, y);
                toDraw = water.getButton();
            }break;

            case("Coal"):{
                GCoal coal = new GCoal(x, y);
                toDraw = coal.getButton();
            }break;
        }

        return toDraw;
    }
}
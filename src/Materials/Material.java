package Materials;

import GObjects.*;
import Objects.Asteroid;

import javax.swing.*;
import java.io.IOException;

public abstract class Material {
    protected String name;              // a nyersanyag neve
    protected Asteroid asteroid;        //tárolja melyik aszteroidán van a nyersanyag
    protected GObject gObject;

    // Getter for name
    public String getName(){
        return name;
    }

    //Setter for name
    public void setName(String n){
        name = n;
    }

    //Setter for asteroid
    public void setAsteroid(Asteroid a){asteroid = a;}

    //Virtual function !!Important at water and uranium!!
    public void PeriMining(){
    }

    //Draw the given material to a x,y point
    //Returns with a Jbutton which can be drawn to panel
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
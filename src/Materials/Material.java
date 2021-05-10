package Materials;

import GObjects.*;
import Objects.Asteroid;

import javax.swing.*;
import java.io.IOException;

/**
 * It represent the materials in the game
 * @author mzperx
 */
public abstract class Material {
    /**
     * Name of the material
     */
    protected String name;
    /**
     * It stores which asteroid the material is on
     */
    protected Asteroid asteroid;
    /**
     * It stores the picture of the material
     */
    protected GObject gObject;

    /**
     * Getter for name
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Setter for name
     * @param n  name
     */
    public void setName(String n){
        name = n;
    }

    /**
     * Getter for asteroid
     * @return name
     */
    Asteroid getAsteroid(){return asteroid;}

    /**
     * Setter for asteroid
     * @param a asteroid
     */
    public void setAsteroid(Asteroid a){asteroid = a;}

    /**
     * Virtual function !!Important at water and uranium!!
     * @return if it's not uranium or water: false
     */
    public boolean PeriMining(){ return false; }

    /**
     * Getter for GObject
     * @return GObject
     */
    public GObject getGobject(){
        return gObject;
    }

    /**
     * Draw the given material to a x,y point
     * Returns with a Jbutton which can be drawn to panel
     * @param x x coordinate
     * @param y y coordinatee
     * @param mat material
     * @return the button
     */
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
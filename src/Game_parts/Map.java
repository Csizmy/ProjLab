package Game_parts;


import Miners.*;
import Objects.Asteroid;
import Objects.Spacething;
import Objects.Teleport;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map implements Steppable {

    private ArrayList<Settler> settlers;         //List of settlers
    private ArrayList<Robot> robots;             //List of robots
    private ArrayList<Ufo> ufos;                 //List of ufos
    private ArrayList<Asteroid> asteroids;       //List of asteroids
    private ArrayList<Teleport> teleports;       //List of teleports
    private int diffMat;                         //Count of different materials on map

    private Random rand = new Random();

    //Map constructor without parameters
    public Map(){
        asteroids = new ArrayList<>();      //Initialize list containing all asteroids on map
        settlers = new ArrayList<>();       //Initialize list containing all settlers on map
        ufos = new ArrayList<>();           //Initialize list containing all ufos on map
        robots = new ArrayList<>();         //Initialize list containing all robots on map
        teleports = new ArrayList<>();      //Initialize list containing all teleports on map

        generateMap();
    }

    //Map constructor with parameters
    //Parameters:
    //noAsteroid = number of asteroids to create
    //noSettler = number of settler
    public Map(int noAsteroids, int noSettler) {
        asteroids = new ArrayList<>();      //Initialize list containing all asteroids on map
        settlers = new ArrayList<>();       //Initialize list containing all settlers on map
        ufos = new ArrayList<>();           //Initialize list containing all ufos on map
        robots = new ArrayList<>();         //Initialize list containing all robots on map
        teleports = new ArrayList<>();      //Initialize list containing all teleports on map


        //Create asteroids
        for (int i = 0; i < noAsteroids; i++) {
            System.out.print("\t");
            Asteroid ball = new Asteroid(i);    //Create new asteroid
            asteroids.add(ball);                //Add asteroid to asteroid list
        }

        //Create settlers
        for (int i = 0; i < noSettler; i++){
            System.out.print("\t");
            int r = rand.nextInt(noAsteroids);          //Add settler to a random asteroid
            Settler s = new Settler(asteroids.get(r));  //Create new settler
            settlers.add(s);                            //Add settler to Settlers list
        }

        //Fill neighbours
        for (int i = 0;i < noAsteroids; i++){
            if(i!=0 && i!=noAsteroids-1){
                asteroids.get(i).AddNeighbor(asteroids.get(i-1));
                asteroids.get(i).AddNeighbor(asteroids.get(i+1));
            }else if(i == noAsteroids-1){
                asteroids.get(i).AddNeighbor(asteroids.get(i-1));
                asteroids.get(i).AddNeighbor(asteroids.get(0));
                asteroids.get(0).AddNeighbor(asteroids.get(i));
                asteroids.get(0).AddNeighbor(asteroids.get(1));
            }
        }

        //Write neighbours
        System.out.println("Szomszédok:");
        for (Asteroid a: asteroids) {
            System.out.print("\t");
            System.out.print(a.getId() + ". aszteroida szomszédjai: ");
            for (Spacething n: a.getNeighbours()){
                System.out.print(n.getId() + ", ");
            }
            System.out.println();
        }

        diffMat = 4;
    }

    //Sunstorm
    //If target given, than only that asteroid, if target is -1 than all asteroid
    public void SolarStorm(int target) {

        //Call sunstorm for all asteroid
        if (target == -1) {
            for (int i = 0; i < asteroids.size(); i++) {  //Check if settler is hidden on all asteroid
                if (asteroids.get(i).getLayer() != asteroids.get(i).getDigged() && asteroids.get(i).getMaterial() != null) {
                        for (int j = 0; j < asteroids.get(i).getMiners().size(); j++) {     //If settler on the asteroid is not hidden than...
                            if(asteroids.get(i).getMiners().get(j).getName() == "settler"){
                                System.out.println(asteroids.get(i).getMiners().get(j).getId() + " settler died");
                                settlers.remove(asteroids.get(i).getMiners().get(j));       //...Settler dies
                                asteroids.get(i).getMiners().get(j).Die();
                            }
                    }
                }
            }
            for (int i = 0; i < teleports.size(); i++)  // egy körig nem lehet használni semelyik kaput se
                teleports.get(i).disable();
        }else{
        //Cal sunstorm on the target asteroid
            if (asteroids.get(target).getLayer() != asteroids.get(target).getDigged() && asteroids.get(target).getMaterial() != null) {     //Check if settler is hidden
                for (int j = 0; j < asteroids.get(target).getMiners().size(); j++) {
                    if(asteroids.get(target).getMiners().get(j).getName()=="settler") {     //If settler on the asteroid is not hidden than...
                        System.out.println(asteroids.get(target).getMiners().get(j).getId() + " settler died");
                        settlers.remove(asteroids.get(target).getMiners().get(j));          //...Settler dies
                        asteroids.get(target).getMiners().get(j).Die();
                    }
                }
            }
        }
    }

    //Random sunstorm
    @Override
    public void Step(String step) {
        Random r = new Random();
        if (r.nextInt(10) < 2)
            SolarStorm(-1);
        else
            System.out.println("Nem tortent napvihar");
    }

    //Getter for the list of settlers
    public  ArrayList<Settler> getSettlers(){return settlers;}

    //Getter for the list of robots
    public ArrayList<Robot> getRobots(){return robots;}

    //Getter for the list of asteroids
    public ArrayList<Asteroid> getAsteroids(){return asteroids;}

    //Getter for the list of teleports
    public ArrayList<Teleport> getTeleports(){return teleports;}

    //Getter for the list of ufos
    public ArrayList<Ufo> getUfos() {return ufos;}

    //Getter for the count of different materials
    public int getDiffMat(){return diffMat;}

    //Setter for the count of different materials
    public void setDiffMat(int mat){this.diffMat=mat;}

    //Add teleport to the list of teleports
    public void AddTeleport(Teleport t){teleports.add(t);}


    //List the things on the map
    public void list(String n){
        boolean vandolog=false;
        if( n.equals("Settlers") || n.equals("Map")){
            for (Settler s: settlers){
                System.out.println("Settler "+s.getId()+", "+s.getAsteroid());
                vandolog=true;
            }
        }
        if( n.equals("Asteroids") || n.equals("Map")){
            for (Asteroid a: asteroids){
                System.out.println("Asteroid "+a.getId()+", "+a.getLayer()+"/"+a.getDigged());
                vandolog=true;
            }
        }
        if( n.equals("Teleport") || n.equals("Map")){
            for (Teleport t: teleports){
                System.out.println("Teleport "+t.getId());
                vandolog=true;
            }
        }
        if( n.equals("Robots") || n.equals("Map")){
            for (Robot r: robots){
                System.out.println("Robot "+r.getId()+", "+r.getAsteroid());
                vandolog=true;
            }
        }
        if( n.equals("Ufos") || n.equals("Map")){
            for (Ufo u: ufos){
                System.out.println("Ufo "+u.getId()+", "+u.getAsteroid());
                vandolog=true;
            }
        }
        if(vandolog==false){
            System.out.println("Nincs semmi a palyan.");
        }
    }

    //Setter for the list of asteroids
    public void setAsteroids(ArrayList<Asteroid> asteroids) {
        this.asteroids = asteroids;
    }

    //Setter for the list of robots
    public void setRobots(ArrayList<Robot> robots) {
        this.robots = robots;
    }

    //Setter for the list of settlers
    public void setSettlers(ArrayList<Settler> settlers) {
        this.settlers = settlers;
    }

    //Setter for the list of teleports
    public void setTeleports(ArrayList<Teleport> teleports) {
        this.teleports = teleports;
    }

    //Setter for the list of ufos
    public void setUfos(ArrayList<Ufo> ufos) {
        this.ufos = ufos;
    }

    //Generate map
    public void generateMap(){
        int id = 0;
        for (int i = 0; i < 9; i++){
            asteroids.add(randomAsteroid(id++, "Uranium"));
            asteroids.add(randomAsteroid(id++, "Water"));
            asteroids.add(randomAsteroid(id++, "Coal"));
            asteroids.add(randomAsteroid(id++, "Iron"));
        }//9*4=36 generated material
        for (int i = 0; i < 14; i++){
            switch (rand.nextInt(5)){
                case 0:
                    asteroids.add(randomAsteroid(id++, "no"));
                    break;
                case 1:
                    asteroids.add(randomAsteroid(id++, "Uranium"));
                    break;
                case 2:
                    asteroids.add(randomAsteroid(id++, "Water"));
                    break;
                case 3:
                    asteroids.add(randomAsteroid(id++, "Coal"));
                    break;
                case 4:
                    asteroids.add(randomAsteroid(id++, "Iron"));
                    break;
            }
        }//14 random
        Asteroid n;
        for(int i = 0; i < 50; i++){
            if (asteroids.get(i).getNeighbours().size() == 0){
                n = findClosest(asteroids.get(i), 1);
                asteroids.get(i).AddNeighbor(n);
                n.AddNeighbor(asteroids.get(i));
            }
            if (asteroids.get(i).getNeighbours().size() == 1 && rand.nextInt(10) < 9){
                n = findClosest(asteroids.get(i), 2);
                asteroids.get(i).AddNeighbor(n);
                n.AddNeighbor(asteroids.get(i));
            }
            if (asteroids.get(i).getNeighbours().size() == 2 && rand.nextInt(10) < 7){
                n = findClosest(asteroids.get(i), 3);
                asteroids.get(i).AddNeighbor(n);
                n.AddNeighbor(asteroids.get(i));
            }
            if (asteroids.get(i).getNeighbours().size() == 3 && rand.nextInt(10) < 5){
                n = findClosest(asteroids.get(i), 4);
                asteroids.get(i).AddNeighbor(n);
                n.AddNeighbor(asteroids.get(i));
            }
        }
    }

    //Pick a random asteroid
    private Asteroid randomAsteroid(int id, String mat) {

        int digged = 0;
        if (rand.nextInt(10) < 1) digged = 1;

        return new Asteroid(id, rand.nextInt(9), digged, mat, rand.nextInt(820)+10, rand.nextInt(530)+90);
    }

    //Find the closest asteroid to a asteroid
    private Asteroid findClosest(Asteroid a, int n){
        Asteroid first = new Asteroid(1000, 0, 0, "", 10000, 10000);
        Asteroid second = new Asteroid(1000, 0, 0, "", 10000, 10000);
        Asteroid third = new Asteroid(1000, 0, 0, "", 10000, 10000);
        Asteroid fourth = new Asteroid(1000, 0, 0, "", 10000, 10000);

        for (int i = 0; i < 50; i++){
            if (a.getId() != asteroids.get(i).getId()){
                if (aDistance(asteroids.get(i), a) < aDistance(a, fourth)){
                    if (aDistance(asteroids.get(i), a) < aDistance(a, third)) {
                        if (aDistance(asteroids.get(i), a) < aDistance(a, second)){
                            if (aDistance(asteroids.get(i), a) < aDistance(a, first)){
                                fourth = third;
                                third = second;
                                second = first;
                                first = asteroids.get(i);
                            }
                            else {
                                fourth = third;
                                third = second;
                                second = asteroids.get(i);
                            }
                        }
                        else {
                            fourth = third;
                            third = asteroids.get(i);
                        }
                    }
                    else
                        fourth = asteroids.get(i);
                }
            }
        }
        switch (n){
            case 1: return first;
            case 2: return second;
            case 3: return third;
            case 4: return fourth;
            default: return null;
        }
    }

    //Distance between two asteroids
    private double aDistance(Asteroid a, Asteroid b){
        return (a.getX()-b.getX())*(a.getX()-b.getX()) + (a.getY()-b.getY())*(a.getY()-b.getY());
    }
}

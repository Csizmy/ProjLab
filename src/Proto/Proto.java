package Proto;

import Game_parts.*;
import Materials.*;
import Miners.*;
import Objects.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Proto {
    private Map map = new Map();

    public void loadMap(String mapName){  // Panka
        try{
            File f = new File("maps\\" + mapName);
            Scanner sc = new Scanner(f);
            int space_id = 0;
            int miner_id = 50;
            ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
            ArrayList<Settler> settlers = new ArrayList<Settler>();
            ArrayList<Ufo> ufos = new ArrayList<Ufo>();
            ArrayList<Robot> robots = new ArrayList<Robot>();
            ArrayList<Teleport> teleports = new ArrayList<Teleport>();

            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                if (line == null) {
                    break;
                }
                String array[] = line.split(" ");

                switch(array[0]){
                    case "*":
                        Asteroid a = new Asteroid(space_id, Integer.parseInt(array[1]), Integer.parseInt(array[2]), array[3]);
                        space_id++;
                        asteroids.add(a);
                        break;
                    case "+":
                        Teleport t1 = null, t2 = null;
                        for (int i = 0; i < asteroids.size(); i++) {
                            if (Integer.parseInt(array[1]) == asteroids.get(i).getId()) {
                                t1 = new Teleport(space_id, asteroids.get(i));
                                space_id++;
                            }
                            if (Integer.parseInt(array[2]) == asteroids.get(i).getId()) {
                                t2 = new Teleport(space_id, asteroids.get(i));
                                space_id++;
                            }
                        }
                        t1.setPair(t2);
                        t2.setPair(t1);
                        teleports.add(t1);
                        teleports.add(t2);
                        break;
                    case "=":
                        int egyik = -1, masik = -1;
                        for (int i = 0; i < asteroids.size(); i++) {
                            if (Integer.parseInt(array[1]) == asteroids.get(i).getId()) {
                                egyik = i;
                            }
                            if (Integer.parseInt(array[2]) == asteroids.get(i).getId()) {
                                masik = i;
                            }
                        }
                        asteroids.get(egyik).AddNeighbor(asteroids.get(masik));
                        asteroids.get(masik).AddNeighbor(asteroids.get(egyik));
                        break;
                    case "s":
                        for (int i = 0; i < asteroids.size(); i++) {
                            if (Integer.parseInt(array[1]) == asteroids.get(i).getId()) {
                                Settler s = new Settler(asteroids.get(i), miner_id);
                                miner_id++;
                                settlers.add(s);
                                break;
                            }
                        }
                        break;
                    case "r":
                        for (int i = 0; i < asteroids.size(); i++) {
                            if (Integer.parseInt(array[1]) == asteroids.get(i).getId()) {
                                Robot r = new Robot(asteroids.get(i), miner_id);
                                miner_id++;
                                robots.add(r);
                                break;
                            }
                        }
                        break;
                    case "u":
                        for (int i = 0; i < asteroids.size(); i++) {
                            if (Integer.parseInt(array[1]) == asteroids.get(i).getId()) {
                                Ufo u = new Ufo(asteroids.get(i), miner_id);
                                miner_id++;
                                ufos.add(u);
                                break;
                            }
                        }
                        break;
                }
            }

            map.setAsteroids(asteroids);
            map.setTeleports(teleports);
            map.setSettlers(settlers);
            map.setRobots(robots);
            map.setUfos(ufos);
            System.out.println("A pálya betöltése sikeres");
            sc.close();
        }
        catch (FileNotFoundException e){
            System.out.println("A pálya betöltése sikertelen");
        }
    }

    public void list(String item){ //axelvoltam
        map.list(item);
    }

    public void moveSettler(int settler_id, int asteroid_id){}//kristof ezt csinalja

    public void stepRobot(int robot_id, String step){}//kristof ezt csinalja

    public void stepUfo(int ufo_id, String step){}//kristof ezt csinalja

    public void drillMiner(int settler_id){}//kristof ezt csinalja

    public void mineMiner(int settler_id){}//kristof ezt csinalja

    public void buildTeleport(int settler_id){} // Panku

    public void placeTeleport(int settler_id, int teleport_id){}  // Panku

    public void perihelion(int asteroid_id){}

    public void sunStorm(String target){} // ha "All",mindet eléri, ha egy szám, akkor át kell alakítani!!

    public void addToBackpack(String material, int settler_id){  // Panku
        for (int i = 0; i < map.getSettlers().size(); i++) {
            if(map.getSettlers().get(i).getId()==settler_id){
                switch (material){
                    case "Water":
                        Water w = new Water(null);
                        if(map.getSettlers().get(i).AddMaterial(w)){
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozzáadás sikeres");
                        }else{
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozzáadás sikertelen");
                        }
                        break;
                    case "Iron":
                        Iron ir = new Iron(null);
                        if(map.getSettlers().get(i).AddMaterial(ir)){
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozzáadás sikeres");
                        }else{
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozzáadás sikertelen");
                        }
                        break;
                    case "Coal":
                        Coal c = new Coal(null);
                        if(map.getSettlers().get(i).AddMaterial(c)){
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozzáadás sikeres");
                        }else{
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozzáadás sikertelen");
                        }
                        break;
                    case "Uranium":
                        Uranium u = new Uranium(null);
                        if(map.getSettlers().get(i).AddMaterial(u)){
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozzáadás sikeres");
                        }else{
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozzáadás sikertelen");
                        }
                        break;
                }
            }
        }
    }

    public void backPack(int settler_id){}  //axel

    public void neighbors(int asteroid_id){}  //axel

    //----------------------------- NOT YET SET ROBOT ID!!!!!!!!!! ------------------------------------------
    public void buildRobot(int settler_id){
        //Calculate the number of settlers alive on the map.
        int numOfsettlers = settler_id - 50 - map.getRobots().size() - map.getUfos().size();
        Settler settler = map.getSettlers().get(numOfsettlers - 1);

        if (settler.BuildRobot()) {

            //no robot to set its id to this...
            int robot_id = 50 + map.getSettlers().size() + map.getRobots().size() + map.getUfos().size();

            System.out.println("Settler " + settler.getId() + robot_id + " robot megépítve.");             // ROBOT ID ?????????
        }
        else {System.out.println("Hiba, nincs elég anyag.");}

    }

    //Add a settler to an existing asteroid.
    public void addSettler(int asteroid_id){

        //Get the asteroid from map, and get the number of settlers and set his ID to that number + 50
        int new_id = 50 + map.getSettlers().size() + map.getRobots().size() + map.getUfos().size();
        Settler settler = new Settler(map.getAsteroids().get(asteroid_id), new_id);

        //if the settler is on the asteroid it was successful!
        if (map.getAsteroids().get(asteroid_id).getMiners().contains(settler)){
        System.out.println("Settler " + settler.getId() + " sikeresen létrejött Asteroid" + map.getAsteroids().get(asteroid_id));}
        else{
        System.out.println("A Settler ezen az aszteroidán nem tudott létrejönni.");}
    }

    public void addUfo(int asteroid_id){        //stipi bence

        //Get the asteroid from map, and get the number of settlers and robots and Ufos set his ID to that number + 50
        int new_id = 50 + map.getSettlers().size() + map.getRobots().size() + map.getUfos().size();
        Ufo ufo = new Ufo(map.getAsteroids().get(asteroid_id), new_id);

        //if the settler is on the asteroid it was successful!
        if (map.getAsteroids().get(asteroid_id).getMiners().contains(ufo)){
            System.out.println("Ufo " + ufo.getId() + " sikeresen létrejött Asteroid" + map.getAsteroids().get(asteroid_id));}
        else{
            System.out.println("Az Ufo ezen az aszteroidán nem tudott létrejönni.");}
    }

    public void addRobot(int asteroid_id){      //stipi bence

        //Get the asteroid from map, and get the number of settlers and set his ID to that number + 50
        int new_id = 50 + map.getSettlers().size() + map.getRobots().size() + map.getUfos().size();
        Robot robot = new Robot(map.getAsteroids().get(asteroid_id), new_id);

        //if the settler is on the asteroid it was successful!
        if (map.getAsteroids().get(asteroid_id).getMiners().contains(robot)){
            System.out.println("Robot" + robot.getId() + " sikeresen létrejött Asteroid" + map.getAsteroids().get(asteroid_id));}
        else{
            System.out.println("A Robot ezen az aszteroidán nem tudott létrejönni.");}
    }

    public void save(){}

    public void step(){}
}
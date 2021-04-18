package Proto;

import Game_parts.*;
import Materials.*;
import Miners.*;
import Objects.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
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
                        //System.out.println("Aszteroida: " + space_id);
                        space_id++;
                        asteroids.add(a);
                        break;
                    case "+":
                        Teleport t1 = null, t2 = null;
                        for (int i = 0; i < asteroids.size(); i++) {
                            if (Integer.parseInt(array[1]) == asteroids.get(i).getId()) {
                                t1 = new Teleport(space_id, asteroids.get(i));
                                //System.out.println("Teleport t1: " + space_id);
                                space_id++;
                            }
                            if (Integer.parseInt(array[2]) == asteroids.get(i).getId()) {
                                t2 = new Teleport(space_id, asteroids.get(i));
                                //System.out.println("Teleport t2: " + space_id);
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
                        //System.out.println("Asteroid " + asteroids.get(masik).getId() + " es Asteroid " + asteroids.get(egyik).getId() + " szomszedok");
                        break;
                    case "s":
                        for (int i = 0; i < asteroids.size(); i++) {
                            if (Integer.parseInt(array[1]) == asteroids.get(i).getId()) {
                                Settler s = new Settler(asteroids.get(i), miner_id);
                                //System.out.println("Settler: " + miner_id);
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
                                //System.out.println("Robot: " + miner_id);
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
                                //System.out.println("Ufo: " + miner_id);
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

    public void moveSettler(int settler_id, int asteroid_id){
        for (int i = 0; i < map.getSettlers().size(); i++) {
            if (map.getSettlers().get(i).getId() == settler_id) {
                map.getSettlers().get(i).Move(asteroid_id);
                System.out.println("Settler " + settler_id + " A mozgás sikeres ide: Asteroid " + asteroid_id + ".");
            }
        }
    }//kristof ezt csinalja

    public void stepRobot(int robot_id, String step){
        for (int i = 0; i < map.getRobots().size(); i++) {
            if (map.getRobots().get(i).getId() == robot_id) {
                map.getRobots().get(i).Step(step);
            }
        }
    }//kristof ezt csinalja

    public void stepUfo(int ufo_id, String step){
        for (int i = 0; i < map.getUfos().size(); i++) {
            if (map.getUfos().get(i).getId() == ufo_id) {
                map.getUfos().get(i).Step(step);
            }
        }
    }//kristof ezt csinalja

    public void drillMiner(int settler_id){
        for (int i = 0; i < map.getSettlers().size(); i++) {
            if (map.getSettlers().get(i).getId() == settler_id) {
                if (map.getSettlers().get(i).Drill()) {
                    System.out.println("Settler " + settler_id + " A fúrás sikeres " + (map.getAsteroids().get(map.getSettlers().get(i).getAsteroid()).getLayer() - map.getAsteroids().get(map.getSettlers().get(i).getAsteroid()).getDigged()) + " réteg maradt Asteroid " + map.getSettlers().get(i).getAsteroid());
                }
                else
                    System.out.println("Settler " + settler_id + " A fúrás sikertelen Asteroid " + map.getSettlers().get(i).getAsteroid());
            }
        }
    }//kristof ezt csinalja

    public void mineMiner(int settler_id){
        for (int i = 0; i < map.getSettlers().size(); i++){
            if (map.getSettlers().get(i).getId() == settler_id) {
                if (map.getSettlers().get(i).Mine())
                    System.out.println("Settler " + settler_id + " A bányászat sikeres Asteroid " + map.getSettlers().get(i).getAsteroid() + map.getAsteroids().get(map.getSettlers().get(i).getAsteroid()).getMaterial().getName());
                else
                    System.out.println("Settler " + settler_id + " A bányászat sikertelen Asteroid " + map.getSettlers().get(i).getAsteroid());
            }
        }
    }//kristof ezt csinalja

    public void buildTeleport(int settler_id){ // Panka
        int _id = map.getTeleports().get(map.getTeleports().size()-1).getId();
        for (int i = 0; i < map.getSettlers().size(); i++) {
            if(map.getSettlers().get(i).getId()==settler_id){

                if(map.getSettlers().get(i).BuildTp(_id, _id+1)){
                    System.out.println("Settler "+ map.getSettlers().get(i).getId() + " Az építés sikeres");
                }else{
                    System.out.println("Settler "+ map.getSettlers().get(i).getId() + " Az építés sikertelen");
                }
            }
        }
    }

    public void placeTeleport(int settler_id, int teleport_id){ // Panku
        for (int i = 0; i < map.getSettlers().size(); i++) {
            if(map.getSettlers().get(i).getId()==settler_id){
                for (int j = 0; j < map.getTeleports().size(); j++) {
                    if(map.getTeleports().get(j).getId()==teleport_id){
                        if(map.getSettlers().get(i).PlaceTp(map.getTeleports().get(j))){
                            System.out.println("Settler "+settler_id+" "+teleport_id +" Teleport lerakása sikeres");
                        }else{
                            System.out.println("Settler "+settler_id+" "+teleport_id +" Teleport lerakása sikertelen");
                        }

                    }
                }
            }
        }
    }

    public void perihelion(int asteroid_id){
        if(map.getAsteroids().get(asteroid_id).getPerihelion()) {
            map.getAsteroids().get(asteroid_id).setPerihelion(false);  //!!!!!!!!! itt asumoltam h false?
            System.out.println(asteroid_id + " Napközelből elvétel sikeres");
        }else{
            map.getAsteroids().get(asteroid_id).setPerihelion(true);  //itt assumoltam hogy true?!!!!!!!!!!!!!!!
            System.out.println(asteroid_id + " Napközel sikeres");
        }
    }

    public void sunStorm(String target){

        if(!target.equals("All")){                // If not all than parse to integer
            try{
                int t = Integer.parseInt(target);
                map.SolarStorm(t);
            }catch(NumberFormatException ex){
                System.out.println("Not set");

            }
            System.out.println(target + " Napvihar sikeres");
        }else if(target.equals("All")){
            map.SolarStorm(-1);
            System.out.println(target + " Napvihar sikeres");
        }else{
            System.out.println(target + " Napvihar sikertelen");
        }
    } // ha "All",mindet eléri, ha egy szám, akkor át kell alakítani!!

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

    public void backPack(int settler_id){ //axel

        for (Settler s: map.getSettlers()){
            if(s.getId()==settler_id){
                s.listBackPack();
            }
        }

    }

    public void neighbors(int asteroid_id){ //axel
        for(Asteroid a: map.getAsteroids()){
            if(a.getId()==asteroid_id){
                a.listNeighbors();
            }
        }
    }

    //----------------------------- NOT YET SET ROBOT ID!!!!!!!!!! ------------------------------------------
    public void buildRobot(int settler_id){

        Settler settler = map.getSettlers().get(settler_id - 50);

        //Giving enough material to build a robot to Settler 50.
        Uranium u = new Uranium(null);
        map.getSettlers().get(0).AddMaterial(u);
        Iron ir = new Iron(null);
        map.getSettlers().get(0).AddMaterial(ir);
        Coal c = new Coal(null);
        map.getSettlers().get(0).AddMaterial(c);

        Settler test = new Settler(map.getAsteroids().get(0), 100);
        map.getSettlers().add(test);

        //The robot's id - one higher than ever before.
        int new_id = 50;
        for (int x = 0; x < map.getUfos().size();x++) {
            int temp = map.getUfos().get(x).getId();
            if(temp >new_id) new_id = temp;
        }
        for (int y = 0; y < map.getSettlers().size();y++) {
            int temp = map.getSettlers().get(y).getId();
            if(temp >new_id) new_id = temp;
        }
        for (int z = 0; z < map.getRobots().size();z++) {
            int temp = map.getRobots().get(z).getId();
            if(temp > new_id) new_id = temp;
        }
        new_id += 1;
        //new_id valamiért mindig 55 a 100as settlert hozzáadva után is... ???

        if (settler.BuildRobot(new_id)) {
            System.out.println("Settler " + settler.getId() + " " + map.getRobots().get(map.getRobots().size() - 1).getId() + " robot megépítve.");             // ROBOT ID ?????????
        }
        else {System.out.println("Hiba, nincs elég anyag.");}

    }

    //Add a settler to an existing asteroid.
    public void addSettler(int asteroid_id){

        //Get the asteroid from map.

        //Get the highest existing ID number.
        int new_id = 50;
        for (int i = 0; i < map.getUfos().size();i++) {
            int temp = map.getUfos().get(i).getId();
            if(temp >new_id) new_id = temp;
        }
        for (int i = 0; i < map.getSettlers().size();i++) {
            int temp = map.getSettlers().get(i).getId();
            if(temp >new_id) new_id = temp;
        }
        for (int i = 0; i < map.getRobots().size();i++) {
            int temp = map.getRobots().get(i).getId();
            if(temp >new_id) new_id = temp;
        }
        new_id += 1;

        //Giving a new id - one higher than ever before - to the settler.
        Settler settler = new Settler(map.getAsteroids().get(asteroid_id), new_id);
        map.getSettlers().add(settler);

        //if the settler is on the asteroid it was successful!
        if (map.getAsteroids().get(asteroid_id).getMiners().contains(settler)){
        System.out.println("Settler " + settler.getId() + " sikeresen létrejött Asteroid " + map.getAsteroids().get(asteroid_id).getId());}
        else{
        System.out.println("A Settler ezen az aszteroidán nem tudott létrejönni.");}
    }

    //Add an Ufo to an existing asteroid.
    public void addUfo(int asteroid_id){

        //Get the asteroid from map, and get the number of settlers and robots and Ufos set his ID to that number + 50
        int new_id = 50;
        for (int i = 0; i < map.getUfos().size();i++) {
            int temp = map.getUfos().get(i).getId();
            if(temp >new_id) new_id = temp;
        }
        for (int i = 0; i < map.getSettlers().size();i++) {
            int temp = map.getSettlers().get(i).getId();
            if(temp >new_id) new_id = temp;
        }
        for (int i = 0; i < map.getRobots().size();i++) {
            int temp = map.getRobots().get(i).getId();
            if(temp >new_id) new_id = temp;
        }
        new_id += 1;

        Ufo ufo = new Ufo(map.getAsteroids().get(asteroid_id), new_id);
        map.getUfos().add(ufo);

        //if the settler is on the asteroid it was successful!
        if (map.getAsteroids().get(asteroid_id).getMiners().contains(ufo)){
            System.out.println("Ufo " + ufo.getId() + " sikeresen létrejött Asteroid " + map.getAsteroids().get(asteroid_id).getId());}
        else{
            System.out.println("Az Ufo ezen az aszteroidán nem tudott létrejönni.");}
    }

    //Add a Robot to an existing asteroid.
    public void addRobot(int asteroid_id){

        //Get the asteroid from map, and get the number of settlers and set his ID to that number + 50
        int new_id = 50;
        for (int i = 0; i < map.getUfos().size();i++) {
            int temp = map.getUfos().get(i).getId();
            if(temp >new_id) new_id = temp;
        }
        for (int i = 0; i < map.getSettlers().size();i++) {
            int temp = map.getSettlers().get(i).getId();
            if(temp >new_id) new_id = temp;
        }
        for (int i = 0; i < map.getRobots().size();i++) {
            int temp = map.getRobots().get(i).getId();
            if(temp >new_id) new_id = temp;
        }
        new_id += 1;

        Robot robot = new Robot(map.getAsteroids().get(asteroid_id), new_id);
        map.getRobots().add(robot);

        //if the settler is on the asteroid it was successful!
        if (map.getAsteroids().get(asteroid_id).getMiners().contains(robot)){
            System.out.println("Robot " + robot.getId() + " sikeresen létrejött Asteroid " + map.getAsteroids().get(asteroid_id).getId());}
        else{
            System.out.println("A Robot ezen az aszteroidán nem tudott létrejönni.");}
    }

    public void save(String saveName){  //ide elv nem kene string!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! gamet is nézd
        File f = new File("maps\\" + saveName + ".txt");
        try {
            FileWriter fWriter = new FileWriter(f);
            for (Settler s: map.getSettlers()){
                fWriter.write("s " + s.getAsteroid()+"\n");
            }

            for (Robot r: map.getRobots()){
                fWriter.write("r " + r.getAsteroid()+"\n");
            }

            for (Ufo u: map.getUfos()){
                fWriter.write("u " + u.getAsteroid()+"\n");
            }

            for (Asteroid a: map.getAsteroids()){
                fWriter.write("* ");
                for(Spacething s: a.getNeighbours()){
                    fWriter.write(s.getId() + " ");
                }
                if(a.getMaterial() != null)
                    fWriter.write(a.getMaterial().getName() + "\n");
                else
                    System.out.println("asdasd");
                fWriter.write("null\n");
            }

            fWriter.close();
            System.out.println("Mentés sikeres");
        } catch (IOException e) {
            System.out.println("Sikertelen mentés");
            e.printStackTrace();
        }

    }

    public void step(){}
}
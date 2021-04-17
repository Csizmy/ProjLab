package Proto;

import Game_parts.*;
import Materials.*;
import Miners.*;
import Objects.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Proto {
    private Map map = new Map();

    public void loadMap(String mapName) throws FileNotFoundException {  // Panka
        try{
            File f = new File("C:\\Users\\Panka\\Desktop\\BME\\4. félév\\Projlab\\intelliJ\\maps\\" + mapName);
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

                if (array[0] == "*") {
                    Asteroid a = new Asteroid(space_id, Integer.parseInt(array[1]), Integer.parseInt(array[2]), array[3]);
                    space_id++;
                    asteroids.add(a);
                } else if (array[0] == "+") {
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
                } else if (array[0] == "=") {
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
                } else if (array[0] == "s") {
                    for (int i = 0; i < asteroids.size(); i++) {
                        if (Integer.parseInt(array[1]) == asteroids.get(i).getId()) {
                            Settler s = new Settler(asteroids.get(i), miner_id);
                            miner_id++;
                            settlers.add(s);
                            break;
                        }
                    }
                } else if (array[0] == "r") {
                    for (int i = 0; i < asteroids.size(); i++) {
                        if (Integer.parseInt(array[1]) == asteroids.get(i).getId()) {
                            Robot r = new Robot(asteroids.get(i), miner_id);
                            miner_id++;
                            robots.add(r);
                            break;
                        }
                    }
                } else if (array[0] == "u") {
                    for (int i = 0; i < asteroids.size(); i++) {
                        if (Integer.parseInt(array[1]) == asteroids.get(i).getId()) {
                            Ufo u = new Ufo(asteroids.get(i), miner_id);
                            miner_id++;
                            ufos.add(u);
                            break;
                        }
                    }
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
            System.out.println("A pálya betölrése sikertelen");
        }
    }
    public void list(String item){}
    public void moveSettler(int settler_id, int asteroid_id){}
    public void stepRobot(int robot_id, Optional<String> step){
        if (step.isPresent()){} //ha van beadott 2. argumentum
        else{} // ha nincs véletlenszerűen step
    }
    public void stepUfo(int ufo_id, Optional<String> step){}
    public void drillMiner(int settler_id){}
    public void mineMiner(int settler_id){}
    public void buildTeleport(int settler_id){}
    public void placeTeleport(int settler_id, int teleport_id){}
    public void perihelion(int asteroid_id){}
    public void sunStorm(String target){} // ha "All",mindet eléri, ha egy szám, akkor át kell alakítani!!
    public void addToBackpack(String material, int settler_id){}
    public void backPack(int settler_id){}
    public void neighbors(int asteroid_id){}
    public void buildRobot(int settler_id){}
    public void addSettler(int asteroid_id){}
    public void addUfo(int asteroid_id){}
    public void addRobot(int asteroid_id){}
    public void save(){}
    public void step(){}
}

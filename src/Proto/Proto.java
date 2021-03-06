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
import java.util.Scanner;

public class Proto {
    private Map map = new Map();
    private Settler currentPlayer;

    public Proto(){
        loadMap("");
    }
    public void loadMap(String mapName){
        try{
            File f = new File("maps\\" + mapName);
            Scanner sc = new Scanner(f);
            int space_id = 0;
            int miner_id = 50;

            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                if (line == null) {
                    break;
                }
                String array[] = line.split(" ");

                switch(array[0]){
                    /*case "*":
                        Asteroid a = new Asteroid(space_id, Integer.parseInt(array[1]), Integer.parseInt(array[2]), array[3]);
                        //System.out.println("Aszteroida: " + space_id);
                        space_id++;
                        asteroids.add(a);
                        break;*/
                    /*case "+":
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
                        break;*/
                    /*case "=":
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
                        break;*/
                    /*case "s":
                        for (int i = 0; i < asteroids.size(); i++) {
                            if (Integer.parseInt(array[1]) == asteroids.get(i).getId()) {
                                Settler s = new Settler(asteroids.get(i), miner_id);
                                //System.out.println("Settler: " + miner_id);
                                miner_id++;
                                settlers.add(s);
                                break;
                            }
                        }
                        break;*/
                    /*case "r":
                        for (int i = 0; i < asteroids.size(); i++) {
                            if (Integer.parseInt(array[1]) == asteroids.get(i).getId()) {
                                Robot r = new Robot(asteroids.get(i), miner_id);
                                //System.out.println("Robot: " + miner_id);
                                miner_id++;
                                robots.add(r);
                                break;
                            }
                        }
                        break;*/
                    /*case "u":
                        for (int i = 0; i < asteroids.size(); i++) {
                            if (Integer.parseInt(array[1]) == asteroids.get(i).getId()) {
                                Ufo u = new Ufo(asteroids.get(i), miner_id);
                                //System.out.println("Ufo: " + miner_id);
                                miner_id++;
                                ufos.add(u);
                                break;
                            }
                        }
                        break;*/
                }
            }

            //map.setAsteroids(asteroids);
            //map.setTeleports(teleports);
            //map.setSettlers(settlers);
            //map.setRobots(robots);
            //map.setUfos(ufos);
            //System.out.println("A p??lya bet??lt??se sikeres");
            sc.close();
        }
        catch (FileNotFoundException e){
            System.out.println("A p??lya bet??lt??se sikertelen");
        }
        currentPlayer=map.getSettlers().get(0);
    }

    public void list(String item){
        map.list(item);
    }

    public boolean moveSettler(int settler_id, int asteroid_id){
        for (int i = 0; i < map.getSettlers().size(); i++) {
            if (map.getSettlers().get(i).getId() == settler_id) {
                map.getSettlers().get(i).Move(asteroid_id);
                if (asteroid_id == map.getSettlers().get(i).getAsteroid()) {
                    System.out.println("Settler " + settler_id + " A mozg??s sikeres ide: Asteroid " + asteroid_id + ".");
                    return true;
                }
                else{
                    System.out.println("Settler " + settler_id + " A mozg??s sikertelen.");
                }
            }
        }
        return false;
    }

    public void moveTp(int teleport_id, int asteroid_id){
        for (int i = 0; i < map.getTeleports().size(); i++) {
            if (map.getTeleports().get(i).getId() == teleport_id) {
                map.getTeleports().get(i).Move(asteroid_id);
            }
        }
    }

    public void stepRobot(int robot_id, String step){
        for (int i = 0; i < map.getRobots().size(); i++) {
            if (map.getRobots().get(i).getId() == robot_id) {
                map.getRobots().get(i).Step(step);
            }
        }
    }

    public void stepUfo(int ufo_id, String step){
        for (int i = 0; i < map.getUfos().size(); i++) {
            if (map.getUfos().get(i).getId() == ufo_id) {
                map.getUfos().get(i).Step(step);
            }
        }
    }

    public boolean drillMiner(){
        int settler_id= currentPlayer.getId();
        for (int i = 0; i < map.getSettlers().size(); i++) {
            if (map.getSettlers().get(i).getId() == settler_id) {
                if (map.getSettlers().get(i).Drill()) {
                    System.out.println("Settler " + settler_id + " A f??r??s sikeres " + (map.getAsteroids().get(map.getSettlers().get(i).getAsteroid()).getLayer() - map.getAsteroids().get(map.getSettlers().get(i).getAsteroid()).getDigged()) + " r??teg maradt Asteroid " + map.getSettlers().get(i).getAsteroid());
                    return true;
                }
                else {
                    System.out.println("Settler " + settler_id + " A f??r??s sikertelen Asteroid " + map.getSettlers().get(i).getAsteroid());
                    return false;
                }
            }
        }
        return false;
    }

    public boolean mineMiner(){
        int settler_id= currentPlayer.getId();
        for (int i = 0; i < map.getSettlers().size(); i++){
            if (map.getSettlers().get(i).getId() == settler_id) {
                return map.getSettlers().get(i).Mine();
            }
        }
        return false;
    }

    public boolean buildTeleport(){
        int settler_id= currentPlayer.getId();
        int _id;
        if(map.getTeleports().size()<2){
            _id = 0;
        }
        else{
            _id = map.getTeleports().get(map.getTeleports().size()-1).getId()+2;
        }
        for (int i = 0; i < map.getSettlers().size(); i++) {
            if(map.getSettlers().get(i).getId()==settler_id){
                if(map.getSettlers().get(i).BuildTp(_id, _id+1)){
                    Teleport t = new Teleport(_id);
                    Teleport t2 = new Teleport(_id+1);
                    t.setPair(t2);
                    t2.setPair(t);
                    map.AddTeleport(t);
                    map.AddTeleport(t2);
                    System.out.println("Settler "+ map.getSettlers().get(i).getId() + " Az ??p??t??s sikeres");
                    return true;
                }else{
                    System.out.println("Settler "+ map.getSettlers().get(i).getId() + " Az ??p??t??s sikertelen");
                    return false;
                }
            }
        }
        System.out.println("Itt nem k??ne lennem buildtp proto btw."); //ezt majd kiszedni
        return false;
    }

    public boolean placeTeleport( int teleport_id){
        int settler_id= currentPlayer.getId();
        for (int i = 0; i < map.getSettlers().size(); i++) {
            if(map.getSettlers().get(i).getId()==settler_id){
                for (int j = 0; j < map.getTeleports().size(); j++) {
                    if(map.getTeleports().get(j).getId()==teleport_id){
                        if(map.getSettlers().get(i).PlaceTp(map.getTeleports().get(j), map.getSettlers().get(i).getAsteroid())){
                            System.out.println("Settler "+settler_id+" "+teleport_id +" Teleport lerak??sa sikeres");
                            return true;
                        }else{
                            System.out.println("Settler "+settler_id+" "+teleport_id +" Teleport lerak??sa sikertelen");
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void perihelion(int asteroid_id){
        if(map.getAsteroids().get(asteroid_id).getPerihelion()) {
            map.getAsteroids().get(asteroid_id).setPerihelion(false);
            System.out.println(asteroid_id + " Napk??zelb??l elv??tel sikeres");
        }else{
            map.getAsteroids().get(asteroid_id).setPerihelion(true);
            System.out.println(asteroid_id + " Napk??zel sikeres");
        }
    }

    public void sunStorm(String target){

        if(!target.equals("All")){
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
    }

    public void addToBackpack(String material, int settler_id){
        for (int i = 0; i < map.getSettlers().size(); i++) {
            if(map.getSettlers().get(i).getId()==settler_id){
                switch (material){
                    case "Water":
                        Water w = new Water(null);
                        if(map.getSettlers().get(i).AddMaterial(w)){
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozz??ad??s sikeres");
                        }else{
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozz??ad??s sikertelen");
                        }
                        break;
                    case "Iron":
                        Iron ir = new Iron(null);
                        if(map.getSettlers().get(i).AddMaterial(ir)){
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozz??ad??s sikeres");
                        }else{
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozz??ad??s sikertelen");
                        }
                        break;
                    case "Coal":
                        Coal c = new Coal(null);
                        if(map.getSettlers().get(i).AddMaterial(c)){
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozz??ad??s sikeres");
                        }else{
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozz??ad??s sikertelen");
                        }
                        break;
                    case "Uranium":
                        Uranium u = new Uranium(null);
                        if(map.getSettlers().get(i).AddMaterial(u)){
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozz??ad??s sikeres");
                        }else{
                            System.out.println(map.getSettlers().get(i).getId()+" "+material+" Hozz??ad??s sikertelen");
                        }
                        break;
                }
            }
        }
    }

    public boolean buildRobot(){
        int settler_id= currentPlayer.getId();
        Settler settler = map.getSettlers().get(settler_id);

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

        if (settler.BuildRobot(new_id)) {
            Miner robot = map.getAsteroids().get(settler.getAsteroid()).getMiners().get(map.getAsteroids().get(settler.getAsteroid()).getMiners().size() - 1);
            map.getRobots().add((Robot) robot);

            System.out.println("Settler " + settler.getId() + " " + map.getRobots().get(map.getRobots().size() - 1).getId() + " robot meg??p??tve.");
            return true;
        }
        else {System.out.println("Hiba, nincs el??g anyag."); return false;}

    }

    public void addSettler(int asteroid_id){

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

        Settler settler = new Settler(map.getAsteroids().get(asteroid_id), new_id);
        map.getSettlers().add(settler);

        if (map.getAsteroids().get(asteroid_id).getMiners().contains(settler)){
        System.out.println("Settler " + settler.getId() + " sikeresen l??trej??tt Asteroid " + map.getAsteroids().get(asteroid_id).getId());}
        else{
        System.out.println("A Settler ezen az aszteroid??n nem tudott l??trej??nni.");}
    }

    public void addUfo(int asteroid_id){

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
            System.out.println("Ufo " + ufo.getId() + " sikeresen l??trej??tt Asteroid " + map.getAsteroids().get(asteroid_id).getId());}
        else{
            System.out.println("Az Ufo ezen az aszteroid??n nem tudott l??trej??nni.");}
    }

    public void addRobot(int asteroid_id){

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

        if (map.getAsteroids().get(asteroid_id).getMiners().contains(robot)){
            System.out.println("Robot " + robot.getId() + " sikeresen l??trej??tt Asteroid " + map.getAsteroids().get(asteroid_id).getId());}
        else{
            System.out.println("A Robot ezen az aszteroid??n nem tudott l??trej??nni.");}
    }

    public void save(String saveName){
        File f = new File("maps\\" + saveName + ".txt");
        try {
            FileWriter fWriter = new FileWriter(f);
            for (Settler s: map.getSettlers()){         // Settler;Position;Backpack
                fWriter.write("s;" + s.getAsteroid());
                for(Material m: s.getBackpack()){
                    fWriter.write(" " + m.getName());
                }
                fWriter.write("\n");
            }

            for (Robot r: map.getRobots()){             //Robot;Position
                fWriter.write("r;" + r.getAsteroid()+"\n");
            }

            for (Ufo u: map.getUfos()){                 //Ufo;Position
                fWriter.write("u;" + u.getAsteroid()+"\n");
            }

            for (Teleport t: map.getTeleports()){       //Ufo;Position
                fWriter.write("t;" + t.getNeighbours().get(0).getId());
                fWriter.write(";" + t.getPair().getId()+"\n");
            }

            for (Asteroid a: map.getAsteroids()){       //Asteroid;Neighbours;Material;Layer;Digged
                fWriter.write("*;");
                for(Spacething s: a.getNeighbours()){
                    fWriter.write(s.getId() + " ");
                }
                if(a.getMaterial() != null)
                    fWriter.write(";" + a.getMaterial().getName());
                else
                    fWriter.write(";null");
                fWriter.write(";" + a.getLayer());
                fWriter.write(";" + a.getDigged());
                fWriter.write("\n");
            }

            fWriter.close();
            System.out.println("Ment??s sikeres");
        } catch (IOException e) {
            System.out.println("Sikertelen ment??s");
            e.printStackTrace();
        }
    }

    public boolean step(){

        for (int i = 0; i < map.getRobots().size(); i++) {
            map.getRobots().get(i).Step("");
        }
        for (int i = 0; i < map.getUfos().size(); i++) {
            map.getUfos().get(i).Step("");
        }
        for (int i = 0; i < map.getTeleports().size(); i++) {
            map.getTeleports().get(i).Step("");
        }
        for (int i = 0; i < map.getAsteroids().size(); i++){
            map.getAsteroids().get(i).Step("");
        }

        for(Asteroid a: map.getAsteroids()){
            if (a.getPerihelion()==true&&a!=null){
                if(a.getMaterial()!= null && a.getDigged() == a.getLayer()){
                    if(a.getMaterial().PeriMining() == true) {
                        a.Explode();
                        for (int i = 0; i < a.getNeighbours().size(); i++) {
                            if (a.getNeighbours().get(i).isAsteroid() == false) {
                                Teleport t = (Teleport) a.getNeighbours().get(i);
                                map.getTeleports().remove(t.getPair());
                                map.getTeleports().remove(t);
                            }
                        }
                        map.getAsteroids().remove(a);
                    }
                }
            }
        }
        for(Settler s: map.getSettlers()){
            Asteroid as = (Asteroid) s.getSpacething();
            if(as.getPerihelion()==true){
                for(Material m: s.getBackpack()){
                    if(m.getName()=="Uranium"){
                        m.PeriMining();
                    }

                }
            }
        }

        map.Step("");
        if(map.getSettlers().isEmpty()==true){
            System.out.println("vesztettetek hahaxd");
            return true;
        }
        return false;
    }

    public Map getMap() {
        return map;
    }

    //l??p??senk??nt ellen??rzi a win/lose esem??nyek bek??vetkez??s??t, ??s befejezi a j??t??kok.
    public boolean EndGame() {
        for(Asteroid a: map.getAsteroids()){
            if(a.checkWin()){
                System.out.println("A j??t??k v??ge, nyertek a Settlerek!");
                return true;
            }
        }

        System.out.println("A j??t??knak nincs v??ge");
        return false;
    }

    public Miner getCurrent() {
        return currentPlayer;
    }
    public void setCurrent(Settler s) {
        currentPlayer=s;
    }

    public int getPlayerCount(){  //visszaadja a current player aszteroid??j??n tartozkodo j??t??kos sz??mot
        int count = 0;
        for(Settler s: map.getSettlers()) {
            if (s.getAsteroid()==currentPlayer.getAsteroid()){
                count++;
            }

        }
        return count;
    }

    public int getRobotCount(){  //visszaadja a current player aszteroid??j??n tartozkodo robot sz??mot
        int count = 0;
        for(Robot r: map.getRobots()) {
            if (r.getAsteroid()==currentPlayer.getAsteroid()){
                count++;
            }

        }
        return count;
    }

    public int getUfoCount(){  //visszaadja a current player aszteroid??j??n tartozkodo ufo sz??mot
        int count = 0;
        for(Ufo u: map.getUfos()) {
            if (u.getAsteroid()==currentPlayer.getAsteroid()){
                count++;
            }

        }
        return count;
    }

}
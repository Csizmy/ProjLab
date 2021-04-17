package Game_parts;

import Tests.*;
import  Proto.*;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public Random rand = new Random();
    private static Map map;                //A játék pálya.

    // A protohoz tartozó osztály
    private static Proto p = new Proto();

    //"Init" Beállítja a játék kezdésénél az értékeket.
    public void StartGame() {
        System.out.println("A játék elkezdődik");
        map = new Map(5, 2);
    }
    //Körönként ellenőrzi a win/lose események bekövetkezését, és befejezi a játékok.
    public void EndGame() {
        System.out.println("A játék vége");
    }

    // A játék maga.
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Indulhat a játék:");

        Scanner input=new Scanner(System.in);

        loop: while(true){

            String line = input.nextLine();
            if (line == null) {break;}
            String array[] = line.split(" ");

            switch(array[0]){
                case "loadMap":
                    p.loadMap(array[1]);
                    break;

                case "list":
                    p.list(array[1]);
                    break;

                case "moveSettler":
                    p.moveSettler(Integer.parseInt(array[1]), Integer.parseInt(array[2]));
                    break;

                case "stepRobot":
                    p.stepRobot(Integer.parseInt(array[1]), array[2]);
                    break;

                case "stepUfo":
                    p.stepUfo(Integer.parseInt(array[1]), array[2]);
                    break;

                case "drillMiner":
                    p.drillMiner(Integer.parseInt(array[1]));
                    break;

                case "mineMiner":
                    p.mineMiner(Integer.parseInt(array[1]));
                    break;

                case "buildTeleport":
                    p.buildTeleport(Integer.parseInt(array[1]));
                    break;

                case "placeTeleport":
                    p.placeTeleport(Integer.parseInt(array[1]),Integer.parseInt(array[2]));
                    break;

                case "perihelion":
                    p.perihelion(Integer.parseInt(array[1]));
                    break;

                case "sunStorm":
                    p.sunStorm(array[1]);
                    break;

                case "addToBackpack":
                    p.addToBackpack(array[1], Integer.parseInt(array[2]));
                    break;

                case "backPack":
                    p.backPack(Integer.parseInt(array[1]));
                    break;

                case "neighbors":
                    p.neighbors(Integer.parseInt(array[1]));
                    break;

                case "buildRobot":
                    p.buildRobot(Integer.parseInt(array[1]));
                    break;

                case "addSettler":
                    p.addSettler(Integer.parseInt(array[1]));
                    break;

                case "addUfo":
                    p.addUfo(Integer.parseInt(array[1]));
                    break;

                case "addRobot":
                    p.addRobot(Integer.parseInt(array[1]));
                    break;

                case "save":
                    p.save();
                    break;

                case "step":
                    p.step();
                    break;

                case "Exit":
                    break loop;
                default:
                    break;
            }
        }
    }
}

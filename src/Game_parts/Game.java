package Game_parts;

import GUIComponents.*;
import  Proto.*;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public ImageResizer imgRes;

    public Random rand = new Random();
    private static Map map;                //A játék pálya.

    // A protohoz tartozó osztály
    private static Proto p = new Proto();

    //"Init" Beállítja a játék kezdésénél az értékeket.
    public void StartGame() {
        System.out.println("A játék elkezdődik");
        map = new Map(5, 2);
    }



    // A játék maga.
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Indulhat a játék:");
        MusicStuff musicObject = new MusicStuff();
        musicObject.playMusic("hansZimmer.wav");
        new MainFrame();
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
                    if (array.length < 3)
                        p.stepRobot(Integer.parseInt(array[1]), "");
                    else
                        p.stepRobot(Integer.parseInt(array[1]), array[2]);
                    break;

                case "moveTp":
                    p.moveTp(Integer.parseInt(array[1]), Integer.parseInt(array[2]));

                case "stepUfo":
                    if (array.length < 3)
                        p.stepUfo(Integer.parseInt(array[1]), "");
                    else
                        p.stepUfo(Integer.parseInt(array[1]), array[2]);
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
                    p.save(array[1]);
                    break;

                case "step":
                    p.step();
                    break;

                case "Checkwin":
                    boolean win=false;
                    win=p.EndGame();
                    if(win==true){
                        break loop;
                    }
                    break;

                case "Exit":
                    break loop;
                default:
                    break;
            }
        }
    }
}

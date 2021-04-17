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

        System.out.println("Indulhat a játék");

        Scanner input=new Scanner(System.in);

        loop: while(true){  // a tesztesetek megtekintéséhez be kell írni a megfelelő számot

            String line = input.nextLine();
            if (line == null) {break;}
            String array[] = line.split(" ");

            switch(array[0]){
                case "loadMap":
                    p.loadMap(array[1]);
                    break;

                case "Exit":
                    break loop;
                default:
                    break;
            }
        }
    }
}

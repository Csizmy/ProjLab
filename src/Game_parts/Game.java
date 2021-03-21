package Game_parts;

import Objects.Asteroid;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public Random rand = new Random();
    private static Map map;                //A játék pálya.

    //"Init" Beállítja a játék kezdésénél az értékeket.
    public void StartGame() {
    }

    //Körönként ellenőrzi a win/lose események bekövetkezését, és befejezi a játékok.
    public void EndGame() {
        //TODO
    }

    // A játék maga.
    public static void main(String[] args) {

        map = new Map(10, 4);    //Játék indítása szekvencia
    }//kk
}

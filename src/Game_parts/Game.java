package Game_parts;

import GUIComponents.*;
import  Proto.*;

import java.io.FileNotFoundException;

public class Game {  //Ez a főosztályunk itt inditjuk el a játékot, itt hozzuk létre a játék ablakját.

    // A játék maga.
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Indulhat a játék:");
        MusicStuff musicObject = new MusicStuff();
        musicObject.playMusic("hansZimmer.wav");
        new MainFrame();
    }
}

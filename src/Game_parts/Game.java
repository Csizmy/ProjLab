package Game_parts;

import GUIComponents.*;
import  Proto.*;

import java.io.FileNotFoundException;

/**
* This is our main class where we start the game, here we create the game window
* @author mzperx
 */


public class Game {  //Ez a főosztályunk itt inditjuk el a játékot, itt hozzuk létre a játék ablakját.

    /**
     * This is our main function
     * @exception FileNotFoundException if there is no music
     */
    public static void main(String[] args) throws FileNotFoundException {
        MusicStuff musicObject = new MusicStuff();
        musicObject.playMusic("hansZimmer.wav");
        new MainFrame();
    }
}

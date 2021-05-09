package Game_parts;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;

//Responsible for music under the game
public class MusicStuff {

    //Loads the given music from path and starts playing it
    void playMusic(String music){
        try {
            File musicPath = new File("music\\" + music);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();

            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

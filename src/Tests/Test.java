package Tests;

import Objects.*;
import Materials.*;
import Miners.*;
import Game_parts.*;

public class Test {

    public void jatek_inditas(){} //Játék indítás + Aszteroidák létrehozása

    public void tpre_mozog(){}//Telepes teleportkapura mozog

    public void asztra_mozog(){} //Telepes aszteroidára mozog

    public void napvihar_elbujas(){

        Map m = new Map(2, 1);            //új random map 2 aszteroidával, 1 settlerrel (azért 2 mert a konstruktor nem tud 1-et)
        Robot r1 = new Robot(m.getAsteroids().get(0));      //plusz egy robot az egyik aszteroidára
        Robot r2 = new Robot(m.getAsteroids().get(1));      //plusz egy robot a másik aszteroidára
                                                            //valamelyik majd meghal
                                                            //
        for (int i = 0; i < 10; i++)                        //
            m.getSettlers().get(0).Drill();                 //a settler fúr 10-szer, hogy ne legyen layer az aszteroidán
                                                            //
        m.getSettlers().get(0).Mine();                      //majd kibányássza a belsejét
                                                            //
        m.SolarStorm();                                     //napvihar elvárt outputja, hogy a settler és az egyik robot túléli, a másik robot meghal

    } // Telepes megfúrt aszteroidán van (automatikus az elbújás)

    public void napvihar_meghal(){

        Map m = new Map(2, 1);            //új aszteroidamező 1 settlerrel

        m.SolarStorm();                                     //elvárt output: a settler meghal

    } // Telepes nem megfúrt aszteroidán van (meghal)

    public void utolso_furas(){

        Map m = new Map(2, 1);            //új aszteroidamező 1 settlerrel

        for (int i = 0; i < 10; i++)                        //ez biztos fúr annyit, hogy leérjen az aljára
            m.getSettlers().get(0).Drill();

    } // Telepes aszteroidát fúr

    public void furas_napkozel_viz(){

        Asteroid a = new Asteroid(0, 0, true, null);
        Water w = new Water(a);



    } // Telepes aszteroidát fúr napközelben vizet

    public void furas_napkozel_uran(){} // Telepes aszteroidát fúr napközelben uránt

    public void banyaszas(){}  // Telepes banyaszik (itt nem néz napközelt csak fúrásnál)

    public void tp_epit_i(){}  // Telepes teleportkaput épít van elég anyag

    public void tp_epit_h(){}  // Telepes teleportkaput épít nincs elég anyag

    public void robot_epit_i(){}  // Telepes robotot épít van elég anyag

    public void robot_epit_h(){}  // Telepes robotot épít nincs elég anyag

    public void napkitores(){}  // Véletlenszerű napkitörés megjelenik

    public void robot_lep(){}  //  Robot műveletet hajt végre - mozog/fur

}

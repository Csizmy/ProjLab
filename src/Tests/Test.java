package Tests;

import Game_parts.*;
import Materials.*;
import Miners.*;
import Objects.*;

public class Test {

    public void jatek_inditas(){ //Játék indítás + Aszteroidák létrehozása

        Map m = new Map(3,2);  //létrehoz 3 aszteroidát (körkörösen szomszédos), és rajtuk 2 settlert
        //elvárt kimenet: aszteroidák konstruktora, telepesek konstruktora, szomszédok kiírása

    }

    public void tpre_mozog(){}//Telepes teleportkapura mozog

    public void asztra_mozog(){//Telepes aszteroidára mozog
        Asteroid a = new Asteroid(0, 0, true, null);  //Létrehozok 2 aszteroidát
        Asteroid a2 = new Asteroid(1, 0, true, null);
        Settler s = new Settler(a);         //egy telepes az első aszteroidán van
        s.Move(a2.getId());             //a telepes átlép a 2. aszteroidára
    }

    public void napvihar_elbujas(){ // Telepes megfúrt aszteroidán van (automatikus az elbújás)

        Map m = new Map(2, 1);            //új random map 2 aszteroidával, 1 settlerrel (azért 2 mert a konstruktor nem tud 1-et)
        Robot r1 = new Robot(m.getAsteroids().get(0));      //plusz egy robot az egyik aszteroidára
        Robot r2 = new Robot(m.getAsteroids().get(1));      //plusz egy robot a másik aszteroidára
        //valamelyik majd meghal
        //
        for (int i = 0; i < 10; i++)                         //
            m.getSettlers().get(0).Drill();                 //a settler fúr 10-szer, hogy ne legyen layer az aszteroidán
        //
        m.getSettlers().get(0).Mine();                      //majd kibányássza a belsejét
        //
        m.SolarStorm();                                     //napvihar elvárt outputja, hogy a settler és az egyik robot túléli, a másik robot meghal

    }

    public void napvihar_meghal(){

        Map m = new Map(2, 1);            //új aszteroidamező 1 settlerrel

        m.SolarStorm();                                     //elvárt output: a settler meghal

    } // Telepes nem megfúrt aszteroidán van (meghal)

    public void utolso_furas(){

        Map m = new Map(2, 1);            //új aszteroidamező 1 settlerrel

        for (int i = 0; i < 10; i++)                        //10 fúrással lejut az aljra
            m.getSettlers().get(0).Drill();

    } // Telepes aszteroidát fúr

    public void furas_napkozel_viz(){

        Asteroid a = new Asteroid(0, 0, true, null);
        Water w = new Water(a);
        Settler s = new Settler(a);

        a.setMaterial(w);
        a.addMiner(s);                                      //aszteroida napközelben, rá víz meg egy settler

        s.Mine();                                           //bányászat

    } // Telepes aszteroidát fúr napközelben vizet

    public void furas_napkozel_uran(){

        Asteroid a = new Asteroid(8, 0, true, null);
        Uranium u = new Uranium(a);                          //
        Settler s = new Settler(a);

        a.setMaterial(u);
        a.addMiner(s);                                      //aszteroida napközelben, rá uránium meg egy settler

        s.Mine();                                           //bányászat

    } // Telepes aszteroidát fúr napközelben uránt

    public void banyaszas(){ // Telepes banyaszik (itt nem néz napközelt csak fúrásnál)

        Asteroid a = new Asteroid(0);  // aszteroida konstruktor
        a.setLayer(0);  // a teszt miatt beállítja kiásottra
        Iron i = new Iron(a);  // vasat rak az aszteroida nyersanyagának (hgy ne legyen semmiképp robbanás)
        Settler s = new Settler(a);  // rárak egy telepest az aszteroidára
        s.Mine();  // bekerül a táskába az anyag, mert nincs probléma

    }

    public void tp_epit_i(){
        Asteroid planet = new Asteroid(17);        //A teszt aszteroida, ahol épít a telepes.
        Settler builder = new Settler(planet);              //Az építő telepes.
        Iron iron = new Iron(null);
        Water water = new Water(null);
        Uranium uranium = new Uranium(null);             //A kellő nyersanyagok létrehozva.

        builder.getBackpack().add(iron);
        builder.getBackpack().add(iron);
        builder.getBackpack().add(water);
        builder.getBackpack().add(uranium);                 //A nyersanyagok a táskához adva.

        builder.BuildTp();

    }  // Telepes teleportkaput épít van elég anyag

    public void tp_epit_h(){
        Asteroid planet = new Asteroid(23);        //A teszt aszteroida, ahol épít a telepes.
        Settler builder = new Settler(planet);              //Az építő telepes.

        builder.BuildTp();
        
    }  // Telepes teleportkaput épít nincs elég anyag

    public void robot_epit_i(){
        Asteroid planet = new Asteroid(12);        //A teszt aszteroida, ahol épít a telepes.
        Settler builder = new Settler(planet);              //Az építő telepes.
        Iron iron = new Iron(null);
        Coal coal = new Coal(null);
        Uranium uranium = new Uranium(null);             //A kellő nyersanyagok létrehozva.

        builder.getBackpack().add(iron);
        builder.getBackpack().add(coal);
        builder.getBackpack().add(uranium);                 //A nyersanyagok a táskához adva.

        builder.BuildRobot();

    }  // Telepes robotot épít van elég anyag.

    public void robot_epit_h(){

        Asteroid planet = new Asteroid(42);        //A teszt aszteroida, ahol épít a telepes.
        Settler builder = new Settler(planet);              //Az építő telepes.

        builder.BuildRobot();

    }  // Telepes robotot épít nincs elég anyag.

    public void robot_lep(){}  //  Robot műveletet hajt végre - mozog/fur

}

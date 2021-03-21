package Tests;

public class Test {

    public void jatek_inditas(){ //Játék indítás + Aszteroidák létrehozása

        Map m = new Map(3,2);

    }

    public void tpre_mozog(){}//Telepes teleportkapura mozog

    public void asztra_mozog(){} //Telepes aszteroidára mozog

    public void napvihar_elbujas(){} // Telepes megfúrt aszteroidán van (automatikus az elbújás)

    } // Telepes megfúrt aszteroidán van (automatikus az elbújás)

    public void napvihar_meghal(){



    } // Telepes nem megfúrt aszteroidán van (meghal)

    public void utolso_furas(){} // Telepes aszteroidát fúr

    public void furas_napkozel_viz(){} // Telepes aszteroidát fúr napközelben vizet

    public void furas_napkozel_uran(){} // Telepes aszteroidát fúr napközelben uránt

    public void banyaszas(){ // 9. Telepes banyaszik (itt nem néz napközelt csak fúrásnál)

        Asteroid a = new Asteroid(0);
        a.setLayer(0);
        Iron i = new Iron(a);
        Settler s = new Settler(a);
        s.Mine();

    }

    public void tp_epit_i(){}  // Telepes teleportkaput épít van elég anyag

    public void tp_epit_h(){}  // Telepes teleportkaput épít nincs elég anyag

    public void robot_epit_i(){}  // Telepes robotot épít van elég anyag

    public void robot_epit_h(){}  // Telepes robotot épít nincs elég anyag

    public void napkitores(){}  // Véletlenszerű napkitörés megjelenik

    public void robot_lep(){}  //  Robot műveletet hajt végre - mozog/fur

}

package Game_parts;

import Objects.Asteroid;
import Tests.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Test t = new Test();
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

        boolean testing = true;

        System.out.println("1. Játék indítás + Aszteroidák létrehozása\n" +
                "2. Telepes teleportkapura mozog\n" +
                "3. Telepes aszteroidára mozog\n" +
                "4. Telepes megfúrt aszteroidán van (automatikus az elbújás\n" +
                "5. Telepes nem megfúrt aszteroidán van (meghal)\n" +
                "6. Telepes aszteroidát fúr\n" +
                "7. Telepes aszteroidát fúr : napközelben vizet\n" +
                "8. Telepes aszteroidát fúr : napközelben uránt\n" +
                "9. Telepes banyaszik (itt nem néz napközelt csak fúrásnál)\n" +
                "10. Telepes teleportkaput épít van elég anyag\n" +
                "11. Telepes teleportkaput épít nincs elég anyag\n" +
                "12. Telepes robotot épít van elég anyag\n" +
                "13. Telepes robotot épít nincs elég anyag\n" +
                "14. Robot műveletet hajt végre - mozog/fur\n" +
                "0. Kilépés\n");

        System.out.println("Teszteset száma: ");
        Scanner input=new Scanner(System.in);
        int choice = input.nextInt();

        while(testing){

            switch(choice){
                case 1:
                    System.out.println("Játék indítás + Aszteroidák létrehozása");
                    t.jatek_inditas();
                    break;

                case 2:
                    System.out.println("Telepes teleportkapura mozog");
                    t.tpre_mozog();
                    break;

                case 3:
                    System.out.println("Telepes aszteroidára mozog");
                    t.asztra_mozog();
                    break;

                case 4:
                    System.out.println("Telepes megfúrt aszteroidán van (automatikus az elbújás)");
                    t.napvihar_elbujas();
                    break;

                case 5:
                    System.out.println("Telepes nem megfúrt aszteroidán van (meghal)");
                    t.napvihar_meghal();
                    break;

                case 6:
                    System.out.println("Telepes aszteroidát fúr");
                    t.utolso_furas();
                    break;

                case 7:
                    System.out.println("Telepes aszteroidát fúr : napközelben vizet");
                    t.furas_napkozel_viz();
                    break;

                case 8:
                    System.out.println("Telepes aszteroidát fúr : napközelben uránt");
                    t.furas_napkozel_uran();
                    break;

                case 9:
                    System.out.println("Telepes banyaszik (itt nem néz napközelt csak fúrásnál)");
                    t.banyaszas();
                    break;

                case 10:
                    System.out.println("Telepes teleportkaput épít van elég anyag");
                    t.tp_epit_i();
                    break;

                case 11:
                    System.out.println("Telepes teleportkaput épít nincs elég anyag");
                    t.tp_epit_h();
                    break;

                case 12:
                    System.out.println("Telepes robotot épít van elég anyag");
                    t.robot_epit_i();
                    break;

                case 13:
                    System.out.println("Telepes robotot épít nincs elég anyag");
                    t.robot_epit_h();
                    break;

                case 14:
                    System.out.println("Robot műveletet hajt végre - mozog/fur");
                    t.robot_lep();
                    break;

                case 0:
                    testing = false;
                    break;
            }

            System.out.println("Teszteset száma: ");
            choice = input.nextInt(); // add this
        }
    }
}

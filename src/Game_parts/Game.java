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

        map = new Map(10, 4);    //Játék indítása szekvencia

        map.getSettlers().get(0).Move(map.getSettlers().get(0).getSpacething().getNeighbours().get(0).getId());
        boolean testing = true;

        System.out.println("Teszteset száma: ");
        Scanner input=new Scanner(System.in);
        int choice = input.nextInt();

        while(testing){

            switch(choice){
                case 1:
                    t.jatek_inditas();
                    break;

                case 2:
                    t.tpre_mozog();
                    break;

                case 3:
                    t.asztra_mozog();
                    break;

                case 4:
                    t.napvihar_elbujas();
                    break;

                case 5:
                    t.napvihar_meghal();
                    break;

                case 6:
                    t.utolso_furas();
                    break;

                case 7:
                    t.furas_napkozel_viz();
                    break;

                case 8:
                    t.furas_napkozel_uran();
                    break;

                case 9:
                    t.banyaszas();
                    break;

                case 10:
                    t.tp_epit_i();
                    break;

                case 11:
                    t.tp_epit_h();
                    break;

                case 12:
                    t.robot_epit_i();
                    break;

                case 13:
                    t.robot_epit_h();
                    break;

                case 14:
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

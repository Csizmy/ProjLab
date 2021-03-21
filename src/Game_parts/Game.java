package Game_parts;

public class Game {

    private Map map;                //A játék pálya.

    //"Init" Beállítja a játék kezdésénél az értékeket.
    public void StartGame() {
        map = new Map();
    }

    //Körönként ellenőrzi a win/lose események bekövetkezését, és befejezi a játékok.
    public void EndGame() {
        //TODO
    }

    // A játék maga.
    public static void main(String[] args) {
        System.out.println("GitHub try"); // Display the string.
        System.out.println("GitHub try2"); // Display the string.
    }
}

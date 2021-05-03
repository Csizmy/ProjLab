package Graphics;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Menu menu;
    private GamePanel gamePanel;            //or game ?

    public MainFrame() {
        this.add(new Menu());
        this.setTitle("Asteroid Game");
        this.setSize(new Dimension(1200,900));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }


    public void runGame() {
        //TODO
    }

    public void changePanel(int x) {
        //TODO
    }

}

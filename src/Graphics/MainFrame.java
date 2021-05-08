package Graphics;


import Proto.Proto;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

interface OnPlayListener {

    void ChangeToGame(int i) throws IOException;
}
public class MainFrame extends JFrame implements OnPlayListener{
    private Menu menu;
    private GamePanel gamePanel;            //or game ?
    private MapView map;
    private Proto p;


    public MainFrame() {
        this.add(new Menu(this));
        this.setTitle("Asteroid Game");
        this.setSize(new Dimension(840+16,630+39));//kristof thing:igy lett 1200x900 a benne levo megjelenitett cucc mert ez beleszamolja a szurke savokat
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        p = new Proto();
        p.loadMap("test.txt");  // pálya betöltése
    }




    @Override
    public void ChangeToGame(int x) throws IOException { changePanel(x); }


    public void runGame() {
        //TODO
    }

    public void changePanel(int x) throws IOException {
        this.getContentPane().removeAll();
        if(x==1){
            this.getContentPane().add(new GamePanel(this,p));
        }
        else if(x==2){
            this.getContentPane().add(new MapView(this,p));
        }
        else if(x==3){
            this.getContentPane().add(new Menu(this));
        }
        this.revalidate();
    }
}

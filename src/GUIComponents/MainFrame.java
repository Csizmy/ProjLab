package GUIComponents;


import Proto.Proto;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

interface OnPlayListener {

    void ChangeToGame(int i, boolean wine) throws IOException;
}
public class MainFrame extends JFrame implements OnPlayListener{
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
    public void ChangeToGame(int x,boolean wine) throws IOException { changePanel(x,wine); }

    public void changePanel(int x,boolean wine) throws IOException {
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
        else if(x==4){
            p = new Proto();
            this.getContentPane().add(new EndScreen(this, p,wine));
        }
        this.revalidate();
    }

}

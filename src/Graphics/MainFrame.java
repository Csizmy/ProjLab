package Graphics;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

interface OnPlayListener {

    void ChangeToGame() throws IOException;
}
public class MainFrame extends JFrame implements OnPlayListener{
    private Menu menu;
    private GamePanel gamePanel;            //or game ?


    public MainFrame() {
        this.add(new Menu(this));
        this.setTitle("Asteroid Game");
        this.setSize(new Dimension(840+16,630+39));//kristof thing:igy lett 1200x900 a benne levo megjelenitett cucc mert ez beleszamolja a szurke savokat
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }




    @Override
    public void ChangeToGame() throws IOException { changePanel(1); }

    public void ChangeToMenu() throws IOException {
        changePanel(2);
    }

    public void runGame() {
        //TODO
    }

    public void changePanel(int x) throws IOException {
        this.getContentPane().removeAll();
        if(x==1){
            this.getContentPane().add(new GamePanel(this));
        }
        else{
            this.getContentPane().add(new Menu(this));
        }
        this.revalidate();
    }
}

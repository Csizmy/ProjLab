package Graphics;


import javax.swing.*;
import java.awt.*;
interface OnPlayListener {


    void ChangeToGame();
}
public class MainFrame extends JFrame implements OnPlayListener{
    private Menu menu;
    private GamePanel gamePanel;            //or game ?


    public MainFrame() {
        this.add(new Menu(this));
        this.setTitle("Asteroid Game");
        this.setSize(new Dimension(1200,900));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }




    @Override
    public void ChangeToGame()
    {
       changePanel(1);
    }

    public void runGame() {
        //TODO
    }

    public void changePanel(int x) {
        this.getContentPane().removeAll();
        if(x==1){
            this.getContentPane().add(new GamePanel());
        }
        else{
            this.getContentPane().add(new Menu(this));
        }
        this.revalidate();
    }

}

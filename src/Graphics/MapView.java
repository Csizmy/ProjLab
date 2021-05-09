package Graphics;

import GObjects.GAsteroid;
import Game_parts.Map;
import Miners.Settler;
import Proto.Proto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MapView extends JPanel {

    private JButton back, zoomin, zoomout;      // gombok
    private Clicklistener click;                // A gombokat kezeli
    private BufferedImage image;                //háttér
    private Proto p;                            //A játék lépéseit valositja meg
    private Settler currentPlayer;              // A jelenlegi játékos
    private OnPlayListener backToGameView;
    private Map map;
    private ArrayList<GAsteroid> asteroids = new ArrayList<GAsteroid>();

    // A szomszédos aszteroidák/teleportok gombjai, amire kattintva oda mozog a telepes.
    private ArrayList<JButton> Neighbours = new ArrayList<>();


    public void InitButton(JButton btn){
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.addActionListener(click);
        btn.setFocusable(false);
    }

    public MapView(OnPlayListener act,Proto val) {
        p = val;
        backToGameView=act;
        map =p.getMap();

        click = new Clicklistener();
        back = new JButton("");             //hogy legyen???
        zoomin = new JButton("");
        zoomout = new JButton("");

        //back.setIcon();
        zoomin.setIcon(new ImageIcon("pictures\\zoomin54x54.png"));
        zoomout.setIcon(new ImageIcon("pictures\\zoomout54x54.png"));

        //back.setBounds();
        zoomin.setBounds(700, 20, 54, 54);
        zoomout.setBounds(770, 20, 54, 54);
        GAsteroid ga = null;
        for (int i = 0; i < 50; i++){
            try {
                asteroids.add(new GAsteroid(map.getAsteroids().get(i), 0.05));
            } catch (IOException ex) { /*mindig jó, nincs error köszi.*/ }

            this.add(asteroids.get(i).getButton());

        }


        InitButton(zoomin);
        this.add(zoomin);
        InitButton(zoomout);
        this.add(zoomout);
        InitButton(back);                       //hogy legyen???
        this.add(back);                         //hogy legyen???

        //this.setLayout(null);                 //?

        try {
            image = ImageIO.read(new File("pictures\\background.png"));
        } catch (IOException ex) { /*mindig jó, nincs error köszi.*/ }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image , 0, 0, this); // see javadoc for more info on the parameters



    }

    public void loadMaporWhat() {} // go wild Kristof

    public void nextPlayer(){} ////         HOW????
    public void setMap(Map m){this.map = m;}


    private class Clicklistener implements ActionListener { //gombok megnyomását kezeli

        public void actionPerformed(ActionEvent e){

            if (e.getSource() == back){  //mozogni probál itt át kéne váltani a map nézetre
                System.out.println("move");
            }

            else if (e.getSource() == zoomout){
                System.out.println("zoomout");
            }

            else if (e.getSource() == zoomin){
                System.out.println("zoomin");
                try {
                    backToGameView.ChangeToGame(1);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }


        }
    }

}

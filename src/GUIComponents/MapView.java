package GUIComponents;

import java.awt.Graphics;
import java.awt.Graphics2D;

import GObjects.GAsteroid;
import Game_parts.Map;
import Miners.Settler;
import Objects.Asteroid;
import Objects.Spacething;
import Objects.Teleport;
import Proto.Proto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
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
    private ArrayList<JLabel> idlabels = new ArrayList<JLabel>();
    private ArrayList<JButton> asteroidButtons = new ArrayList<JButton>();


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
        currentPlayer = (Settler)p.getCurrent();

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
            Asteroid current = map.getAsteroids().get(i);
            try {
                asteroids.add(new GAsteroid(current, 0.05));
            } catch (IOException ex) { /*mindig jó, nincs error köszi.*/ }

            this.add(asteroids.get(i).getButton());
            asteroids.get(i).getButton().addActionListener(click);
            asteroidButtons.add(asteroids.get(i).getButton());

            idlabels.add( new JLabel(String.valueOf(current.getId())));
            idlabels.get(i).setBounds(current.getX(), current.getY()-20, 20, 20);
            idlabels.get(i).setForeground(Color.yellow);
            this.add(idlabels.get(i));
        }




        InitButton(zoomin);
        this.add(zoomin);
        InitButton(zoomout);
        this.add(zoomout);
        InitButton(back);                       //hogy legyen???
        this.add(back);                         //hogy legyen???

        this.setLayout(null);                 //?

        try {
            image = ImageIO.read(new File("pictures\\background.png"));
        } catch (IOException ex) { /*mindig jó, nincs error köszi.*/ }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g.drawImage(image , 0, 0, this); // see javadoc for more info on the parameters

        //g.setColor(Color.BLUE);

        for (int i = 0; i < 50; i++){
            Asteroid current = map.getAsteroids().get(i);

            for (int j = 0; j < current.getNeighbours().size(); j++){
                g.setColor(Color.BLUE);
                Spacething neighbor = current.getNeighbours().get(j);
                if (!neighbor.isAsteroid()){
                    g.setColor(Color.pink);
                    neighbor = ((Teleport) neighbor).getPair();
                    neighbor = neighbor.getNeighbours().get(0);
                }

                g2.drawLine(current.getX()+7, current.getY()+7, neighbor.getX()+7, neighbor.getY()+7);
            }

        }

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
            else{
                int indx = asteroidButtons.indexOf( e.getSource() );
                p.moveSettler(currentPlayer.getId(), indx);
            }
        }
    }

}

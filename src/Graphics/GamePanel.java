package Graphics;

import GObjects.*;
import Game_parts.Game;
import Materials.Material;
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

public class GamePanel extends JPanel {

    private JButton tp,robot,dig,mine,move,zoomin, zoomout, skip;    //gombok
    private JLabel resourceInventory, tpInventory;    //A játékos táskája
    private Clicklistener click;  // A gombokat kezeli
    private BufferedImage image;    //háttér
    private Proto p;            //A játék lépéseit valositja meg
    private Settler currentPlayer;  // A jelenlegi játékos
    private ArrayList<JButton> Things = new ArrayList<>();
    private ArrayList<JButton> gfxTest = new ArrayList<>();

    public void InitButton(JButton btn){
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.addActionListener(click);
        btn.setFocusable(false);
    }

    public GamePanel(OnPlayListener act ) throws IOException {
        p = new Proto();
        p.loadMap("test.txt");  // pálya betöltése
        p.addToBackpack("Water",51);
        p.addToBackpack("Iron",51);
        currentPlayer = p.getMap().getSettlers().get(0);
        click = new Clicklistener();
        zoomout = new JButton("");
        skip= new JButton("");
        zoomin = new JButton("");
        tp = new JButton("");
        robot = new JButton("");
        dig = new JButton("");
        mine = new JButton("");
        move = new JButton("");

        resourceInventory = new JLabel(new ImageIcon("pictures\\resourceinventory191x386.png"));
        tpInventory = new JLabel(new ImageIcon("pictures\\tpinventory210x63.png"));

        skip.setIcon(new ImageIcon("pictures\\skip200x53.png" ));
        zoomout.setIcon(new ImageIcon("pictures\\zoomout54x54.png" ));
        zoomin.setIcon(new ImageIcon("pictures\\zoomin54x54.png" ));
        tp.setIcon(new ImageIcon("pictures\\tp200x53.png" ));
        robot.setIcon(new ImageIcon("pictures\\robot200x53.png" ));
        dig.setIcon(new ImageIcon("pictures\\dig200x53.png" ));
        mine.setIcon(new ImageIcon("pictures\\mine200x53.png" ));
        move.setIcon(new ImageIcon("pictures\\move200x53.png" ));



        zoomout.setBounds(770,20,54,54);
        zoomin.setBounds(700,20,54,54);
        tp.setBounds(50,570,200,53);
        robot.setBounds(300,570,200,53);
        dig.setBounds(50,500,200,53);
        mine.setBounds(300,500,200,53);
        move.setBounds(550,500,200,53);
        resourceInventory.setBounds(50,20,191,386);
        tpInventory.setBounds(40,420,210,63);
        skip.setBounds(550,570,200,53);

        Things.add(zoomout);
        Things.add(zoomin);
        Things.add(tp);
        Things.add(robot);
        Things.add(dig);
        Things.add(mine);
        Things.add(move);
        Things.add(skip);

        for (JButton jb: Things) {
            InitButton(jb);
            this.add(jb);
        }

        resourceInventory.setOpaque(false);
        tpInventory.setOpaque(false);

        this.setLayout(null);

        //this.add(resourceInventory);
        this.add(tpInventory);

        try {
            image = ImageIO.read(new File("pictures\\background.png"));
        } catch (IOException ex) {

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image , 0, 0, this); // see javadoc for more info on the parameters

        int x = 0;
        int y = 0;

        GIron iron = null;
        try {
            iron = new GIron(x, y);
        } catch (IOException e) {
            e.printStackTrace();
        }


        for(Material m :currentPlayer.getBackpack()){  ////!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            if(x==5){   ///!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                y=1;  ///!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            }  ///!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ok itt a backpacket akarom kirajzolni nem megy vkinek hajrá fent a konstruktorban az
            System.out.println("Beleptem "+m.getName());  // 51-es idhez adtam 2 anyagot is amit itt ki is ir de a rajzolása már sehogy se megy gl hf
            try {
                this.add(m.drawMaterial(x*70 + 200, y*70 + 100, this, m));
            } catch (IOException e) {
                e.printStackTrace();
            }

            x++;

        }


    }

    public void exit() {
        //TODO
    }

    public void start() {
        //TODO
    }

    public void drawAll() {
        //TODO
    }

    public void backPackDraw(Graphics g){

    }

    public void nextPlayer(){
        if(p.EndGame()==true){  //ellenőrzi hogy nyertek e a telepesek.
            //TODO kilép vagy kirajzol valami képet hogy win ugyi vagy
        }
        for (int i = 0; i < p.getMap().getSettlers().size(); i++) {
            if(i== p.getMap().getSettlers().size()-1){
                p.step(); // léptet mindenkit ha az utolso player lelépte a lépését
                currentPlayer = p.getMap().getSettlers().get(0);
                return;
            }
            if(p.getMap().getSettlers().get(i)==currentPlayer){
                currentPlayer = p.getMap().getSettlers().get(i+1);
                return;
            }
        }
    }

    private class Clicklistener implements ActionListener { //gombok megnyomását kezeli

        public void actionPerformed(ActionEvent e){
            if (e.getSource() == tp){   //teleportot probál épiteni
                System.out.println("tp");
                if(p.buildTeleport(currentPlayer.getId())==true){
                    nextPlayer();
                }
            }
            else if (e.getSource() == robot){ //robotot probnál épiteni
                System.out.println("robot");
                if(p.buildRobot(currentPlayer.getId())==true){
                    nextPlayer();
                }
            }
            else if (e.getSource() == dig){  //furni probál
                System.out.println("dig");
                if(p.drillMiner(currentPlayer.getId())==true){
                    nextPlayer();
                }
            }
            else if (e.getSource() == mine){  //ásni probál
                System.out.println("mine");
                if(p.mineMiner(currentPlayer.getId())==true){
                    nextPlayer();
                }
            }
            else if (e.getSource() == move){  //mozogni probál itt át kéne váltani a map nézetre
                System.out.println("move");
            }

            else if (e.getSource() == zoomout){
                System.out.println("zoomout");
            }

            else if (e.getSource() == zoomin){
                System.out.println("zoomin");
            }

            else if (e.getSource() == skip){
                System.out.println("skip");
                nextPlayer();
            }

        }
    }

}

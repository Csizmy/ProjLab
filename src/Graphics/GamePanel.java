package Graphics;

import GObjects.*;
import Game_parts.Game;
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

    private JButton tp,robot,dig,mine,move,zoomin,zoomout;
    private JLabel resourceInventory, tpInventory;
    private Clicklistener click;
    private BufferedImage image;
    private Proto p;
    private Settler currentPlayer;  /// ezt még meg kéne vhogy kapnia.........
    private ArrayList<JButton> gfxTest = new ArrayList<>();

    private Game game;
    private Controller controller; //ez így van itt?


    public GamePanel(OnPlayListener act) throws IOException {
        p = new Proto();
        p.loadMap("test.txt");  // pálya betöltése
        currentPlayer = p.getMap().getSettlers().get(0);
        click = new Clicklistener();
        tp = new JButton("");
        robot = new JButton("");
        dig = new JButton("");
        mine = new JButton("");
        move = new JButton("");
        zoomin = new JButton("");
        zoomout = new JButton("");

        resourceInventory = new JLabel(new ImageIcon("pictures\\resourceinventory289x586.png"));
        tpInventory = new JLabel(new ImageIcon("pictures\\tpinventory280x83.png"));

        tp.setIcon(new ImageIcon("pictures\\tp248x65.png" ));
        tp.setOpaque(false);
        tp.setContentAreaFilled(false);

        robot.setIcon(new ImageIcon("pictures\\robot248x65.png" ));
        robot.setOpaque(false);
        robot.setContentAreaFilled(false);

        dig.setIcon(new ImageIcon("pictures\\dig248x65.png" ));
        dig.setOpaque(false);
        dig.setContentAreaFilled(false);

        mine.setIcon(new ImageIcon("pictures\\mine248x65.png" ));
        mine.setOpaque(false);
        mine.setContentAreaFilled(false);

        move.setIcon(new ImageIcon("pictures\\move248x65.png" ));
        move.setOpaque(false);
        move.setContentAreaFilled(false);

        zoomin.setIcon(new ImageIcon("pictures\\zoomin54x54.png" ));
        zoomin.setOpaque(false);
        zoomin.setContentAreaFilled(false);

        zoomout.setIcon(new ImageIcon("pictures\\zoomout54x54.png" ));
        zoomout.setOpaque(false);
        zoomout.setContentAreaFilled(false);


        resourceInventory.setOpaque(false);
        tpInventory.setOpaque(false);


        this.setLayout(null);

        tp.setBounds(62,740,248,65);
        robot.setBounds(62,818,248,65);
        dig.setBounds(333,818,248,65);
        mine.setBounds(600,818,248,65);
        move.setBounds(868,818,248,65);
        zoomout.setBounds(1064,13,54,54);
        zoomin.setBounds(1132,13,54,54);
        resourceInventory.setBounds(41,22,289,586);
        tpInventory.setBounds(45,639,280,83);

        tp.setFocusable(false);
        robot.setFocusable(false);
        dig.setFocusable(false);
        mine.setFocusable(false);
        move.setFocusable(false);
        zoomout.setFocusable(false);
        zoomin.setFocusable(false);
        resourceInventory.setFocusable(false);
        tpInventory.setFocusable(false);

        tp.addActionListener(click);
        robot.addActionListener(click);
        dig.addActionListener(click);
        mine.addActionListener(click);
        move.addActionListener(click);
        zoomout.addActionListener(click);
        zoomin.addActionListener(click);

        for(int i = 0; i < 2;i++){
            for(int j = 0; i < 5; i++){
                JButton btnTmp = new JButton();

                switch (j){
                   case 0:{
                       if(i == 0){
                           GAsteroid tmp = new GAsteroid(400 + i*150, 100 + j*150);
                           btnTmp = tmp.getButton();
                       }else{
                           GWater tmp = new GWater(400 + i*150, 100 + j*150);
                           btnTmp = tmp.getButton();
                       }
                   }break;

                    case 1:{
                        if(i == 0){
                            GUfo tmp = new GUfo(400 + i*150, 100 + j*150);
                            btnTmp = tmp.getButton();
                        }else{
                            GCoal tmp = new GCoal(400 + i*150, 100 + j*150);
                            btnTmp = tmp.getButton();
                        }
                    }break;

                    case 2:{
                        if(i == 0){
                            GSettler tmp = new GSettler(400 + i*150, 100 + j*150);
                            btnTmp = tmp.getButton();
                        }else{
                            GIron tmp = new GIron(400 + i*150, 100 + j*150);
                            btnTmp = tmp.getButton();
                        }
                    }break;

                    case 3:{
                        if(i == 0){
                            GRobot tmp = new GRobot(400 + i*150, 100 + j*150);
                            btnTmp = tmp.getButton();
                        }else{
                            GUranium tmp = new GUranium(400 + i*150, 100 + j*150);
                            btnTmp = tmp.getButton();
                        }
                    }break;

                    case 4:{
                        if(i == 0){
                            GTeleport tmp = new GTeleport(400 + i*150, 100 + j*150);
                            btnTmp = tmp.getButton();
                        }else{
                            GTeleport tmp = new GTeleport(400 + i*150, 100 + j*150);
                            btnTmp = tmp.getButton();
                        }
                    }break;
                }
                btnTmp.addActionListener(click);
                gfxTest.add(btnTmp);
            }
        }



        for (JButton jb: gfxTest) {
            this.add(jb);
        }

        this.add(tp);
        this.add(robot);
        this.add(dig);
        this.add(mine);
        this.add(move);
        this.add(zoomout);
        this.add(zoomin);
        this.add(resourceInventory);
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
            if (e.getSource() == tp){
                System.out.println("tp");
                if(p.buildTeleport(currentPlayer.getId())==true){
                    nextPlayer();
                }
            }
            else if (e.getSource() == robot){
                System.out.println("robot");
                if(p.buildRobot(currentPlayer.getId())==true){
                    nextPlayer();
                }
            }
            else if (e.getSource() == dig){
                System.out.println("dig");
                if(p.drillMiner(currentPlayer.getId())==true){
                    nextPlayer();
                }
            }
            else if (e.getSource() == mine){
                System.out.println("mine");
                if(p.mineMiner(currentPlayer.getId())==true){
                    nextPlayer();
                }
            }
            else if (e.getSource() == move){
                System.out.println("move");
            }
            else if (e.getSource() == zoomin){
                System.out.println("zoomin");
            }
            else if (e.getSource() == zoomout){
                System.out.println("zoomout");
            }
        }
    }

}

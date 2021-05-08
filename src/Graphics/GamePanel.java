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

    private JButton tp,robot,dig,mine,move,zoomin, zoomout;    //gombok
    private JLabel resourceInventory, tpInventory;    //A játékos táskája
    private Clicklistener click;  // A gombokat kezeli
    private BufferedImage image;    //háttér
    private BufferedImage texture;
    private Proto p;            //A játék lépéseit valositja meg
    private Settler currentPlayer;  // A jelenlegi játékos
    private ArrayList<JButton> gfxTest = new ArrayList<>();

    public GamePanel(OnPlayListener act) throws IOException {
        p = new Proto();
        p.loadMap("test.txt");  // pálya betöltése
        p.addToBackpack("Water",51);
        currentPlayer = p.getMap().getSettlers().get(0);
        click = new Clicklistener();
        zoomout = new JButton("");
        zoomin = new JButton("");
        tp = new JButton("");
        robot = new JButton("");
        dig = new JButton("");
        mine = new JButton("");
        move = new JButton("");

        resourceInventory = new JLabel(new ImageIcon("pictures\\resourceinventory191x386.png"));
        tpInventory = new JLabel(new ImageIcon("pictures\\tpinventory210x63.png"));

        zoomout.setIcon(new ImageIcon("pictures\\zoomout54x54.png" ));
        zoomout.setOpaque(false);
        zoomout.setContentAreaFilled(false);

        zoomin.setIcon(new ImageIcon("pictures\\zoomin54x54.png" ));
        zoomin.setOpaque(false);
        zoomin.setContentAreaFilled(false);

        tp.setIcon(new ImageIcon("pictures\\tp200x53.png" ));
        tp.setOpaque(false);
        tp.setContentAreaFilled(false);

        robot.setIcon(new ImageIcon("pictures\\robot200x53.png" ));
        robot.setOpaque(false);
        robot.setContentAreaFilled(false);

        dig.setIcon(new ImageIcon("pictures\\dig200x53.png" ));
        dig.setOpaque(false);
        dig.setContentAreaFilled(false);

        mine.setIcon(new ImageIcon("pictures\\mine200x53.png" ));
        mine.setOpaque(false);
        mine.setContentAreaFilled(false);

        move.setIcon(new ImageIcon("pictures\\move200x53.png" ));
        move.setOpaque(false);
        move.setContentAreaFilled(false);



        resourceInventory.setOpaque(false);
        tpInventory.setOpaque(false);


        this.setLayout(null);

        zoomout.setBounds(770,20,54,54);
        zoomin.setBounds(700,20,54,54);
        tp.setBounds(50,570,200,53);
        robot.setBounds(300,570,200,53);
        dig.setBounds(50,500,200,53);
        mine.setBounds(300,500,200,53);
        move.setBounds(550,500,200,53);
        resourceInventory.setBounds(50,20,191,386);
        tpInventory.setBounds(40,420,210,63);

        zoomout.setFocusable(false);
        zoomin.setFocusable(false);
        tp.setFocusable(false);
        robot.setFocusable(false);
        dig.setFocusable(false);
        mine.setFocusable(false);
        move.setFocusable(false);
        resourceInventory.setFocusable(false);
        tpInventory.setFocusable(false);

        zoomout.addActionListener(click);
        zoomin.addActionListener(click);
        tp.addActionListener(click);
        robot.addActionListener(click);
        dig.addActionListener(click);
        mine.addActionListener(click);
        move.addActionListener(click);

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

        this.add(zoomout);
        this.add(zoomin);
        this.add(tp);
        this.add(robot);
        this.add(dig);
        this.add(mine);
        this.add(move);
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

        //g.drawImage(image , 0, 0, this); // see javadoc for more info on the parameters
        backPackDraw(g);
        invalidate();

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
        int x = 0;
        int y = 0;


        for(Material m :currentPlayer.getBackpack()){
            if(x==5){
                y=1;
            }
            System.out.println("Beleptem"+m.getName());
            g.drawImage( m.getGobject().getTexture(),x*70 + 20, y*70 + 20,this);

            try {
                texture=  ImageIO.read(new File("pictures\\uranium70x70.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(texture, 400, 400,this);

            x++;
        }
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

        }
    }

}

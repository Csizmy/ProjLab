package GUIComponents;

import Materials.Material;
import Miners.Miner;
import Miners.Settler;
import Objects.Asteroid;
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

    private JButton tp, robot, dig, mine, move, zoomin, zoomout, skip, tp1, tp2, tp3;    //gombok
    private JLabel resourceInventory, tpInventory;    //A játékos táskája
    private JLabel a_teli_kozel, a_teli_tavol, a_ures_kozel, a_ures_tavol;    //Aszteroida fajták
    private JLabel water, coal, iron, uranium;    //Aszteroidák anyagai, ha azok ki vannak fúrva
    private Clicklistener click;  // A gombokat kezeli
    private BufferedImage image,robotImage,settlerImage,ufoImage;    //háttér
    private Proto p;            //A játék lépéseit valositja meg
    private ArrayList<JButton> Things = new ArrayList<>();
    private ArrayList<JButton> inventory = new ArrayList<>();
    private OnPlayListener toMapView;

    public void InitButton(JButton btn) {
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.addActionListener(click);
        btn.setFocusable(false);
    }

    public GamePanel(OnPlayListener act,Proto val) throws IOException {
        p=val;
        toMapView=act;

        p.addToBackpack("Water", 51);
        p.addToBackpack("Water", 51);
        p.addToBackpack("Iron", 51);
        p.addToBackpack("Water", 51);
        p.addToBackpack("Water", 51);
        p.addToBackpack("Iron", 51);
        p.addToBackpack("Uranium", 51);
        p.addToBackpack("Coal", 51);

        click = new Clicklistener();
        zoomout = new JButton("");
        skip = new JButton("");
        zoomin = new JButton("");
        tp = new JButton("");
        robot = new JButton("");
        dig = new JButton("");
        mine = new JButton("");
        move = new JButton("");
        tp1 = new JButton("");
        tp2 = new JButton("");
        tp3 = new JButton("");

        resourceInventory = new JLabel(new ImageIcon("pictures\\resourceinventory191x386.png"));
        tpInventory = new JLabel(new ImageIcon("pictures\\tpinventory210x63.png"));

        a_teli_kozel = new JLabel(new ImageIcon("pictures\\a_teli_kozel.png"));
        a_teli_tavol = new JLabel(new ImageIcon("pictures\\a_teli_tavol.png"));
        a_ures_kozel = new JLabel(new ImageIcon("pictures\\a_ures_kozel.png"));
        a_ures_tavol = new JLabel(new ImageIcon("pictures\\a_ures_tavol.png"));

        water = new JLabel(new ImageIcon("pictures\\water70x70.png"));
        coal = new JLabel(new ImageIcon("pictures\\coal70x70.png"));
        iron = new JLabel(new ImageIcon("pictures\\iron70x70.png"));
        uranium = new JLabel(new ImageIcon("pictures\\uranium70x70.png"));

        skip.setIcon(new ImageIcon("pictures\\skip200x53.png"));
        zoomout.setIcon(new ImageIcon("pictures\\zoomout54x54.png"));
        zoomin.setIcon(new ImageIcon("pictures\\zoomin54x54.png"));
        tp.setIcon(new ImageIcon("pictures\\tp200x53.png"));
        robot.setIcon(new ImageIcon("pictures\\robot200x53.png"));
        dig.setIcon(new ImageIcon("pictures\\dig200x53.png"));
        mine.setIcon(new ImageIcon("pictures\\mine200x53.png"));
        move.setIcon(new ImageIcon("pictures\\move200x53.png"));
        tp1.setIcon(new ImageIcon("pictures\\tp.png"));
        tp2.setIcon(new ImageIcon("pictures\\tp.png"));
        tp3.setIcon(new ImageIcon("pictures\\tp.png"));

        zoomout.setBounds(770, 20, 54, 54);
        zoomin.setBounds(700, 20, 54, 54);
        tp.setBounds(50, 570, 200, 53);
        robot.setBounds(300, 570, 200, 53);
        dig.setBounds(50, 500, 200, 53);
        mine.setBounds(300, 500, 200, 53);
        move.setBounds(550, 500, 200, 53);
        resourceInventory.setBounds(50, 20, 191, 386);
        tpInventory.setBounds(40, 420, 210, 63);
        skip.setBounds(550, 570, 200, 53);
        tp1.setBounds(65, 435, 30, 30);
        tp2.setBounds(125, 435, 30, 30);
        tp3.setBounds(195, 435, 30, 30);

        a_teli_kozel.setBounds(350, 180, 300, 300);
        a_teli_tavol.setBounds(350, 180, 300, 300);
        a_ures_kozel.setBounds(350, 180, 300, 300);
        a_ures_tavol.setBounds(350, 180, 300, 300);

        water.setBounds(465, 300, 70, 70);
        coal.setBounds(465, 300, 70, 70);
        iron.setBounds(465, 300, 70, 70);
        uranium.setBounds(465, 300, 70, 70);

        Things.add(zoomout);
        //Things.add(zoomin);
        Things.add(tp);
        Things.add(robot);
        Things.add(dig);
        Things.add(mine);
        Things.add(move);
        Things.add(skip);
        Things.add(tp1);
        Things.add(tp2);
        Things.add(tp3);

        for (JButton jb : Things) {
            InitButton(jb);
            this.add(jb);
        }

        resourceInventory.setOpaque(false);
        tpInventory.setOpaque(false);
        a_teli_kozel.setOpaque(false);
        a_teli_tavol.setOpaque(false);
        a_ures_kozel.setOpaque(false);
        a_ures_tavol.setOpaque(false);
        water.setOpaque(false);
        coal.setOpaque(false);
        iron.setOpaque(false);
        uranium.setOpaque(false);

        this.setLayout(null);

        this.add(resourceInventory);
        this.add(tpInventory);
        this.add(water);
        this.add(coal);
        this.add(iron);
        this.add(uranium);
        this.add(a_teli_kozel);
        this.add(a_teli_tavol);
        this.add(a_ures_kozel);
        this.add(a_ures_tavol);

        try {
            image = ImageIO.read(new File("pictures\\background.png"));
            settlerImage = ImageIO.read(new File("pictures\\settler45x75.png"));
            ufoImage = ImageIO.read(new File("pictures\\ufo139x75.png"));
            robotImage = ImageIO.read(new File("pictures\\robot112x75.png"));
        } catch (IOException ex) {

        }
        refreshBp();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
        g.drawImage(settlerImage, 710, 150, this);
        g.drawImage(ufoImage, 650, 230, this);
        g.drawImage(robotImage, 660, 310, this);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 60));
        g.setColor(Color.BLUE);
        g.drawString(String.valueOf(p.getPlayerCount()) , 790, 210);
        g.drawString(String.valueOf(p.getUfoCount()) , 790, 290);
        g.drawString(String.valueOf(p.getRobotCount()) , 790, 370);
        g.setColor(Color.YELLOW);
        g.drawString(String.valueOf(p.getCurrent().getSpacething().getId()) , 470, 160);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.setColor(Color.RED);
        g.drawString("Current Player is Agent" + String.valueOf(p.getCurrent().getId()) , 270, 40);

        a_teli_kozel.setVisible(false);
        a_teli_tavol.setVisible(false);
        a_ures_kozel.setVisible(false);
        a_ures_tavol.setVisible(false);

        water.setVisible(false);
        coal.setVisible(false);
        iron.setVisible(false);
        uranium.setVisible(false);

        Asteroid curr_a = (Asteroid) p.getCurrent().getSpacething();
        if (curr_a.getDigged() == curr_a.getLayer()) {  // ha ki van ásva az aszteroida
            if (curr_a.getPerihelion()) { // ha napközel
                a_ures_kozel.setVisible(true);
            } else { // ha naptávol
                a_ures_tavol.setVisible(true);
            }

            if (curr_a.getMaterial() != null && curr_a.getMaterial().getName() == "Water") water.setVisible(true);
            if (curr_a.getMaterial() != null && curr_a.getMaterial().getName() == "Iron") iron.setVisible(true);
            if (curr_a.getMaterial() != null && curr_a.getMaterial().getName() == "Coal") coal.setVisible(true);
            if (curr_a.getMaterial() != null && curr_a.getMaterial().getName() == "Uranium") uranium.setVisible(true);
        } else {
            if (curr_a.getPerihelion()) { // ha napközel
                a_teli_kozel.setVisible(true);
            } else { // ha naptávol
                a_teli_tavol.setVisible(true);
            }
        }
        Settler s = (Settler)p.getCurrent();
        tp1.setVisible(false);
        tp2.setVisible(false);
        tp3.setVisible(false);

        if(s.getTeleports().size()>2){
            tp3.setVisible(true);
        }
        if(s.getTeleports().size()>1){
            tp2.setVisible(true);
        }
        if(s.getTeleports().size()>0){
            tp1.setVisible(true);
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

    public void backPackDraw(Graphics g) {

    }

    public void refreshBp() {  //A hátitáskát refresheli a képernyőn, hogy a jelenlegi játékost lássuk mindig :3
        for (JButton b : inventory) {
            this.remove(b);
        }
        int y = 0;
        int x = 0;

        for (Material m : p.getCurrent().getBackpack()) {
            if (y == 5) {
                x = 1;
                y = 0;
            }
            // 51-es idhez adtam sok anyagot  a gamepanel konstruktorban
            try {
                JButton b = m.drawMaterial(x * 90 + 70, y * 75 + 30,  m);
                inventory.add(b);
                this.add(b);
            } catch (IOException e) {
                e.printStackTrace();
            }

            y++;

        }
        repaint();
    }

    public void nextPlayer() {
        if (p.EndGame() == true) {  //ellenőrzi hogy nyertek e a telepesek.
            try { //ha vesztettek akkor a vesztes képernyőre lép
                toMapView.ChangeToGame(4,true);
                return;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if(p.getCurrent()==p.getMap().getSettlers().get(p.getMap().getSettlers().size()-1)){
            if(p.step()==true){ // léptet mindenkit ha az utolso player lelépte a lépését
                try { //ha vesztettek akkor a vesztes képernyőre lép
                    toMapView.ChangeToGame(4,false);

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
            if(p.getMap().getSettlers().isEmpty()==false){
                p.setCurrent(p.getMap().getSettlers().get(0)) ;
            }

        }
        else{
            int kovetkezo=0;
            for (int i = 0; i < p.getMap().getSettlers().size(); i++) {
                if (p.getMap().getSettlers().get(i)==p.getCurrent()){
                    kovetkezo=i+1;
                }
            }
            p.setCurrent(p.getMap().getSettlers().get(kovetkezo)) ;
        }
        refreshBp();


    }

    private class Clicklistener implements ActionListener { //gombok megnyomását kezeli

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == tp) {   //teleportot probál épiteni
                System.out.println("tp");
                if (p.buildTeleport()) {
                    nextPlayer();
                }
                else {
                    new BadMovement();
                }
            } else if (e.getSource() == robot) { //robotot probnál épiteni
                System.out.println("robot");
                if (p.buildRobot()) {
                    nextPlayer();
                } else {
                    new BadMovement();
                }
            } else if (e.getSource() == dig) {  //furni probál
                System.out.println("dig");
                if (p.drillMiner()) {
                    nextPlayer();
                }
                else {
                    new BadMovement();
                }
            } else if (e.getSource() == mine) {  //ásni probál
                System.out.println("mine");
                if (p.mineMiner()) {
                    nextPlayer();
                }
                else {
                    new BadMovement();
                }
            } else if (e.getSource() == move) {  //mozogni probál itt át kéne váltani a map nézetre
                System.out.println("move");
                try {
                    toMapView.ChangeToGame(2,false);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else if (e.getSource() == zoomout) {
                System.out.println("zoomout");
                try {
                    toMapView.ChangeToGame(2,false);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else if (e.getSource() == zoomin) {
                System.out.println("zoomin");
            } else if (e.getSource() == skip) {
                System.out.println("skip");
                nextPlayer();
            }else if (e.getSource() == tp1) {
                Settler s = (Settler)p.getCurrent();
                if (p.placeTeleport(s.getTeleports().get(0).getId())) {
                    nextPlayer();
                }
            }else if (e.getSource() == tp2) {
                Settler s = (Settler)p.getCurrent();
                if (p.placeTeleport(s.getTeleports().get(1).getId())) {
                    nextPlayer();
                }
            }else if (e.getSource() == tp3) {
                Settler s = (Settler)p.getCurrent();
                if (p.placeTeleport(s.getTeleports().get(2).getId())) {
                    nextPlayer();
                }
            }
        }
    }
}

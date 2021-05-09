package Graphics;

import GObjects.GAsteroid;
import Game_parts.Map;
import Materials.Material;
import Miners.Settler;
import Objects.Asteroid;
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
import java.util.concurrent.atomic.AtomicStampedReference;

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
        Graphics g = new Graphics() {
            @Override
            public Graphics create() {
                return null;
            }

            @Override
            public void translate(int x, int y) {

            }

            @Override
            public Color getColor() {
                return null;
            }

            @Override
            public void setColor(Color c) {

            }

            @Override
            public void setPaintMode() {

            }

            @Override
            public void setXORMode(Color c1) {

            }

            @Override
            public Font getFont() {
                return null;
            }

            @Override
            public void setFont(Font font) {

            }

            @Override
            public FontMetrics getFontMetrics(Font f) {
                return null;
            }

            @Override
            public Rectangle getClipBounds() {
                return null;
            }

            @Override
            public void clipRect(int x, int y, int width, int height) {

            }

            @Override
            public void setClip(int x, int y, int width, int height) {

            }

            @Override
            public Shape getClip() {
                return null;
            }

            @Override
            public void setClip(Shape clip) {

            }

            @Override
            public void copyArea(int x, int y, int width, int height, int dx, int dy) {

            }

            @Override
            public void drawLine(int x1, int y1, int x2, int y2) {

            }

            @Override
            public void fillRect(int x, int y, int width, int height) {

            }

            @Override
            public void clearRect(int x, int y, int width, int height) {

            }

            @Override
            public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

            }

            @Override
            public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

            }

            @Override
            public void drawOval(int x, int y, int width, int height) {

            }

            @Override
            public void fillOval(int x, int y, int width, int height) {

            }

            @Override
            public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

            }

            @Override
            public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

            }

            @Override
            public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {

            }

            @Override
            public void drawString(String str, int x, int y) {

            }

            @Override
            public void drawString(AttributedCharacterIterator iterator, int x, int y) {

            }

            @Override
            public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
                return false;
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
                return false;
            }

            @Override
            public void dispose() {

            }
        };

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


            for (int j = 0; j < current.getNeighbours().size(); j++){
                Asteroid neighbor = (Asteroid) current.getNeighbours().get(i);
                super.paint(g);
                Graphics2D g2 = (Graphics2D) g;
                Line2D lin = new Line2D.Float(current.getX(), current.getY(), neighbor.getX(), neighbor.getY());
                g2.draw(lin);
            }

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

        g.drawImage(image , 0, 0, this); // see javadoc for more info on the parameters

        for (int i = 0; i < 50; i++){
            Asteroid current = map.getAsteroids().get(i);

            for (int j = 0; j < current.getNeighbours().size(); j++){
                Asteroid neighbor = (Asteroid) current.getNeighbours().get(i);
                super.paint(g);
                Graphics2D g2 = (Graphics2D) g;
                Line2D lin = new Line2D.Float(current.getX(), current.getY(), neighbor.getX(), neighbor.getY());
                g2.draw(lin);
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


        }
    }

}

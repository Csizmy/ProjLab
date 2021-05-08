package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu extends JPanel {  //Menu osztálya
    private JButton play,help,exit,back;  //gombok
    private Clicklistener click;    //gomb figyelo
    private BufferedImage image;    // háttér
    private OnPlayListener playListener;  // azért kell hogy a mainframeben váltson a gamepanelre

    public Menu(OnPlayListener act){
        playListener=act;
        click= new Clicklistener();
        play= new JButton("");
        help= new JButton("");
        exit= new JButton("");

        play.setIcon(new ImageIcon("pictures\\playcropped.png" ));
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        //play.setBorderPainted(false);

        help.setIcon(new ImageIcon("pictures\\helpcropped.png" ));
        help.setOpaque(false);
        help.setContentAreaFilled(false);

        exit.setIcon(new ImageIcon("pictures\\exitcropped.png" ));
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        this.setLayout(null);
        play.setBounds(28,50,800,123);
        help.setBounds(28,250,800,123);
        exit.setBounds(28,450,800,123);
        play.setFocusable(false);
        help.setFocusable(false);
        exit.setFocusable(false);

        play.addActionListener(click);
        help.addActionListener(click);
        exit.addActionListener(click);

        this.add(play);
        this.add(help);
        this.add(exit);
        try {
            image = ImageIO.read(new File("pictures\\background.png"));
        } catch (IOException ex) {

        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
    }


    private class Clicklistener implements ActionListener { //gombok megnyomását kezeli

        public void actionPerformed(ActionEvent e){
            if (e.getSource() == play){  //ha a playre kattintanak elindul a játék
                try {
                    playListener.ChangeToGame();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            else if (e.getSource() == help){ //ha a helpre kattintanak akkor kiir pár dolgot a játékrol
                System.out.println("help");
            }
            else if (e.getSource() == exit){ //ha az exitre kattintanak akkor bezárul az ablak
                System.out.println("exit");
                //close the window
                System.exit(0);

            }
        }
    }

}

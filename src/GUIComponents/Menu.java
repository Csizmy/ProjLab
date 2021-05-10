package GUIComponents;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu extends JPanel {  //Menu osztálya
    private JButton play,help,exit, back;  //gombok
    private Clicklistener click;    //gomb figyelo
    private BufferedImage image;    // háttér
    private BufferedImage help_img;    // háttér
    private OnPlayListener playListener;  // azért kell hogy a mainframeben váltson a gamepanelre
    private boolean help_bool = false;
    private ImageResizer ir = new ImageResizer();

    public Menu(OnPlayListener act){
        playListener=act;
        click= new Clicklistener();
        play= new JButton("");
        help= new JButton("");
        exit= new JButton("");
        back= new JButton("");

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

        try {
            BufferedImage bi = ImageIO.read(new File("pictures\\back.png"));
            bi = ir.resize(bi, 0.082);
            back.setIcon(new ImageIcon(bi));
            back.setOpaque(false);
            back.setContentAreaFilled(false);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setLayout(null);

        play.setBounds(28,50,800,123);
        help.setBounds(28,250,800,123);
        exit.setBounds(28,450,800,123);
        back.setBounds(300,550,267,41);

        play.setFocusable(false);
        help.setFocusable(false);
        exit.setFocusable(false);
        back.setFocusable(false);

        play.addActionListener(click);
        help.addActionListener(click);
        exit.addActionListener(click);
        back.addActionListener(click);

        play.setBorderPainted(false);
        help.setBorderPainted(false);
        exit.setBorderPainted(false);
        back.setBorderPainted(false);

        back.setVisible(false);

        this.add(play);
        this.add(help);
        this.add(exit);
        this.add(back);
        try {
            image = ImageIO.read(new File("pictures\\background.png"));
        } catch (IOException ex) {}
        try {
            help_img = ImageIO.read(new File("pictures\\help_szoveg.png"));
            help_img = ir.resize(help_img, 0.2);
        } catch (IOException ex) {}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
        if(help_bool) g.drawImage(help_img, 20, 20, this);
    }


    class Clicklistener implements ActionListener { //gombok megnyomását kezeli

        public void actionPerformed(ActionEvent e){
            if (e.getSource() == play){  //ha a playre kattintanak elindul a játék
                try {
                    playListener.ChangeToGame(1,false);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            else if (e.getSource() == help){ //ha a helpre kattintanak akkor kiir pár dolgot a játékrol

                help_bool=true;
                play.setVisible(false);
                help.setVisible(false);
                exit.setVisible(false);
                back.setVisible(true);


                System.out.println("help");
            }
            else if (e.getSource() == exit){ //ha az exitre kattintanak akkor bezárul az ablak
                System.out.println("exit");
                //close the window
                System.exit(0);

            }

            else if (e.getSource() == back){ //ha a backre kattintanak akkor bezárul az ablak
                System.out.println("back");
                help_bool=false;

                play.setVisible(true);
                help.setVisible(true);
                exit.setVisible(true);
                back.setVisible(false);

            }
        }
    }

}

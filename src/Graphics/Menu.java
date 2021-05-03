package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu extends JPanel { //axelfoglaltahihi
    private JButton play,help,exit,back;
    private Clicklistener click;
    private BufferedImage image;

    public Menu(){
        Clicklistener click= new Clicklistener();
        play= new JButton("");
        help= new JButton("");
        exit= new JButton("");

        play.setIcon(new ImageIcon("pictures\\play3.png" ));
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        //play.setBorderPainted(false);

        help.setIcon(new ImageIcon("pictures\\help3.png" ));
        help.setOpaque(false);
        help.setContentAreaFilled(false);

        exit.setIcon(new ImageIcon("pictures\\exit3.png" ));
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        this.setLayout(null);
        play.setBounds(500,100,240,180);
        help.setBounds(500,300,240,180);
        exit.setBounds(500,500,240,180);
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
            if (e.getSource() == play){
                System.out.println("play");
            }
            else if (e.getSource() == help){
                System.out.println("help");
            }
            else if (e.getSource() == exit){
                System.out.println("exit");
            }
        }
    }

}

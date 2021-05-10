package GUIComponents;

import Proto.Proto;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EndScreen extends JPanel {  //A játék végén lévő képernyő ha nyertek/vesztettek a telepesek.
    private OnPlayListener backToMenu;
    private BufferedImage image;                //háttér
    private Clicklistener click;    //gomb figyelo
    private boolean wine;  /// Jelzi, hogy a win vagy a loose képernyőt kell-e megjelenitenie
    private JButton back;
    private ImageResizer ir = new ImageResizer();
    public EndScreen(OnPlayListener act, Proto val,boolean win) throws IOException {
        backToMenu=act;
        wine=win;
        click= new Clicklistener();
        back = new JButton("");
        


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
        back.setBounds(300,550,267,41);
        back.setFocusable(false);
        back.addActionListener(click);
        back.setBorderPainted(false);
        this.add(back);

            try {
                image = ImageIO.read(new File("pictures\\background.png"));
            } catch (IOException ex) { /*mindig jó, nincs error köszi.*/ }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // kirajzolja a képet
        g.setFont(new Font("TimesRoman", Font.PLAIN, 60));
        g.setColor(Color.BLUE);
        if(wine){
            g.drawString("Gratulálunk nyertél." , 300, 300);
        }
        else{
            g.drawString("Vesztettél." , 300, 300);
        }
    }

    private class Clicklistener implements ActionListener { //gombok megnyomását kezeli

        public void actionPerformed(ActionEvent e){
            if (e.getSource() == back){ //ha a backre kattintanak akkor a menü megnyilik
                try {
                    backToMenu.ChangeToGame(3,false);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        }
    }


}

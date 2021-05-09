package GUIComponents;

import javax.swing.*;

//JFrame to alert players if they are not allowed to do the movement
public class BadMovement {
    JFrame f;

    //Function to create the alert
    public BadMovement() {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "You can't do this right now","Wrong Action",JOptionPane.WARNING_MESSAGE);
    }

}

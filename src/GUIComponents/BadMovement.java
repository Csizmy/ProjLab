package GUIComponents;

import javax.swing.*;

public class BadMovement {
    JFrame f;

    BadMovement() {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, "You can't do this right now","Wrong Action",JOptionPane.WARNING_MESSAGE);
    }

}

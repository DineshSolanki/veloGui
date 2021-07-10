package org.pipoware.velogui;


// https://user.velocity.apache.narkive.com
//refactored : Dinesh

import javax.swing.UIManager;
import java.awt.*;

public class Application {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[3].getClassName());
            Core core = new Core();
            Frame frame = new Frame(core);
            //Validate frames that have preset sizes
            //Pack frames that have useful preferred size info, e.g. from their layout
            frame.validate();
            //Center the window
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension frameSize = frame.getSize();
            if (frameSize.height > screenSize.height) {
                frameSize.height = screenSize.height;
            }
            if (frameSize.width > screenSize.width) {
                frameSize.width = screenSize.width;
            }
            frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
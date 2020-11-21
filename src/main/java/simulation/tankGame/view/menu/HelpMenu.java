package simulation.tankGame.view.menu;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * HelpMenu...
 *
 * @author fengluo
 * @since 2020/10/19 19:36
 */
public class HelpMenu extends JMenu {
    public HelpMenu(ActionListener listener) {
        super("Game Help");
        JMenuItem help = new JMenuItem("Game Help");
        JMenuItem about = new JMenuItem("About the game");

        help.setActionCommand("help");
        about.setActionCommand("about");

        help.addActionListener(listener);
        about.addActionListener(listener);

        this.add(help);
        this.add(about);
    }
}

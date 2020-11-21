package simulation.tankGame.view.menu;

import simulation.tankGame.util.MapUtils;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/11/2 21:26
 */
public class CustomMapMenu extends JMenu {
    public CustomMapMenu(ActionListener listener) {
        super("Custom Map");
        MapUtils.getCustomFileList().forEach(s->{
            JMenuItem test = new JMenuItem(s);
            test.setActionCommand("customMap");
            test.addActionListener(listener);
            this.add(test);
        });

    }
}

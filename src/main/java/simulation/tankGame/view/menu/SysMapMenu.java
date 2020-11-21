package simulation.tankGame.view.menu;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * LevelMenu...
 *
 * @author fengluo
 * @since 2020/10/19 19:36
 */
public class SysMapMenu extends JMenu {

    public SysMapMenu(ActionListener listener) {
        super("Maps");
        JMenuItem firstLevel = new JMenuItem("Map 1");
        JMenuItem secondLevel = new JMenuItem("Map 2");
        JMenuItem thirdLevel = new JMenuItem("Map 3");
        JMenuItem fourthLevel = new JMenuItem("Map 4");
        JMenuItem fifthLevel = new JMenuItem("Map 5");

        firstLevel.setActionCommand("first");
        secondLevel.setActionCommand("second");
        thirdLevel.setActionCommand("third");
        fourthLevel.setActionCommand("fourth");
        fifthLevel.setActionCommand("fifth");

        firstLevel.addActionListener(listener);
        secondLevel.addActionListener(listener);
        thirdLevel.addActionListener(listener);
        fourthLevel.addActionListener(listener);
        fifthLevel.addActionListener(listener);

        this.add(firstLevel);
        this.add(secondLevel);
        this.add(thirdLevel);
        this.add(fourthLevel);
        this.add(fifthLevel);
    }
}

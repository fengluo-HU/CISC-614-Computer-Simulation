package simulation.tankGame.view.menu;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/11/1 9:57
 */
public class MapEditMenu extends JMenu {
    public MapEditMenu(ActionListener listener) {
        super("Map Editor");
        JMenuItem createMap = new JMenuItem("Map Editor");
        JMenuItem saveMap = new JMenuItem("Save Map");

        createMap.setActionCommand("createMap");
        saveMap.setActionCommand("saveMap");

        createMap.addActionListener(listener);
        saveMap.addActionListener(listener);

        this.add(createMap);
        this.add(saveMap);
    }
}

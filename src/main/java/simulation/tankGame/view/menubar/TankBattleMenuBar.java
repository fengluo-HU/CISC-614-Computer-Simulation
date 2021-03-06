package simulation.tankGame.view.menubar;

import simulation.tankGame.view.menu.*;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * TankBattleMenuBar...
 *
 * @author fengluo
 * @since 2020/10/19 19:36
 */
public class TankBattleMenuBar extends JMenuBar {

    private static final long serialVersionUID = -4010376438320829163L;
    private GameMenu gameMenu;
    private SysMapMenu sysMapMenu;
    private HelpMenu helpMenu;
    private MapEditMenu mapEditMenu;
    private CustomMapMenu customMapMenu;

    public TankBattleMenuBar(ActionListener listener) {
        super();

        gameMenu = new GameMenu(listener);
        sysMapMenu = new SysMapMenu(listener);
        helpMenu = new HelpMenu(listener);
        mapEditMenu = new MapEditMenu(listener);
        customMapMenu=new CustomMapMenu(listener);

        this.add(gameMenu);
        this.add(sysMapMenu);
        this.add(mapEditMenu);
        this.add(customMapMenu);
        this.add(helpMenu);
    }

    public GameMenu getGameMenu() {
        return gameMenu;
    }

    public SysMapMenu getSysMapMenu() {
        return sysMapMenu;
    }

    public MapEditMenu getMapEditMenu() {
        return mapEditMenu;
    }

    public CustomMapMenu getCustomMapMenu() {
        return customMapMenu;
    }

    @Override
    public HelpMenu getHelpMenu() {
        return helpMenu;
    }
}

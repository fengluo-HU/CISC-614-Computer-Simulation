package simulation.tankGame.view.menu;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * GameMenu...
 *
 * @author fengluo
 * @since 2020/10/19 19:36
 */
public class GameMenu extends JMenu {
    private static final long serialVersionUID = -3078540026626514620L;

    public GameMenu(ActionListener listener) {
        super("Game");
        JMenuItem gameStart = new JMenuItem("Start the game");
        JMenuItem startAgain = new JMenuItem("Restart");
        JMenuItem gameStop = new JMenuItem("Pause/Resume");
        JMenuItem gameExit = new JMenuItem("Exit the game");

        gameStart.setActionCommand("start");
        startAgain.setActionCommand("again");
        gameStop.setActionCommand("stop");
        gameExit.setActionCommand("exit");

        gameStart.addActionListener(listener);
        startAgain.addActionListener(listener);
        gameExit.addActionListener(listener);
        gameStop.addActionListener(listener);

        this.add(gameStart);
        this.add(startAgain);
        this.add(gameStop);
        this.add(gameExit);
    }
}

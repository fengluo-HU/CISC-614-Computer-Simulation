package simulation.tankGame.view.frame;

import simulation.tankGame.resource.TankGameImages;

import javax.swing.*;
import java.awt.*;

/**
 * GameFrame...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class GameFrame extends JFrame {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1176914786963603304L;


    public GameFrame() {
        super();


        this.setSize(810, 700);
        this.setTitle("Tank Game");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(TankGameImages.myTankImg[0]);

        // Display size
        Dimension screenSizeInfo = Toolkit.getDefaultToolkit().getScreenSize();
        int leftTopX = ((int) screenSizeInfo.getWidth() - this.getWidth()) / 2;
        int leftTopY = ((int) screenSizeInfo.getHeight() - this.getHeight()) / 2;

        // Set to center of screen
        this.setLocation(leftTopX, leftTopY);
    }

}
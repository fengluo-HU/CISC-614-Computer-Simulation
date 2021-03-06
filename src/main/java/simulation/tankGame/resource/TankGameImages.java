package simulation.tankGame.resource;

import java.awt.Image;
import java.awt.Toolkit;

/**
 * TankGameImages...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class TankGameImages {

    public static Image myTankImg[] = {
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/UTank_.gif")),
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/DTank_.gif")),
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/LTank_.gif")),
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/RTank_.gif"))
    };

    public static Image enemyTankImg[] = {
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/UTank.gif")),
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/DTank.gif")),
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/LTank.gif")),
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/RTank.gif"))};

    public static Image stuffImg[] = {
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/brick.gif")),
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/iron.gif")),
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/water.gif"))};

    public static Image startImage = Toolkit.getDefaultToolkit()
            .getImage(TankGameImages.class.getResource("/static/img/gameStart.png"));

    public static Image bullet = Toolkit.getDefaultToolkit()
            .getImage(TankGameImages.class.getResource("/static/img/bullet.gif"));

    public static Image bomb[] = {
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/bomb_1.png")),
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/bomb_2.png")),
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/bomb_3.png")),
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/bomb_4.png")),
            Toolkit.getDefaultToolkit().getImage(TankGameImages.class.getResource("/static/img/bomb_5.png")),};

    public static Image gameOver = Toolkit.getDefaultToolkit()
            .getImage(TankGameImages.class.getResource("/static/img/gameOver.gif"));

    public static Image gameWin = Toolkit.getDefaultToolkit()
            .getImage(TankGameImages.class.getResource("/static/img/gameWin.jpg"));
}

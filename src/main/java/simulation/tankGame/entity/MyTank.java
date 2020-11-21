package simulation.tankGame.entity;

import simulation.tankGame.enums.DirectionEnum;
import simulation.tankGame.enums.TankTypeEnum;

import java.awt.Color;

/**
 * MyTank...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class MyTank extends Tank {
    /**
     * Constructor
     *
     * @param x      X-coordinate
     * @param y      Y-coordinate
     * @param direct Direction
     */
    public MyTank(int x, int y, DirectionEnum direct) {
        super(x, y, direct);
        this.setColor(Color.yellow);
        this.setTankType(TankTypeEnum.MY);
        this.setBlood(10);
    }


}
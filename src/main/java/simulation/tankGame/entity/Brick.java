package simulation.tankGame.entity;

import simulation.tankGame.enums.StuffTypeEnum;

/**
 * Brick...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class Brick extends Stuff {
    /**
     * Constructor
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     */
    public Brick(int x, int y) {
        super(x, y);
        this.setType(StuffTypeEnum.BRICK);
        this.setWidth(20);
        this.setHeight(20);
    }

}

package simulation.tankGame.entity;

import simulation.tankGame.enums.StuffTypeEnum;

/**
 * Water...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class Water extends Stuff {
    /**
     * 构造方法
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     */

    public Water(int x, int y) {
        super(x, y);
        this.setType(StuffTypeEnum.WATER);
        this.setWidth(20);
        this.setHeight(20);
    }

}

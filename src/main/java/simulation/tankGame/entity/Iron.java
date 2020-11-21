package simulation.tankGame.entity;

import simulation.tankGame.enums.StuffTypeEnum;

/**
 * Iron...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class Iron extends Stuff {
    /**
     * Constructor
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     */
    public Iron(int x, int y) {
        super(x, y);
        this.setType(StuffTypeEnum.IRON);
        this.setWidth(20);
        this.setHeight(20);
    }

}

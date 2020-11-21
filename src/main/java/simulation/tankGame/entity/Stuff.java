package simulation.tankGame.entity;

import simulation.tankGame.enums.DirectionEnum;
import simulation.tankGame.enums.StuffTypeEnum;


/**
 * Stuff...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class Stuff {
    /**
     * X-coordinate
     */
    private Integer x;
    /**
     * Y-coordinate
     */
    private Integer y;
    /**
     * Width
     */
    private Integer width;
    /**
     * Length
     */
    private Integer height;
    /**
     * Type
     */
    private StuffTypeEnum type;

    /**
     * Is Alive
     */
    private Boolean isAlive;
    /**
     * Direction
     */
    private DirectionEnum direct;
    /**
     * HP
     */
    private Integer healthPoints;

    /**
     * Stuff
     *
     * @param x x
     * @param y y
     */
    public Stuff(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        this.isAlive = Boolean.TRUE;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public StuffTypeEnum getType() {
        return type;
    }

    public void setType(StuffTypeEnum type) {
        this.type = type;
    }

    public Boolean getLive() {
        return isAlive;
    }

    public void setLive(Boolean live) {
        isAlive = live;
    }

    public DirectionEnum getDirect() {
        return direct;
    }

    public void setDirect(DirectionEnum direct) {
        this.direct = direct;
    }

    public Integer getBlood() {
        return healthPoints;
    }

    public void setBlood(Integer hp) {
        this.healthPoints = hp;
    }
}

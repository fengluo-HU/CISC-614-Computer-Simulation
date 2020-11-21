package simulation.tankGame.entity;


import simulation.tankGame.enums.DirectionEnum;

/**
 * Bullet...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class Bullet {
    /**
     * Speed
     */
    private int speed = 6;
    /**
     * X-coordinate
     */
    private int x;
    /**
     * Y-coordinate
     */
    private int y;
    /**
     * Direction
     */
    private DirectionEnum direct;
    /**
     * IsAlive
     */
    private boolean isAlive = true;
    /**
     * Store list of speeds when pausing game
     */
    private int speedVector;

    private int width;
    private int height;

    /**
     * Constructor
     *
     * @param x      X-coordinate
     * @param y      Y-coordinate
     * @param direct Direction
     */
    public Bullet(int x, int y, DirectionEnum direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.width = 4;
        this.height = 4;

    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public DirectionEnum getDirect() {
        return direct;
    }

    public void setDirect(DirectionEnum direct) {
        this.direct = direct;
    }

    public boolean isLive() {
        return isAlive;
    }

    public void setLive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setSpeedVector(int speedVector) {
        this.speedVector = speedVector;
    }

    public int getSpeedVector() {
        return speedVector;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
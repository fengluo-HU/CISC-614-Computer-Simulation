package simulation.tankGame.entity;

/**
 * Bomb Class
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class Bomb {
    /**
     * Width
     */
    private int l;
    /**
     * X-coordinate
     */
    private int x;
    /**
     * Y-coordinate
     */
    private int y;
    /**
     * HP
     */
    private int healthPoints = 30;
    /**
     * Is Alive
     */
    private boolean isAlive = true;

    /**
     * Constructor
     *
     * @param x X-coordinate
     * @param y Y-coordinate
     */
    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     */
    public void lifeDown() {
        if (healthPoints > 0) {
            healthPoints--;
        }
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

    public int getLifeTime() {
        return healthPoints;
    }

    public void setLifeTime(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public boolean isLive() {
        return isAlive;
    }

    public void setLive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }
}

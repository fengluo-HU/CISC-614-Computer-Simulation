package simulation.tankGame.entity;

import java.awt.Color;
import java.util.Vector;

import simulation.tankGame.constant.GameConstants;
import simulation.tankGame.enums.DirectionEnum;
import simulation.tankGame.enums.StuffTypeEnum;
import simulation.tankGame.enums.TankTypeEnum;

/**
 * Tank...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class Tank extends Stuff {
    /**
     * Color
     */
    private Color color = Color.green;
    /**
     * Move speed
     */
    private int speed = 4; // 坦克移动速度
    /**
     * Blocker in front of tank
     */
    private StuffTypeEnum frontStuff = StuffTypeEnum.INVALID;
    /**
     * Bullets
     */
    private Vector<Bullet> bullets;
    /**
     * Overlap No
     */
    private boolean isOverlapNo = false;
    /**
     * Overlap Yes
     */
    private boolean isOverlapYes = false;
    /**
     * Store the speed when pausing the game
     */
    private int speedVector;

    private Boolean isActivate = Boolean.FALSE;
    /**
     * type of tank
     */
    private TankTypeEnum tankType;

    /**
     * Constructor
     *
     * @param x      X-coordinate
     * @param y      Y-coordinate
     * @param direct Direction
     */
    public Tank(int x, int y, DirectionEnum direct) {
        super(x, y);
        this.setDirect(direct);
        this.bullets = new Vector<>();
        this.setType(StuffTypeEnum.TANK);
        this.setWidth(40);
        this.setHeight(40);
    }


    /**
     * Move Up(North)
     */
    public void goNorth() {
        this.setDirect(DirectionEnum.NORTH);
        if (this.getY() > 20) {
            this.setY(this.getY() - this.speed);
        } else {
            this.setFrontStuff(StuffTypeEnum.IRON);
        }
    }

    /**
     * Move Down(South)
     */
    public void goSouth() {
        this.setDirect(DirectionEnum.SOUTH);
        if (this.getY() < GameConstants.GAME_PANEL_HEIGHT - 20) {
            this.setY(this.getY() + this.speed);
        } else {
            this.setFrontStuff(StuffTypeEnum.IRON);
        }
    }

    /**
     * Move Left(West)
     */
    public void goWest() {
        this.setDirect(DirectionEnum.WEST);
        if (this.getX() > 20 && this.getY() <= GameConstants.GAME_PANEL_HEIGHT - 20) {
            this.setX(this.getX() - this.speed);
        } else {
            this.setFrontStuff(StuffTypeEnum.IRON);
        }
    }

    /**
     * Move Right(East)
     */
    public void goEast() {
        this.setDirect(DirectionEnum.EAST);
        if (this.getX() < GameConstants.GAME_PANEL_WIDTH - 20
                && this.getY() <= GameConstants.GAME_PANEL_HEIGHT - 20) {
            this.setX(this.getX() + this.speed);
        } else {
            this.setFrontStuff(StuffTypeEnum.IRON);
        }
    }

    /**
     * Move tank as given direction
     *
     * @param direction 方向
     */

    public void move(DirectionEnum direction) {
        switch (direction) {
            case NORTH:
                this.goNorth();
            case SOUTH:
                this.goSouth();
            case WEST:
                this.goWest();
            case EAST:
                this.goEast();
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }

    public void setSpeedVector(int speedVector) {
        this.speedVector = speedVector;
    }

    public int getSpeedVector() {
        return speedVector;
    }

    public boolean isOverlapNo() {
        return isOverlapNo;
    }

    public void setOverlapNo(boolean isOverlapNo) {
        this.isOverlapNo = isOverlapNo;
    }

    public boolean isOverlapYes() {
        return isOverlapYes;
    }

    public void setOverlapYes(boolean isOverlapYes) {
        this.isOverlapYes = isOverlapYes;
    }

    public void setFrontStuff(StuffTypeEnum frontStuff) {
        this.frontStuff = frontStuff;
    }

    public Boolean activate() {
        return isActivate;
    }

    public void setActivate(Boolean activate) {
        isActivate = activate;
    }

    public TankTypeEnum getTankType() {
        return tankType;
    }

    public void setTankType(TankTypeEnum tankType) {
        this.tankType = tankType;
    }
}

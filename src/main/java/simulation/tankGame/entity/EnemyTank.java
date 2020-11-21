package simulation.tankGame.entity;

import java.awt.Color;
import java.util.Timer;

import simulation.tankGame.enums.DirectionEnum;
import simulation.tankGame.enums.TankTypeEnum;

/**
 * EnemyTank...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class EnemyTank extends Tank {
    /**
     * Five locations for enemy tank
     */
    private int location;
    /**
     * Location for my tank
     */
    private DirectionEnum myTankLocation = DirectionEnum.INVALID;
    /**
     * Direction for my tank
     */
    private DirectionEnum myTankDirect = DirectionEnum.NORTH;
    /**
     * Timer
     */
    private Timer timer;
    /**
     * Shall we shoot
     */
    private boolean isShoot = false;

    /**
     * Constructor
     *
     * @param x
     * @param y
     * @param direct
     */
    public EnemyTank(int x, int y, DirectionEnum direct) {
        super(x, y, direct);
        this.setSpeed(4);
        this.setTankType(TankTypeEnum.ENEMY);
        this.setDirect(DirectionEnum.NORTH);
        this.setColor(Color.red);
        this.setBlood(10);
        this.setSpeedVector(0);
        timer = new Timer();

    }


    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }


    public boolean isShot() {
        return isShoot;
    }

    public void setShot(boolean isShoot) {
        this.isShoot = isShoot;
    }

    public DirectionEnum getMyTankLocation() {
        return myTankLocation;
    }

    public void setMyTankLocation(DirectionEnum myTankLocation) {
        this.myTankLocation = myTankLocation;
    }

    public DirectionEnum getMyTankDirect() {
        return myTankDirect;
    }

    public void setMyTankDirect(DirectionEnum myTankDirect) {
        this.myTankDirect = myTankDirect;
    }
}


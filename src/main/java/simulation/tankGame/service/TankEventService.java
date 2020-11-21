package simulation.tankGame.service;

import simulation.tankGame.entity.*;
import simulation.tankGame.enums.DirectionEnum;
import simulation.tankGame.resource.map.Map;
import simulation.tankGame.thread.GameTimeUnit;
import org.springframework.stereotype.Service;

import java.util.Vector;

/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/10/24 19:52
 */
@Service
public class TankEventService {

    /**
     * Check if the tank is overlapped with another
     *
     * @param stuff  Objectives
     * @param distance Distance between two tanks
     * @return Is overlapped
     */
    public boolean isTankOverlap(Tank tank, Stuff stuff, int distance) {
        boolean b = false;
        int x = stuff.getX();
        int y = stuff.getY();
        if (tank.getDirect() == DirectionEnum.NORTH) {
            tank.setY(tank.getY() - tank.getSpeed());
            if (Math.abs(tank.getY() - y) < distance
                    && Math.abs(tank.getX() - x) < distance) {
                b = true;
                tank.setY(tank.getY() + tank.getSpeed());
            } else {
                tank.setY(tank.getY() + tank.getSpeed());
            }
        }
        if (tank.getDirect() == DirectionEnum.SOUTH) {
            tank.setY(tank.getY() + tank.getSpeed());
            if (Math.abs(tank.getY() - y) < distance
                    && Math.abs(tank.getX() - x) < distance) {
                b = true;
            }
            tank.setY(tank.getY() - tank.getSpeed());
        }
        if (tank.getDirect() == DirectionEnum.EAST) {
            tank.setX(tank.getX() + tank.getSpeed());
            if (Math.abs(tank.getY() - y) < distance
                    && Math.abs(tank.getX() - x) < distance) {
                b = true;
            }
            tank.setX(tank.getX() - tank.getSpeed());
        }
        if (tank.getDirect() == DirectionEnum.WEST) {
            tank.setX(tank.getX() - tank.getSpeed());
            if (Math.abs(tank.getY() - y) < distance
                    && Math.abs(tank.getX() - x) < distance) {
                b = true;
            }
            tank.setX(tank.getX() + tank.getSpeed());
        }
        return b;
    }

    /**
     * Check if my tank is overlapped with another
     *
     * @param enemies Enemy tanks
     * @return Is overlapped
     */
    public boolean isMyTankOverlap(MyTank tank, Vector<EnemyTank> enemies) {
        for (int i = 0; i < enemies.size(); i++) {
            if (isTankOverlap(tank, enemies.get(i), 40))
                return true;
        }
        return false;
    }

    /**
     * Check if enemy tank is overlapped with another
     *
     * @param enemies Enemy tanks
     * @param myTanks Hero(my) tanks
     * @return Is overlapped
     */
    public boolean isEnemyTankOverlap(EnemyTank enemy, Vector<EnemyTank> enemies, Vector<MyTank> myTanks) {
        for (int i = 0; i < enemies.size(); i++) {
            if (enemy != enemies.get(i)) {
                if (isTankOverlap(enemy, enemies.get(i), 40)) {
                    enemy.setOverlapNo(true);
                    return true;
                }
            }
        }
        for (int j = 0; j < myTanks.size(); j++) {
            if (isTankOverlap(enemy, myTanks.get(j), 40)) {
                enemy.setOverlapYes(true);
                return true;
            }
        }

        enemy.setOverlapNo(false);
        enemy.setOverlapYes(false);
        return false;
    }

    /**
     * Left move every 36 millis
     */
    public void enemyGoWest(EnemyTank enemy) {
        for (; ; ) {
            GameTimeUnit.sleepMillis(36);
            if (!enemy.isOverlapNo()&& !enemy.isOverlapYes()) {
                enemy.goWest();
            }
            if (enemy.getMyTankLocation() != DirectionEnum.WEST) {
                enemy.setDirect(enemy.getMyTankDirect());
                break;
            }
        }
    }

    /**
     * Right move every 36 millis
     */
    public void enemyGoEast(EnemyTank enemy) {
        for (; ; ) {
            GameTimeUnit.sleepMillis(36);
            if (!enemy.isOverlapNo() && !enemy.isOverlapYes()) {
                enemy.goEast();
            }
            if (enemy.getMyTankLocation() != DirectionEnum.EAST) {
                enemy.setDirect(enemy.getMyTankDirect());
                break;
            }
        }
    }

    /**
     * Move up every 36 millis
     */
    public void enemyGoNorth(EnemyTank enemy) {
        for (; ; ) {
            GameTimeUnit.sleepMillis(36);
            if (!enemy.isOverlapNo() && !enemy.isOverlapYes()) {
                enemy.goNorth();
            }
            if (enemy.getMyTankLocation() != DirectionEnum.NORTH) {
                enemy.setDirect(enemy.getMyTankDirect());
                break;
            }
        }
    }

    /**
     * Move down every 36 millis
     */
    public void enemyGoSouth(EnemyTank enemy) {
        for (; ; ) {
            GameTimeUnit.sleepMillis(36);
            if (!enemy.isOverlapNo() && !enemy.isOverlapYes()) {
                enemy.goSouth();
            }
            if (enemy.getMyTankLocation() != DirectionEnum.SOUTH) {
                enemy.setDirect(enemy.getMyTankDirect());
                break;
            }
        }
    }

    /**
     * Select any direction from three options
     *
     * @param direct1 Direction 1
     * @param direct2 Direction 2
     * @param direct3 Direction 3
     */
    public DirectionEnum enemyGetRandomDirect(DirectionEnum direct1, DirectionEnum direct2, DirectionEnum direct3) {
        int random = (int) (Math.random() * 3);

        DirectionEnum returnDirect = DirectionEnum.INVALID;
        switch (random) {
            case 0:
                returnDirect = direct1;
                break;
            case 1:
                returnDirect = direct2;
                break;
            case 2:
                returnDirect = direct3;
                break;
        }
        return returnDirect;
    }

    /**
     * Acknowledged by enemy tank when my tank is shooting and moving
     *
     * @param myTank My Tank
     * @param map    Map
     */
    public void enemyFindAndKill(EnemyTank enemy, MyTank myTank, Map map) {
        int myX = myTank.getX();
        int myY = myTank.getY();
        int enX = enemy.getX();
        int enY = enemy.getY();
        if (Math.abs(myX - enX) < 20 && myY <= 580) {
            if (enY < myY) {
                int s = 0;
                for (int t = 0; t < map.getIrons().size(); t++) {
                    Iron iron = map.getIrons().get(t);
                    if (Math.abs(enX - iron.getX()) <= 10 && iron.getY() > enY
                            && iron.getY() < myY) {
                        s = 1;
                        break;
                    }
                }
                if (s == 0) {
                    enemy.setShot(true);
                    enemy.setMyTankLocation(DirectionEnum.SOUTH);
                }
            } else {
                int s = 0;
                for (int t = 0; t < map.getIrons().size(); t++) {
                    Iron iron = map.getIrons().get(t);
                    if (Math.abs(enX - iron.getX()) <= 10 && iron.getY() < enY
                            && iron.getY() > myY) {
                        s = 1;
                        break;
                    }
                }
                if (s == 0) {
                    enemy.setShot(true);
                    enemy.setMyTankLocation(DirectionEnum.NORTH);
                }
            }
        } else if (Math.abs(myY - enY) < 20 && myY <= 580) {
            if (enX > myX) {
                int s = 0;
                for (int t = 0; t < map.getIrons().size(); t++) {
                    Iron iron = map.getIrons().get(t);
                    if (Math.abs(enY - iron.getY()) <= 10 && iron.getX() < enX
                            && iron.getX() > myX) {
                        s = 1;
                        break;
                    }
                }
                if (s == 0) {
                    enemy.setShot(true);
                    enemy.setMyTankLocation(DirectionEnum.WEST);
                }
            } else {
                int s = 0;
                for (int t = 0; t < map.getIrons().size(); t++) {
                    Iron iron = map.getIrons().get(t);
                    if (Math.abs(enY - iron.getY()) <= 10 && iron.getX() > enX
                            && iron.getX() < myX) {
                        s = 1;
                        break;
                    }
                }
                if (s == 0) {
                    enemy.setShot(true);
                    enemy.setMyTankLocation(DirectionEnum.EAST);
                }
            }
        } else {
            enemy.setShot(false);
            enemy.setMyTankLocation(DirectionEnum.INVALID);
        }
    }
}

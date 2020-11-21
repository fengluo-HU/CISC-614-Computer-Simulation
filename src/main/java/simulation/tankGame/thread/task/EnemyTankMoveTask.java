package simulation.tankGame.thread.task;

import simulation.tankGame.constant.GameConstants;
import simulation.tankGame.enums.DirectionEnum;
import simulation.tankGame.entity.EnemyTank;
import simulation.tankGame.service.TankEventService;
import simulation.tankGame.thread.GameTimeUnit;

/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/10/24 19:29
 */
public class EnemyTankMoveTask implements Runnable {
    EnemyTank tank;
    TankEventService enemyTankEventService;

    public EnemyTankMoveTask(EnemyTank tank, TankEventService enemyTankEventService) {
        this.tank = tank;
        this.enemyTankEventService = enemyTankEventService;
    }

    @Override
    public void run() {
        while (true) {
            switch (tank.getDirect()) { // Select direction for tank
                case NORTH:
                    while (tank.activate()) {
                        // Set to sleep for 36 millis，which is used to make sure the tank is checked
                        GameTimeUnit.sleepMillis(36);
                        // If my tank is on the WEST of enemy tank
                        if (DirectionEnum.WEST.equals(tank.getMyTankLocation())) {
                            tank.setDirect(DirectionEnum.WEST);
                            enemyTankEventService.enemyGoWest(tank);
                        }
                        // If my tank is on the EAST of enemy tank
                        if (DirectionEnum.EAST.equals(tank.getMyTankLocation())) {
                            tank.setDirect(DirectionEnum.EAST);
                            enemyTankEventService.enemyGoEast(tank);
                        }
                        // If my tank is on the SOUTH of enemy tank
                        if (tank.getMyTankLocation() == DirectionEnum.SOUTH) {
                            tank.setDirect(DirectionEnum.SOUTH);
                            enemyTankEventService.enemyGoSouth(tank);
                        }
                        // If my tank is on the NORTH of enemy tank
                        if (tank.getMyTankLocation() == DirectionEnum.NORTH) {
                            enemyTankEventService.enemyGoNorth(tank);
                        }
                        // If out of bounds and overlapped, changing the direction
                        if (tank.getY() <= 20 || tank.isOverlapNo() == true) {
                            tank.setDirect(enemyTankEventService.enemyGetRandomDirect(DirectionEnum.SOUTH,
                                    DirectionEnum.WEST, DirectionEnum.EAST));
                            break;
                        }
                        // If current direction of tank is not NORTH, break
                        if (tank.getDirect() != DirectionEnum.NORTH)
                            break;
                        // If not overlapped, continue
                        if (!tank.isOverlapYes())
                            tank.goNorth();
                    }
                    break;
                case SOUTH:
                    for (; ; ) {
                        GameTimeUnit.sleepMillis(36);
                        if (tank.getMyTankLocation() == DirectionEnum.WEST) {
                            tank.setDirect(DirectionEnum.WEST);
                            enemyTankEventService.enemyGoWest(tank);
                        }
                        if (tank.getMyTankLocation() == DirectionEnum.EAST) {
                            tank.setDirect(DirectionEnum.EAST);
                            enemyTankEventService.enemyGoEast(tank);
                        }
                        if (tank.getMyTankLocation() == DirectionEnum.NORTH) {
                            tank.setDirect(DirectionEnum.NORTH);
                            enemyTankEventService.enemyGoNorth(tank);
                        }
                        if (tank.getMyTankLocation() == DirectionEnum.SOUTH) {
                            enemyTankEventService.enemyGoSouth(tank);
                        }
                        if (tank.getY() >= GameConstants.GAME_PANEL_HEIGHT - 20
                                || tank.isOverlapNo()) {
                            tank.setDirect(enemyTankEventService.enemyGetRandomDirect(DirectionEnum.NORTH,
                                    DirectionEnum.WEST, DirectionEnum.EAST));
                            break;
                        }
                        if (tank.getDirect() != DirectionEnum.SOUTH)
                            break;
                        if (!tank.isOverlapYes())
                            tank.goSouth();
                    }
                    break;
                case WEST:
                    for (; ; ) {
                        GameTimeUnit.sleepMillis(36);
                        if (tank.getMyTankLocation() == DirectionEnum.NORTH) {
                            tank.setDirect(DirectionEnum.NORTH);
                            enemyTankEventService.enemyGoNorth(tank);
                        }
                        if (tank.getMyTankLocation() == DirectionEnum.EAST) {
                            tank.setDirect(DirectionEnum.EAST);
                            enemyTankEventService.enemyGoEast(tank);
                        }
                        if (tank.getMyTankLocation() == DirectionEnum.SOUTH) {
                            tank.setDirect(DirectionEnum.SOUTH);
                            enemyTankEventService.enemyGoSouth(tank);
                        }
                        if (tank.getMyTankLocation() == DirectionEnum.WEST) {
                            enemyTankEventService.enemyGoWest(tank);
                        }
                        if (tank.getX() <= 20 || tank.getY() <= 20
                                || tank.isOverlapNo()) {
                            tank.setDirect(enemyTankEventService.enemyGetRandomDirect(DirectionEnum.NORTH,
                                    DirectionEnum.SOUTH, DirectionEnum.EAST));
                            break;
                        }
                        if (tank.getDirect() != DirectionEnum.WEST)
                            break;
                        if (!tank.isOverlapYes())
                            tank.goWest();
                    }
                    break;
                case EAST:
                    for (; ; ) {
                        GameTimeUnit.sleepMillis(36);
                        if (tank.getMyTankLocation() == DirectionEnum.WEST) {
                            tank.setDirect(DirectionEnum.WEST);
                            enemyTankEventService.enemyGoWest(tank);
                        }
                        if (tank.getMyTankLocation() == DirectionEnum.NORTH) {
                            tank.setDirect(DirectionEnum.NORTH);
                            enemyTankEventService.enemyGoNorth(tank);
                        }
                        if (tank.getMyTankLocation() == DirectionEnum.SOUTH) {
                            tank.setDirect(DirectionEnum.SOUTH);
                            enemyTankEventService.enemyGoSouth(tank);
                        }
                        if (tank.getMyTankLocation() == DirectionEnum.EAST) {
                            enemyTankEventService.enemyGoEast(tank);
                        }
                        if (tank.getX() >= GameConstants.GAME_PANEL_WIDTH - 20
                                || tank.getY() <= 20 || tank.isOverlapNo()) {
                            tank.setDirect(enemyTankEventService.enemyGetRandomDirect(DirectionEnum.NORTH,
                                    DirectionEnum.SOUTH, DirectionEnum.WEST));
                            break;
                        }
                        if (tank.getDirect() != DirectionEnum.EAST)
                            break;
                        if (!tank.isOverlapYes())
                            tank.goEast();
                    }
                    break;
            }
            GameTimeUnit.sleepMillis(216); // Make the tank changing direction not too fast
            if (!tank.getLive()) { // If the tank is killed, kill the thread
                break;
            }
        }
    }
}

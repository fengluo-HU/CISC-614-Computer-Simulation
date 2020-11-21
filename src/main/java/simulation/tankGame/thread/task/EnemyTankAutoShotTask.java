package simulation.tankGame.thread.task;

import simulation.tankGame.entity.EnemyTank;
import simulation.tankGame.service.GameEventService;

import java.util.TimerTask;

/**
 * MyTimerTask...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class EnemyTankAutoShotTask extends TimerTask {
    EnemyTank tank;
    GameEventService gameEventService;

    public EnemyTankAutoShotTask(EnemyTank tank, GameEventService gameEventService) {
        this.tank = tank;
        this.gameEventService = gameEventService;
    }

    @Override
    public void run() {
        if (tank.getSpeedVector() == 0 && tank.isShot() && tank.activate()) {
            gameEventService.shot(tank);
        }

    }

}
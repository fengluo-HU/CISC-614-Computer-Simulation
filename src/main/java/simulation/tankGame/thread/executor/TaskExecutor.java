package simulation.tankGame.thread.executor;

import simulation.tankGame.context.GameContext;
import simulation.tankGame.entity.EnemyTank;
import simulation.tankGame.service.TankEventService;
import simulation.tankGame.service.GameEventService;
import simulation.tankGame.thread.task.EnemyTankAutoShotTask;
import simulation.tankGame.thread.task.EnemyTankMoveTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.Vector;

/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/10/24 19:12
 */
@Component
public class TaskExecutor {
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;
    @Autowired
    private GameContext gameContext;
    @Autowired
    private TankEventService enemyTankEventService;
    @Autowired
    private GameEventService gameEventService;

    public void startEnemyTankThreads() {
        Vector<EnemyTank> enemies = gameContext.getRealTimeGameData().getEnemies();
        enemies.forEach(e -> {
            taskExecutor.execute(new EnemyTankMoveTask(e, enemyTankEventService));
            e.getTimer().schedule(new EnemyTankAutoShotTask(e, gameEventService), 0, 500);
        });
    }

    public void startSingleEnemyTankTask(EnemyTank tank) {
        taskExecutor.execute(new EnemyTankMoveTask(tank, enemyTankEventService));
        tank.getTimer().schedule(new EnemyTankAutoShotTask(tank, gameEventService), 0, 500);
    }
}

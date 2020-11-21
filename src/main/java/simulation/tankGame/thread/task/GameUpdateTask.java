package simulation.tankGame.thread.task;

import simulation.tankGame.context.GameContext;
import simulation.tankGame.service.GameEventService;
import simulation.tankGame.dto.RealTimeGameData;
import simulation.tankGame.thread.GameTimeUnit;
import simulation.tankGame.view.panel.GamePanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UpdateThread...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class GameUpdateTask implements Runnable {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private GameContext gameContext;


    public GameUpdateTask(GameContext gameContext) {
        this.gameContext = gameContext;
    }

    @Override
    public void run() {
        GamePanel panel = gameContext.getGamePanel();
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        GameEventService control = gameContext.getControl();
        // Repaint every 30 millis
        while (true) {
            GameTimeUnit.sleepMillis(30);
            if (gameData.isStart()) {
                if ((gameData.getMyTankNum() == 0 || gameData.getEnemyTankNum() == 0)
                        && gameData.getDy() > 250) {
                    gameData.setDy(gameData.getDy() - 2);
                }
                if (gameData.getDy() == 250) {
                    panel.repaint();
                    GameTimeUnit.sleepMillis(4000);
                    if (gameData.getLevel() == 5) {
                        gameData.setLevel(0);
                    }
                    if (gameData.getMyTankNum() >= 1 && gameData.getLevel() <= 4) {
                        gameData.setLevel(gameData.getLevel() + 1);
                        gameData.setDy(600);
                        control.nextGame(gameData);
                    }
                }
                if (!gameData.isStop() && gameData.getDy() == 600) {
                    control.cleanAndCreate(); // Remove dead object
                    control.refreshState();
                    control.doBulletEvent();
                    control.doOverlapJudge(); // Check if the object is overlapped
                    control.myTankEvent();

                }
            } else {
                if (gameData.getKy() == 21 && gameData.getKx() <= 654) {
                    gameData.setKx(gameData.getKx() + 2);
                }
                GameTimeUnit.sleepMillis(100);

            }
            panel.repaint();
            logger.debug("data : {}", gameData);
        }
    }


}

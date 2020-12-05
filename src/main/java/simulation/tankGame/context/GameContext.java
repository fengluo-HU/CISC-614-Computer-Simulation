package simulation.tankGame.context;

import simulation.tankGame.constant.GameConstants;
import simulation.tankGame.enums.DirectionEnum;
import simulation.tankGame.listener.MainFrameMouseListener;
import simulation.tankGame.service.GameEventService;
import simulation.tankGame.service.PaintService;
import simulation.tankGame.dto.RealTimeGameData;
import simulation.tankGame.enums.LevelEnum;
import simulation.tankGame.entity.EnemyTank;
import simulation.tankGame.entity.MyTank;
import simulation.tankGame.thread.executor.TaskExecutor;
import simulation.tankGame.thread.task.GameUpdateTask;
import simulation.tankGame.listener.MainFrameKeyListener;
import simulation.tankGame.listener.MenuActionListener;
import simulation.tankGame.util.LogUtils;
import simulation.tankGame.view.frame.GameFrame;
import simulation.tankGame.view.menubar.TankBattleMenuBar;
import simulation.tankGame.view.panel.GamePanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/10/19 20:32
 */
@Component
public class GameContext {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * Frame
     */
    private GameFrame gameFrame;
    /**
     * Menu
     */
    private TankBattleMenuBar tankBattleMenuBar;
    /**
     * Panel
     */
    private GamePanel gamePanel;
    /**
     * RealTimeGameData
     */
    private RealTimeGameData realTimeGameData;

    @Autowired
    private MainFrameKeyListener mainFrameKeyListener;
    @Autowired
    private MenuActionListener menuActionListener;
    @Autowired
    private MainFrameMouseListener mainFrameMouseListener;
    @Autowired
    private GameEventService control;
    @Autowired
    private PaintService paintService;
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;
    @Autowired
    private TaskExecutor threadTaskExecutor;

    @EventListener
    public void init(ApplicationReadyEvent applicationStartedEvent) {
        LogUtils.info("Application Started... applicationStartedEvent={}", applicationStartedEvent);

        //Initialize level 1
        initGameData(1);

        this.gameFrame = new GameFrame();
        this.tankBattleMenuBar = new TankBattleMenuBar(menuActionListener);
        this.gamePanel = new GamePanel(paintService);

        this.gameFrame.setJMenuBar(this.tankBattleMenuBar);
        this.gameFrame.add(this.gamePanel);
        this.gameFrame.addKeyListener(mainFrameKeyListener);
        this.gamePanel.addMouseListener(mainFrameMouseListener);

        this.gameFrame.setVisible(true);

        logger.info("execute UpdateTask...");
        taskExecutor.execute(new GameUpdateTask(this));
        logger.info("game start success...");
    }


    /**
     * Initialize game setting and data
     *
     * @param level
     */
    private void initGameData(int level) {
        this.realTimeGameData = new RealTimeGameData();

        for (int i = 0; i < GameConstants.INIT_ENEMY_TANK_IN_MAP_NUM; i++) {
            EnemyTank enemy = new EnemyTank((i) * 140 + 20, -20, DirectionEnum.SOUTH);
            enemy.setLocation(i);
            this.realTimeGameData.getEnemies().add(enemy);
        }
        MyTank myTank = new MyTank(300, 620, DirectionEnum.NORTH);
        this.realTimeGameData.getMyTanks().add(myTank);

        this.realTimeGameData.setMap(LevelEnum.getByLevel(level).getMap());
        //realTimeGameData.setMap(new Map(MapParser.getMapFromXml()));
        this.realTimeGameData.setEnemyTankNum(GameConstants.INIT_ENEMY_TANK_NUM);
        this.realTimeGameData.setMyTankNum(GameConstants.INIT_MY_TANK_NUM);
        this.realTimeGameData.setMyBulletNum(GameConstants.MY_TANK_INIT_BULLET_NUM);
        this.realTimeGameData.setBeKilled(0);
        this.realTimeGameData.setDy(600);
        this.realTimeGameData.setLevel(level);
        threadTaskExecutor.startEnemyTankThreads();
        logger.info("Init Game Data end...");
    }


    private void reset(int level) {
        this.realTimeGameData.reset();
        initGameData(level);
        logger.info("Init Game Data...");
    }


    public void startGame() {
        this.realTimeGameData.setStart(Boolean.TRUE);
        this.realTimeGameData.getEnemies().forEach(t -> t.setActivate(Boolean.TRUE));
        this.realTimeGameData.getMyTanks().forEach(t -> t.setActivate(Boolean.TRUE));
    }

    public void startLevel(int level) {
        reset(level);
        this.startGame();
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public TankBattleMenuBar getTankBattleMenuBar() {
        return tankBattleMenuBar;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public RealTimeGameData getRealTimeGameData() {
        return realTimeGameData;
    }

    public GameEventService getControl() {
        return control;
    }

}

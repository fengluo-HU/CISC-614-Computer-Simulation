package simulation.tankGame.service;

import simulation.tankGame.context.GameContext;
import simulation.tankGame.dto.RealTimeGameData;
import simulation.tankGame.resource.map.Map;
import simulation.tankGame.resource.map.xml.parse.MapParser;
import simulation.tankGame.util.RefUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;

/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/10/24 10:27
 */
@Service
public class CommandService {
    @Autowired
    private GameEventService gameEventService;

    @Autowired
    private GameContext gameContext;

    public void executeByCmd(String cmd) {
        RefUtils.executeByMethodName(this, cmd, null, null);
    }

    public void executeCustomMapMenu(String para) {
        RefUtils.executeByMethodName(this, "loadCustomMap", new Class[]{String.class}, new String[]{para});
    }

    public void loadCustomMap(String mapName){
        System.out.println(mapName);
        gameContext.getRealTimeGameData().setMap(new Map(MapParser.getMapFromXml(mapName)));
        gameContext.startGame();
    }

    public void stop() {
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        gameEventService.gameEventStop(gameData);
    }

    public void start() {
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        if (!gameData.isStart()) { // not start yet
            gameContext.startGame();// game starts
            //this.setVisible(true);
        } else if (!gameData.isStop()
                && gameData.getMyTankNum() != 0) {
            // Pause Game
            gameEventService.gameEventStop(gameData);
            JOptionPane.showMessageDialog(null, "The game is started", "Instruction",
                    JOptionPane.INFORMATION_MESSAGE);
            // Resume Game
            gameEventService.gameEventStop(gameData);
        } else if (gameData.isStop()) {
            JOptionPane.showMessageDialog(null, "The game is started", "Instruction",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (!gameData.isStop()
                && (gameData.getMyTankNum() == 0)) {
            gameContext.startGame();
        }
    }

    public void exit() {
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        // Pause game
        gameEventService.gameEventStop(gameData);
        int select = JOptionPane.showConfirmDialog(null, "Game Exit, Good game？", "Confirm Exit",
                JOptionPane.YES_NO_OPTION);
        if (select == JOptionPane.OK_OPTION) {
            // Exit Game
            System.exit(0);
        } else {
            // Resume Game
            gameEventService.gameEventStop(gameData);
        }
    }

    public void again() {
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        if (!gameData.isStop()) {
            gameEventService.gameEventStop(gameData);
        }
            int select = JOptionPane.showConfirmDialog(null, "Play Again", "Confirm", JOptionPane.OK_CANCEL_OPTION);
            if (select == JOptionPane.OK_OPTION) {
                gameEventService.gameEventStop(gameData);
                gameContext.startLevel(gameData.getLevel());
            } else {
                gameEventService.gameEventStop(gameData);
            }

    }

    public void first() {
        selectLevel(1);
    }

    public void second() {
        selectLevel(2);
    }

    public void third() {
        selectLevel(3);
    }

    public void fourth() {
        selectLevel(4);
    }

    public void fifth() {
        selectLevel(5);
    }

    public void selectLevel(int level) {
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        if (gameData.isStart()) {
            if (!gameData.isStop()) {// Pause Game
                gameEventService.gameEventStop(gameData);
            }
            int select = JOptionPane.showConfirmDialog(null,
                    "You choose level" + level + "，confirm and start the game", "Confirm",
                    JOptionPane.OK_CANCEL_OPTION);
            if (select == JOptionPane.OK_OPTION) {
                if (gameData.isStart()) {
                    // Resume Game
                    gameEventService.gameEventStop(gameData);
                }
                gameContext.startLevel(level);
            } else {
                if (gameData.isStart()) {
                    // Resume Game
                    gameEventService.gameEventStop(gameData);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please click the start game from menu", "Instruction",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void help() {
        JOptionPane.showMessageDialog(
                null,
                "Move: Arrow Key\nShoot: X Key\nPause: P key\nGo to next map after killing 8 enemy tanks",
                "Help", JOptionPane.INFORMATION_MESSAGE);
    }

    public void about() {
        JOptionPane.showMessageDialog(null,
                "Tank Game Simulation in JAVA\nAuthor: Feng Luo\n", "About",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void createMap() {
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        gameData.setMapMakingFlag(Boolean.TRUE);
        gameData.getEnemies().forEach(t -> t.setLive(Boolean.FALSE));
        gameData.getMyTanks().forEach(t -> t.setLive(Boolean.FALSE));
        gameData.getMyTanks().clear();
        gameData.getEnemies().clear();
        gameData.setMap(new Map());
        gameData.setStart(Boolean.TRUE);
    }

    public void saveMap() {
        RealTimeGameData gameData = gameContext.getRealTimeGameData();
        String inputValue = JOptionPane.showInputDialog("Please enter custom map name");
        System.out.println(inputValue);
        try {
            MapParser.generateXmlFromMap(gameData.getMap(), inputValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

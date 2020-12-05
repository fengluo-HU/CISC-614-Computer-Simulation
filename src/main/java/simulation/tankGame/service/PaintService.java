package simulation.tankGame.service;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

import javax.swing.JPanel;

import simulation.tankGame.constant.GameConstants;
import simulation.tankGame.context.GameContext;
import simulation.tankGame.dto.RealTimeGameData;
import simulation.tankGame.enums.DirectionEnum;
import simulation.tankGame.enums.StuffTypeEnum;
import simulation.tankGame.enums.TankTypeEnum;
import simulation.tankGame.entity.Bomb;
import simulation.tankGame.entity.Brick;
import simulation.tankGame.entity.Bullet;
import simulation.tankGame.entity.EnemyTank;
import simulation.tankGame.entity.Iron;
import simulation.tankGame.entity.MyTank;
import simulation.tankGame.entity.Stuff;
import simulation.tankGame.entity.Tank;
import simulation.tankGame.resource.TankGameImages;
import simulation.tankGame.entity.Water;
import simulation.tankGame.resource.map.Map;
import simulation.tankGame.view.panel.GamePanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Draw...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
@Service
public class  PaintService {
    @Autowired
    private GameContext context;
    private Brick rightBrick = new Brick(700, 50);
    private Iron rightIron = new Iron(700, 50);
    private Water rightWater = new Water(700, 50);

    /**
     * Draw Objective（Including Tank、Obstacle..）
     *
     * @param g     Graphics
     * @param stuff Blockers
     * @param panel Main Panel
     */
    public void drawStuff(Graphics g, Stuff stuff, JPanel panel) {
        switch (stuff.getType()) {
            case TANK:
                Tank tank = (Tank) stuff;
                switch (stuff.getDirect()) {
                    case NORTH:
                        this.drawNorth(g, tank, panel);
                        break;
                    case SOUTH:
                        this.drawSouth(g, tank, panel);
                        break;
                    case WEST:
                        this.drawWest(g, tank, panel);
                        break;
                    case EAST:
                        this.drawEast(g, tank, panel);
                        break;
                }
                break;
            case BRICK:

//                g.setColor(new Color(216, 90, 49));
//                g.fill3DRect(stuff.getX() - 20, stuff.getY() - 20, 40, 40, false);

                g.drawImage(TankGameImages.stuffImg[StuffTypeEnum.BRICK.getKey()],
                        stuff.getX() - 10, stuff.getY() - 10, 20, 20, panel);
                break;
            case IRON:

//                g.setColor(new Color(225, 225, 225));
//                g.fill3DRect(stuff.getX() - 20,
//                        stuff.getY() - 20, 40, 40, false);

                g.drawImage(TankGameImages.stuffImg[StuffTypeEnum.IRON.getKey()], stuff.getX() - 10,
                        stuff.getY() - 10, 20, 20, panel);
                break;
            case WATER:

//                g.setColor(new Color(65, 64, 253));
//                g.fillRect(stuff.getX() - 20,
//                        stuff.getY() - 20, 40, 40);

                g.drawImage(TankGameImages.stuffImg[StuffTypeEnum.WATER.getKey()],
                        stuff.getX() - 10, stuff.getY() - 10, 20, 20, panel);
                break;
        }

    }

    /**
     * Draw Explosion
     *
     * @param g     Graphics
     * @param bombs Bomb
     * @param panel Main Panel
     */
    public void drawBomb(Graphics g, Vector<Bomb> bombs, JPanel panel) {
        for (int i = 0; i < bombs.size(); i++) {
            int l = bombs.get(i).getL();
            Bomb b = bombs.get(i); //
            if (b.getLifeTime() > 24) { // HP: 21-25
                g.drawImage(TankGameImages.bomb[0], b.getX() - l / 2, b.getY()
                        - l / 2, l, l, panel);
            } else if (b.getLifeTime() > 18) { // HP: 16-20
                g.drawImage(TankGameImages.bomb[1], b.getX() - l / 2, b.getY()
                        - l / 2, l, l, panel);
            } else if (b.getLifeTime() > 12) { // HP: 11-15
                g.drawImage(TankGameImages.bomb[2], b.getX() - l / 2, b.getY()
                        - l / 2, l, l, panel);
            } else if (b.getLifeTime() > 6) { // HP: 6-10
                g.drawImage(TankGameImages.bomb[3], b.getX() - l / 2, b.getY()
                        - l / 2, l, l, panel);
            } else { // HP less than 6
                g.drawImage(TankGameImages.bomb[4], b.getX() - l / 2, b.getY()
                        - l / 2, l, l, panel);
            }
            b.lifeDown(); // Deduct lives
            if (b.getLifeTime() == 0) { // Dead Bomb
                b.setLive(false);
            }
        }
    }

    /**
     * Draw Bullets from Enemy Tank
     *
     * @param g       Graphics
     * @param enemies Enemy Tanks
     * @param panel   Painting Panel
     */
    public void drawEnemyTank(Graphics g, Vector<EnemyTank> enemies, JPanel panel) {
        for (int i = 0; i < enemies.size(); i++) {
            this.drawStuff(g, enemies.get(i), panel); // Draw Enemy Tank
            for (int j = 0; j < enemies.get(i).getBullets().size(); j++) {
                if (enemies.get(i).getBullets().get(j) != null) {
                    Bullet eb = enemies.get(i).getBullets().get(j);
                    g.drawImage(TankGameImages.bullet, eb.getX() - 2,
                            eb.getY() - 2, 4, 4, panel);
                }
            }
        }
    }

    /**
     * Draw Bullets from Hero Tank
     *
     * @param g       Graphics
     * @param myTanks Hero Tank
     * @param panel   Painting Panel
     */
    public void drawMyTank(Graphics g, Vector<MyTank> myTanks, JPanel panel) {
        for (int m = 0; m < myTanks.size(); m++) {
            MyTank myTank = myTanks.get(m); // Get Hero Tank
            this.drawStuff(g, myTank, panel); // Draw Hero Tank
            for (int i = 0; i < myTank.getBullets().size(); i++) {
                if (myTank.getBullets().get(i) != null) {
                    Bullet b = myTank.getBullets().get(i);
                    g.drawImage(TankGameImages.bullet, b.getX() - 2,
                            b.getY() - 2, 4, 4, panel);
                }
            }
        }
    }

    /**
     * Draw Map
     *
     * @param g     Graphics
     * @param map   Map
     * @param panel Painting Panel
     */
    public void drawMap(Graphics g, Map map, JPanel panel) {
        Vector<Brick> bricks = map.getBricks();
        Vector<Iron> irons = map.getIrons();
        Vector<Water> waters = map.getWaters();
        for (int i = 0; i < bricks.size(); i++) {
            this.drawStuff(g, bricks.get(i), panel);
        }
        for (int i = 0; i < irons.size(); i++) {
            this.drawStuff(g, irons.get(i), panel);
        }
        for (int i = 0; i < waters.size(); i++) {
            this.drawStuff(g, waters.get(i), panel);
        }
    }

    /**
     * Draw tank towards to North
     *
     * @param g     Graphics
     * @param tank  Tank
     * @param panel Painting Panel
     */
    public void drawNorth(Graphics g, Tank tank, JPanel panel) {

//        int x = tank.getX();
//        int y = tank.getY(); //0.
//        g.setColor(Color.white);
//        g.fill3DRect(x - 20, y - 20, 10,
//                40, false);
//        g.fill3DRect(x + 10, y - 20, 10, 40, false);
//        g.setColor(tank.getColor());
//        for (int
//             i = 0;
//             i < 20 - 1;
//             i++) {
//            g.drawLine(x - 20, y - 20 + (i + 1) * 2, x - 10 - 1, y - 20 + (i + 1) * 2);
//            g.drawLine(x + 10, y - 20 + (i + 1) * 2, x + 20 - 1, y - 20 + (i + 1) * 2);
//        g.fill3DRect(x - 15, y - 14, 30, 28, false);
//        g.setColor(Color.white);
//        g.draw3DRect(x - 10, y - 9, 20,
//                18, false);
//        g.draw3DRect(x - 3, y - 5, 6, 10, false);
//        g.drawLine(x - 15, y - 14, x - 10, y - 9);
//        g.drawLine(x + 15, y - 14, x + 10, y - 9);
//        g.drawLine(x - 15, y + 14, x - 10, y + 9);
//        g.drawLine(x + 15, y + 14, x + 10, y + 9);
//        g.setColor(tank.getColor());
//        g.fill3DRect(x - 3, y - 12, 6, 3,
//                false);
//        g.fill3DRect(x - 2, y - 20, 4, 2, false);
//        g.fill3DRect(x - 1, y - 20,
//                2, 11, false);

        Image image;
        if (tank.getTankType() == TankTypeEnum.MY) {
            g.setColor(Color.green);
            image = TankGameImages.myTankImg[DirectionEnum.NORTH.getKey()];// Initialize the Tank Image
        } else {
            image = TankGameImages.enemyTankImg[DirectionEnum.NORTH.getKey()];
            g.setColor(Color.gray);
        }
        g.drawImage(image, tank.getX() - 20, tank.getY() - 20, 40, 40, panel);
        g.fillRect(tank.getX() - 20, tank.getY() - 30, tank.getBlood() * 4, 5);
    }

    /**
     * Draw tank towards to South
     *
     * @param g     Graphics
     * @param tank  Tank
     * @param panel Painting Panel
     */
    public void drawSouth(Graphics g, Tank tank, JPanel panel) {

//        int x = tank.getX();
//        int y = tank.getY();
//        g.setColor(Color.white);
//        g.fill3DRect(x - 20, y - 20, 10, 40, false);
//        g.fill3DRect(x + 10, y - 20, 10,
//                40, false);
//        g.setColor(tank.getColor());
//        for (int i = 0; i < 20 - 1; i++) {
//            g.drawLine(x - 20, y - 20 + (i + 1) * 2, x - 10 - 1, y - 20 + (i + 1) * 2);
//            g.drawLine(x + 10,
//                    y - 20 + (i + 1) * 2, x + 20 - 1, y - 20 + (i + 1) * 2);
//        }
//        g.fill3DRect(x - 15, y - 14, 30,
//                28, false);
//        g.setColor(Color.white);
//        g.draw3DRect(x - 10, y - 9, 20,
//                18, false);
//        g.draw3DRect(x - 3, y - 5, 6, 10, false);
//        g.drawLine(x - 15,
//                y - 14, x - 10, y - 9);
//        g.drawLine(x + 15, y - 14, x + 10, y - 9);
//        g.drawLine(x - 15,
//                y + 14, x - 10, y + 9);
//        g.drawLine(x + 15, y + 14, x + 10, y + 9);
//        g.setColor(tank.getColor());
//        g.fill3DRect(x - 3, y + 9, 6, 3, false);
//        g.fill3DRect(x - 1, y + 9, 2, 11, false);
//        g.fill3DRect(x - 2, y + 18, 4, 2,
//                false);

        Image image;
        if (tank.getTankType() == TankTypeEnum.MY) {
            g.setColor(Color.green);
            image = TankGameImages.myTankImg[DirectionEnum.SOUTH.getKey()];// Initialize Image
        } else {
            image = TankGameImages.enemyTankImg[DirectionEnum.SOUTH.getKey()];
            g.setColor(Color.gray);
        }
        g.drawImage(image, tank.getX() - 20, tank.getY() - 20, 40, 40, panel);
        g.fillRect(tank.getX() - 20, tank.getY() - 30, tank.getBlood() * 4, 5);
    }

    /**
     * Draw tank towards to West
     *
     * @param g     Graphics
     * @param tank  Tank
     * @param panel Painting Panel
     */
    public void drawWest(Graphics g, Tank tank, JPanel panel) {

//        int x = tank.getX();
//        int y = tank.getY();
//        g.setColor(Color.white);
//        g.fill3DRect(x - 20, y - 20, 40, 10, false);
//        g.fill3DRect(x - 20, y + 10, 40,
//                10, false);
//        g.setColor(tank.getColor());
//        for (int i = 0; i < 20 - 1; i++) {
//            g.drawLine(x - 20 + (i + 1) * 2, y - 20, x - 20 + (i + 1) * 2, y - 10 - 1);
//            g.drawLine(x - 20 + (i + 1) * 2, y - 20 + 30, x - 20 + (i + 1) * 2, y - 10 - 1 + 30);
//        }
//        g.fill3DRect(x - 14, y - 15, 28, 30, false);
//        g.setColor(Color.white);
//        g.draw3DRect(x - 9, y - 10, 18, 20, false);
//        g.draw3DRect(x - 5, y - 3, 10,
//                6, false);
//        g.drawLine(x - 15, y - 14, x - 10, y - 9);
//        g.drawLine(x + 15, y - 14,
//                x + 10, y - 9);
//        g.drawLine(x - 15, y + 14, x - 10, y + 9);
//        g.drawLine(x + 15, y + 14,
//                x + 10, y + 9);
//        g.setColor(tank.getColor());
//        g.fill3DRect(x - 12, y - 3, 3,
//                6, false);
//        g.fill3DRect(x - 20, y - 1, 11, 2, false);
//        g.fill3DRect(x - 20,
//                y - 2, 2, 4, false);

        Image image;
        if (tank.getTankType() == TankTypeEnum.MY) {
            image = TankGameImages.myTankImg[DirectionEnum.WEST.getKey()];// Initialize Image
            g.setColor(Color.green);
        } else {
            image = TankGameImages.enemyTankImg[DirectionEnum.WEST.getKey()];
            g.setColor(Color.gray);
        }
        g.drawImage(image, tank.getX() - 20, tank.getY() - 20, 40, 40, panel);
        g.fillRect(tank.getX() - 20, tank.getY() - 30, tank.getBlood() * 4, 5);
    }

    /**
     * Draw tank towards to East
     *
     * @param g     Graphics
     * @param tank  Tank
     * @param panel Painting Panel
     */
    public void drawEast(Graphics g, Tank tank, JPanel panel) {

//        int x = tank.getX();
//        int y = tank.getY();
//        g.setColor(Color.white);
//        g.fill3DRect(x - 20, y - 20, 40, 10, false);
//        g.fill3DRect(x - 20, y + 10, 40,
//                10, false);
//        g.setColor(tank.getColor());
//        for (int i = 0; i < 20 - 1; i++) {
//            g.drawLine(x - 20 + (i + 1) * 2, y - 20, x - 20 + (i + 1) * 2, y - 10 - 1);
//            g.drawLine(x - 20 + (i + 1) * 2, y - 20 + 30, x - 20 + (i + 1) * 2, y - 10 - 1 + 30);
//        }
//        g.fill3DRect(x - 14, y - 15, 28, 30, false);
//        g.setColor(Color.white);
//        g.draw3DRect(x - 9, y - 10, 18, 20, false);
//        g.draw3DRect(x - 5, y - 3, 10,
//                6, false);
//        g.drawLine(x - 15, y - 14, x - 10, y - 9);
//        g.drawLine(x + 15, y - 14,
//                x + 10, y - 9);
//        g.drawLine(x - 15, y + 14, x - 10, y + 9);
//        g.drawLine(x + 15, y + 14,
//                x + 10, y + 9);
//        g.setColor(tank.getColor());
//        g.fill3DRect(x + 9, y - 3, 3, 6,
//                false);
//        g.fill3DRect(x + 9, y - 1, 11, 2, false);
//        g.fill3DRect(x + 18, y - 2,
//                2, 4, false);

        Image image;
        if (tank.getTankType() == TankTypeEnum.MY) {
            image = TankGameImages.myTankImg[DirectionEnum.EAST.getKey()];// Initialize Image
            g.setColor(Color.green);
        } else {
            image = TankGameImages.enemyTankImg[DirectionEnum.EAST.getKey()];
            g.setColor(Color.gray);
        }
        g.drawImage(image, tank.getX() - 20, tank.getY() - 20, 40, 40, panel);
        g.fillRect(tank.getX() - 20, tank.getY() - 30, tank.getBlood() * 4, 5);
    }

    /**
     * Draw Right side Panel
     *
     * @param g   Graphics
     * @param tgp Painting Panel
     */
    public void drawRight(Graphics g, GamePanel tgp, RealTimeGameData data) {
        if (data.getMapMakingFlag().equals(Boolean.TRUE)) {
            g.drawString("Paint pen（Press 'C' to switch）", 620, 20);
            if (data.getCurrentStuff() == StuffTypeEnum.IRON) {
                drawStuff(g, rightIron, tgp);
            } else if (data.getCurrentStuff() == StuffTypeEnum.BRICK) {
                drawStuff(g, rightBrick, tgp);
            } else if (data.getCurrentStuff() == StuffTypeEnum.WATER) {
                drawStuff(g, rightWater, tgp);
            } else {
                g.drawString("Eraser", 680, 50);
            }

        } else {
            for (int i = 0; i < data.getEnemyTankNum(); i++) {
                if (i >= 4) {
                    g.drawImage(TankGameImages.enemyTankImg[DirectionEnum.NORTH.getKey()],
                            402 + 50 * i, 100, 40, 40, tgp);
                } else {
                    g.drawImage(TankGameImages.enemyTankImg[DirectionEnum.NORTH.getKey()],
                            602 + 50 * i, 20, 40, 40, tgp);
                }
            }
            for (int j = 0; j < data.getMyTankNum(); j++) {
                g.drawImage(TankGameImages.myTankImg[DirectionEnum.NORTH.getKey()], 602 + 50 * j,
                        400, 40, 40, tgp);
            }
            g.drawString("My tank bullets:" + data.getMyBulletNum(), 620, 500);
        }

    }


    public void rePaintPanel(GamePanel panel, Graphics g) {

        RealTimeGameData data = context.getRealTimeGameData();
        if (data.isStart()) {
            g.setColor(Color.black);
            g.fillRect(0, 0, GameConstants.GAME_PANEL_WIDTH, GameConstants.GAME_PANEL_HEIGHT);
            g.fillRect(280, 600, 40, 40);
            this.drawMap(g, data.getMap(), panel);
            this.drawMyTank(g, data.getMyTanks(), panel); // Draw hero Tank（Including bullets）
            this.drawEnemyTank(g, data.getEnemies(), panel); // Draw enemy Tank（Including bullets）
            this.drawBomb(g, data.getBombs(), panel); // Draw explosion
            this.drawRight(g, panel, data);

            if (data.getMyTankNum() == 0) { // When hero tank's lives are 0
                g.drawImage(TankGameImages.gameOver, 250, data.getDy(), 100,
                        100, panel);
            }

            if (data.getEnemyTankNum() == 0) { // When the number of enemy tank's lives is 0
                g.drawImage(TankGameImages.gameWin, 250, data.getDy(), 100,
                        100, panel);
            }
            if (data.getDy() == 250) {
                g.fillRect(0, 0, 800, 600);
                g.setColor(Color.BLUE);
                if (data.getMyTankNum() == 0) {
                    g.drawString("Challenge failed, good game!", 300, 220);
                } else {
                    g.drawString("Challenge success，please wait...", 300, 220);
                }
                g.drawString(
                        ("Number of enemy tanks killed:" + (8 - data.getEnemyTankNum())),
                        300, 260);
                g.drawString("Number of my tanks killed:" + data.getBeKilled(), 300,
                        280);
                g.drawString(
                        "The total number of my bullets used:"
                                + (GameConstants.MY_TANK_INIT_BULLET_NUM - data
                                .getMyBulletNum()), 300, 300);
                g.drawString("The remaining number of enemy tanks:" + data.getEnemyTankNum(), 300,
                        320);
                g.drawString("The remaining number of my tanks:" + data.getMyTankNum(), 300,
                        340);
                g.drawString("The total number of my bullets remaining:" + data.getMyBulletNum(), 300,
                        360);
            }
        } else {
            g.drawImage(TankGameImages.startImage, 0, 0, 800, 700, panel);
        }
    }
}

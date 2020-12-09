package simulation.tankGame.resource.map;

import java.util.Vector;

import simulation.tankGame.entity.Brick;
import simulation.tankGame.entity.Iron;
import simulation.tankGame.entity.Water;

/**
 * map...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class Map1 extends Map {
    /**
     * Constructor
     */
    public Map1() {
        Vector<Brick> bricks = this.getBricks();
        for (int i = 0; i < 25; i++) {
            Brick Brick = new Brick(20 * i + 60, 60);
            bricks.add(Brick);
        }
        for (int i = 0; i < 25; i++) {
            Brick Brick = new Brick(20 * i + 60, 140);
            bricks.add(Brick);
        }
        for (int i = 0; i < 25; i++) {
            Brick Brick = new Brick(20 * i + 60, 220);
            bricks.add(Brick);
        }
        for (int i = 0; i < 25; i++) {
            if (i == 11 || i == 12 || i == 13)
                continue;
            Brick Brick = new Brick(20 * i + 60, 460);
            bricks.add(Brick);
        }
        for (int i = 0; i < 25; i++) {
            if (i == 11 || i == 12 || i == 13)
                continue;
            Brick Brick = new Brick(20 * i + 60, 540);
            bricks.add(Brick);
        }
        for (int i = 0; i < 25; i++) {
            Brick Brick = new Brick(60, 20 * i + 60);
            bricks.add(Brick);
        }
        for (int i = 0; i < 25; i++) {
            Brick Brick = new Brick(540, 20 * i + 60);
            bricks.add(Brick);
        }
        Brick Brick = new Brick(290, 290);
        bricks.add(Brick);
        Brick = new Brick(310, 290);
        bricks.add(Brick);
        Brick = new Brick(290, 310);
        bricks.add(Brick);
        Brick = new Brick(310, 310);
        bricks.add(Brick);
    }

}

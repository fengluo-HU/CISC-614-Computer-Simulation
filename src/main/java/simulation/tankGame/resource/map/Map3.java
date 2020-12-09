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
public class Map3 extends Map {
    public Map3() {
// TODO Auto-generated constructor stub
        Vector<Brick> bricks = this.getBricks();
        Vector<Iron> irons = this.getIrons();
        Vector<Water> waters = this.getWaters();
        // Draw Brick
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0)
                continue;
            Brick brick = new Brick(20 * i + 10, 470);
            bricks.add(brick);
        }
        // Draw Water
        for (int i = 0; i < 25; i++) {
            Water water = new Water(20 * i + 60, 130);
            waters.add(water);
        }
        for (int i = 8; i < 15; i++) {
            Water water = new Water(100, 20 * i + 120);
            waters.add(water);
        }
        for (int i = 0; i < 25; i++) {
            if (i == 11 || i == 12 || i == 13)
                continue;
            Water water = new Water(20 * i + 60, 60);
            waters.add(water);
        }
        // Draw Steel
        for (int i = 0; i < 29; i++) {
            if (i % 2 == 0 || i % 3 == 0)
                continue;
            Iron iron = new Iron(20 * i + 10, 540);
            irons.add(iron);
        }
        Iron iron = new Iron(10, 540);
        irons.add(iron);
        for (int i = 0; i < 27; i++) {
            if (i % 3 == 0)
                continue;
            if (i >= 10 && i <= 15)
                continue;
            iron = new Iron(20 * i - 10, 200);
            irons.add(iron);
        }
        iron = new Iron(230, 150);
        irons.add(iron);
        iron = new Iron(230, 170);
        irons.add(iron);
        iron = new Iron(290, 200);
        irons.add(iron);

        iron = new Iron(290, 290);
        irons.add(iron);
        iron = new Iron(310, 290);
        irons.add(iron);
        iron = new Iron(290, 310);
        irons.add(iron);
        iron = new Iron(310, 310);
        irons.add(iron);
        iron = new Iron(590, 400);
        irons.add(iron);
        iron = new Iron(570, 400);
        irons.add(iron);

        Brick brick = new Brick(200, 290);
        bricks.add(brick);
        brick = new Brick(220, 290);
        bricks.add(brick);
        brick = new Brick(200, 310);
        bricks.add(brick);
        brick = new Brick(220, 310);
        bricks.add(brick);

        Water water = new Water(380, 290);
        waters.add(water);
        water = new Water(400, 290);
        waters.add(water);
        water = new Water(380, 310);
        waters.add(water);
        water = new Water(400, 310);
        waters.add(water);
    }
}

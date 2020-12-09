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
        Vector<Iron> irons = this.getIrons();
        for (int i = 0; i < 25; i++) {
            if (i % 2 == 0)
                continue;
            if (i == 11 || i == 12 || i == 13)
                continue;
            Iron iron = new Iron(20 * i + 60, 60);
            irons.add(iron);
        }
        for (int i = 0; i < 25; i++) {
            if (i == 11 || i == 12 || i == 13)
                continue;
            Iron iron = new Iron(20 * i + 60, 540);
            irons.add(iron);
        }
        for (int i = 0; i < 25; i++) {
            if (i % 2 == 0)
                continue;
            if (i == 11 || i == 12 || i == 13)
                continue;
            Iron iron = new Iron(60, 20 * i + 60);
            irons.add(iron);
        }
        for (int i = 0; i < 25; i++) {
            if (i % 2 == 0)
                continue;
            if (i == 11 || i == 12 || i == 13)
                continue;
            Iron iron = new Iron(540, 20 * i + 60);
            irons.add(iron);
        }
        Iron iron = new Iron(290, 290);
        irons.add(iron);
        iron = new Iron(310, 290);
        irons.add(iron);
        iron = new Iron(290, 310);
        irons.add(iron);
        iron = new Iron(310, 310);
        irons.add(iron);
    }
}

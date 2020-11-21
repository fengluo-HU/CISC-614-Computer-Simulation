package simulation.tankGame.resource.map.xml;

import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;

import java.util.Vector;

/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/10/31 9:10
 */
@ObjectCreate(pattern = "map/bricks")
public class XmlBricks {
    private Vector<XmlBrick> bricks = new Vector<>();

    @SetNext
    public void addBrick(XmlBrick brick) {
        this.bricks.add(brick);
    }

    public Vector<XmlBrick> getBricks() {
        return bricks;
    }

    public void setBricks(Vector<XmlBrick> bricks) {
        this.bricks = bricks;
    }
}

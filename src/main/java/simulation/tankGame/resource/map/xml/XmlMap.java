package simulation.tankGame.resource.map.xml;


import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;


/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/10/31 9:10
 */
@ObjectCreate(pattern = "map")
public class XmlMap {
    private XmlBricks bricks;
    private XmlIrons irons;
    private XmlWaters waters;


    @SetNext
    public void setBricks(XmlBricks bricks) {
        this.bricks = bricks;
    }

    @SetNext
    public void setIrons(XmlIrons irons) {
        this.irons = irons;
    }

    @SetNext
    public void setWaters(XmlWaters waters) {
        this.waters = waters;
    }

    public XmlBricks getBricks() {
        return bricks;
    }

    public XmlIrons getIrons() {
        return irons;
    }


    public XmlWaters getWaters() {
        return waters;
    }

}

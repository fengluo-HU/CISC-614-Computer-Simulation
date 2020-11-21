package simulation.tankGame.view.panel;

import java.awt.Graphics;

import javax.swing.JPanel;


import simulation.tankGame.service.PaintService;
import org.apache.commons.logging.LogFactory;

/**
 * GamePanel...
 *
 * @author fengluo
 * @since 2020-10-10 19:29
 */
public class GamePanel extends JPanel {


    private static final long serialVersionUID = 2933760710140135907L;
    private PaintService paintService;

    public GamePanel(PaintService paintService) {
        super();
        this.paintService = paintService;
    }

    /*
     * Repaint
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.paintService.rePaintPanel(this, g);
        LogFactory.getLog(this.getClass()).debug("paint...");
    }
}

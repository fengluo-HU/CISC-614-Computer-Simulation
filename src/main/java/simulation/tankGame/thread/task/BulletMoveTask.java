package simulation.tankGame.thread.task;


import simulation.tankGame.constant.GameConstants;
import simulation.tankGame.entity.Bullet;
import simulation.tankGame.thread.GameTimeUnit;

/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/10/24 20:08
 */
public class BulletMoveTask implements Runnable {
    private Bullet bullet;

    public BulletMoveTask(Bullet bullet) {
        this.bullet = bullet;
    }

    @Override
    public void run() {
        while (bullet.isLive()) {
            switch (bullet.getDirect()) { // Select direction for bullet
                case NORTH:
                    bullet.setY(bullet.getY() - bullet.getSpeed());
                    break;
                case SOUTH:
                    bullet.setY(bullet.getY() + bullet.getSpeed());
                    break;
                case WEST:
                    bullet.setX(bullet.getX() - bullet.getSpeed());
                    break;
                case EAST:
                    bullet.setX(bullet.getX() + bullet.getSpeed());
                    break;
            }

            if (bullet.getX() < 5 || bullet.getX() > GameConstants.GAME_PANEL_WIDTH - 5 || bullet.getY() < 5
                    || bullet.getY() > GameConstants.GAME_PANEL_HEIGHT - 5) { // Check whether the bullet is reaching to edge
                bullet.setLive(false); // Bullet died(disappear)
            }

            GameTimeUnit.sleepMillis(36);
        }
    }
}

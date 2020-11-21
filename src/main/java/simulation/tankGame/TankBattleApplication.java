package simulation.tankGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Tank Game (computer simulation)...
 *
 * @author fengluo
 * @since 2020/10/19 19:36
 */
@SpringBootApplication
public class TankBattleApplication {
    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(TankBattleApplication.class, args);
        System.out.println("started...");
    }
}

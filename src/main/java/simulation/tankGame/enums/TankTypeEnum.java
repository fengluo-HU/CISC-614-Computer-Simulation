package simulation.tankGame.enums;

/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/10/25 14:12
 */
public enum TankTypeEnum {
    INVALID(-1, "Invalid"),
    MY(0, "MyTank"),
    ENEMY(1, "EnemyTank");

    private Integer key;
    private String name;

    TankTypeEnum(Integer key, String name) {
        this.key = key;
        this.name = name;
    }

    public static TankTypeEnum getByKey(Integer key) {
        for (TankTypeEnum tmp : TankTypeEnum.values()) {
            if (tmp.getKey().equals(key)) {
                return tmp;
            }
        }
        return INVALID;
    }

    public Integer getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}

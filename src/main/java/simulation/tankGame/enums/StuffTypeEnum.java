package simulation.tankGame.enums;


/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/10/24 21:03
 */
public enum StuffTypeEnum {
    INVALID(-1, "Invalid"),
    BRICK(0, "Brick"),
    IRON(1, "IronBlock"),
    WATER(2, "Water"),
    TANK(3, "Tank"),
    MAP(4, "Map");

    private Integer key;
    private String name;

    StuffTypeEnum(Integer key, String name) {
        this.key = key;
        this.name = name;
    }

    public static StuffTypeEnum getByKey(Integer key) {
        for (StuffTypeEnum tmp : StuffTypeEnum.values()) {
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

package simulation.tankGame.enums;

/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/10/24 21:18
 */
public enum DirectionEnum {
    INVALID(-1, "Invalid"),
    NORTH(0, "North"),
    SOUTH(1, "South"),
    WEST(2, "West"),
    EAST(3, "East");
    private Integer key;
    private String name;

    DirectionEnum(Integer key, String name) {
        this.key = key;
        this.name = name;
    }

    public static DirectionEnum getByKey(Integer key) {
        for (DirectionEnum tmp : DirectionEnum.values()) {
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

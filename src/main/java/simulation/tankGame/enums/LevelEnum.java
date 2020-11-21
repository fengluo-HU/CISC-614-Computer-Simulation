package simulation.tankGame.enums;

import simulation.tankGame.resource.map.*;

/**
 * Class Description...
 *
 * @author fengluo
 * @since 2020/10/21 21:12
 */
public enum LevelEnum {
    INVALID_LEVEL(-1, "Invalid", null),
    FIRST_LEVEL(1, "Level1", new Map1()),
    SECOND_LEVEL(2, "Level2", new Map2()),
    THIRD_LEVEL(3, "Level3", new Map3()),
    FOUR_LEVEL(4, "Level4", new Map4()),
    FIVE_LEVEL(5, "Level5", new Map5());

    private Integer level;
    private String name;
    private Map map;

    LevelEnum(Integer level, String name, Map map) {
        this.level = level;
        this.name = name;
        this.map = map;
    }

    public static LevelEnum getByLevel(Integer level) {
        for (LevelEnum levelEnum : LevelEnum.values()) {
            if (levelEnum.getLevel().equals(level)) {
                return levelEnum;
            }
        }
        return INVALID_LEVEL;
    }

    public Integer getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public Map getMap() {
        return map;
    }
}

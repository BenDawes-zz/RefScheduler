package refscheduler.person;

/**
 * Referee level enumeration.
 */
public enum Level {

    LEVEL_1 (1),
    LEVEL_2 (2),
    LEVEL_3 (3),
    LEVEL_4 (4),
    LEVEL_5 (5);

    private final int level;

    Level(final int level) {
        this.level = level;
    }

    public int level() {
        return level;
    }
}

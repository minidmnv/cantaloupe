package pl.mn.cantaloupe.core.world.resource;

import java.util.Random;

/**
 * @author asiazkrainyowiec
 */
public enum ResourceType {
    WOOD,
    WATER,
    STONE,
    GOLD;

    private static final Random rand = new Random();

    public static ResourceType random() {
        return values()[rand.nextInt(3)];
    }
}

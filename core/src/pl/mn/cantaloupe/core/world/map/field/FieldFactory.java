package pl.mn.cantaloupe.core.world.map.field;

import pl.mn.cantaloupe.core.world.resource.ResourceType;

/**
 * @author asiazkrainyowiec
 */
public class FieldFactory {

    public static Field buildHomeField() {
        return new Field(ResourceType.random());
    }

    public static Field buildRegularField() {
        return new Field(ResourceType.random());
    }

    public static Field buildMainField() {
        return new Field(ResourceType.GOLD);
    }
}

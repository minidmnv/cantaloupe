package pl.mn.cantaloupe.core.world.map.field;

import pl.mn.cantaloupe.core.world.resource.ResourceType;

/**
 * @author asiazkrainyowiec
 */
public class FieldFactory {

    public static Field buildHomeField(int i) {
        return new Field(i, ResourceType.random());
    }

    public static Field buildRegularField(int i) {
	    return new Field(i, ResourceType.random());
    }

	public static Field buildMainField(int i) {
        return new Field(i, ResourceType.GOLD);
    }

}

package pl.mn.cantaloupe.core.world.map.field;

import pl.mn.cantaloupe.core.world.resource.ResourceType;

/**
 * @author asiazkrainyowiec
 */
public class FieldFactory {

    public static Field buildHomeField(int i) {
        return placeField(i, new Field(ResourceType.random()));
    }

    public static Field buildRegularField(int i) {
	    return placeField(i, new Field(ResourceType.random()));
    }

	public static Field buildMainField(int i) {
        return placeField(i, new Field(ResourceType.GOLD));
    }

	private static Field placeField(int i, Field field) {
		field.setX(50 + i  * 132);
		field.setY(50 + i * 83);
		return field;
	}
}

package pl.mn.cantaloupe.core.world.map.field;

import pl.mn.cantaloupe.core.world.CoreWorld;
import pl.mn.cantaloupe.core.world.resource.ResourceType;
import pl.mn.cantaloupe.util.DrawUtils;

import static pl.mn.cantaloupe.util.DrawUtils.*;

/**
 * @author asiazkrainyowiec
 */
public class FieldFactory {

    public static Field buildHomeField(int i) {
        return placeField(i, new Field(i, ResourceType.random()));
    }

    public static Field buildRegularField(int i) {
	    return placeField(i, new Field(i, ResourceType.random()));
    }

	public static Field buildMainField(int i) {
        return placeField(i, new Field(i, ResourceType.GOLD));
    }

	private static Field placeField(int i, Field field) {
        int y = i / 5;
        int xCount = isEven(y) ? 5 : 4;
        int xShift = MAP_X_SHIFT + (isEven(y) ? 0 : MAP_TILE_WIDTH);

        field.setX(xShift + (i % xCount) * MAP_TILE_WIDTH * 2);
        field.setY(MAP_Y_SHIFT + y * DrawUtils.MAP_TILE_HEIGHT);
        field.setZIndex(y);
		return field;
	}

    private static boolean isEven(int y) {
        return y % 2 == 0;
    }
}

package pl.mn.cantaloupe.core.world.map.field;

import static pl.mn.cantaloupe.util.DrawUtils.MAP_TILE_HEIGHT;
import static pl.mn.cantaloupe.util.DrawUtils.MAP_TILE_WIDTH;
import static pl.mn.cantaloupe.util.DrawUtils.MAP_X_SHIFT;
import static pl.mn.cantaloupe.util.DrawUtils.MAP_Y_SHIFT;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Batch;

import pl.mn.cantaloupe.core.world.map.Zone;
import pl.mn.cantaloupe.core.world.resource.ResourceType;
import pl.mn.cantaloupe.shared.stage.actor.CantaloupeActor;
import pl.mn.cantaloupe.util.DrawUtils;

/**
 * @author asiazkrainyowiec
 */
public class Field extends CantaloupeActor {

	private static final String TAG = Field.class.getSimpleName();

    private final List<Zone> zones;
    private final ResourceType resource;
    private final Integer fieldId;

    public Field(Integer fieldId, ResourceType resource) {
        this.resource = resource;
        this.zones = Zone.zones();
        this.fieldId = fieldId;
        addListener(new FieldTouchedListener());
    }

	@Override
	public String toString() {
		return "Field{" +
				"resource=" + resource +
				", fieldId=" + fieldId +
				", zIndex=" + getZIndex() +
				", coordinates=[" + getX() + ", " + getY() + "]" +
				'}';
	}

	@Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(resource.getTextureRegion(), getX() + MAP_TILE_WIDTH / 2, getY() + (DrawUtils.MAP_TILE_HEIGHT - 33) / 2);
        batch.draw(resource.getTextureRegion(), getX(), getY());
        batch.draw(resource.getTextureRegion(), getX() + MAP_TILE_WIDTH, getY());
        batch.draw(resource.getTextureRegion(), getX() + MAP_TILE_WIDTH / 2, getY() - (DrawUtils.MAP_TILE_HEIGHT - 33) / 2);
    }

	public void placeField() {

		int y = countY();
		int xCount = isEven(y) ? 5 : 4;
		int xShift = MAP_X_SHIFT + (isEven(y) ? 0 : MAP_TILE_WIDTH);

		this.setX(xShift + (fieldId % xCount) * MAP_TILE_WIDTH * 2);
		this.setY(MAP_Y_SHIFT + y * (DrawUtils.MAP_TILE_HEIGHT - 29));
		this.setZIndex(0);
		setBounds(getX(), getY() - (DrawUtils.MAP_TILE_HEIGHT - 33) / 2, MAP_TILE_WIDTH * 2, MAP_TILE_HEIGHT * 2);
	}

	private int countY() {
		int result = fieldId / 5;
		int addition = (result / 2) + result % 2;
		return result > 0 ? (fieldId + addition) / 5 : result;
	}

	private boolean isEven(int y) {
		return y % 2 == 0;
	}

}

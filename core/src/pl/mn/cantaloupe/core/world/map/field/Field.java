package pl.mn.cantaloupe.core.world.map.field;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;
import pl.mn.cantaloupe.core.world.map.Zone;
import pl.mn.cantaloupe.core.world.resource.ResourceType;
import pl.mn.cantaloupe.shared.stage.actor.CantaloupeActor;

import java.util.List;

import static pl.mn.cantaloupe.util.DrawUtils.*;

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
        addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				chosen();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
        setTouchable(Touchable.enabled);
    }

	private void chosen() {
		Gdx.app.log(TAG, String.format("%d Zostałem wybrany!", fieldId));
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
        batch.draw(resource.getTextureRegion(), getX() + MAP_TILE_WIDTH / 2, getY() + (MAP_TILE_HEIGHT * 1.5f) - 15 );
        batch.draw(resource.getTextureRegion(), getX(), getY() + MAP_TILE_HEIGHT);
        batch.draw(resource.getTextureRegion(), getX() + MAP_TILE_WIDTH, getY() + MAP_TILE_HEIGHT);
        batch.draw(resource.getTextureRegion(), getX() + MAP_TILE_WIDTH / 2, getY() + (MAP_TILE_HEIGHT / 2) + 16);
        super.draw(batch, parentAlpha);
    }

	public void placeField() {
		int y = countY();
		int xCount = isEven(y) ? 5 : 4;
		int xShift = MAP_X_SHIFT + (isEven(y) ? 0 : MAP_TILE_WIDTH);

		this.setX(xShift + (fieldId % xCount) * MAP_TILE_WIDTH * 2);
		this.setY(MAP_Y_SHIFT + y * (MAP_TILE_HEIGHT - 29));
		this.setZIndex(0);
		setBounds(getX(), getY(), MAP_TILE_WIDTH * 2, MAP_TILE_HEIGHT * 2);
	}

	private int countY() {
		int result = fieldId / 5;
		int addition = (result / 2) + result % 2;
		return result > 0 ? (fieldId + addition) / 5 : result;
	}

	private boolean isEven(int y) {
		return y % 2 == 0;
	}

	@Override
	public Actor hit(float x, float y, boolean touchable) {
    	Gdx.app.log(TAG,  "[" + x + ", " + y + "]");
		if (!isVisible() || !isTouchable()) {
			return null;
		}

		Array<Vector2> boundPolygonVertices = Array.of(Vector2.class);
		boundPolygonVertices.addAll(
				new Vector2(getX(), getY() + MAP_TILE_HEIGHT),
				new Vector2(getX() + MAP_TILE_WIDTH, getY()),
				new Vector2(getX() + MAP_TILE_WIDTH * 2, getY() + MAP_TILE_HEIGHT),
				new Vector2(getX() + MAP_TILE_WIDTH, getY() + MAP_TILE_HEIGHT * 2));

		if (Intersector.isPointInPolygon(boundPolygonVertices, new Vector2(x, y))) {
			Gdx.app.log(TAG, "Trafiony, zatopiony" + boundPolygonVertices.toString() + "[" + x + ", " + y + "]");
			return this;
		}

		return null;
	}
}

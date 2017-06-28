package pl.mn.cantaloupe.core.world.map.field;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.Array;
import pl.mn.cantaloupe.core.world.WorldStage;
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
    public final Integer fieldId;
    private boolean chosen = false;
	Array<Vector2> boundPolygonVertices;
    private Integer originZIndex;

    public Field(Integer fieldId, ResourceType resource) {
        this.resource = resource;
        this.zones = Zone.zones();
        this.fieldId = fieldId;
        addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				if (!chosen) {
					choose();
				} else {
					unChoose();
				}
				return super.touchDown(event, x, y, pointer, button);
			}
		});
        setTouchable(Touchable.enabled);
    }

	private void choose() {
		Gdx.app.log(TAG, String.format("%d Zostałem wybrany!", fieldId));
		setScale(5);
		originZIndex = getZIndex();
		setZIndex(Integer.MAX_VALUE);
		((WorldStage) getStage()).chooseField(fieldId);
		chosen = true;
	}

	public void unChoose() {
		Gdx.app.log(TAG, String.format("%d Zostałem odebrany :(:(:( !", fieldId));
		setScale(1);
		placeField();
		setZIndex(originZIndex);
		chosen = false;
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
        batch.draw(resource.getTextureRegion(), getX() + MAP_TILE_WIDTH / 2, getY() + (MAP_TILE_HEIGHT * 1.5f) - 15
				, getOriginX(), getOriginY(), getWidth() / 2, getHeight() / 2, getScaleX(), getScaleY(), getRotation());
        batch.draw(resource.getTextureRegion(), getX(), getY() + MAP_TILE_HEIGHT
				, getOriginX(), getOriginY(), getWidth() / 2, getHeight() / 2, getScaleX(), getScaleY(), getRotation());
        batch.draw(resource.getTextureRegion(), getX() + MAP_TILE_WIDTH, getY() + MAP_TILE_HEIGHT
				, getOriginX(), getOriginY(), getWidth() / 2, getHeight() / 2, getScaleX(), getScaleY(), getRotation());
        batch.draw(resource.getTextureRegion(), getX() + MAP_TILE_WIDTH / 2, getY() + (MAP_TILE_HEIGHT / 2) + 16
				, getOriginX(), getOriginY(), getWidth() / 2, getHeight() / 2, getScaleX(), getScaleY(), getRotation());
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

		boundPolygonVertices = getBoundPolygonVertices();
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
		Vector2 coordinates = localToParentCoordinates(new Vector2(x, y));
		if (!isVisible() || !isTouchable()) {
			return null;
		}

		if (Intersector.isPointInPolygon(boundPolygonVertices, new Vector2(coordinates.x, coordinates.y))) {
			return this;
		}

		return null;
	}

	private Array<Vector2> getBoundPolygonVertices() {
		Array<Vector2> boundPolygonVertices = Array.of(Vector2.class);
		boundPolygonVertices.addAll(
				new Vector2(getX(), getY() + MAP_TILE_HEIGHT),
				new Vector2(getX() + MAP_TILE_WIDTH, getY()),
				new Vector2(getX() + MAP_TILE_WIDTH * 2, getY() + MAP_TILE_HEIGHT),
				new Vector2(getX() + MAP_TILE_WIDTH, getY() + MAP_TILE_HEIGHT * 2));
		return boundPolygonVertices;
	}
}

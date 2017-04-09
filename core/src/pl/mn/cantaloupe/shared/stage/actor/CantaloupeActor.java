package pl.mn.cantaloupe.shared.stage.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author asiazkrainyowiec
 */
public class CantaloupeActor extends Actor {

	protected TextureRegion texture;

	protected ShapeRenderer shapes = new ShapeRenderer();

	@Override
	public void draw(Batch batch, float parentAlpha) {
		shapes.setProjectionMatrix(batch.getProjectionMatrix());
		shapes.setAutoShapeType(true);
		shapes.begin();
		drawDebug(shapes);
		shapes.end();
	}
}

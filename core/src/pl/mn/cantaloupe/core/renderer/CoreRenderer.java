package pl.mn.cantaloupe.core.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import pl.mn.cantaloupe.core.world.CoreWorld;

/**
 * @author mnicinski
 */
public class CoreRenderer {

	private final OrthographicCamera coreCamera;
	private CoreWorld world;
	private SpriteBatch batcher;
	private ShapeRenderer shapeRenderer;

	public CoreRenderer(CoreWorld world, OrthographicCamera coreCamera) {
		this.world = world;
		this.coreCamera = coreCamera;

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(coreCamera.combined);

		batcher = new SpriteBatch();
	}

	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batcher.begin();
		batcher.setProjectionMatrix(coreCamera.combined);
		world.getStage()
				.getActors()
				.forEach(actor -> actor.draw(batcher, 1));
		batcher.end();
	}
}

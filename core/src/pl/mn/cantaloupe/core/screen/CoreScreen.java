package pl.mn.cantaloupe.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

import pl.mn.cantaloupe.core.renderer.CoreRenderer;
import pl.mn.cantaloupe.core.world.CoreWorld;

/**
 * @author mnicinski
 */
public class CoreScreen extends ScreenAdapter implements GestureListener, InputProcessor {

	public static final int VIEWPORT_WIDTH = 2560;
	public static final int VIEWPORT_HEIGHT = 1600;

	private CoreWorld world;
	private CoreRenderer renderer;
	private OrthographicCamera coreCamera;

	public CoreScreen() {
		coreCamera = new OrthographicCamera();
		coreCamera.setToOrtho(true, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);

		world = new CoreWorld();
		Gdx.input.setInputProcessor(this);
		renderer = new CoreRenderer(world, coreCamera);
	}

	@Override
	public void render(float delta) {
		world.update(delta);
		renderer.render();
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {

		}

		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}

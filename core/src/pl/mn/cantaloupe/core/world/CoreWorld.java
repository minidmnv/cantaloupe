package pl.mn.cantaloupe.core.world;

import java.util.Random;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * @author mnicinski
 */
public class CoreWorld {

	private Stage stage;

	private Random random = new Random();

	public CoreWorld(OrthographicCamera coreCamera) {
		init();
	}

	private void init() {
		stage = new Stage();
	}

	public Stage getStage() {
		return stage;
	}

	public void update(float delta) {
		stage.getActors()
				.forEach(actor -> actor.act(delta));
	}

}

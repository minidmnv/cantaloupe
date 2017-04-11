package pl.mn.cantaloupe.core.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

import pl.mn.cantaloupe.core.screen.CoreScreen;
import pl.mn.cantaloupe.core.world.map.GameMap;
import pl.mn.cantaloupe.core.world.map.field.Field;
import pl.mn.cantaloupe.core.world.map.field.FieldFactory;
import pl.mn.cantaloupe.core.world.map.field.FieldTouchedListener;
import pl.mn.cantaloupe.core.world.player.Player;

import static pl.mn.cantaloupe.core.screen.CoreScreen.VIEWPORT_HEIGHT;
import static pl.mn.cantaloupe.core.screen.CoreScreen.VIEWPORT_WIDTH;

/**
 * @author mnicinski
 */
public class CoreWorld {

    private static final String TAG = CoreWorld.class.getSimpleName();

    public static final int NUMBER_OF_FIELDS = 41 - 1;
    public static final int MAIN_FIELD_NUMBER = 23 - 1;

    private Stage stage;
	private GameMap gameMap;
	private List<Player> players = new ArrayList();

	private Random random = new Random();

	public CoreWorld(OrthographicCamera coreCamera) {
		init(coreCamera);
	}

	private void init(OrthographicCamera coreCamera) {
		stage = new Stage(new FitViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, coreCamera));
		stage.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.log(TAG, String.format("%f, %f stage", x, y));
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		generateMap();

		raportInit();
	}

    private void raportInit() {
	    Gdx.app.log(TAG, "Wygenerowane pola:");
	    IntStream.rangeClosed(0, NUMBER_OF_FIELDS)
                .mapToObj(fieldId -> fieldId + " " + gameMap.getField(fieldId).toString())
                .forEach(fieldText -> Gdx.app.log(TAG, fieldText));
    }

    private void generateMap() {
		gameMap = new GameMap();
		gameMap.setFields(generateFields());
		gameMap.getFields().forEach(stage::addActor);
		gameMap.getFields().forEach(Field::placeField);
	}

	private List generateFields() {
        return IntStream.rangeClosed(0, NUMBER_OF_FIELDS)
                .mapToObj(this::constructField).collect(Collectors.toList());
	}

    private Field constructField(int i) {
	    Field field;

        if (players.stream().anyMatch(player -> player.getHomeFieldNumber().equals(i))) {
            field = FieldFactory.buildHomeField(i);
        } else if(i == MAIN_FIELD_NUMBER) {
            field = FieldFactory.buildMainField(i);
        } else {
            field = FieldFactory.buildRegularField(i);
        }

        return field;
	}

    public Stage getStage() {
		return stage;
	}

	public void update(float delta) {
		stage.getActors()
				.forEach(actor -> actor.act(delta));
	}

}

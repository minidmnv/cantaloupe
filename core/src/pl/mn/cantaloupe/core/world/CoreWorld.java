package pl.mn.cantaloupe.core.world;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import pl.mn.cantaloupe.core.world.map.field.Field;
import pl.mn.cantaloupe.core.world.map.GameMap;
import pl.mn.cantaloupe.core.world.map.field.FieldFactory;
import pl.mn.cantaloupe.core.world.player.Player;

/**
 * @author mnicinski
 */
public class CoreWorld {

    private static final String TAG = CoreWorld.class.getSimpleName();

    private static final int NUMBER_OF_FIELDS = 45 - 1;
    private static final int MAIN_FIELD_NUMBER = 23 - 1;

    private Stage stage;
	private GameMap gameMap;
	private List<Player> players = new ArrayList();

	private Random random = new Random();

	public CoreWorld() {
		init();
	}

	private void init() {
		stage = new Stage();
		generateMap();

		raportInit();
	}

    private void raportInit() {
	    Gdx.app.log(TAG, "Wygenerowane pola:");
	    IntStream.rangeClosed(0, NUMBER_OF_FIELDS)
                .mapToObj(fieldId -> fieldId + " " + gameMap.getField(fieldId).toString())
                .forEach(field -> Gdx.app.log(TAG, field));
    }

    private void generateMap() {
		gameMap = new GameMap();
		gameMap.setFields(generateFields());
		gameMap.getFields().forEach(stage::addActor);
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

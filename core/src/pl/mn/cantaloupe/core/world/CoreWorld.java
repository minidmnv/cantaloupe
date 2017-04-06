package pl.mn.cantaloupe.core.world;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.badlogic.gdx.scenes.scene2d.Stage;
import pl.mn.cantaloupe.core.world.map.field.Field;
import pl.mn.cantaloupe.core.world.map.GameMap;
import pl.mn.cantaloupe.core.world.player.Player;

/**
 * @author mnicinski
 */
public class CoreWorld {


    private static final int NUMBER_OF_FIELDS = 18;
    private final List<Integer> HOME_FIELD_NUMBERS = Arrays.asList();
    private Stage stage;
	private GameMap gameMap;
	private List<Player> players;

	private Random random = new Random();

	public CoreWorld() {
		init();
	}

	private void init() {
		stage = new Stage();
		generateMap();
	}

	private void generateMap() {
		GameMap gameMap = new GameMap();
		gameMap.setFields(generateFields());
	}

	private List generateFields() {
        return IntStream.of(NUMBER_OF_FIELDS).mapToObj(this::constructField).collect(Collectors.toList());
	}

    private Field constructField(int i) {
        if (players.stream().anyMatch(player -> player.homeFieldNumber.equals(i))) {
        }
	}

    public Stage getStage() {
		return stage;
	}

	public void update(float delta) {
		stage.getActors()
				.forEach(actor -> actor.act(delta));
	}

}

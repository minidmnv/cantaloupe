package pl.mn.cantaloupe.core.world.player;

import com.badlogic.gdx.graphics.Color;

/**
 * @author asiazkrainyowiec
 */
public class Player {

    private final Color color;
    private final String name;
    private final PlayerType type;
    private final Integer homeFieldNumber;

    public Player(Color color, String name, PlayerType type, Integer homeFieldNumber) {
        this.color = color;
        this.name = name;
        this.type = type;
        this.homeFieldNumber = homeFieldNumber;
    }

    public Integer getHomeFieldNumber() {
        return homeFieldNumber;
    }

}

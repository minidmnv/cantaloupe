package pl.mn.cantaloupe.core.world.map;

import pl.mn.cantaloupe.core.world.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author asiazkrainyowiec
 */
public class Zone {

    private final ZonePlacement placement;
    private Player currentOwner;
    private short numberOfOwningRounds;

    private Zone(ZonePlacement placement) {
        this.placement = placement;
    }

    public static List<Zone> zones() {
        return Arrays.stream(ZonePlacement.values()).map(Zone::new).collect(Collectors.toList());
    }
}

package pl.mn.cantaloupe.core.world.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pl.mn.cantaloupe.core.world.player.Player;
import pl.mn.cantaloupe.shared.stage.actor.CantaloupeActor;

/**
 * @author asiazkrainyowiec
 */
public class Zone extends CantaloupeActor {

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

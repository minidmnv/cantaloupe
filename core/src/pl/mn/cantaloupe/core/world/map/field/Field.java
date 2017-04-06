package pl.mn.cantaloupe.core.world.map.field;

import pl.mn.cantaloupe.core.world.map.Zone;
import pl.mn.cantaloupe.core.world.resource.ResourceType;

import java.util.List;

/**
 * @author asiazkrainyowiec
 */
public class Field {

    private final List<Zone> zones;
    private final ResourceType resource;

    public Field(ResourceType resource) {
        this.resource = resource;
        this.zones = Zone.zones();
    }
}

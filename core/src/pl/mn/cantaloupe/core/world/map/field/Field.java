package pl.mn.cantaloupe.core.world.map.field;

import java.util.List;

import pl.mn.cantaloupe.core.world.map.Zone;
import pl.mn.cantaloupe.core.world.resource.ResourceType;
import pl.mn.cantaloupe.shared.stage.actor.CantaloupeActor;

/**
 * @author asiazkrainyowiec
 */
public class Field extends CantaloupeActor {

    private final List<Zone> zones;
    private final ResourceType resource;

    public Field(ResourceType resource) {
        this.resource = resource;
        this.zones = Zone.zones();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Field{");
        sb.append("resource=").append(resource);
        sb.append('}');
        return sb.toString();
    }
}

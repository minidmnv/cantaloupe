package pl.mn.cantaloupe.core.world.map.field;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Batch;
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

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(resource.getTextureRegion(), getX() + 132 / 2, getY() + 80 / 2);
        batch.draw(resource.getTextureRegion(), getX(), getY());
        batch.draw(resource.getTextureRegion(), getX() + 132, getY());
        batch.draw(resource.getTextureRegion(), getX() + 132 / 2, getY() - 80 / 2);
    }
}

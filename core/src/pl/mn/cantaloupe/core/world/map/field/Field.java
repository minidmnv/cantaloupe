package pl.mn.cantaloupe.core.world.map.field;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Batch;
import pl.mn.cantaloupe.core.world.map.Zone;
import pl.mn.cantaloupe.core.world.resource.ResourceType;
import pl.mn.cantaloupe.shared.stage.actor.CantaloupeActor;
import pl.mn.cantaloupe.util.DrawUtils;

import static pl.mn.cantaloupe.util.DrawUtils.MAP_TILE_WIDTH;

/**
 * @author asiazkrainyowiec
 */
public class Field extends CantaloupeActor {

    private final List<Zone> zones;
    private final ResourceType resource;
    private final Integer fieldId;

    public Field(Integer fieldId, ResourceType resource) {
        this.resource = resource;
        this.zones = Zone.zones();
        this.fieldId = fieldId;
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
        batch.draw(resource.getTextureRegion(), getX() + MAP_TILE_WIDTH / 2, getY() + (DrawUtils.MAP_TILE_HEIGHT - 27) / 2);
        batch.draw(resource.getTextureRegion(), getX(), getY());
        batch.draw(resource.getTextureRegion(), getX() + MAP_TILE_WIDTH, getY());
        batch.draw(resource.getTextureRegion(), getX() + MAP_TILE_WIDTH / 2, getY() - (DrawUtils.MAP_TILE_HEIGHT - 27) / 2);
    }
}

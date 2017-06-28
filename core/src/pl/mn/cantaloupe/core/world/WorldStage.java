package pl.mn.cantaloupe.core.world;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * @author minidmnv
 */
public class WorldStage extends Stage {

    private final CoreWorld world;

    public WorldStage(CoreWorld world, FitViewport fitViewport) {
        super(fitViewport);
        this.world = world;
    }

    public void chooseField(Integer fieldId) {
        world.chooseField(fieldId);
    }
}

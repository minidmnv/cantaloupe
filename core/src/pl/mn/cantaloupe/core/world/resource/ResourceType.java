package pl.mn.cantaloupe.core.world.resource;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import pl.mn.cantaloupe.util.Assets;

import java.util.Random;

/**
 * @author asiazkrainyowiec
 */
public enum ResourceType {
    WOOD(Assets.instance.field.wood),
    WATER(Assets.instance.field.water),
    STONE(Assets.instance.field.stone),
    GOLD(Assets.instance.field.gold);

    private static final Random rand = new Random();
    private Texture texture;


    ResourceType(Texture textureRegion) {
        this.texture = textureRegion;
    }

    public static ResourceType random() {
        return values()[rand.nextInt(3)];
    }

    public TextureRegion getTextureRegion() {
        return new TextureRegion(texture);
    }

}

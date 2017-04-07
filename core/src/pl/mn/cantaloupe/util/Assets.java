package pl.mn.cantaloupe.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;
import sun.font.TextRecord;

/**
 * @author minidmnv
 */
public class Assets implements Disposable, AssetErrorListener {

    public static final Assets instance = new Assets();
    private static final String TAG = Assets.class.getName();
    private static final String FIELD_WOOD_TEXTURE_NAME = "wood.png";
    private static final String FIELD_WATER_TEXTURE_NAME = "water.png";
    private static final String FIELD_STONE_TEXTURE_NAME = "stone.png";
    private static final String FIELD_GOLD_TEXTURE_NAME = "gold.png";
    private static final String FIELDS_DIR = "landscapetiles";

    private AssetManager manager;

    public Font font;
    public Field field;

    private Assets() {
        init(new AssetManager());
    }

    private void init(AssetManager manager) {
        this.manager = manager;
        manager.setErrorListener(this);

        manager.load("default.fnt", BitmapFont.class);

        manager.load(FIELDS_DIR + "/" + FIELD_WOOD_TEXTURE_NAME, Texture.class);
        manager.load(FIELDS_DIR + "/" + FIELD_WATER_TEXTURE_NAME, Texture.class);
        manager.load(FIELDS_DIR + "/" + FIELD_STONE_TEXTURE_NAME, Texture.class);
        manager.load(FIELDS_DIR + "/" + FIELD_GOLD_TEXTURE_NAME, Texture.class);

        manager.finishLoading();

        font = new Font();
        field = new Field();
    }

    public class Font {

        public BitmapFont smallFont;

        public Font() {
            smallFont = manager.get("default.fnt", BitmapFont.class);
            smallFont.getData().setScale(3, 3);
        }
    }


    public class Field {

        public Texture wood;
        public Texture water;
        public Texture stone;
        public Texture gold;

        public Field() {
            wood = manager.get(FIELDS_DIR + "/" + FIELD_WOOD_TEXTURE_NAME, Texture.class);
            water = manager.get(FIELDS_DIR + "/" + FIELD_WATER_TEXTURE_NAME, Texture.class);
            stone = manager.get(FIELDS_DIR + "/" + FIELD_STONE_TEXTURE_NAME, Texture.class);
            gold = manager.get(FIELDS_DIR + "/" + FIELD_GOLD_TEXTURE_NAME, Texture.class);
        }

    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Error with loading asset " + asset.fileName);
    }

    @Override
    public void dispose() {

    }
}

package pl.mn.cantaloupe.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;

/**
 * @author minidmnv
 */
public class Assets implements Disposable, AssetErrorListener {

    public static final Assets instance = new Assets();
    private static final String TAG = Assets.class.getName();

    private AssetManager manager;

    public Font font;

    private Assets() {
        init(new AssetManager());
    }

    private void init(AssetManager manager) {
        this.manager = manager;
        manager.setErrorListener(this);

        manager.load("default.fnt", BitmapFont.class);

        manager.finishLoading();

        font = new Font();
    }

    public class Font {

        public BitmapFont smallFont;

        public Font() {
            smallFont = manager.get("default.fnt", BitmapFont.class);
            smallFont.getData().setScale(3, -3);
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

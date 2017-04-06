package pl.mn.cantaloupe;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pl.mn.cantaloupe.core.screen.CoreScreen;

public class CantaloupeGame extends Game {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		setScreen(new CoreScreen());
	}

}

package pl.mn.cantaloupe.core.world.map.field;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * @author mnicinski
 */
public class FieldTouchedListener extends InputListener {

	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
		Gdx.app.log("Field", String.format("[%f, %f] %s : dotknięty!", x, y, button));
		return super.touchDown(event, x, y, pointer, button);
	}

	@Override
	public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
		Gdx.app.log("Field", String.format("[%f, %f] %s : najechany!", x, y, fromActor.toString()));
		super.enter(event, x, y, pointer, fromActor);
	}
}

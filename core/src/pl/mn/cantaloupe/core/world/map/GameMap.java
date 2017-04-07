package pl.mn.cantaloupe.core.world.map;

import java.util.List;

import pl.mn.cantaloupe.core.world.map.field.Field;

/**
 * @author asiazkrainyowiec
 */
public class GameMap {

    private List<Field> fields;

    public void setFields(List fields) {
        this.fields = fields;
    }

    public Field getField(Integer fieldId) {
        return fields.get(fieldId);
    }

	public List<Field> getFields() {
		return fields;
	}
}

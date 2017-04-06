package pl.mn.cantaloupe.core.world.map;

import pl.mn.cantaloupe.core.world.map.field.Field;

import java.util.List;

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
}

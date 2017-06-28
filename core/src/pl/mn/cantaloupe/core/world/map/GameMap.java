package pl.mn.cantaloupe.core.world.map;

import java.util.Comparator;
import java.util.List;

import pl.mn.cantaloupe.core.world.map.field.Field;

/**
 * @author asiazkrainyowiec
 */
public class GameMap {

    private List<Field> fields;
    private Integer currentChosenFieldId = null;

    public void setFields(List fields) {
        this.fields = fields;
    }

    public Field getField(Integer fieldId) {
        return fields.get(fieldId);
    }

	public List<Field> getFields() {
		return fields;
	}

    public void chooseField(Integer fieldId) {
        if (currentChosenFieldId != null
                && !fieldId.equals(currentChosenFieldId)) {
            fields.stream()
                    .filter(field -> field.fieldId.equals(currentChosenFieldId))
                    .findFirst().ifPresent(Field::unChoose);
        }
        currentChosenFieldId = fieldId;
    }
}

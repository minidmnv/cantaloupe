package pl.mn.cantaloupe.core.world.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mn.cantaloupe.core.world.map.field.Field;
import pl.mn.cantaloupe.core.world.resource.ResourceType;

import java.util.Arrays;

/**
 * @author minidmnv
 */
class GameMapTest {

    private final GameMap MAP = new GameMap();

    @BeforeEach
    public void setUp() {
        MAP.setFields(Arrays.asList(createWoodField(), createStoneField()));
    }

    @Test
    void getField() {
        Assertions.assertEquals(createWoodField(), MAP.getField(1));
    }

    @Test
    void getFields() {
    }

    @Test
    void chooseField() {
    }

    private Field createStoneField() {
        return new Field(2, ResourceType.STONE);
    }

    private Field createWoodField() {
        return new Field(1, ResourceType.WOOD);
    }

}
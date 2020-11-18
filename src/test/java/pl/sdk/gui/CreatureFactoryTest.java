package pl.sdk.gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatureFactoryTest {

    @Test
    void shouldCreateBehemoth(){
        String behemoth = "Behemoth";
        Creature beh = CreatureFactory.create(behemoth);

        assertEquals(behemoth, beh.getName());
    }

    @Test
    void shouldCreateAirElemental(){
        String airElemental = "Air Elemental";
        Creature beh = CreatureFactory.create(airElemental);

        assertEquals(airElemental, beh.getName());
    }
}

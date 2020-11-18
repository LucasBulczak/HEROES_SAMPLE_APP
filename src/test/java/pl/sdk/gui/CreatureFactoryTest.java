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
        String airElementalName = "Air Elemental";
        Creature airElemental = CreatureFactory.create(airElementalName);

        assertEquals(airElementalName, airElemental.getName());
    }
}

package pl.sdk.gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BehemothTest {

    @Test
    void behemothShouldIgnore80PercentOfDefence() {
        //given
        Creature behemoth = new Creature(100,200, 100, "Behemoth",1, 1, new ReduceArmorPercentageCalculateStrategy(80));
        Creature defender = new Creature(1000,100, 100, "Defender",11, 1);
        //when
        behemoth.attack(defender);
        //then
        assertEquals(820, defender.getCurrentHp());
    }
}

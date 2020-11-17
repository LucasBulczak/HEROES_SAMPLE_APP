package pl.sdk.gui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementalCreatureTest {

    @DisplayName("Water attacks Fire")
    @Test
    void waterElementalShouldAttackFireElementalWithDoubledDamage() {
        //given
        Creature waterElemental = new Creature(1,5, 1, "Water Elemental",1, 1);
        Creature fireElemental = new Creature(1,4, 1, "Fire Elemental",1, 10);
        //when
        waterElemental.attack(fireElemental);
        //then
        assertEquals(2, fireElemental.getAmount());
    }

    @DisplayName("Fire counter attacks Water")
    @Test
    void fireElementalShouldCounterAttacksWaterElementalWithHalfOfDamage() {
        //given
        Creature waterElemental = new Creature(1,5, 1, "Water Elemental",1, 1);
        Creature fireElemental = new Creature(1,4, 1, "Fire Elemental",1, 10);
        //when
        waterElemental.attack(fireElemental);
        //then
        assertEquals(-2, waterElemental.getAmount());
    }

    @DisplayName("Water attacks Earth")
    @Test
    void waterElementalShouldAttackEarthElementalWithHalfOfdDamage() {
        //given
        Creature waterElemental = new Creature(1,4, 1, "Water Elemental",1, 1);
        Creature earthElemental = new Creature(1,1, 1, "Earth Elemental",1, 2);
        //when
        waterElemental.attack(earthElemental);
        //then
        assertEquals(0, earthElemental.getAmount());
    }

    @DisplayName("Earth counter attacks Water")
    @Test
    void earthElementalShouldCounterAttacksWaterElementalWithDoubledDamage() {
        //given
        Creature waterElemental = new Creature(1,4, 1, "Water Elemental",1, 1);
        Creature earthElemental = new Creature(1,1, 1, "Earth Elemental",1, 2);
        //when
        waterElemental.attack(earthElemental);
        //then
        assertEquals(1, waterElemental.getAmount());
    }

    @DisplayName("Fire attacks Air")
    @Test
    void fireElementalShouldAttackAirElementalWithDoubledDamage() {
        //given
        Creature fireElemental = new Creature(1,5, 1, "Fire Elemental",1, 1);
        Creature airElemental = new Creature(1,4, 1, "Air Elemental",1, 10);
        //when
        fireElemental.attack(airElemental);
        //then
        assertEquals(2, airElemental.getAmount());
    }

    @DisplayName("Air counter attacks Fire")
    @Test
    void airElementalShouldCounterAttacksFireElementalWithHalfOfDamage() {
        //given
        Creature fireElemental = new Creature(1,5, 1, "Fire Elemental",1, 1);
        Creature airElemental = new Creature(1,4, 1, "Air Elemental",1, 10);
        //when
        fireElemental.attack(airElemental);
        //then
        assertEquals(-2, fireElemental.getAmount());
    }

    @DisplayName("Fire attacks Water")
    @Test
    void fireElementalShouldAttackWaterElementalWithHalfOfdDamage() {
        //given
        Creature fireElemental = new Creature(1,4, 1, "Fire Elemental",1, 1);
        Creature waterElemental = new Creature(1,1, 1, "Water Elemental",1, 2);
        //when
        fireElemental.attack(waterElemental);
        //then
        assertEquals(0, waterElemental.getAmount());
    }

    @DisplayName("Water counter attacks Fire")
    @Test
    void waterElementalShouldCounterAttacksFireElementalWithDoubledDamage() {
        //given
        Creature fireElemental = new Creature(1,4, 1, "Fire Elemental",1, 1);
        Creature waterElemental = new Creature(1,1, 1, "Water Elemental",1, 2);
        //when
        fireElemental.attack(waterElemental);
        //then
        assertEquals(1, fireElemental.getAmount());
    }

    @DisplayName("Air attacks Earth")
    @Test
    void airElementalShouldAttackEarthElementalWithDoubledDamage() {
        //given
        Creature airElemental = new Creature(1,5, 1, "Air Elemental",1, 1);
        Creature earthElemental = new Creature(1,4, 1, "Earth Elemental",1, 10);
        //when
        airElemental.attack(earthElemental);
        //then
        assertEquals(2, earthElemental.getAmount());
    }

    @DisplayName("Earth counter attacks Air")
    @Test
    void earthElementalShouldCounterAttacksAirElementalWithHalfOfDamage() {
        //given
        Creature airElemental = new Creature(1,5, 1, "Air Elemental",1, 1);
        Creature earthElemental = new Creature(1,4, 1, "Earth Elemental",1, 10);
        //when
        airElemental.attack(earthElemental);
        //then
        assertEquals(-2, airElemental.getAmount());
    }

    @DisplayName("Air attacks Fire")
    @Test
    void airElementalShouldAttackFireElementalWithHalfOfdDamage() {
        //given
        Creature airElemental = new Creature(1,4, 1, "Air Elemental",1, 1);
        Creature fireElemental = new Creature(1,1, 1, "Fire Elemental",1, 2);
        //when
        airElemental.attack(fireElemental);
        //then
        assertEquals(0, fireElemental.getAmount());
    }

    @DisplayName("Fire counter attacks Air")
    @Test
    void fireElementalShouldCounterAttacksAirElementalWithDoubledDamage() {
        //given
        Creature airElemental = new Creature(1,4, 1, "Air Elemental",1, 1);
        Creature fireElemental = new Creature(1,1, 1, "Fire Elemental",1, 2);
        //when
        airElemental.attack(fireElemental);
        //then
        assertEquals(1, airElemental.getAmount());
    }

    @DisplayName("Earth attacks Water")
    @Test
    void earthElementalShouldAttackWaterElementalWithDoubledDamage() {
        //given
        Creature earthElemental = new Creature(1,5, 1, "Earth Elemental",1, 1);
        Creature waterElemental = new Creature(1,4, 1, "Water Elemental",1, 10);
        //when
        earthElemental.attack(waterElemental);
        //then
        assertEquals(2, waterElemental.getAmount());
    }

    @DisplayName("Water counter attacks Earth")
    @Test
    void waterElementalShouldCounterAttacksEarthElementalWithHalfOfDamage() {
        //given
        Creature earthElemental = new Creature(1,5, 1, "Earth Elemental",1, 1);
        Creature waterElemental = new Creature(1,4, 1, "Water Elemental",1, 10);
        //when
        earthElemental.attack(waterElemental);
        //then
        assertEquals(-2, earthElemental.getAmount());
    }

    @DisplayName("Earth attacks Air")
    @Test
    void earthElementalShouldAttackAirElementalWithHalfOfdDamage() {
        //given
        Creature earthElemental = new Creature(1,4, 1, "Earth Elemental",1, 1);
        Creature airElemental = new Creature(1,1, 1, "Air Elemental",1, 2);
        //when
        earthElemental.attack(airElemental);
        //then
        assertEquals(0, airElemental.getAmount());
    }

    @DisplayName("Air counter attacks Earth")
    @Test
    void airElementalShouldCounterAttacksEarthElementalWithDoubledDamage() {
        //given
        Creature earthElemental = new Creature(1,4, 1, "Earth Elemental",1, 1);
        Creature airElemental = new Creature(1,1, 1, "Air Elemental",1, 2);
        //when
        earthElemental.attack(airElemental);
        //then
        assertEquals(1, earthElemental.getAmount());
    }
}

package pl.sdk.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementalCreatureTest {
    private Creature waterElemental;
    private Creature fireElemental;
    private Creature earthElemental;
    private Creature airElemental;

    @BeforeEach
    void setUp() {
        waterElemental = new Creature(100, 30, 5, "Water Elemental", 7, 5, new ElementalCalculateStrategy());
        fireElemental = new Creature(100, 30, 5, "Fire Elemental", 7, 5, new ElementalCalculateStrategy());
        earthElemental = new Creature(100, 30, 5, "Earth Elemental", 7, 5, new ElementalCalculateStrategy());
        airElemental = new Creature(100, 30, 5, "Air Elemental", 7, 5, new ElementalCalculateStrategy());

    }

    @DisplayName("Water attacks Fire")
    @Test
    void waterElementalShouldAttackFireElementalWithDoubledDamage() {
        //when
        waterElemental.attack(fireElemental);
        //then
        assertEquals(50, fireElemental.getCurrentHp());
        assertEquals(3, fireElemental.getAmount());
    }

    @DisplayName("Fire counter attacks Water")
    @Test
    void fireElementalShouldCounterAttacksWaterElementalWithHalfOfDamage() {
        //when
        waterElemental.attack(fireElemental);
        //then
        assertEquals(62, waterElemental.getCurrentHp());
        assertEquals(5, waterElemental.getAmount());
    }

    @DisplayName("Water attacks Earth")
    @Test
    void waterElementalShouldAttackEarthElementalWithHalfOfdDamage() {
        //when
        waterElemental.attack(earthElemental);
        //then
        assertEquals(37, earthElemental.getCurrentHp());
        assertEquals(5, earthElemental.getAmount());
    }

    @DisplayName("Earth counter attacks Water")
    @Test
    void earthElementalShouldCounterAttacksWaterElementalWithDoubledDamage() {
        //when
        waterElemental.attack(earthElemental);
        //then
        assertEquals(50, waterElemental.getCurrentHp());
        assertEquals(3, waterElemental.getAmount());
    }

    @DisplayName("Fire attacks Air")
    @Test
    void fireElementalShouldAttackAirElementalWithDoubledDamage() {
        //when
        fireElemental.attack(airElemental);
        //then
        assertEquals(50, airElemental.getCurrentHp());
        assertEquals(3, airElemental.getAmount());
    }

    @DisplayName("Air counter attacks Fire")
    @Test
    void airElementalShouldCounterAttacksFireElementalWithHalfOfDamage() {
        //when
        fireElemental.attack(airElemental);
        //then
        assertEquals(62, fireElemental.getCurrentHp());
        assertEquals(5, fireElemental.getAmount());
    }

    @DisplayName("Fire attacks Water")
    @Test
    void fireElementalShouldAttackWaterElementalWithHalfOfdDamage() {
        //when
        fireElemental.attack(waterElemental);
        //then
        assertEquals(37, waterElemental.getCurrentHp());
        assertEquals(5, waterElemental.getAmount());
    }

    @DisplayName("Water counter attacks Fire")
    @Test
    void waterElementalShouldCounterAttacksFireElementalWithDoubledDamage() {
        //when
        fireElemental.attack(waterElemental);
        //then
        assertEquals(50, fireElemental.getCurrentHp());
        assertEquals(3, fireElemental.getAmount());
    }

    @DisplayName("Air attacks Earth")
    @Test
    void airElementalShouldAttackEarthElementalWithDoubledDamage() {
        //when
        airElemental.attack(earthElemental);
        //then
        assertEquals(50, earthElemental.getCurrentHp());
        assertEquals(3, earthElemental.getAmount());
    }

    @DisplayName("Earth counter attacks Air")
    @Test
    void earthElementalShouldCounterAttacksAirElementalWithHalfOfDamage() {
        //when
        airElemental.attack(earthElemental);
        //then
        assertEquals(62, airElemental.getCurrentHp());
        assertEquals(5, airElemental.getAmount());
    }

    @DisplayName("Air attacks Fire")
    @Test
    void airElementalShouldAttackFireElementalWithHalfOfdDamage() {
        //when
        airElemental.attack(fireElemental);
        //then
        assertEquals(37, fireElemental.getCurrentHp());
        assertEquals(5, fireElemental.getAmount());
    }

    @DisplayName("Fire counter attacks Air")
    @Test
    void fireElementalShouldCounterAttacksAirElementalWithDoubledDamage() {
        //when
        airElemental.attack(fireElemental);
        //then
        assertEquals(50, airElemental.getCurrentHp());
        assertEquals(3, airElemental.getAmount());
    }

    @DisplayName("Earth attacks Water")
    @Test
    void earthElementalShouldAttackWaterElementalWithDoubledDamage() {
        //when
        earthElemental.attack(waterElemental);
        //then
        assertEquals(50, waterElemental.getCurrentHp());
        assertEquals(3, waterElemental.getAmount());
    }

    @DisplayName("Water counter attacks Earth")
    @Test
    void waterElementalShouldCounterAttacksEarthElementalWithHalfOfDamage() {
        //when
        earthElemental.attack(waterElemental);
        //then
        assertEquals(62, earthElemental.getCurrentHp());
        assertEquals(5, earthElemental.getAmount());
    }

    @DisplayName("Earth attacks Air")
    @Test
    void earthElementalShouldAttackAirElementalWithHalfOfdDamage() {
        //when
        earthElemental.attack(airElemental);
        //then
        assertEquals(37, airElemental.getCurrentHp());
        assertEquals(5, airElemental.getAmount());
    }

    @DisplayName("Air counter attacks Earth")
    @Test
    void airElementalShouldCounterAttacksEarthElementalWithDoubledDamage() {
        //when
        earthElemental.attack(airElemental);
        //then
        assertEquals(50, earthElemental.getCurrentHp());
        assertEquals(3, earthElemental.getAmount());
    }
}

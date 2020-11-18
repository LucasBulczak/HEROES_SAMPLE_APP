package pl.sdk.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementalCreatureTest {

    private Creature airElemental;
    private Creature waterElemental;
    private Creature earthElemental;
    private Creature fireElemental;

    @BeforeEach
    void initElemental() {
        airElemental = new Creature(100, 30, 5, "Air Elemental", 7, 5, new ElementalCalculateStrategy());
        waterElemental = new Creature(100, 30, 5, "Water Elemental", 7, 5, new ElementalCalculateStrategy());
        earthElemental = new Creature(100, 30, 5, "Earth Elemental", 7, 5, new ElementalCalculateStrategy());
        fireElemental = new Creature(100, 30, 5, "Fire Elemental", 7, 5, new ElementalCalculateStrategy());
    }

    @DisplayName("Air attacks Earth")
    @Test
    void airElementalShouldAttackEarthElementalWithDoubledDamage() {
        //when
        airElemental.attack(earthElemental);
        //then
        assertEquals(50, earthElemental.getCurrentHp());
        assertEquals(3, earthElemental.getAmount());

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

        assertEquals(50, airElemental.getCurrentHp());
        assertEquals(3, airElemental.getAmount());
    }

    @DisplayName("Air attacks Water")
    @Test
    void airElementalShouldNotChangeDamageForWaterElemental() {
        airElemental.attack(waterElemental);
        assertEquals(75, waterElemental.getCurrentHp());
        assertEquals(4, waterElemental.getAmount());

        assertEquals(100, airElemental.getCurrentHp());
        assertEquals(4, airElemental.getAmount());
    }

    @DisplayName("Earth attacks Water")
    @Test
    void earthElementalShouldAttackWaterElementalWithDoubledDamage() {
        //when
        earthElemental.attack(waterElemental);
        //then
        assertEquals(50, waterElemental.getCurrentHp());
        assertEquals(3, waterElemental.getAmount());

        assertEquals(62, earthElemental.getCurrentHp());
        assertEquals(5, earthElemental.getAmount());
    }

    @DisplayName("Earth attacks Fire")
    @Test
    void earthElementalShouldNotChangeDamageForFireElemental() {
        earthElemental.attack(fireElemental);
        assertEquals(75, fireElemental.getCurrentHp());
        assertEquals(4, fireElemental.getAmount());

        assertEquals(100, earthElemental.getCurrentHp());
        assertEquals(4, earthElemental.getAmount());
    }

    @DisplayName("Earth attacks Air")
    @Test
    void earthElementalShouldAttackAirElementalWithHalfOfdDamage() {
        //when
        earthElemental.attack(airElemental);
        //then
        assertEquals(37, airElemental.getCurrentHp());
        assertEquals(5, airElemental.getAmount());

        assertEquals(50, earthElemental.getCurrentHp());
        assertEquals(3, earthElemental.getAmount());
    }

    @DisplayName("Fire attacks Air")
    @Test
    void fireElementalShouldAttackAirElementalWithDoubledDamage() {
        //when
        fireElemental.attack(airElemental);
        //then
        assertEquals(50, airElemental.getCurrentHp());
        assertEquals(3, airElemental.getAmount());

        assertEquals(62, fireElemental.getCurrentHp());
        assertEquals(5, fireElemental.getAmount());
    }

    @DisplayName("Fire attacks Earth")
    @Test
    void fireElementalShouldNotChangeDamageForEarthElemental() {
        fireElemental.attack(earthElemental);
        assertEquals(75, earthElemental.getCurrentHp());
        assertEquals(4, earthElemental.getAmount());

        assertEquals(100, fireElemental.getCurrentHp());
        assertEquals(4, fireElemental.getAmount());
    }

    @DisplayName("Fire attacks Water")
    @Test
    void fireElementalShouldAttackWaterElementalWithHalfOfdDamage() {
        //when
        fireElemental.attack(waterElemental);
        //then
        assertEquals(37, waterElemental.getCurrentHp());
        assertEquals(5, waterElemental.getAmount());

        assertEquals(50, fireElemental.getCurrentHp());
        assertEquals(3, fireElemental.getAmount());
    }

    @DisplayName("Water attacks Earth")
    @Test
    void waterElementalShouldAttackEarthElementalWithHalfOfdDamage() {
        //when
        waterElemental.attack(earthElemental);
        //then
        assertEquals(37, earthElemental.getCurrentHp());
        assertEquals(5, earthElemental.getAmount());

        assertEquals(50, waterElemental.getCurrentHp());
        assertEquals(3, waterElemental.getAmount());
    }

    @DisplayName("Water attacks Fire")
    @Test
    void waterElementalShouldAttackFireElementalWithDoubledDamage() {
        //when
        waterElemental.attack(fireElemental);
        //then
        assertEquals(50, fireElemental.getCurrentHp());
        assertEquals(3, fireElemental.getAmount());

        assertEquals(62, waterElemental.getCurrentHp());
        assertEquals(5, waterElemental.getAmount());
    }

    @DisplayName("Water attacks Air")
    @Test
    void waterElementalShouldNotChangeDamageForAirElemental() {
        waterElemental.attack(airElemental);
        assertEquals(75, airElemental.getCurrentHp());
        assertEquals(4, airElemental.getAmount());

        assertEquals(100, waterElemental.getCurrentHp());
        assertEquals(4, waterElemental.getAmount());
    }
}
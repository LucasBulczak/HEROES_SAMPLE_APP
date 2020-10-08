package pl.sdk.gui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatureTest {

    @DisplayName("Defender should lost 499 units because of attack")
    @Test
    void defenderShouldLost499UnitsBecauseOfArmor(){
        //given
        Creature student = new Creature(1,1, 1, "Student",1, 512);
        Creature professor = new Creature(1000,500, 500, "Professor",11, 1);
        //when
        professor.attack(student);
        //then
        assertEquals(13, student.getAmount());
    }

    @DisplayName("Defender should lost 0HP because armor is greater than attacker damage")
    @Test
    void defenderShouldLost0HpBecauseArmorIsGreaterThanAttackerDamage(){
        //given
        Creature student = new Creature(1,1, 1, "Student",1, 1);
        Creature professor = new Creature(1000,500, 500, "Professor",11, 1);
        //when
        student.attack(professor);
        //then
        assertEquals(1000, professor.getCurrentHp());
    }

    @DisplayName("Attacker should lost 1HP because of counter attack")
    @Test
    void attackerShouldLost1HpBecauseOfCounterAttack(){
        //given
        Creature student1 = new Creature(1,2, 1, "Student 1",1, 1);
        Creature student2 = new Creature(1,2, 1, "Student 2",1, 1);
        //when
        student1.attack(student2);
        //then
        assertEquals(1, student1.getCurrentHp());
    }

    @DisplayName("Defender should lost 1 unit because of attack")
    @Test
    void defenderShouldLost1UnitBecauseOfAttack(){
        //given
        Creature student1 = new Creature(1,2, 1, "Student 1",1, 1);
        Creature student2 = new Creature(1,2, 1, "Student 2",1, 2);
        //when
        student1.attack(student2);
        //then
        assertEquals(1, student2.getAmount());
    }

    @DisplayName("Defender should lost 5 units because of attack")
    @Test
    void defenderShouldLost5UnitsBecauseOfAttack(){
        //given
        Creature studentX = new Creature(1,16, 1, "StudentX",1, 10);
        Creature studentY = new Creature(3,2, 1, "StudentY",1, 7);
        //when
        studentX.attack(studentY);
        //then
        assertEquals(-43, studentY.getAmount());
    }

    @DisplayName("Defender should remain 1 HP because of attack (2HP lost + few units killed)")
    @Test
    void defenderShouldLost2HpBecauseOfAttack(){
        //given
        Creature studentX = new Creature(1,18, 1, "StudentX",1, 10);
        Creature studentY = new Creature(3,2, 1, "StudentY",1, 7);
        //when
        studentX.attack(studentY);
        //then
        assertEquals(1, studentY.getCurrentHp());
    }

    @DisplayName("Attacker should lost 1 units because of counter attack")
    @Test
    void attackerShouldLost1UnitBecauseOfCounterAttack(){
        //given
        Creature student1 = new Creature(1,2, 1, "Student 1",1, 2);
        Creature student2 = new Creature(1,2, 1, "Student 2",1, 2);
        //when
        student1.attack(student2);
        //then
        assertEquals(2, student1.getAmount());
    }

    @DisplayName("Attacker should lost 6 units because of counter attack")
    @Test
    void attackerShouldLost6UnitBecauseOfCounterAttack(){
        //given
        Creature student1 = new Creature(1,1, 1, "Student 1",1, 10);
        Creature student2 = new Creature(1,4, 1, "Student 2",1, 2);
        //when
        student1.attack(student2);
        //then
        assertEquals(4, student1.getAmount());
    }

    @DisplayName("Attacker should remain 8 HP because of counter attack (2HP lost + few units killed)")
    @Test
    void attackerShouldLost2HpBecauseOfCounterAttack(){
        //given
        Creature student1 = new Creature(10,1, 1, "Student 1",1, 10);
        Creature student2 = new Creature(1,33, 1, "Student 2",1, 2);
        //when
        student1.attack(student2);
        //then
        assertEquals(6, student1.getCurrentHp());
        assertEquals(4, student1.getAmount());
    }

    @DisplayName("Defender should ont counter attack when no units left")
    @Test
    void defenderShouldNotCounterAttackWhenNoUnitsLeft(){
        //given
        Creature student1 = new Creature(1,11, 1, "Student 1",1, 1);
        Creature student2 = new Creature(1,10, 1, "Student 2",1, 10);
        //when
        student1.attack(student2);
        //then
        assertEquals(0, student2.getAmount());
        assertEquals(1, student1.getCurrentHp());
    }

    @DisplayName("Defender should ont counter attack when no units left (more than enough killed)")
    @Test
    void defenderShouldNotCounterAttackWhenNoUnitsLeft2(){
        //given
        Creature student1 = new Creature(1,100, 1, "Student 1",1, 1);
        Creature student2 = new Creature(1,10, 1, "Student 2",1, 10);
        //when
        student1.attack(student2);
        //then
        assertEquals(-89, student2.getAmount());
        assertEquals(1, student1.getCurrentHp());
    }

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

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


}

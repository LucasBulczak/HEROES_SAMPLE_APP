package pl.sdk.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;
    private Creature creature;

    @BeforeEach
    void setUp() {
        board = new Board();
        creature = new Creature(10, 1, 1, "Creature", 1, 10);
    }

    @Test
    void shouldAddCreature() {
        board.add(new Point(0, 0), creature);

        Creature creatureFromBoard = board.get(0, 0);

        assertEquals(creature, creatureFromBoard);
    }

    @Test
    void shouldReturnNullWhenFieldIsEmpty() {
        Creature creatureFromBoard = board.get(0, 0);

        assertNull(creatureFromBoard);
    }

    @Test
    void shouldXWhenYouAddCreatureToNotEmptyField() {
        board.add(new Point(0, 0), creature);
        Creature creature2 = new Creature(10, 1, 1, "Creature 2", 1, 10);
        board.add(new Point(0, 0), creature2);

        Creature creatureFromBoard = board.get(0, 0);

        assertEquals(creature, creatureFromBoard);
    }
}
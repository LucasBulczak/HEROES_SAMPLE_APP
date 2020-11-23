package pl.sdk.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardMovingTest {

    private Board board;
    private Creature creature;

    @BeforeEach
    void setUp() {
        board = new Board();
        creature = new Creature(10, 1, 1, "Creature", 1, 10);
        board.add(new Point(0, 0), creature);
    }

    @Test
    void creatureShouldMoveCorrectly() {
        board.move(new Point(0, 0), new Point(0, 1));
        Creature creatureFromBoard = board.get(0, 1);

        assertEquals(creature, creatureFromBoard);
        assertNull(board.get(0, 0));
    }

    @Test
    void shouldThrowExceptionWhenCreatureTryingToMoveToNotEmptyField() {
        board.add(new Point(0, 1), new Creature(10, 1, 1, "Creature2", 1, 10));

        assertThrows(IllegalArgumentException.class, () -> board.move(new Point(0, 0), new Point(0, 1)));

        Creature creatureFromBoard = board.get(0, 0);
        assertEquals(creature, creatureFromBoard);
    }
}

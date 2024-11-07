package figures.movement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.King;

import static org.junit.jupiter.api.Assertions.*;

public class KingMovementTest {

    Figure[][] board;
    King king0;

    @BeforeEach
    void setUp() {
        board = new Figure[10][10];
        king0 = new King(FigureColor.WHITE, 3, 3, board);
    }

    @Test
    void testValidMoveToEmptyCell() {
        king0.moveTo(board, 4, 4);

        assertEquals(king0, board[4][4]);
        assertNull(board[3][3]);
    }
    @Test
    void testInvalidMoveToEmptyCell() {
        assertThrows(IllegalArgumentException.class, () -> king0.moveTo(board, 3, 5));
        assertEquals(king0, board[3][3]);
        assertNull(board[3][5]);
    }

    @Test
    void testValidMoveToOccupiedByOpponentColorCell() {
        King king1 = new King(FigureColor.BLACK, 4, 4, board);

        king0.moveTo(board, 4, 4);

        assertEquals(king0, board[4][4]);
        assertNull(board[3][3]);
    }
    @Test
    void testInvalidMoveToOccupiedBySameColorCell() {
        King king1 = new King(king0.getColor(), 4, 4, board);

        assertThrows(IllegalArgumentException.class, () -> king0.moveTo(board, 4, 4));
        assertEquals(king1, board[4][4]);
        assertEquals(king0, board[3][3]);
    }

    @Test
    void testValidMoveFromCenter() {
        king0.moveTo(board, 4, 4);

        king0.moveTo(board, 4, 0);

        assertEquals(king0, board[4][0]);
        assertNull(board[4][4]);
    }
    @Test
    void testInvalidMoveFromCenter() {
        assertThrows(IllegalArgumentException.class, () -> king0.moveTo(board, 0, 0));
        assertEquals(king0, board[3][3]);
        assertNotEquals(king0, board[0][0]);
    }

    @Test
    void testInvalidMoveToSameCell() {
        assertThrows(IllegalArgumentException.class, () -> king0.moveTo(board, 3, 3));
        assertEquals(king0, board[3][3]);
    }

}
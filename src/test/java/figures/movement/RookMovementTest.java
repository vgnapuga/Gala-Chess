package figures.movement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.Rook;

import static org.junit.jupiter.api.Assertions.*;

public class RookMovementTest {

    Figure[][] board;
    Rook rook0;

    @BeforeEach
    void setUp() {
        board = new Figure[10][10];
        rook0 = new Rook(FigureColor.WHITE, 3, 6, board);
    }

    @Test
    void testInvalidSameCellMove() {
        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 3, 6));
        assertEquals(board[3][6], rook0);
    }

    @Test
    void testInvalidMoveOut() {
        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 3, 10));
        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 10, 6));
        assertEquals(board[3][6], rook0);
    }

    @Test
    void testValidHorizontalMoveToEmptyCell() {
        rook0.moveTo(board, 6, 6);

        assertEquals(board[6][6], rook0);
        assertNull(board[3][6]);
    }

    @Test
    void testInvalidHorizontalMoveToEmptyCell() {
        Rook rook1 = new Rook(FigureColor.WHITE, 4, 6, board);

        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 6, 6));
        assertNull(board[6][6]);
        assertEquals(board[3][6], rook0);
        assertEquals(board[4][6], rook1);
    }

    @Test
    void testInvalidHorizontalMoveFromCentre() {
        rook0.setPosition(board, 4, 4);

        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 5, 4));
        assertEquals(board[4][4], rook0);
    }

    @Test
    void testValidVerticalMoveToEmptyCell() {
        rook0.moveTo(board, 3, 3);

        assertEquals(board[3][3], rook0);
        assertNull(board[3][6]);
    }

    @Test
    void testInvalidVerticalMoveToEmptyCell() {
        Rook rook1 = new Rook(FigureColor.WHITE, 3, 8, board);

        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 3, 9));
        assertNull(board[3][9]);
        assertEquals(board[3][6], rook0);
        assertEquals(board[3][8], rook1);
    }

    @Test
    void testInvalidVerticalMoveFromCentre() {
        rook0.setPosition(board, 4, 4);

        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 4, 5));
        assertEquals(board[4][4], rook0);
    }

    @Test
    void testValidBishopMoveToEmptyCell() {
        rook0.setPosition(board, 4, 4);

        rook0.moveTo(board, 6, 6);

        assertEquals(board[6][6], rook0);
        assertNull(board[4][4]);
    }

    @Test
    void testInvalidBishopMoveToEmptyCell() {
        rook0.setPosition(board, 4, 4);
        Rook rook1 = new Rook(FigureColor.WHITE, 5, 5, board);

        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 6, 6));
        assertNull(board[6][6]);
        assertEquals(board[4][4], rook0);
        assertEquals(board[5][5], rook1);
    }

    @Test
    void testInvalidBishopMoveNotFromCentre() {
        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 5, 4));
        assertNull(board[5][4]);
        assertEquals(board[3][6], rook0);
    }

    @Test
    void testValidRookMoveToNotEmptyCell() {
        Rook rook1 = new Rook(FigureColor.BLACK, 6, 6, board);

        rook0.moveTo(board, 6, 6);

        assertEquals(board[6][6], rook0);
        assertNotEquals(board[6][6], rook1);
        assertNull(board[3][6]);
    }

    @Test
    void testInvalidRookMoveToNotEmptyCell() {
        Rook rook1 = new Rook(FigureColor.WHITE, 6, 6, board);

        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 6, 6));
        assertEquals(board[6][6], rook1);
        assertEquals(board[3][6], rook0);
    }

    @Test
    void testValidBishopMoveToNotEmptyCell() {
        rook0.setPosition(board, 4, 4);
        Rook rook1 = new Rook(FigureColor.BLACK, 6, 6, board);

        rook0.moveTo(board, 6, 6);

        assertEquals(board[6][6], rook0);
        assertNotEquals(board[6][6], rook1);
        assertNull(board[4][4]);
    }

    @Test
    void testInvalidBishopMoveToNotEmptyCell() {
        rook0.setPosition(board, 4, 4);
        Rook rook1 = new Rook(FigureColor.WHITE, 6, 6, board);

        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 6, 6));
        assertEquals(board[6][6], rook1);
        assertEquals(board[4][4], rook0);
    }

}
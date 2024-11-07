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
        rook0 = new Rook(FigureColor.WHITE, 7, 7, board);
    }

    @Test
    void testValidHorizontalMoveToEmptyCell() {
        rook0.moveTo(board, 9, 7);

        assertEquals(board[9][7], rook0);
        assertNull(board[7][7]);
    }
    @Test
    void testInvalidHorizontalMoveToEmptyCell() {
        Rook rook1 = new Rook(FigureColor.BLACK, 8, 7, board);

        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 9, 7));
        assertEquals(board[7][7], rook0);
        assertNull(board[9][7]);
        assertEquals(board[8][7], rook1);
    }

    @Test
    void testValidVerticalMoveToEmptyCell() {
        rook0.moveTo(board, 7, 9);

        assertEquals(board[7][9], rook0);
        assertNull(board[7][7]);
    }
    @Test
    void testInvalidVerticalMoveToEmptyCell() {
        Rook rook1 = new Rook(FigureColor.BLACK, 7, 8, board);

        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 7, 9));
        assertEquals(board[7][7], rook0);
        assertNull(board[7][9]);
        assertEquals(board[7][8], rook1);
    }

    @Test
    void testValidMoveToOccupiedByOpponentColorCell() {
        Rook rook1 = new Rook(FigureColor.BLACK, 7, 9, board);

        rook0.moveTo(board, 7, 9);

        assertEquals(board[7][9], rook0);
        assertNull(board[7][7]);
    }
    @Test
    void testInvalidMoveToOccupiedBySameColorCell() {
        Rook rook1 = new Rook(FigureColor.WHITE, 7, 9, board);

        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 7, 9));
        assertEquals(board[7][9], rook1);
        assertEquals(board[7][7], rook0);
    }

    @Test
    void testMainDiagonalValidMoveFromCenterToEmptyCell() {
        Rook rook1 = new Rook(FigureColor.BLACK, 4, 4, board);

        rook0.moveTo(board, 6, 6);

        assertEquals(board[6][6], rook0);
        assertNull(board[4][4]);
    }
    @Test
    void testMainDiagonalInvalidMoveFromCenterToEmptyCell() {
        Rook rook1 = new Rook(FigureColor.BLACK, 4, 4, board);

        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 8, 8));
        assertEquals(board[4][4], rook1);
        assertNull(board[8][8]);
        assertEquals(board[7][7], rook0);
    }

    @Test
    void testSideDiagonalValidMoveFromCenterToEmptyCell() {
        Rook rook1 = new Rook(FigureColor.BLACK, 4, 4, board);

        rook0.moveTo(board, 6, 2);

        assertEquals(board[6][2], rook0);
        assertNull(board[4][4]);
    }
    @Test
    void testSideDiagonalInvalidMoveFromCenterToEmptyCell() {
        Rook rook1 = new Rook(FigureColor.BLACK, 5, 9, board);

        assertThrows(IllegalArgumentException.class, () -> rook1.moveTo(board, 9, 5));
        assertEquals(board[5][9], rook1);
        assertNull(board[9][5]);
        assertEquals(board[7][7], rook0);
    }

    @Test
    void testInvalidMoveToSameCell() {
        assertThrows(IllegalArgumentException.class, () -> rook0.moveTo(board, 7, 7));
        assertEquals(board[7][7], rook0);
    }

}
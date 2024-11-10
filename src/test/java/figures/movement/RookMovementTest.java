package figures.movement;

import interfaces.RookAndBishopTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.vsu.cs.cg.oop.galaChess.exceptions.InvalidCoordinateException;
import ru.vsu.cs.cg.oop.galaChess.exceptions.InvalidMoveException;
import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.movement.Rook;

import static org.junit.jupiter.api.Assertions.*;

public class RookMovementTest implements RookAndBishopTest {

    private static Figure[][] board;
    private static Rook rook0;
    private static Rook rook1;

    @BeforeEach
    void boardSetUp() {
        board = new Figure[10][10];
    }

    // NOT FROM CENTRE MOVEMENT TESTS

    @Test
    @Override
    public void testInvalidMoveOutOfBoard() {
        rook0 = notCentreSetUp();

        assertThrows(InvalidCoordinateException.class, () -> rook0.moveTo(board, 10, 6));
        assertThrows(InvalidCoordinateException.class, () -> rook0.moveTo(board, 3, 10));
        assertSame(notCentreStartPos(), rook0);
    }

    @Test
    @Override
    public void testInvalidMoveToSameCell() {
        rook0 = notCentreSetUp();

        assertThrows(InvalidMoveException.class, () -> rook0.moveTo(board, rook0.getX(), rook0.getY()));
        assertSame(notCentreStartPos(), rook0);
    }

    @Test
    @Override
    public void testValidMoveToEmptyCell() {
        rook0 = notCentreSetUp();

        rook0.moveTo(board, 9, 6);
        assertSame(board[9][6], rook0);
        assertNull(notCentreStartPos());

        rook0.moveTo(board, 9, 9);
        assertSame(board[9][9], rook0);
        assertNull(board[9][6]);
    }

    @Test
    @Override
    public void testInvalidMoveToEmptyCell() {
        rook0 = notCentreSetUp();

        assertThrows(InvalidMoveException.class, () -> rook0.moveTo(board, 4, 7));
        assertSame(notCentreStartPos(), rook0);
    }

    @Test
    @Override
    public void testValidMoveToNotEmptyCell() {
        rook0 = notCentreSetUp();
        rook1 = new Rook(FigureColor.BLACK, board, 3, 7);

        rook0.moveTo(board, 3, 7);

        assertSame(board[3][7], rook0);
        assertNull(notCentreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveToNotEmptyCell() {
        rook0 = notCentreSetUp();
        rook1 = new Rook(FigureColor.WHITE, board, 3, 7);

        assertThrows(InvalidMoveException.class, () -> rook0.moveTo(board, 3, 7));
        assertSame(notCentreStartPos(), rook0);
        assertSame(board[3][7], rook1);
    }

    @Test
    @Override
    public void testInvalidMoveThrowFigure() {
        rook0 = notCentreSetUp();
        rook1 = new Rook(FigureColor.BLACK, board, 3, 7);

        assertThrows(InvalidMoveException.class, () -> rook0.moveTo(board, 3, 8));
        assertSame(notCentreStartPos(), rook0);
        assertSame(board[3][7], rook1);
        assertNull(board[3][8]);
    }

    // FROM CENTER MOVEMENT TEST

    @Test
    @Override
    public void testInvalidMoveOutOfBoardFromCentre() {
        rook0 = centreSetUp();

        assertThrows(InvalidCoordinateException.class, () -> rook0.moveTo(board, 10, 7));
        assertThrows(InvalidCoordinateException.class, () -> rook0.moveTo(board, 4, 10));
        assertSame(centreStartPos(), rook0);
    }

    @Test
    @Override
    public void testInvalidMoveToSameCellFromCentre() {
        rook0 = centreSetUp();

        assertThrows(InvalidMoveException.class, () -> rook0.moveTo(board, rook0.getX(), rook0.getY()));
        assertSame(centreStartPos(), rook0);
    }

    @Test
    @Override
    public void testValidMoveToEmptyCellFromCentre() {
        rook0 = centreSetUp();

        rook0.moveTo(board, 5, 6);

        assertSame(board[5][6], rook0);
        assertNull(centreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveToEmptyCellFromCentre() {
        rook0 = centreSetUp();

        assertThrows(InvalidMoveException.class, () -> rook0.moveTo(board, 4, 6));
        assertSame(centreStartPos(), rook0);
        assertNull(board[4][6]);
    }

    @Test
    @Override
    public void testValidMoveToNotEmptyCellFromCentre() {
        rook0 = centreSetUp();
        rook1 = new Rook(FigureColor.BLACK, board, 5, 6);

        rook0.moveTo(board, 5, 6);

        assertSame(board[5][6], rook0);
        assertNull(centreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveToNotEmptyCellFromCentre() {
        rook0 = centreSetUp();
        rook1 = new Rook(FigureColor.WHITE, board, 5, 6);

        assertThrows(InvalidMoveException.class, () -> rook0.moveTo(board, 5, 6));
        assertSame(centreStartPos(), rook0);
        assertEquals(board[5][6], rook1);
    }

    @Test
    @Override
    public void testInvalidMoveThrowFigureFromCentre() {
        rook0 = centreSetUp();
        rook1 = new Rook(FigureColor.BLACK, board, 5, 6);

        assertThrows(InvalidMoveException.class, () -> rook0.moveTo(board, 6, 7));
        assertSame(centreStartPos(), rook0);
        assertSame(board[5][6], rook1);
        assertNull(board[6][7]);
    }

    private static Rook centreSetUp() {
        return new Rook(FigureColor.WHITE, board, 4, 5);
    }

    private static Figure centreStartPos() {
        return board[4][5];
    }

    private static Rook notCentreSetUp() {
        return new Rook(FigureColor.WHITE, board, 3, 6);
    }

    private static Figure notCentreStartPos() {
        return board[3][6];
    }

}
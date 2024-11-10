package figures.movement;

import interfaces.PawnTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.vsu.cs.cg.oop.galaChess.exceptions.InvalidCoordinateException;
import ru.vsu.cs.cg.oop.galaChess.exceptions.InvalidMoveException;
import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.movement.Pawn;

import static org.junit.jupiter.api.Assertions.*;

public class PawnMovementTest implements PawnTest {

    private static Figure[][] board;
    private static Pawn pawn0;
    private static Pawn pawn1;

    @BeforeEach
    public void boardSetUp() {
        board = new Figure[10][10];
    }

    // NOT FROM CENTRE MOVEMENT TESTS

    @Test
    @Override
    public void testInvalidMoveOutOfBoard() {
        pawn0 = notCentreSetUp();

        assertThrows(InvalidCoordinateException.class, () -> pawn0.moveTo(board, 10, 9));
        assertThrows(InvalidCoordinateException.class, () -> pawn0.moveTo(board, 9, 10));
        assertEquals(notCentreStartPos(), pawn0);
    }

    @Test
    @Override
    public void testInvalidMoveToSameCell() {
        pawn0 = notCentreSetUp();

        assertThrows(InvalidMoveException.class, () -> pawn0.moveTo(board, pawn0.getX(), pawn0.getY()));
        assertEquals(notCentreStartPos(), pawn0);
    }

    @Test
    @Override
    public void testValidMoveToEmptyCell() {
        pawn0 = notCentreSetUp();

        pawn0.moveTo(board, 3, 7);
        assertEquals(board[3][7], pawn0);
        assertNull(notCentreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveToEmptyCell() {
        pawn0 = notCentreSetUp();

        assertThrows(InvalidMoveException.class, () -> pawn0.moveTo(board, 5, 8));
        assertEquals(notCentreStartPos(), pawn0);
        assertNull(board[5][8]);
    }

    @Test
    @Override
    public void testValidMoveThrowCellToEmptyCell() {
        pawn0 = notCentreSetUp();

        pawn0.moveTo(board, 4, 6);
        assertEquals(board[4][6], pawn0);
        assertNull(notCentreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveThrowCellToEmptyCell() {
        pawn0 = notCentreSetUp();
        pawn1 = new Pawn(FigureColor.WHITE, board, 3, 7);

        assertThrows(InvalidMoveException.class, () -> pawn0.moveTo(board, 4, 6));
        assertEquals(notCentreStartPos(), pawn0);
        assertEquals(board[3][7], pawn1);
        assertNull(board[4][6]);
    }

    @Test
    @Override
    public void testValidMoveToNotEmptyCell() {
        pawn0 = notCentreSetUp();
        pawn1 = new Pawn(FigureColor.BLACK, board, 3, 7);

        pawn0.moveTo(board, 3, 7);
        assertEquals(board[3][7], pawn0);
        assertNull(notCentreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveToNotEmptyCell() {
        pawn0 = notCentreSetUp();
        pawn1 = new Pawn(FigureColor.WHITE, board, 3, 7);

        assertThrows(InvalidMoveException.class, () -> pawn0.moveTo(board, 3, 7));
        assertEquals(notCentreStartPos(), pawn0);
        assertEquals(board[3][7], pawn1);
    }

    @Test
    @Override
    public void testValidMoveThrowCellToNotEmptyCell() {
        pawn0 = notCentreSetUp();
        pawn1 = new Pawn(FigureColor.BLACK, board, 4, 6);

        pawn0.moveTo(board, 4, 6);

        assertEquals(board[4][6], pawn0);
        assertNull(notCentreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveThrowCellToNotEmptyCell() {
        pawn0 = notCentreSetUp();
        pawn1 = new Pawn(FigureColor.WHITE, board, 4, 6);

        assertThrows(InvalidMoveException.class, () -> pawn0.moveTo(board, 4, 6));
        assertEquals(notCentreStartPos(), pawn0);
        assertEquals(board[4][6], pawn1);
    }

    // FROM CENTRE MOVEMENT TESTS

    @Test
    @Override
    public void testInvalidMoveOutOfBoardFromCentre() {
        pawn0 = centreSetUp();

        assertThrows(InvalidCoordinateException.class, () -> pawn0.moveTo(board, 10, 7));
        assertThrows(InvalidCoordinateException.class, () -> pawn0.moveTo(board, 7, 10));
        assertEquals(centreStartPos(), pawn0);
    }

    @Test
    @Override
    public void testInvalidMoveToSameCellFromCentre() {
        pawn0 = centreSetUp();

        assertThrows(InvalidMoveException.class, () -> pawn0.moveTo(board, pawn0.getX(), pawn0.getY()));
        assertEquals(centreStartPos(), pawn0);
    }

    @Test
    @Override
    public void testValidMoveToEmptyCellFromCentre() {
        pawn0 = centreSetUp();

        pawn0.moveTo(board, 4, 6);

        assertEquals(board[4][6], pawn0);
        assertNull(centreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveToEmptyCellFromCentre() {
        pawn0 = centreSetUp();

        assertThrows(InvalidMoveException.class, () -> pawn0.moveTo(board, 4, 7));
        assertEquals(centreStartPos(), pawn0);
        assertNull(board[4][7]);
    }

    @Test
    @Override
    public void testValidMoveToNotEmptyCellFromCentre() {
        pawn0 = centreSetUp();
        pawn1 = new Pawn(FigureColor.BLACK, board, 4, 6);

        pawn0.moveTo(board, 4, 6);

        assertEquals(board[4][6], pawn0);
        assertNull(centreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveToNotEmptyCellFromCentre() {
        pawn0 = centreSetUp();
        pawn1 = new Pawn(FigureColor.WHITE, board, 4, 6);

        assertThrows(InvalidMoveException.class, () -> pawn0.moveTo(board, 4, 6));
        assertEquals(centreStartPos(), pawn0);
        assertEquals(board[4][6], pawn1);
    }

    private static Pawn centreSetUp() {
        return new Pawn(FigureColor.WHITE, board, 4, 5);
    }
    private static Figure centreStartPos() {
        return board[4][5];
    }

    private static Pawn notCentreSetUp() {
        return new Pawn(FigureColor.WHITE, board, 2, 8);
    }
    private static Figure notCentreStartPos() {
        return board[2][8];
    }

}
package figures.movement;

import interfaces.KingTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.vsu.cs.cg.oop.galaChess.exceptions.InvalidMoveException;
import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.movement.King;

import static org.junit.jupiter.api.Assertions.*;

public class KingMovementTest implements KingTest {

    private static Figure[][] board;
    private static King king0;
    private static King king1;

    @BeforeEach
    void boardSetUp() {
        board = new Figure[10][10];
    }

    // NOT FROM CENTRE MOVEMENT TESTS

    @Test
    @Override
    public void testInvalidMoveOutOfBoard() {
        king0 = notCentreSetUp();

        assertThrows(InvalidMoveException.class, () -> king0.moveTo(board, 10, 6));
        assertThrows(InvalidMoveException.class, () -> king0.moveTo(board, 6, 10));
        assertSame(notCentreStartPos(), king0);
    }

    @Test
    @Override
    public void testInvalidMoveToSameCell() {
        king0 = notCentreSetUp();

        assertThrows(InvalidMoveException.class, () -> king0.moveTo(board, king0.getX(), king0.getY()));
        assertSame(notCentreStartPos(), king0);
    }

    @Test
    @Override
    public void testValidMoveToEmptyCell() {
        king0 = notCentreSetUp();

        king0.moveTo(board, 4, 6);

        assertSame(board[4][6], king0);
        assertNull(notCentreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveToEmptyCell() {
        king0 = notCentreSetUp();

        assertThrows(InvalidMoveException.class, () -> king0.moveTo(board, 5, 6));
        assertSame(board[3][6], king0);
        assertNull(board[5][6]);
    }

    @Test
    @Override
    public void testValidMoveToNotEmptyCell() {
        king0 = notCentreSetUp();
        king1 = new King(FigureColor.BLACK, board, 3, 7);

        king0.moveTo(board, 3, 7);

        assertSame(board[3][7], king0);
        assertNull(notCentreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveToNotEmptyCell() {
        king0 = notCentreSetUp();
        king1 = new King(FigureColor.WHITE, board, 3, 7);

        assertThrows(InvalidMoveException.class, () -> king0.moveTo(board, 3, 7));
        assertSame(notCentreStartPos(), king0);
        assertSame(board[3][7], king1);
    }

    // FROM CENTRE MOVEMENT

    @Test
    @Override
    public void testInvalidMoveOutOfBoardFromCentre() {
        king0 = centreSetUp();

        assertThrows(InvalidMoveException.class, () -> king0.moveTo(board, 10, 6));
        assertThrows(InvalidMoveException.class, () -> king0.moveTo(board, 6, 10));
    }

    @Test
    @Override
    public void testInvalidMoveToSameCellFromCentre() {
        king0 = centreSetUp();

        assertThrows(InvalidMoveException.class, () -> king0.moveTo(board, king0.getX(), king0.getY()));
        assertSame(centreStartPos(), king0);
    }

    @Test
    @Override
    public void testValidMoveToEmptyCellFromCentre() {
        king0 = centreSetUp();

        king0.moveTo(board, 9, 5);

        assertSame(board[9][5], king0);
        assertNull(centreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveToBlackStartFromCentre() {
        king0 = centreSetUp();

        assertThrows(InvalidMoveException.class, () -> king0.moveTo(board, 0, 0));
        assertSame(centreStartPos(), king0);
    }

    @Test
    @Override
    public void testInvalidMoveToWhiteStartFromCentre() {
        king0 = centreSetUp();

        assertThrows(InvalidMoveException.class, () -> king0.moveTo(board, 0, 9));
        assertSame(centreStartPos(), king0);
    }

    @Test
    @Override
    public void testValidMoveToNotEmptyCellFromCentre() {
        king0 = centreSetUp();
        king1 = new King(FigureColor.BLACK, board, 0, 4);

        king0.moveTo(board, 0, 4);

        assertSame(board[0][4], king0);
        assertNull(centreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveToNotEmptyCellFromCentre() {
        king0 = centreSetUp();
        king1 = new King(FigureColor.WHITE, board, 0, 4);

        assertThrows(InvalidMoveException.class, () -> king0.moveTo(board, 0, 4));
        assertSame(centreStartPos(), king0);
        assertSame(board[0][4], king1);
    }

    private static King centreSetUp() {
        return new King(FigureColor.WHITE, board, 4, 5);
    }

    private static Figure centreStartPos() {
        return board[4][5];
    }

    private static King notCentreSetUp() {
        return new King(FigureColor.WHITE, board, 3, 6);
    }

    private static Figure notCentreStartPos() {
        return board[3][6];
    }

}
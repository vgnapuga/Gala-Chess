package figures.movement;

import interfaces.RookAndBishopTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.movement.Bishop;
import ru.vsu.cs.cg.oop.galaChess.figures.movement.Rook;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BishopMovementTest implements RookAndBishopTest {

    private static Figure[][] board;
    private static Bishop bishop0;
    private static Bishop bishop1;

    @BeforeEach
    void boardSetUp() {
        board = new Figure[10][10];
    }

    // NOT FROM CENTRE MOVEMENT TESTS

    @Test
    @Override
    public void testInvalidMoveOutOfBoard() {
        bishop0 = notCentreSetUp();

        assertThrows(IllegalArgumentException.class, () -> bishop0.moveTo(board, 9, 10));
        assertThrows(IllegalArgumentException.class, () -> bishop0.moveTo(board, 10, 9));
        assertSame(notCentreStartPos(), bishop0);
    }

    @Test
    @Override
    public void testInvalidMoveToSameCell() {
        bishop0 = notCentreSetUp();

        assertThrows(IllegalArgumentException.class, () -> bishop0.moveTo(board, bishop0.getX(), bishop0.getY()));
        assertSame(notCentreStartPos(), bishop0);
    }

    @Test
    @Override
    public void testValidMoveToEmptyCell() {
        bishop0 = notCentreSetUp();

        bishop0.moveTo(board, 4, 7);
        assertSame(board[4][7], bishop0);
        assertNull(notCentreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveToEmptyCell() {
        bishop0 = notCentreSetUp();

        assertThrows(IllegalArgumentException.class, () -> bishop0.moveTo(board, 5, 6));
        assertSame(notCentreStartPos(), bishop0);
        assertNull(board[4][7]);
    }

    @Test
    @Override
    public void testValidMoveToNotEmptyCell() {
        bishop0 = notCentreSetUp();
        bishop1 = new Bishop(FigureColor.BLACK, board, 5 ,8);

        bishop0.moveTo(board, 5, 8);

        assertSame(board[5][8], bishop0);
        assertNull(notCentreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveToNotEmptyCell() {
        bishop0 = notCentreSetUp();
        bishop1 = new Bishop(FigureColor.WHITE, board, 5 ,8);

        assertThrows(IllegalArgumentException.class, () -> bishop0.moveTo(board, 5, 8));
        assertSame(notCentreStartPos(), bishop0);
        assertSame(board[5][8], bishop1);
    }

    @Test
    @Override
    public void testInvalidMoveThrowFigure() {
        bishop0 = notCentreSetUp();
        bishop1 = new Bishop(FigureColor.BLACK, board, 5 ,8);

        assertThrows(IllegalArgumentException.class, () -> bishop0.moveTo(board, 6, 9));
        assertSame(notCentreStartPos(), bishop0);
        assertSame(board[5][8], bishop1);
        assertNull(board[6][9]);
    }

    // FROM CENTRE MOVEMENT TESTS

    @Test
    @Override
    public void testInvalidMoveOutOfBoardFromCentre() {
        bishop0 = centreSetUp();

        assertThrows(IllegalArgumentException.class, () -> bishop0.moveTo(board, 10, 6));
        assertThrows(IllegalArgumentException.class, () -> bishop0.moveTo(board, 3, 10));
        assertSame(centreStartPos(), bishop0);
    }

    @Test
    @Override
    public void testInvalidMoveToSameCellFromCentre() {
        bishop0 = centreSetUp();

        assertThrows(IllegalArgumentException.class, () -> bishop0.moveTo(board, bishop0.getX(), bishop0.getY()));
        assertSame(centreStartPos(), bishop0);
    }

    @Test
    @Override
    public void testValidMoveToEmptyCellFromCentre() {
        bishop0 = centreSetUp();

        bishop0.moveTo(board, 4, 6);
        assertSame(board[4][6], bishop0);
        assertNull(centreStartPos());

        bishop0.moveTo(board, 5, 6);
        assertSame(board[5][6], bishop0);
        assertNull(board[4][6]);
    }

    @Test
    @Override
    public void testInvalidMoveToEmptyCellFromCentre() {
        bishop0 = centreSetUp();

        assertThrows(IllegalArgumentException.class, () -> bishop0.moveTo(board, 5, 7));
        assertSame(centreStartPos(), bishop0);

    }

    @Test
    @Override
    public void testValidMoveToNotEmptyCellFromCentre() {
        bishop0 = centreSetUp();
        bishop1 = new Bishop(FigureColor.BLACK, board, 4, 6);

        bishop0.moveTo(board, 4, 6);

        assertSame(board[4][6], bishop0);
        assertNull(notCentreStartPos());
    }

    @Test
    @Override
    public void testInvalidMoveToNotEmptyCellFromCentre() {
        bishop0 = centreSetUp();
        bishop1 = new Bishop(FigureColor.WHITE, board, 4, 6);

        assertThrows(IllegalArgumentException.class, () -> bishop0.moveTo(board, 4, 6));
        assertSame(centreStartPos(), bishop0);
        assertSame(board[4][6], bishop1);
    }

    @Test
    @Override
    public void testInvalidMoveThrowFigureFromCentre() {
        bishop0 = centreSetUp();
        bishop1 = new Bishop(FigureColor.BLACK, board, 4, 6);

        assertThrows(IllegalArgumentException.class, () -> bishop0.moveTo(board, 4, 7));
        assertSame(centreStartPos(), bishop0);
        assertSame(board[4][6], bishop1);
        assertNull(board[4][7]);
    }

    private static Bishop centreSetUp() {
        return new Bishop(FigureColor.WHITE, board, 4, 5);
    }

    private static Figure centreStartPos() {
        return board[4][5];
    }

    private static Bishop notCentreSetUp() {
        return new Bishop(FigureColor.WHITE, board, 3, 6);
    }

    private static Figure notCentreStartPos() {
        return board[3][6];
    }

}
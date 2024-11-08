package figures.movement;

import interfaces.PawnTest;
import interfaces.RookAndBishopTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.Pawn;

public class PawnMovementTest implements PawnTest {

    private static Figure[][] board;
    private static Pawn pawn0;
    private static Pawn pawn1;

    @BeforeEach
    public void boardSetUp() {
        board = new Figure[10][10];
    }

    @Test
    @Override
    public void testInvalidMoveOutOfBoard() {

    }

    @Test
    @Override
    public void testInvalidMoveToSameCell() {

    }

    @Test
    @Override
    public void testValidMoveToEmptyCell() {

    }

    @Test
    @Override
    public void testInvalidMoveToEmptyCell() {

    }

    @Test
    @Override
    public void testValidMoveToNotEmptyCell() {

    }

    @Test
    @Override
    public void testInvalidMoveToNotEmptyCell() {

    }

    @Test
    @Override
    public void testInvalidMoveOutOfBoardFromCentre() {

    }

    @Test
    @Override
    public void testInvalidMoveToSameCellFromCentre() {

    }

    @Test
    @Override
    public void testValidMoveToEmptyCellFromCentre() {

    }

    @Test
    @Override
    public void testInvalidMoveToEmptyCellFromCentre() {

    }

    @Test
    @Override
    public void testValidMoveToNotEmptyCellFromCentre() {

    }

    @Test
    @Override
    public void testInvalidMoveToNotEmptyCellFromCentre() {

    }

    private static Pawn centreSetUp() {
        return new Pawn(FigureColor.WHITE, board, 4, 5);
    }

    private static Figure centreStartPos() {
        return board[4][5];
    }

    private static Pawn notCentreSetUp() {
        return new Pawn(FigureColor.WHITE, board, 3, 6);
    }

    private static Figure notCentreStartPos() {
        return board[3][6];
    }

}
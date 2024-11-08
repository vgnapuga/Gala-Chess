package engine;

import org.junit.jupiter.api.Test;

import ru.vsu.cs.cg.oop.galaChess.board.GameBoard;
import ru.vsu.cs.cg.oop.galaChess.figures.*;

import static org.junit.jupiter.api.Assertions.*;

public class InitializationTest {

    GameBoard gameBoard = new GameBoard();
    Figure[][] figures = gameBoard.getBoard();

    @Test
    void testWhiteCount() {
        int result = count(FigureColor.WHITE);
        int expected = 20;

        assertEquals(result, expected);
    }

    @Test
    void testBlackCount() {
        int result = count(FigureColor.BLACK);
        int expected = 20;

        assertEquals(result, expected);
    }

    @Test
    void testEmptyCellsCount() {
        int result = 0;
        int expected = 60;

        for (Figure[] figure : figures) {
            for (Figure value : figure) {
                if (value == null)
                    result++;
            }
        }

        assertEquals(result, expected);
    }

    // KINGS
    @Test
    void testKingsCount() {
        int result = count(FigureType.KING);
        int expected = 4;

        assertEquals(result, expected);
    }
    @Test
    void testWhiteKingsCount() {
        int result = count(FigureType.KING, FigureColor.WHITE);
        int expected = 2;

        assertEquals(result, expected);
    }
    @Test
    void testBlackKingsCount() {
        int result = count(FigureType.KING, FigureColor.BLACK);
        int expected = 2;

        assertEquals(result, expected);
    }

    // ROOKS
    @Test
    void testRooksCount() {
        int result = count(FigureType.ROOK);
        int expected = 10;

        assertEquals(result, expected);
    }
    @Test
    void testWhiteRooksCount() {
        int result = count(FigureType.ROOK, FigureColor.WHITE);
        int expected = 5;

        assertEquals(result, expected);
    }
    @Test
    void testBlackRooksCount() {
        int result = count(FigureType.ROOK, FigureColor.BLACK);
        int expected = 5;

        assertEquals(result, expected);
    }

    // BISHOPS
    @Test
    void testBishopsCount() {
        int result = count(FigureType.BISHOP);
        int expected = 10;

        assertEquals(result, expected);
    }
    @Test
    void testWhiteBishopsCount() {
        int result = count(FigureType.BISHOP, FigureColor.WHITE);
        int expected = 5;

        assertEquals(result, expected);
    }
    @Test
    void testBlackBishopsCount() {
        int result = count(FigureType.BISHOP, FigureColor.BLACK);
        int expected = 5;

        assertEquals(result, expected);
    }

    // PAWNS
    @Test
    void testPawnsCount() {
        int result = count(FigureType.PAWN);
        int expected = 16;

        assertEquals(result, expected);
    }
    @Test
    void testWhitePawnsCount() {
        int result = count(FigureType.PAWN, FigureColor.WHITE);
        int expected = 8;

        assertEquals(result, expected);
    }
    @Test
    void testBlackPawnsCount() {
        int result = count(FigureType.PAWN, FigureColor.BLACK);
        int expected = 8;

        assertEquals(result, expected);
    }

    private int count(FigureType type) {
        int count = 0;

        for (Figure[] figure : figures) {
            for (Figure value : figure) {
                if (value != null && value.getType() == type)
                    count++;
            }
        }

        return count;
    }
    private int count(FigureColor color) {
        int count = 0;

        for (Figure[] figure : figures) {
            for (Figure value : figure) {
                if (value != null && value.getColor() == color)
                    count++;
            }
        }

        return count;
    }
    private int count(FigureType type, FigureColor color) {
        int count = 0;

        for (Figure[] figure : figures) {
            for (Figure value : figure) {
                if (value != null && value.getType() == type && value.getColor() == color)
                    count++;
            }
        }

        return count;
    }

}
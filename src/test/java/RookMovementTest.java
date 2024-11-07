import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.vsu.cs.cg.oop.galaChess.engine.GameBoard;
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
        rook0.move(board, 7, 9);

        assertEquals(board[7][9], rook0);
        assertNull(board[7][7]);
    }

}
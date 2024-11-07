package figures.movement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.Bishop;

public class BishopMovementTest {

    Figure[][] board;
    Bishop bishop0;

    @BeforeEach
    void setUp() {
        board = new Figure[10][10];
        bishop0 = new Bishop(FigureColor.WHITE, 3, 6, board);
    }

    @Test
    void testBishopMovement() {

    }

}
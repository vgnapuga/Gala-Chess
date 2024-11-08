package figures.movement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.Bishop;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.King;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.Pawn;

import static org.junit.jupiter.api.Assertions.*;

public class PawnMovementTest {

    private static Figure[][] board;
    private static Pawn pawn0;
    private static Pawn pawn1;

    @BeforeEach
    public void boardSetUp() {
        board = new Figure[10][10];
    }



    private static Pawn centreSetUp() {
        return new Pawn(FigureColor.WHITE, board, 4, 5);
    }

    private static Pawn notCentreSetUp() {
        return new Pawn(FigureColor.WHITE, board, 3, 6);
    }
}
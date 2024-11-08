package figures.movement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.King;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.Rook;

import static org.junit.jupiter.api.Assertions.*;

public class RookMovementTest {

    private static Figure[][] board;
    private static Rook rook0;
    private static Rook rook1;

    @BeforeEach
    void boardSetUp() {
        board = new Figure[10][10];
    }



    private static Rook centreSetUp() {
        return new Rook(FigureColor.WHITE, board, 4, 5);
    }

    private static Rook notCentreSetUp() {
        return new Rook(FigureColor.WHITE, board, 3, 6);
    }

}
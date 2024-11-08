package figures.movement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.Bishop;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.King;

import static org.junit.jupiter.api.Assertions.*;

public class BishopMovementTest {

    private static Figure[][] board;
    private static Bishop bishop0;
    private static Bishop bishop1;

    @BeforeEach
    void boardSetUp() {
        board = new Figure[10][10];
    }



    private static Bishop centreSetUp() {
        return new Bishop(FigureColor.WHITE, board, 4, 5);
    }

    private static Bishop notCentreSetUp() {
        return new Bishop(FigureColor.WHITE, board, 3, 6);
    }
}
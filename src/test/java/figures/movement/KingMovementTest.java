package figures.movement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.King;

import static org.junit.jupiter.api.Assertions.*;

public class KingMovementTest {

    private static Figure[][] board;
    private static King king0;
    private static King king1;

    @BeforeEach
    void boardSetUp() {
        board = new Figure[10][10];
    }



    private static King centreSetUp() {
        return new King(FigureColor.WHITE, board, 4, 5);
    }

    private static King notCentreSetUp() {
        return new King(FigureColor.WHITE, board, 3, 6);
    }

}
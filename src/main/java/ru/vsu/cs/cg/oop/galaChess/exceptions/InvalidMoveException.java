package ru.vsu.cs.cg.oop.galaChess.exceptions;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public class InvalidMoveException extends RuntimeException {

    public InvalidMoveException(FigureColor color, FigureType type, int x0, int y0, int x1, int y1) {
        super("Cannot move " + color + " " + type + " from (" + x1 + "; " + y1 + ") to (" + x0 + "; " + y0 + ")");
    }

}

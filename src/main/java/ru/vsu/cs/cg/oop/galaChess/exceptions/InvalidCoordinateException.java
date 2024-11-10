package ru.vsu.cs.cg.oop.galaChess.exceptions;

public class InvalidCoordinateException extends RuntimeException {

    public InvalidCoordinateException(int x0, int y0) {
        super("Coordinates (" + x0 + "; " + y0 + ") out of board");
    }

}

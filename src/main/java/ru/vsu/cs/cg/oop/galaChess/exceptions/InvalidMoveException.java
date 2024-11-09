package ru.vsu.cs.cg.oop.galaChess.exceptions;

public class InvalidMoveException extends RuntimeException {

    private final String message;

    public InvalidMoveException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

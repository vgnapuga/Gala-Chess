package ru.vsu.cs.cg.oop.galaChess.figures.movement;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public final class King extends Figure {

    public King(final FigureColor color, Figure[][] board, int x, int y) {
        super(FigureType.KING, color, board, x, y);
    }

    @Override
    public boolean isMiddleMove(final int destinationX, final int destinationY) {
        return this.isInCentralSquare() && (!isStartCoordinates(destinationX, destinationY));
    }

    @Override
    public boolean isNotMiddleMove(final int destinationX, final int destinationY) {
        int deltaX = Math.abs(destinationX - this.getX());
        int deltaY = Math.abs(destinationY - this.getY());

        return deltaX <= 1 && deltaY <= 1;
    }

    private boolean isInCentralSquare() {
        return (this.getX() == 4 || this.getX() == 5) && (this.getY() == 4 || this.getY() == 5);
    }

    private static boolean isStartCoordinates(final int x, final int y) {
        return isWhiteStart(x, y) || isBlackStart(x, y);
    }

    private static boolean isWhiteStart(final int x, final int y) {
        return (y == 9 && (x < 4 || x > 5)) ||
                (y == 8 && (x < 3 || x > 6)) ||
                (y == 7 && (x < 2 || x > 7)) ||
                (y == 6 && (x == 0 || x == 9));
    }

    private static boolean isBlackStart(final int x, final int y) {
        return (y == 0 && (x < 4 || x > 5)) ||
                (y == 1 && (x < 3 || x > 6)) ||
                (y == 2 && (x < 2 || x > 7)) ||
                (y == 3 && (x == 0 || x == 9));
    }
}
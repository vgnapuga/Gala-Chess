package ru.vsu.cs.cg.oop.galaChess.figures.movement;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public final class King extends Figure {

    public King(final FigureColor color, Figure[][] board, int x, int y) {
        super(FigureType.KING, color, board, x, y);
    }

    @Override
    protected boolean isValidMove(final Figure[][] board, final int x0, final int y0,
                                  final int x1, final int y1) {
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);

        if ((isInCentralSquare(x0, y0) && (!isStartCoordinates(x1, y1))) ||
                (dx <= 1 && dy <= 1))
            return move(board, x0, y0, x1, y1);

        return false;
    }

    private static boolean isInCentralSquare(final int x, final int y) {
        return (x == 4 || x == 5) && (y == 4 || y == 5);
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
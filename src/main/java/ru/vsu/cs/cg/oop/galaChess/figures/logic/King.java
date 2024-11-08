package ru.vsu.cs.cg.oop.galaChess.figures.logic;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public final class King extends Figure {

    public King(final FigureColor color, int x, int y, Figure[][] board) {
        super(FigureType.KING, color, x, y, board);
    }

    @Override
    protected boolean isValidMove(final Figure[][] board, final int x0, final int y0,
                                final int x1, final int y1) {
        if (isOutOfBoard(x0, y0) || isOutOfBoard(x1, y1))
            return false;

        Figure start = board[x0][y0];
        Figure end = board[x1][y1];

        if (isInCentralSquare(x0, y0) && !isStartCoordinates(x1, y1) &&
                (end == null || !start.isSameColorWith(end)))
            return true;

        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);

        if (dx <= 1 && dy <= 1)
            return end == null || !start.isSameColorWith(end);

        return false;
    }

    private static boolean isInCentralSquare(final int x0, final int y0) {
        return (x0 == 4 || x0 == 5) && (y0 == 4 || y0 == 5);
    }

    private static boolean isStartCoordinates(final int x, final int y) {
        return isWhiteStart(x, y) || isBlackStart(x, y);
    }
    private static boolean isWhiteStart(final int x, final int y) {
        return ((x < 4 || x > 5) && y == 9) ||
                ((x < 3 || x > 6) && y == 8) ||
                ((x < 2 || x > 7) && y == 7) ||
                ((x == 0) || (x == 9) && y == 6);
    }
    private static boolean isBlackStart(final int x, final int y) {
        return ((x < 4 || x > 5) && y == 0) ||
                ((x < 3 || x > 6) && y == 1) ||
                ((x < 2 || x > 7) && y == 2) ||
                ((x == 0) || (x == 9) && y == 3);
    }

}
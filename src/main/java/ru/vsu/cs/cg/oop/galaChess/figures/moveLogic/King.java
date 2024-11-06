package ru.vsu.cs.cg.oop.galaChess.figures.moveLogic;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public class King extends Figure implements Movable {

    public King(final FigureColor color) {
        super(FigureType.KING, color);
    }

    @Override
    public void move(Figure[][] board, int x0, int y0, int x1, int y1) {
        Figure start = board[x0][y0];
        Figure end = board[x1][y1];

        if (!isValidMove(start, end, x0, y0, x1, y1)) {
            throw new IllegalArgumentException("Invalid move");
        } else {
            board[x1][y1] = start;
            board[x0][y0] = null;
        }
    }

    private boolean isValidMove(Figure start, Figure end, int x0, int y0, int x1, int y1) {
        if ((x0 == x1 && y0 == y1) || start == null)
            return false;

        if (isInCentralSquare(x0, y0) && !isStartCoordinates(x1, y1) && !isSameColor(start, end))
            return true;

        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);

        if (dx <= 1 || dy <= 1)
            return end == null || !isSameColor(start, end);

        return false;
    }

    private static boolean isInCentralSquare(int x0, int y0) {
        return (x0 == 4 || x0 == 5) && (y0 == 4 || y0 == 5);
    }

    private boolean isSameColor(Figure start, Figure end) {
        return start.getColor() == end.getColor();
    }

    private boolean isStartCoordinates(int x, int y) {
        return isWhiteStart(x, y) || isBlackStart(x, y);
    }
    private boolean isWhiteStart(int x, int y) {
        return ((x < 4 || x > 5) && y == 9) ||
                ((x < 3 || x > 6) && y == 8) ||
                ((x < 2 || x > 7) && y == 7) ||
                ((x == 0) || (x == 9) && y == 6);    }
    private boolean isBlackStart(int x, int y) {
        return ((x < 4 || x > 5) && y == 0) ||
                ((x < 3 || x > 6) && y == 1) ||
                ((x < 2 || x > 7) && y == 2) ||
                ((x == 0) || (x == 9) && y == 3);
    }

}
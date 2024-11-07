package ru.vsu.cs.cg.oop.galaChess.figures.logic;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public class King extends Figure implements Movable {

    public King(final FigureColor color, int x, int y, Figure[][] board) {
        super(FigureType.KING, color, x, y, board);
    }

    @Override
    public void moveTo(Figure[][] board, int x1, int y1) {
        int x0 = this.getX();
        int y0 = this.getY();

        if (!isValidMove(board, x0, y0, x1, y1)) {
            throw new IllegalArgumentException("Invalid move");
        } else {
            this.setPosition(board, x1, y1);
            board[x0][y0] = null;
        }
    }

    private boolean isValidMove(Figure[][] board, int x0, int y0, int x1, int y1) {
        if (Movable.isOutOfBoard(x0) || Movable.isOutOfBoard(y0) ||
                Movable.isOutOfBoard(x1) || Movable.isOutOfBoard(y1))
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

    private static boolean isInCentralSquare(int x0, int y0) {
        return (x0 == 4 || x0 == 5) && (y0 == 4 || y0 == 5);
    }

    private static boolean isStartCoordinates(int x, int y) {
        return isWhiteStart(x, y) || isBlackStart(x, y);
    }
    private static boolean isWhiteStart(int x, int y) {
        return ((x < 4 || x > 5) && y == 9) ||
                ((x < 3 || x > 6) && y == 8) ||
                ((x < 2 || x > 7) && y == 7) ||
                ((x == 0) || (x == 9) && y == 6);
    }
    private static boolean isBlackStart(int x, int y) {
        return ((x < 4 || x > 5) && y == 0) ||
                ((x < 3 || x > 6) && y == 1) ||
                ((x < 2 || x > 7) && y == 2) ||
                ((x == 0) || (x == 9) && y == 3);
    }

}
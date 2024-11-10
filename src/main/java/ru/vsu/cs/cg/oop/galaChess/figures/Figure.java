package ru.vsu.cs.cg.oop.galaChess.figures;

import ru.vsu.cs.cg.oop.galaChess.exceptions.InvalidCoordinateException;
import ru.vsu.cs.cg.oop.galaChess.exceptions.InvalidMoveException;

public abstract class Figure {

    private final FigureType type;
    private final FigureColor color;
    private int x;
    private int y;

    public Figure(final FigureType type, final FigureColor color, Figure[][] board, int x, int y) {
        this.type = type;
        this.color = color;
        this.x = x;
        this.y = y;

        this.setPosition(board, x, y);
    }

    public void moveTo(Figure[][] board, final int x1, final int y1) {
        int x0 = this.getX();
        int y0 = this.getY();

        if (isValidMove(board, x0, y0, x1, y1)) {
            this.setPosition(board, x1, y1);
            board[x0][y0] = null;
        } else {
            throw new InvalidMoveException(this.getColor(), this.getType(), x0, y0, x1, y1);
        }
    }

    private boolean isValidMove(final Figure[][] board, final int x0, final int y0,
                                final int x1, final int y1) {
        if (isOutOfBoard(x0, y0))
            throw new InvalidCoordinateException(x0, y0);
        else if (isOutOfBoard(x1, y1))
            throw new InvalidCoordinateException(x1, y1);
        else if (this.isMiddleMove(x1, y1) || this.isNotMiddleMove(x1, y1))
            return isPathClear(board, x0, y0, x1, y1);

        return false;
    }

    protected abstract boolean isMiddleMove(final int x1, final int y1);

    protected abstract boolean isNotMiddleMove(final int x1, final int y1);

    private static boolean isPathClear(Figure[][] board, final int x0, final int y0,
                                       final int x1, final int y1) {
        Figure start = board[x0][y0];
        Figure destination = board[x1][y1];

        if (start == null || (x0 == x1 && y0 == y1) ||
                (destination != null && start.isSameColorWith(destination)))
            return false;

        if (x0 == x1) {
            int dy = y1 > y0 ? 1 : -1;

            for (int y = y0 + dy; y != y1; y += dy) {
                if (board[x0][y] != null)
                    return false;
            }
        } else if (y0 == y1) {
            int dx = x1 > x0 ? 1 : -1;

            for (int x = x0 + dx; x != x1; x += dx) {
                if (board[x][y0] != null)
                    return false;
            }
        } else {
            int dx = x1 > x0 ? 1 : -1;
            int dy = y1 > y0 ? 1 : -1;

            for (int x = x0 + dx, y = y0 + dy; x != x1 && y != y1; x += dx, y += dy) {
                if (board[x][y] != null)
                    return false;
            }
        }

        return true;
    }

    public boolean isOutOfBoard(final int coordinate1, final int coordinate2) {
        return coordinate1 < 0 || coordinate1 > 9 ||
                coordinate2 < 0 || coordinate2 > 9;
    }

    public final void setPosition(Figure[][] board, final int x, final int y) {
        this.x = x;
        this.y = y;

        board[x][y] = this;
    }

    public final FigureType getType() {
        return type;
    }

    public final FigureColor getColor() {
        return color;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final boolean isSameColorWith(Figure figure) {
        return this.getColor() == figure.getColor();
    }

    public final boolean isInMiddle() {
        return ((this.x == 4 || this.x == 5) || (this.y == 4 || this.y == 5));
    }

}
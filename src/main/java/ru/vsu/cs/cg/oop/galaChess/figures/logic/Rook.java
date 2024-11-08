package ru.vsu.cs.cg.oop.galaChess.figures.logic;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

import static ru.vsu.cs.cg.oop.galaChess.figures.logic.Bishop.bishopMove;

public final class Rook extends Figure implements Movable {

    public Rook(final FigureColor color, Figure[][] board, int x, int y) {
        super(FigureType.ROOK, color, board, x, y);
    }

    @Override
    protected boolean isValidMove(final Figure[][] board, final int x0, final int y0,
                                final int x1, final int y1) {
        if (isOutOfBoard(x0, y0) || isOutOfBoard(x1, y1))
            return false;

        Figure start = board[x0][y0];
        Figure end = board[x1][y1];

        if (end != null && start.isSameColorWith(end) || (x0 == x1 && y0 == y1) || start == null)
            return false;

        if (this.isInMiddle())
            return bishopMove(board, x0, y0, x1, y1);
        else
            return rookMove(board, x0, y0, x1, y1);
    }

    static boolean rookMove(final Figure[][] board, final int x0, final int y0,
                            final int x1, final int y1) {
        if (x0 != x1 && y0 != y1)
            return false;

        if (x0 != x1)
            return horizontalMove(board, y0, x0, x1);
        else
            return verticalMove(board, x0, y0, y1);
    }

    private static boolean verticalMove(final Figure[][] board, final int x0, final int y0, final int y1) {
        int dy = y1 > y0 ? 1 : -1;

        for (int y = y0 + dy; (dy > 0 ? y < y1 : y > y1); y += dy) {
            if (board[x0][y] != null)
                return false;
        }

        return true;
    }

    private static boolean horizontalMove(final Figure[][] board, final int y0, final int x0, final int x1) {
        int dx = x1 > x0 ? 1 : -1;

        for (int x = x0 + dx; (dx > 0 ? x < x1 : x > x1); x += dx) {
            if (board[x][y0] != null)
                return false;
        }

        return true;
    }

}
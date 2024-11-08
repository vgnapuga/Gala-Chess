package ru.vsu.cs.cg.oop.galaChess.figures.movement;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

import static ru.vsu.cs.cg.oop.galaChess.figures.movement.Rook.rookMove;

public final class Bishop extends Figure {

    public Bishop(final FigureColor color, Figure[][] board, int x, int y) {
        super(FigureType.BISHOP, color, board, x, y);
    }

    @Override
    protected boolean isValidMove(final Figure[][] board, final int x0, final int y0,
                                final int x1, final int y1) {
        if (isOutOfBoard(x0, y0) || isOutOfBoard(x1, y1))
            return false;

        Figure start = board[x0][y0];
        Figure end = board[x1][y1];

        if (end != null && start.isSameColorWith(end))
            return false;

        if ((x0 == x1 && y0 == y1) || start == null)
            return false;

        if (this.isInMiddle())
            return rookMove(board, x0, y0, x1, y1);
        else
            return bishopMove(board, x0, y0, x1, y1);
    }


    static boolean bishopMove(final Figure[][] board, final int x0, final int y0,
                              final int x1, final int y1) {
        if (Math.abs(x1 - x0) != Math.abs(y1 - y0))
            return false;

        int dx = x1 > x0 ? 1 : -1;
        int dy = y1 > y0 ? 1 : -1;

        for (int i = 1; i < Math.abs(x1 - x0); i++) {
            if (board[x0 + i * dx][y0 + i * dy] != null)
                return false;
        }

        return true;
    }

}
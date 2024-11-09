package ru.vsu.cs.cg.oop.galaChess.figures.movement;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public final class Bishop extends Figure {

    public Bishop(final FigureColor color, Figure[][] board, int x, int y) {
        super(FigureType.BISHOP, color, board, x, y);
    }

    @Override
    protected boolean isValidMove(final Figure[][] board, final int x0, final int y0,
                                final int x1, final int y1) {
        Figure start = board[x0][y0];

        if (start.isInMiddle() && (x0 == x1 || y0 == y1))
            return move(board, x0, y0, x1, y1);
        else if (!start.isInMiddle() && x0 != x1 && y0 != y1)
            return move(board, x0, y0, x1, y1);

        return false;
    }

}
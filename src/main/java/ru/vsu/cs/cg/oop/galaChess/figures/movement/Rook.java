package ru.vsu.cs.cg.oop.galaChess.figures.movement;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public final class Rook extends Figure {

    public Rook(final FigureColor color, Figure[][] board, int x, int y) {
        super(FigureType.ROOK, color, board, x, y);
    }

    @Override
    protected boolean isValidMove(final Figure[][] board, final int x0, final int y0,
                                final int x1, final int y1) {
        Figure start = board[x0][y0];

        if (start.isInMiddle() && x1 != x0 && y1 != y0 ||
                (!start.isInMiddle() && (x1 == x0 || y1 == y0)))
            return move(board, x0, y0, x1, y1);

        return false;
    }

}
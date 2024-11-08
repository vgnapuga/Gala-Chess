package ru.vsu.cs.cg.oop.galaChess.figures.logic;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public final class Pawn extends Figure {

    public Pawn(final FigureColor color, Figure[][] board, int x, int y) {
        super(FigureType.PAWN, color, board, x, y);
    }

    @Override
    protected boolean isValidMove(final Figure[][] board, final int x0, final int y0,
                                  final int x1, final int y1) {
        if (isOutOfBoard(x0, y0) || isOutOfBoard(x1, y1))
            return false;

        Figure start = board[x0][y0];
        Figure end = board[x1][y1];

        if ((x0 == x1 && y0 == y1) || start == null)
            return false;

        return false;
    }

}
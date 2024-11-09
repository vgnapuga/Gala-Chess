package ru.vsu.cs.cg.oop.galaChess.figures.movement;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public final class Pawn extends Figure {

    public Pawn(final FigureColor color, Figure[][] board, int x, int y) {
        super(FigureType.PAWN, color, board, x, y);
    }

    @Override
    protected boolean isValidMove(final Figure[][] board, final int x0, final int y0,
                                  final int x1, final int y1) {
        Figure start = board[x0][y0];

        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);

        return false;
    }

    private static boolean canMoveOnTwoCells(final Figure[][] board, final int x, final int y) {
        return (x == 1 && (y == 2 || y == 7)) || (x == 2 && (y == 1 || y == 8)) ||
                (x == 7 && (y == 1 || y == 8)) || (x == 8 && (y == 2 || y == 7));
    }

}
package ru.vsu.cs.cg.oop.galaChess.figures.movement;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public final class Rook extends Figure implements Movable {

    public Rook(final FigureColor color, Figure[][] board, int x, int y) {
        super(FigureType.ROOK, color, board, x, y);
    }

    @Override
    protected boolean isValidMove(final Figure[][] board, final int x0, final int y0,
                                final int x1, final int y1) {
        if (isMiddleMove(x1, y1) || isNotMiddleMove(x1, y1))
            return move(board, x0, y0, x1, y1);

        return false;
    }

    @Override
    public boolean isMiddleMove(int destinationX, int destinationY) {
        return this.isInMiddle() && destinationX != this.getX() && destinationY != this.getY();
    }

    @Override
    public boolean isNotMiddleMove(int destinationX, int destinationY) {
        return !this.isInMiddle() && (destinationX == this.getX() || destinationY == this.getY());
    }
}
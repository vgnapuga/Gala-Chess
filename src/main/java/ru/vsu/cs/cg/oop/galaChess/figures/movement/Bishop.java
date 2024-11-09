package ru.vsu.cs.cg.oop.galaChess.figures.movement;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public final class Bishop extends Figure implements Movable {

    public Bishop(final FigureColor color, Figure[][] board, int x, int y) {
        super(FigureType.BISHOP, color, board, x, y);
    }

    @Override
    protected boolean isValidMove(final Figure[][] board, final int x0, final int y0,
                                final int x1, final int y1) {
        if (this.isMiddleMove(x1, y1) || isNotMiddleMove(x1, y1))
            return move(board, x0, y0, x1, y1);

        return false;
    }

    @Override
    public boolean isMiddleMove(final int destinationX, final int destinationY) {
        return this.isInMiddle() && (this.getX() == destinationX || this.getY() == destinationY);
    }

    @Override
    public boolean isNotMiddleMove(final int destinationX, final int destinationY) {
        return !this.isInMiddle() && (this.getX() != destinationX & this.getY() != destinationY);
    }

}
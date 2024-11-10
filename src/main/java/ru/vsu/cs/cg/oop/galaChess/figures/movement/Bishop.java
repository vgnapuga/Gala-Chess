package ru.vsu.cs.cg.oop.galaChess.figures.movement;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public final class Bishop extends Figure {

    public Bishop(final FigureColor color, Figure[][] board, int x, int y) {
        super(FigureType.BISHOP, color, board, x, y);
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
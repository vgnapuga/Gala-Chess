package ru.vsu.cs.cg.oop.galaChess.figures.movement;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public final class Rook extends Figure {

    public Rook(final FigureColor color, Figure[][] board, int x, int y) {
        super(FigureType.ROOK, color, board, x, y);
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
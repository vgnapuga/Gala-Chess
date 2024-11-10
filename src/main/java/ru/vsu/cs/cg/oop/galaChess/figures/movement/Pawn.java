package ru.vsu.cs.cg.oop.galaChess.figures.movement;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public final class Pawn extends Figure {

    public Pawn(final FigureColor color, Figure[][] board, int x, int y) {
        super(FigureType.PAWN, color, board, x, y);
    }

    @Override
    public boolean isMiddleMove(final int destinationX, final int destinationY) {
        int dx = Math.abs(this.getX() - destinationX);
        int dy = Math.abs(this.getY() - destinationY);

        return this.isInMiddle() && (dx <= 1 && dy <= 1);
    }

    @Override
    public boolean isNotMiddleMove(final int destinationX, final int destinationY) {
        if (!this.isInMiddle()) {
            int dx = Math.abs(this.getX() - destinationX);
            int dy = Math.abs(this.getY() - destinationY);

            if (this.canMoveOnTwoCells() && dx <= 2 && dy <= 2) {
                return this.pawnMovement(destinationX, destinationY);
            } else if (!this.canMoveOnTwoCells() && dx == 1 && dy == 1) {
                return this.pawnMovement(destinationX, destinationY);
            }
        }

        return false;
    }

    private boolean canMoveOnTwoCells() {
        int x = this.getX();
        int y = this.getY();

        return (x == 1 && (y == 2 || y == 7)) || (x == 2 && (y == 1 || y == 8)) ||
                (x == 7 && (y == 1 || y == 8)) || (x == 8 && (y == 2 || y == 7));
    }

    private boolean pawnMovement(int destinationX, int destinationY) {
        int x = this.getX();
        int y = this.getY();

        if (this.getColor() == FigureColor.BLACK) {
            if (this.isOnLeftSide())
                return x < destinationX && y < destinationY;
            else
                return x > destinationX && y < destinationY;
        } else {
            if (this.isOnLeftSide())
                return x < destinationX && y > destinationY;
            else
                return x > destinationX && y > destinationY;
        }
    }

    private boolean isOnLeftSide() {
        return this.getX() < 4;
    }

}
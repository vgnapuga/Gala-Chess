package ru.vsu.cs.cg.oop.galaChess.figures;

public interface Movable {

    boolean isMiddleMove(final int destinationX, final int destinationY);
    boolean isNotMiddleMove(final int destinationX, final int destinationY);

}

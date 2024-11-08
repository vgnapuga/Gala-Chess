package ru.vsu.cs.cg.oop.galaChess.figures;

public interface Movable {

    void moveTo(Figure[][] board, int x, int y);

    boolean isOutOfBoard(final int coordinate1, final int coordinate2);

}
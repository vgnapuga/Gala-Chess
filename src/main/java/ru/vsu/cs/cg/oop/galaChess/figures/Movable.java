package ru.vsu.cs.cg.oop.galaChess.figures;

public interface Movable {

    public static boolean isOutOfBoard(int coordinate) {
        return coordinate < 0 || coordinate > 9;
    }

    void moveTo(Figure[][] board, int x, int y);

}

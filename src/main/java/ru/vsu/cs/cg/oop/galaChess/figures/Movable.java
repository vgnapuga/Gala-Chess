package ru.vsu.cs.cg.oop.galaChess.figures;

public interface Movable {

    static boolean isOutOfBoard(int coordinate) {
        return coordinate < 0 || coordinate > 9;
    }

    static int delta(int coordinate1, int coordinate2) {
        return (coordinate1 > coordinate2) ? 1 : -1;
    }

    void moveTo(Figure[][] board, int x, int y);

}

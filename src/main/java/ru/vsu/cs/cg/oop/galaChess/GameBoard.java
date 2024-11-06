package ru.vsu.cs.cg.oop.galaChess;

public class GameBoard {

    private static final int BOARD_HEIGHT = 10;
    private static final int BOARD_WIDTH = 10;

    private int[][] board;

    public GameBoard() {
        board = new int[BOARD_HEIGHT][BOARD_WIDTH];
    }

    public final int getHeight() {
        return BOARD_HEIGHT;
    }

    public final int getWidth() {
        return BOARD_WIDTH;
    }

}

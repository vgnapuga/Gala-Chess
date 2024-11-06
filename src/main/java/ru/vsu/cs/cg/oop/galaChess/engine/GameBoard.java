package ru.vsu.cs.cg.oop.galaChess.engine;

import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.Bishop;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.King;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.Pawn;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.Rook;

public class GameBoard {

    private static final int BOARD_HEIGHT = 10;
    private static final int BOARD_WIDTH = 10;

    private static Figure[][] board;

    public GameBoard() {
        board = new Figure[BOARD_HEIGHT][BOARD_WIDTH];
        initializeBoard();
    }

    private static void initializeBoard() {
        initializeKings();
        initializeRooks();
        initialiceBishops();
        initializePawns();
    }

    private static void initializeKings() {
            board[9][0] = new King(FigureColor.WHITE, 9, 0);
            board[9][9] = new King(FigureColor.WHITE, 9, 9);

            board[0][0] = new King(FigureColor.BLACK, 0, 0);
            board[0][9] = new King(FigureColor.BLACK, 0, 9);
    }

    private static void initializeRooks() {
            board[9][2] = new Rook(FigureColor.WHITE, 9, 2);
            board[8][1] = new Rook(FigureColor.WHITE, 8, 1);
            board[7][0] = new Rook(FigureColor.WHITE, 7, 0);
            board[8][9] = new Rook(FigureColor.WHITE, 8, 9);
            board[9][8] = new Rook(FigureColor.WHITE, 9, 8);

            board[0][1] = new Rook(FigureColor.BLACK, 0, 1);
            board[1][0] = new Rook(FigureColor.BLACK, 1, 0);
            board[0][7] = new Rook(FigureColor.BLACK, 0, 7);
            board[1][8] = new Rook(FigureColor.BLACK, 1, 8);
            board[2][9] = new Rook(FigureColor.BLACK, 2, 9);
    }

    public static void initialiceBishops() {
            board[8][0] = new Bishop(FigureColor.WHITE, 8, 0);
            board[9][1] = new Bishop(FigureColor.WHITE, 9, 1);
            board[7][9] = new Bishop(FigureColor.WHITE, 7, 9);
            board[8][8] = new Bishop(FigureColor.WHITE, 8, 8);
            board[9][7] = new Bishop(FigureColor.WHITE, 9, 7);

            board[0][2] = new Bishop(FigureColor.BLACK, 0, 2);
            board[1][1] = new Bishop(FigureColor.BLACK, 1, 1);
            board[2][0] = new Bishop(FigureColor.BLACK, 2, 0);
            board[0][8] = new Bishop(FigureColor.BLACK, 0, 8);
            board[1][9] = new Bishop(FigureColor.BLACK, 1, 9);
    }

    private static void initializePawns() {
            board[6][0] = new Pawn(FigureColor.WHITE, 6, 0);
            board[7][1] = new Pawn(FigureColor.WHITE, 7, 1);
            board[8][2] = new Pawn(FigureColor.WHITE, 8, 2);
            board[9][3] = new Pawn(FigureColor.WHITE, 9, 3);
            board[6][9] = new Pawn(FigureColor.WHITE, 6, 9);
            board[7][8] = new Pawn(FigureColor.WHITE, 7, 8);
            board[8][7] = new Pawn(FigureColor.WHITE, 8, 7);
            board[9][6] = new Pawn(FigureColor.WHITE, 9, 6);

            board[0][3] = new Pawn(FigureColor.BLACK, 0, 3);
            board[1][2] = new Pawn(FigureColor.BLACK, 1, 2);
            board[2][1] = new Pawn(FigureColor.BLACK, 2, 1);
            board[3][0] = new Pawn(FigureColor.BLACK, 3, 0);
            board[0][6] = new Pawn(FigureColor.BLACK, 0, 6);
            board[1][7] = new Pawn(FigureColor.BLACK, 1, 7);
            board[2][8] = new Pawn(FigureColor.BLACK, 2, 8);
            board[3][9] = new Pawn(FigureColor.BLACK, 3, 9);
    }

    public final Figure[][] getBoard() {
        return board;
    }

    public final int getHeight() {
        return BOARD_HEIGHT;
    }

    public final int getWidth() {
        return BOARD_WIDTH;
    }

}
package ru.vsu.cs.cg.oop.galaChess.engine;

import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.moveLogic.Bishop;
import ru.vsu.cs.cg.oop.galaChess.figures.moveLogic.King;
import ru.vsu.cs.cg.oop.galaChess.figures.moveLogic.Pawn;
import ru.vsu.cs.cg.oop.galaChess.figures.moveLogic.Rook;

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
            board[9][0] = new King(FigureColor.WHITE);
            board[9][9] = new King(FigureColor.WHITE);

            board[0][0] = new King(FigureColor.BLACK);
            board[0][9] = new King(FigureColor.BLACK);
    }

    private static void initializeRooks() {
            board[9][2] = new Rook(FigureColor.WHITE);
            board[8][1] = new Rook(FigureColor.WHITE);
            board[7][0] = new Rook(FigureColor.WHITE);
            board[8][9] = new Rook(FigureColor.WHITE);
            board[9][8] = new Rook(FigureColor.WHITE);

            board[0][1] = new Rook(FigureColor.BLACK);
            board[1][0] = new Rook(FigureColor.BLACK);
            board[0][7] = new Rook(FigureColor.BLACK);
            board[1][8] = new Rook(FigureColor.BLACK);
            board[2][9] = new Rook(FigureColor.BLACK);
    }

    public static void initialiceBishops() {
            board[8][0] = new Bishop(FigureColor.WHITE);
            board[9][1] = new Bishop(FigureColor.WHITE);
            board[7][9] = new Bishop(FigureColor.WHITE);
            board[8][8] = new Bishop(FigureColor.WHITE);
            board[9][7] = new Bishop(FigureColor.WHITE);

            board[0][2] = new Bishop(FigureColor.BLACK);
            board[1][1] = new Bishop(FigureColor.BLACK);
            board[2][0] = new Bishop(FigureColor.BLACK);
            board[0][8] = new Bishop(FigureColor.BLACK);
            board[1][9] = new Bishop(FigureColor.BLACK);
    }

    private static void initializePawns() {
            board[6][0] = new Pawn(FigureColor.WHITE);
            board[7][1] = new Pawn(FigureColor.WHITE);
            board[8][2] = new Pawn(FigureColor.WHITE);
            board[9][3] = new Pawn(FigureColor.WHITE);
            board[6][9] = new Pawn(FigureColor.WHITE);
            board[7][8] = new Pawn(FigureColor.WHITE);
            board[8][7] = new Pawn(FigureColor.WHITE);
            board[9][6] = new Pawn(FigureColor.WHITE);

            board[0][3] = new Pawn(FigureColor.BLACK);
            board[1][2] = new Pawn(FigureColor.BLACK);
            board[2][1] = new Pawn(FigureColor.BLACK);
            board[3][0] = new Pawn(FigureColor.BLACK);
            board[0][6] = new Pawn(FigureColor.BLACK);
            board[1][7] = new Pawn(FigureColor.BLACK);
            board[2][8] = new Pawn(FigureColor.BLACK);
            board[3][9] = new Pawn(FigureColor.BLACK);
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
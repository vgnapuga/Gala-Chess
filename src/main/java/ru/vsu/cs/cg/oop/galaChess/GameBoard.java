package ru.vsu.cs.cg.oop.galaChess;

import ru.vsu.cs.cg.oop.galaChess.figures.Figure;
import ru.vsu.cs.cg.oop.galaChess.figures.FigureColor;
import ru.vsu.cs.cg.oop.galaChess.figures.FigureType;

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
            board[9][0] = new Figure(FigureType.KING, FigureColor.WHITE);
            board[9][9] = new Figure(FigureType.KING, FigureColor.WHITE);

            board[0][0] = new Figure(FigureType.KING, FigureColor.BLACK);
            board[0][9] = new Figure(FigureType.KING, FigureColor.BLACK);
    }

    private static void initializeRooks() {
            board[9][2] = new Figure(FigureType.ROOK, FigureColor.WHITE);
            board[8][1] = new Figure(FigureType.ROOK, FigureColor.WHITE);
            board[7][0] = new Figure(FigureType.ROOK, FigureColor.WHITE);
            board[8][9] = new Figure(FigureType.ROOK, FigureColor.WHITE);
            board[9][8] = new Figure(FigureType.ROOK, FigureColor.WHITE);

            board[0][1] = new Figure(FigureType.ROOK, FigureColor.BLACK);
            board[1][0] = new Figure(FigureType.ROOK, FigureColor.BLACK);
            board[0][7] = new Figure(FigureType.ROOK, FigureColor.BLACK);
            board[1][8] = new Figure(FigureType.ROOK, FigureColor.BLACK);
            board[2][9] = new Figure(FigureType.ROOK, FigureColor.BLACK);
    }

    public static void initialiceBishops() {
            board[8][0] = new Figure(FigureType.BISHOP, FigureColor.WHITE);
            board[9][1] = new Figure(FigureType.BISHOP, FigureColor.WHITE);
            board[7][9] = new Figure(FigureType.BISHOP, FigureColor.WHITE);
            board[8][8] = new Figure(FigureType.BISHOP, FigureColor.WHITE);
            board[9][7] = new Figure(FigureType.BISHOP, FigureColor.WHITE);

            board[0][2] =  new Figure(FigureType.BISHOP, FigureColor.BLACK);
            board[1][1] =  new Figure(FigureType.BISHOP, FigureColor.BLACK);
            board[2][0] =  new Figure(FigureType.BISHOP, FigureColor.BLACK);
            board[0][8] = new Figure(FigureType.BISHOP, FigureColor.BLACK);
            board[1][9] = new Figure(FigureType.BISHOP, FigureColor.BLACK);
    }

    private static void initializePawns() {
            board[6][0] = new Figure(FigureType.PAWN, FigureColor.WHITE);
            board[7][1] = new Figure(FigureType.PAWN, FigureColor.WHITE);
            board[8][2] = new Figure(FigureType.PAWN, FigureColor.WHITE);
            board[9][3] = new Figure(FigureType.PAWN, FigureColor.WHITE);
            board[6][9] = new Figure(FigureType.PAWN, FigureColor.WHITE);
            board[7][8] = new Figure(FigureType.PAWN, FigureColor.WHITE);
            board[8][7] = new Figure(FigureType.PAWN, FigureColor.WHITE);
            board[9][6] = new Figure(FigureType.PAWN, FigureColor.WHITE);

            board[0][3] =  new Figure(FigureType.PAWN, FigureColor.BLACK);
            board[1][2] =  new Figure(FigureType.PAWN, FigureColor.BLACK);
            board[2][1] = new Figure(FigureType.PAWN, FigureColor.BLACK);
            board[3][0] =  new Figure(FigureType.PAWN, FigureColor.BLACK);
            board[0][6] = new Figure(FigureType.PAWN, FigureColor.BLACK);
            board[1][7] = new Figure(FigureType.PAWN, FigureColor.BLACK);
            board[2][8] = new Figure(FigureType.PAWN, FigureColor.BLACK);
            board[3][9] = new Figure(FigureType.PAWN, FigureColor.BLACK);
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
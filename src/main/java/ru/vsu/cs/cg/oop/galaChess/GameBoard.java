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
    }

    private static void initializeBoard() {
        initializeKings(FigureColor.WHITE);
        initializeKings(FigureColor.BLACK);

        initializeRooks(FigureColor.WHITE);
        initializeRooks(FigureColor.BLACK);

        initialiceBishops(FigureColor.WHITE);
        initialiceBishops(FigureColor.BLACK);

        initializePawns(FigureColor.WHITE);
        initializePawns(FigureColor.BLACK);
    }

    private static void initializeKings(FigureColor color) {
        if (color == FigureColor.WHITE) {
            board[9][0] = new Figure(FigureType.KING, color);
            board[9][9] = new Figure(FigureType.KING, color);
        } else if (color == FigureColor.BLACK) {
            board[0][0] = new Figure(FigureType.KING, color);
            board[0][9] = new Figure(FigureType.KING, color);
        }
    }

    private static void initializeRooks(FigureColor color) {
        if (color == FigureColor.WHITE) {
            board[9][2] = new Figure(FigureType.ROOK, color);
            board[8][1] = new Figure(FigureType.ROOK, color);
            board[7][0] = new Figure(FigureType.ROOK, color);

            board[8][9] = new Figure(FigureType.ROOK, color);
            board[9][8] = new Figure(FigureType.ROOK, color);
        } else if (color == FigureColor.BLACK) {
            board[0][1] = new Figure(FigureType.ROOK, color);
            board[1][0] = new Figure(FigureType.ROOK, color);

            board[0][7] = new Figure(FigureType.ROOK, color);
            board[1][8] = new Figure(FigureType.ROOK, color);
            board[2][9] = new Figure(FigureType.ROOK, color);
        }
    }

    public static void initialiceBishops(FigureColor color) {
        if (color == FigureColor.WHITE) {
            board[8][0] = new Figure(FigureType.BISHOP, color);
            board[9][1] = new Figure(FigureType.BISHOP, color);

            board[7][9] = new Figure(FigureType.BISHOP, color);
            board[8][8] = new Figure(FigureType.BISHOP, color);
            board[9][7] = new Figure(FigureType.BISHOP, color);
        } else if (color == FigureColor.BLACK) {
            board[0][2] =  new Figure(FigureType.BISHOP, color);
            board[1][1] =  new Figure(FigureType.BISHOP, color);
            board[2][0] =  new Figure(FigureType.BISHOP, color);

            board[0][8] = new Figure(FigureType.BISHOP, color);
            board[1][9] = new Figure(FigureType.BISHOP, color);
        }
    }

    private static void initializePawns(FigureColor color) {
        if (color == FigureColor.WHITE) {
            board[6][0] = new Figure(FigureType.PAWN, color);
            board[7][1] = new Figure(FigureType.PAWN, color);
            board[8][2] = new Figure(FigureType.PAWN, color);
            board[9][3] = new Figure(FigureType.PAWN, color);

            board[6][9] = new Figure(FigureType.PAWN, color);
            board[7][8] = new Figure(FigureType.PAWN, color);
            board[8][7] = new Figure(FigureType.PAWN, color);
            board[9][6] = new Figure(FigureType.PAWN, color);
        } else if (color == FigureColor.BLACK) {
            board[0][3] =  new Figure(FigureType.PAWN, color);
            board[1][2] =  new Figure(FigureType.PAWN, color);
            board[2][1] = new Figure(FigureType.PAWN, color);
            board[3][0] =  new Figure(FigureType.PAWN, color);

            board[0][6] = new Figure(FigureType.PAWN, color);
            board[1][7] = new Figure(FigureType.PAWN, color);
            board[2][8] = new Figure(FigureType.PAWN, color);
            board[3][9] = new Figure(FigureType.PAWN, color);
        }
    }

    public final int getHeight() {
        return BOARD_HEIGHT;
    }

    public final int getWidth() {
        return BOARD_WIDTH;
    }

}
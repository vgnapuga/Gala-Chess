package ru.vsu.cs.cg.oop.galaChess.board;

import ru.vsu.cs.cg.oop.galaChess.figures.*;
import ru.vsu.cs.cg.oop.galaChess.figures.logic.*;

public final class GameBoard {

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
        initializeBishops();
        initializePawns();
    }

    private static void initializeKings() {
        new King(FigureColor.WHITE, board, 0, 9);
        new King(FigureColor.WHITE, board, 9, 9);

        new King(FigureColor.BLACK, board, 0, 0);
        new King(FigureColor.BLACK, board, 9, 0);
    }

    private static void initializeRooks() {
        new Rook(FigureColor.WHITE, board, 0, 7);
        new Rook(FigureColor.WHITE, board, 1, 8);
        new Rook(FigureColor.WHITE, board, 2, 9);
        new Rook(FigureColor.WHITE, board, 8, 9);
        new Rook(FigureColor.WHITE, board, 9, 8);

        new Rook(FigureColor.BLACK, board, 0, 1);
        new Rook(FigureColor.BLACK, board, 1, 0);
        new Rook(FigureColor.BLACK, board, 7, 0);
        new Rook(FigureColor.BLACK, board, 8, 1);
        new Rook(FigureColor.BLACK, board, 9, 2);
    }

    public static void initializeBishops() {
        new Bishop(FigureColor.WHITE, board, 0, 8);
        new Bishop(FigureColor.WHITE, board, 1, 9);
        new Bishop(FigureColor.WHITE, board, 7, 9);
        new Bishop(FigureColor.WHITE, board, 8, 8);
        new Bishop(FigureColor.WHITE, board, 9, 7);

        new Bishop(FigureColor.BLACK, board, 2, 0);
        new Bishop(FigureColor.BLACK, board, 1, 1);
        new Bishop(FigureColor.BLACK, board, 0, 2);
        new Bishop(FigureColor.BLACK, board, 8, 0);
        new Bishop(FigureColor.BLACK, board, 9, 1);
    }

    private static void initializePawns() {
        new Pawn(FigureColor.WHITE, board, 0, 6);
        new Pawn(FigureColor.WHITE, board, 1, 7);
        new Pawn(FigureColor.WHITE, board, 2, 8);
        new Pawn(FigureColor.WHITE, board, 3, 9);
        new Pawn(FigureColor.WHITE, board, 6, 9);
        new Pawn(FigureColor.WHITE, board, 7, 8);
        new Pawn(FigureColor.WHITE, board, 8, 7);
        new Pawn(FigureColor.WHITE, board, 9, 6);

        new Pawn(FigureColor.BLACK, board, 0, 3);
        new Pawn(FigureColor.BLACK, board, 1, 2);
        new Pawn(FigureColor.BLACK, board, 2, 1);
        new Pawn(FigureColor.BLACK, board, 3, 0);
        new Pawn(FigureColor.BLACK, board, 6, 0);
        new Pawn(FigureColor.BLACK, board, 7, 1);
        new Pawn(FigureColor.BLACK, board, 8, 2);
        new Pawn(FigureColor.BLACK, board, 9, 3);
    }

    public Figure[][] getBoard() {
        return board;
    }

}
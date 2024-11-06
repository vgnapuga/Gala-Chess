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
        new King(FigureColor.WHITE, 0, 9, board);
        new King(FigureColor.WHITE, 9, 9, board);

        new King(FigureColor.BLACK, 0, 0, board);
        new King(FigureColor.BLACK, 9, 0, board);
    }

    private static void initializeRooks() {
        new Rook(FigureColor.WHITE, 0, 7, board);
        new Rook(FigureColor.WHITE, 1, 8, board);
        new Rook(FigureColor.WHITE, 2, 9, board);
        new Rook(FigureColor.WHITE, 8, 9, board);
        new Rook(FigureColor.WHITE, 9, 8, board);

        new Rook(FigureColor.BLACK, 0, 1, board);
        new Rook(FigureColor.BLACK, 1, 0, board);
        new Rook(FigureColor.BLACK, 7, 0, board);
        new Rook(FigureColor.BLACK, 8, 1, board);
        new Rook(FigureColor.BLACK, 9, 2, board);
    }

    public static void initialiceBishops() {
        new Bishop(FigureColor.WHITE, 0, 8, board);
        new Bishop(FigureColor.WHITE, 1, 9, board);
        new Bishop(FigureColor.WHITE, 7, 9, board);
        new Bishop(FigureColor.WHITE, 8, 8, board);
        new Bishop(FigureColor.WHITE, 9, 7, board);

        new Bishop(FigureColor.BLACK, 2, 0, board);
        new Bishop(FigureColor.BLACK, 1, 1, board);
        new Bishop(FigureColor.BLACK, 0, 2, board);
        new Bishop(FigureColor.BLACK, 8, 0, board);
        new Bishop(FigureColor.BLACK, 9, 1, board);
    }

    private static void initializePawns() {
        new Pawn(FigureColor.WHITE, 0, 6, board);
        new Pawn(FigureColor.WHITE, 1, 7, board);
        new Pawn(FigureColor.WHITE, 2, 8, board);
        new Pawn(FigureColor.WHITE, 3, 9, board);
        new Pawn(FigureColor.WHITE, 6, 9, board);
        new Pawn(FigureColor.WHITE, 7, 8, board);
        new Pawn(FigureColor.WHITE, 8, 7, board);
        new Pawn(FigureColor.WHITE, 9, 6, board);

        new Pawn(FigureColor.BLACK, 0, 3, board);
        new Pawn(FigureColor.BLACK, 1, 2, board);
        new Pawn(FigureColor.BLACK, 2, 1, board);
        new Pawn(FigureColor.BLACK, 3, 0, board);
        new Pawn(FigureColor.BLACK, 6, 0, board);
        new Pawn(FigureColor.BLACK, 7, 1, board);
        new Pawn(FigureColor.BLACK, 8, 2, board);
        new Pawn(FigureColor.BLACK, 9, 3, board);
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
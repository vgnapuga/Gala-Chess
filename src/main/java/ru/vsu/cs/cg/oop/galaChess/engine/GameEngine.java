package ru.vsu.cs.cg.oop.galaChess.engine;

import ru.vsu.cs.cg.oop.galaChess.board.GameBoard;
import ru.vsu.cs.cg.oop.galaChess.exceptions.InvalidMoveException;
import ru.vsu.cs.cg.oop.galaChess.exceptions.InvalidTurnExceprion;
import ru.vsu.cs.cg.oop.galaChess.exceptions.InvalidTurnException;
import ru.vsu.cs.cg.oop.galaChess.figures.Figure;
import ru.vsu.cs.cg.oop.galaChess.figures.FigureColor;
import ru.vsu.cs.cg.oop.galaChess.figures.FigureType;
import ru.vsu.cs.cg.oop.galaChess.figures.movement.King;

public final class GameEngine {

    private enum GameState {
        START,
        WHITE_MOVE,
        BLACK_MOVE,
        END;
    }

    private static Figure[][] board;

    public GameEngine() {
        GameBoard GameBoard = new GameBoard();
        board = GameBoard.getBoard();
        GameState gameState = GameState.START;

        switch (gameState) {
            case START:
                whiteMove(0 ,0 ,0 ,0);

                if (isEnd())
                    gameState = GameState.END;
                else
                    gameState = GameState.BLACK_MOVE;
            case BLACK_MOVE:
                 blackMove(0, 0, 0, 0);

                 if (isEnd())
                     gameState = GameState.END;
                 else
                     gameState = GameState.WHITE_MOVE;
            case END:
                if (blackKingsCount() == 0)
                    System.out.println("White wins.");
                else if (whiteKingsCount() == 0)
                    System.out.println("Black wins.");
                else
                    System.out.println("Draw.");

                break;
        }
    }

    private static void whiteMove(int x0, int y0, int x1, int y1) {
        if (board[x0][y0].getColor() != FigureColor.WHITE)
            throw new InvalidTurnException(board[x0][y0].getColor());
    }

    private static void blackMove(int x0, int y0, int x1, int y1) {

    }

    private static boolean isEnd() {
        return (whiteKingsCount() == 0 || blackKingsCount() == 0) ||
                (whiteKingsCount() == 1 && blackKingsCount() == 1);
    }

    private static int whiteKingsCount() {
        return kingsCount(FigureColor.WHITE);
    }

    private static int blackKingsCount() {
        return kingsCount(FigureColor.BLACK);
    }

    private static int kingsCount(FigureColor color) {
        int count = 0;

        for (Figure[] figures : board) {
            for (Figure figure : figures) {
                if (figure.getType() == FigureType.KING && figure.getColor() == color)
                    count++;
            }
        }

        return count;
    }

}
package ru.vsu.cs.cg.oop.galaChess.engine;

import ru.vsu.cs.cg.oop.galaChess.board.GameBoard;
import ru.vsu.cs.cg.oop.galaChess.figures.*;

public final class GameEngine {

    private enum GameState {
        WHITE_MOVE,
        BLACK_MOVE,
        END;
    }

    private GameState gameState;
    private Figure[][] board;
    private int[][] selectedCell;

    public GameEngine(GameBoard gameBoard) {
        this.board = gameBoard.getBoard();
        this.gameState = GameState.WHITE_MOVE;
        this.selectedCell = null;
    }

}
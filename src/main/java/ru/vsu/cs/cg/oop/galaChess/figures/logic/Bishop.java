package ru.vsu.cs.cg.oop.galaChess.figures.logic;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

import static ru.vsu.cs.cg.oop.galaChess.figures.logic.Rook.rookMove;

public class Bishop extends Figure implements Movable {

    public Bishop(final FigureColor color, int x, int y, Figure[][] board) {
        super(FigureType.BISHOP, color, x, y, board);
    }

    @Override
    public void moveTo(Figure[][] board, int x1, int y1) {
        int x0 = this.getX();
        int y0 = this.getY();

        if (!isValidMove(board, x0, y0, x1, y1)) {
            throw new IllegalArgumentException("Invalid move");
        } else {
            this.setPosition(board, x1, y1);
            board[x0][y0] = null;
        }
    }

    private boolean isValidMove(Figure[][] board, int x0, int y0, int x1, int y1) {
        if (Movable.isOutOfBoard(x0) || Movable.isOutOfBoard(y0) ||
                Movable.isOutOfBoard(x1) || Movable.isOutOfBoard(y1))
            return false;

        Figure start = board[x0][y0];
        Figure end = board[x1][y1];

        if (end != null && start.isSameColorWith(end))
            return false;

        if ((x0 == x1 && y0 == y1) || start == null)
            return false;

        if (this.isInMiddle())
            return rookMove(board, x0, y0, x1, y1);
        else
            return bishopMove(board, x0, y0, x1, y1);
    }


    static final boolean bishopMove(Figure[][] board, int x0, int y0, int x1, int y1) {
        if (Math.abs(x1 - x0) != Math.abs(y1 - y0))
            return false;

        int dx = (x1 > x0) ? 1 : -1;
        int dy = (y1 > y0) ? 1 : -1;

        for (int i = 1; i < Math.abs(x1 - x0); i++) {
            if (board[x0 + i * dx][y0 + i * dy] != null)
                return false;
        }

        return true;
    }

}
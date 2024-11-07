package ru.vsu.cs.cg.oop.galaChess.figures.logic;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

import static ru.vsu.cs.cg.oop.galaChess.figures.logic.Bishop.bishopMove;

public class Rook extends Figure implements Movable {

    public Rook(final FigureColor color, int x, int y, Figure[][] board) {
        super(FigureType.ROOK, color, x, y, board);
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
            return bishopMove(board, x0, y0, x1, y1);
        else
            return rookMove(board, x0, y0, x1, y1);
    }

    static boolean rookMove(Figure[][] board, int x0, int y0, int x1, int y1) {
        if (x0 != x1 && y0 != y1)
            return false;

        if (x0 != x1)
            return horizontalMove(board, x0, y0, x1);
        else
            return verticalMove(board, x0, y0, y1);
    }


    private static boolean verticalMove(Figure[][] board, int x0, int y0, int y1) {
        int dy = (y1 > y0) ? 1 : -1;

        for (int y = y0 + dy; y != y1; y += dy) {
            if (board[x0][y] != null)
                return false;
        }

        return true;
    }

    private static boolean horizontalMove(Figure[][] board, int y0, int x0, int x1) {
        int dx = (x1 > x0) ? 1 : -1;

        for (int x = x0 + dx; x != x1; x += dx) {
            if (board[x][y0] != null)
                return false;
        }

        return true;
    }

}
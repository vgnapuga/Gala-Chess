package ru.vsu.cs.cg.oop.galaChess.figures.logic;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

import static ru.vsu.cs.cg.oop.galaChess.figures.logic.Bishop.bishopMove;

public class Rook extends Figure implements Movable {

    public Rook(final FigureColor color, int x, int y, Figure[][] board) {
        super(FigureType.ROOK, color, x, y, board);
    }

    @Override
    public void move(Figure[][] board, int x1, int y1) {
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
        Figure start = board[x0][y0];
        Figure end = board[x1][y1];

        if ((x0 == x1 && y0 == y1) || start == null)
            return false;

        if (this.isInMiddle())
            return bishopMove();
        else
            return rookMove(board, x0, y0, x1, y1);
    }

    protected static boolean rookMove(Figure[][] board, int x0, int y0, int x1, int y1) {
        if (x0 >= board[0].length || x1 >= board[0].length || y0 >= board.length || y1 >= board.length)
            return false;

        Figure start = board[x0][y0];
        Figure end = board[x1][y1];

        if (x0 != x1 && y0 != y1)
            return false;
        else if (x0 != x1)
            return horizontalMove(board, start, x0, y0, x1, y1);
        else if (y0 != y1)
            return verticalMove(board, start, x0, y0, x1, y1);

        return false;
    }

    private static boolean horizontalMove(Figure[][] board, Figure start, int x0, int y0, int x1, int y1) {
        if (x0 > x1) {
            for (int x = x0; x > x1; x--) {
                if (board[x - 1][y0] != null ||
                        (board[x1][y1] != null && start.isSameColor(board[x1][y1])))
                    return false;
                else
                    return true;
            }
        } else if (x0 < x1) {
            for (int x = x0; x < x1; x++) {
                if (board[x + 1][y0] != null ||
                        (board[x1][y1] != null && start.isSameColor(board[x1][y1])))
                    return false;
                else
                    return true;
            }
        }

        return false;
    }

    private static final boolean verticalMove(Figure[][] board, Figure start, int x0, int y0, int x1, int y1) {
        if (y0 > y1) {
            for (int y = y0; y > y1; y--) {
                if (board[x0][y - 1] != null || (board[x1][y1] != null &&
                        board[x1][y - 1].isSameColor(start)))
                    return false;
                else
                    return true;
            }
        } else if (y0 < y1) {
            for (int y = y0; y < y1; y++) {
                if (board[x0][y + 1] != null || (board[x1][y1] != null && board[x1][y + 1].isSameColor(start)))
                    return false;
                else
                    return true;
            }
        }

        return false;
    }

}
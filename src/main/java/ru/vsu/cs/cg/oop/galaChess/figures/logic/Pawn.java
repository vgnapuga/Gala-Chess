package ru.vsu.cs.cg.oop.galaChess.figures.logic;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public class Pawn extends Figure implements Movable {

    public Pawn(final FigureColor color, int x, int y, Figure[][] board) {
        super(FigureType.PAWN, color, x, y, board);
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

        if ((x0 == x1 && y0 == y1) || start == null)
            return false;

        return false;
    }

}
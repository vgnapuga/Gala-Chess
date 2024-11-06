package ru.vsu.cs.cg.oop.galaChess.figures.moveLogic;

import ru.vsu.cs.cg.oop.galaChess.figures.*;

public class Rook extends Figure implements Movable {

    public Rook(final FigureColor color) {
        super(FigureType.ROOK, color);
    }

    @Override
    public void move(Figure[][] board, int x0, int y0, int x1, int y1) {
        Figure start = board[x0][y0];
        Figure end = board[x1][y1];

        if (!isValidMove(start, end, x0, y0, x1, y1)) {
            throw new IllegalArgumentException("Invalid move");
        } else {
            board[x1][y1] = start;
            board[x0][y0] = null;
        }
    }

    private boolean isValidMove(Figure start, Figure end, int x0, int y0, int x1, int y1) {
        if ((x0 == x1 && y0 == y1) || start == null || end.getColor() == start.getColor()) {
            return false;
        }

        return true;
    }

}
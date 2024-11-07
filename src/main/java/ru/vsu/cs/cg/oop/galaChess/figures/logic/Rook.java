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

        Figure start = board[x0][y0];
        Figure end = board[x1][y1];

        if (!isValidMove(start, end, x0, y0, x1, y1)) {
            throw new IllegalArgumentException("Invalid move");
        } else {
            this.setPosition(board, x1, y1);
            board[x0][y0] = null;
        }
    }

    private boolean isValidMove(Figure start, Figure end, int x0, int y0, int x1, int y1) {
        if ((x0 == x1 && y0 == y1) || start == null)
            return false;

        if (this.isInMiddle())
            return bishopMove();
        else
            return rookMove();
    }

    protected static final boolean rookMove() {
        return false;
    }

}
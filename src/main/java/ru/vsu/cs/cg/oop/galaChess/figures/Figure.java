package ru.vsu.cs.cg.oop.galaChess.figures;

public class Figure implements Movable {

    private final FigureType type;
    private final FigureColor color;
    private int x;
    private int y;

    public Figure(final FigureType type, final FigureColor color, Figure[][] board, int x, int y) {
        this.type = type;
        this.color = color;
        this.x = x;
        this.y = y;

        this.setPosition(board, x, y);
    }

    @Override
    public void moveTo(Figure[][] board, final int x1, final int y1) {
        int x0 = this.getX();
        int y0 = this.getY();

        if (isValidMove(board, x0, y0, x1, y1)) {
            this.setPosition(board, x1, y1);
            board[x0][y0] = null;
        } else {
            throw new IllegalArgumentException("Invalid move");
        }
    }

    protected boolean isValidMove(final Figure[][] board, final int x0, final int y0,
                                  final int x1, final int y1) {
        return false;
    }

    @Override
    public boolean isOutOfBoard(final int coordinate1, final int coordinate2) {
        return coordinate1 < 0 || coordinate1 > 9 ||
                coordinate2 < 0 || coordinate2 > 9;
    }

    public final void setPosition(Figure[][] board, final int x, final int y) {
        this.x = x;
        this.y = y;

        board[x][y] = this;
    }

    public final FigureType getType() {
        return type;
    }

    public final FigureColor getColor() {
        return color;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final boolean isSameColorWith(Figure figure) {
        return this.getColor() == figure.getColor();
    }

    public final boolean isInMiddle() {
        return ((this.x == 4 || this.x == 5) || (this.y == 4 || this.y == 5));
    }

}
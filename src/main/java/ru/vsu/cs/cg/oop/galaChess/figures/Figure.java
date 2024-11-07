package ru.vsu.cs.cg.oop.galaChess.figures;

public class Figure {

    private final FigureType type;
    private final FigureColor color;
    private int x;
    private int y;

    public Figure(final FigureType type, final FigureColor color, int x, int y, Figure[][] board) {
        this.type = type;
        this.color = color;
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

    public final void setPosition(Figure[][] board, final int x, final int y) {
        this.x = x;
        this.y = y;

        board[x][y] = this;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final boolean isSameColor(Figure figure) {
        return this.getColor() == figure.getColor();
    }

    public final boolean isInMiddle() {
        return ((this.x == 4 || this.x == 5) || (this.y == 4 || this.y == 5));
    }

}
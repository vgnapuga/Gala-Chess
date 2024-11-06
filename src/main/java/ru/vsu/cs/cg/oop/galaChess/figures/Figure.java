package ru.vsu.cs.cg.oop.galaChess.figures;

public class Figure {

    private final FigureType type;
    private final FigureColor color;

    private int x;
    private int y;

    public Figure(final FigureType type, final FigureColor color, int x, int y) {
        this.type = type;
        this.color = color;
        this.x = x;
        this.y = y;
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
    public final void setX(int x) {
        this.x = x;
    }

    public final int getY() {
        return y;
    }
    public final void setY(int y) {
        this.y = y;
    }

    public final boolean isSameColor(Figure figure) {
        return this.getColor() == figure.getColor();
    }

    public static final boolean isInMiddle(int x, int y) {
        return ((x == 4 || x == 5) || (y == 4 || y == 5));
    }

}
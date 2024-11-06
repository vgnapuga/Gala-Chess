package ru.vsu.cs.cg.oop.galaChess.figures;

public class Figure {

    private final FigureType type;
    private final FigureColor color;

    public Figure(final FigureType type, final FigureColor color) {
        this.type = type;
        this.color = color;
    }

    public final FigureType getType() {
        return type;
    }

    public final FigureColor getColor() {
        return color;
    }

}

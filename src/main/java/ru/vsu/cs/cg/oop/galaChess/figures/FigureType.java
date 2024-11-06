package ru.vsu.cs.cg.oop.galaChess.figures;

public enum FigureType {

    PAWN('P'),
    ROOK('R'),
    BISHOP('B'),
    KING('K');

    private final char type;

    FigureType(char type) {
        this.type = type;
    }

}
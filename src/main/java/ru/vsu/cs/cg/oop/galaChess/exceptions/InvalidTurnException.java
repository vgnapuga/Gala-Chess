package ru.vsu.cs.cg.oop.galaChess.exceptions;

import ru.vsu.cs.cg.oop.galaChess.figures.FigureColor;

public class InvalidTurnException extends RuntimeException {

  public InvalidTurnException(FigureColor color) {
    super("That's not " + color + " turn");
  }

}

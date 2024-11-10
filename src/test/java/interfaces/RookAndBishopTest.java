package interfaces;

public interface RookAndBishopTest extends MovableTest {

    void testInvalidMoveThrowFigure();

    void testInvalidMoveToEmptyCellFromCentre();
    void testInvalidMoveThrowFigureFromCentre();

}
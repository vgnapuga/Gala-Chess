package interfaces;

public interface RookAndBishopTest extends MovableTest {

    void testInvalidMoveToEmptyCellFromCentre();
    void testInvalidMoveThrowFigure();

    void testInvalidMoveThrowFigureFromCentre();

}
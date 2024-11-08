package interfaces;

public interface MovableTest {

    void testInvalidMoveOutOfBoard();
    void testInvalidMoveToSameCell();
    void testValidMoveToEmptyCell();
    void testInvalidMoveToEmptyCell();
    void testValidMoveToNotEmptyCell();
    void testInvalidMoveToNotEmptyCell();

    void testInvalidMoveOutOfBoardFromCentre();
    void testInvalidMoveToSameCellFromCentre();
    void testValidMoveToEmptyCellFromCentre();
    void testValidMoveToNotEmptyCellFromCentre();
    void testInvalidMoveToNotEmptyCellFromCentre();

}

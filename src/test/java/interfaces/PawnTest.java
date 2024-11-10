package interfaces;

public interface PawnTest extends MovableTest {

    void testValidMoveThrowCellToEmptyCell();
    void testInvalidMoveThrowCellToEmptyCell();
    void testValidMoveThrowCellToNotEmptyCell();
    void testInvalidMoveThrowCellToNotEmptyCell();

    void testInvalidMoveToEmptyCellFromCentre();

}

package Assignment4.Model.Blocks;

public interface TetrisBlock {
    // MOVEMENT LOGIC
    void fallDown();
    void moveLeft();
    void moveRight();
    void moveDropDown();
    void rotateBlock();

    // SHIT TO MAKE IT WORK
    void setLockBlock(boolean x);
    boolean getLockBlock();
    void setCurrentBoard(String[][] newBlockPosition);
    String[][] getCurrentBoard();
    String getBlockType();
}
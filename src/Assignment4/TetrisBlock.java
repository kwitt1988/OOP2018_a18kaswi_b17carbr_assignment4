package Assignment4;

public interface TetrisBlock {
    void setLockBlock(boolean x);
    boolean getLockBlock();
    void setBlockPosition(String[][] newBlockPosition);
    String[][] getBlockPosition();
    void moveDown();
    void moveLeft();
    void moveRight();
    void moveDropDown();void rotateBlock();
}
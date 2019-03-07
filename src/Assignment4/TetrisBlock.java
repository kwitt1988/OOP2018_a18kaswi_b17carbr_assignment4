package Assignment4;

public interface TetrisBlock {
    String[][] getBlockPosition();
    void moveDown();
    void moveLeft();
    void moveRight();
    void lockBlock();
    void moveDropDown();
    void rotateBlock();
    boolean getLockBlock();
    void setLockBlock();
}
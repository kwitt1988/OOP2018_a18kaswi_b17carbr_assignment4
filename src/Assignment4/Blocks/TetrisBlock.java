package Assignment4.Blocks;

public interface TetrisBlock {
    void fallDown();
    void moveLeft();
    void moveRight();
    void moveDropDown();
    void rotateBlock();
    void setLockBlock(boolean x);
    boolean getLockBlock();
    void setBlockPosition(String[][] newBlockPosition);
    String[][] getBlockPosition();
    String getBlockType();
}
package Assignment4.Model;

// This interface supports the BlockFactorys creation of block-objects.

public interface TetrisBlock {
    void fallDown();
    void moveLeft();
    void moveRight();
    void moveDropDown();
    void rotateBlock();
    boolean getLockBlock();
    String[][] getBlockPosition();
    String getBlockType();
}
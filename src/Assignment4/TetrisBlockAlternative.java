package Assignment4;

public interface TetrisBlockAlternative {
    String[][] getBlockPosition();
    void moveLeft();
    String[][] moveRight(String[][] blockPosition);
    void moveDropDown();
    void rotateBlock();
}

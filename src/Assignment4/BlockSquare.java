package Assignment4;

import java.util.Arrays;

public class BlockSquare extends BlockModel {
    String blockType = "Square";
    int currentAngle = 0;

    BlockSquare(TetrisBoard tetrisBoard) {
        blockPosition = Arrays.copyOf(tetrisBoard.getTetrisBoard(), tetrisBoard.getTetrisBoard().length);
        setBlockPosition(0);
    }

    // UNIQUE FOR BLOCK
    public void setBlockPosition(int angle) {
        blockPosition[1][1] = currentPiece1;
        blockPosition[1][2] = currentPiece2;
        blockPosition[2][2] = currentPiece3;
        blockPosition[2][3] = currentPiece4;
    }
}

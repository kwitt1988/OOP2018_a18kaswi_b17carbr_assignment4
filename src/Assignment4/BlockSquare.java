package Assignment4;

import java.util.Arrays;

public class BlockSquare extends BlockModel {
    String blockType = "Square";
    int currentAngle = 0;

    BlockSquare(TetrisBoard tetrisBoard) {
        super.blockType = blockType;
        blockPosition = Arrays.copyOf(tetrisBoard.getTetrisBoard(), tetrisBoard.getTetrisBoard().length);
        setBlockPosition(0);
    }

    // UNIQUE FOR BLOCK
    public void setBlockPosition(int angle) {
                blockPosition[1][1] = blockType;
                blockPosition[1][2] = blockType;
                blockPosition[2][2] = blockType;
                blockPosition[2][3] = blockType;
    }
}
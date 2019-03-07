package Assignment4;

import java.util.Arrays;

public class BlockL extends BlockModel {
    String blockType = "L";
    int angle = 0;

    BlockL(TetrisBoard tetrisBoard) {
        super.angle = angle;
        blockPosition = Arrays.copyOf(tetrisBoard.getTetrisBoard(), tetrisBoard.getTetrisBoard().length);
        setBlockPosition(0);
    }

    // UNIQUE FOR BLOCK
    public void setBlockPosition(int angle) {
        blockPosition[0][2] = currentPiece1;
        blockPosition[1][2] = currentPiece2;
        blockPosition[2][2] = currentPiece3;
        blockPosition[2][3] = currentPiece4;
    }

    @Override
    public int rotateRow(int currentRow, String currentPiece) {
        int newRow = 0;
        switch (angle) {
            case 0:
                if (currentPiece == currentPiece1) {
                    newRow = currentRow;
                    break;
                } else if (currentPiece == currentPiece2) {
                    newRow = (currentRow - 1);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newRow = (currentRow - 2);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newRow = (currentRow - 1);
                    break;
                }
        }
        return newRow;
    }

    @Override
    public int rotateColumn(int currentColumn, String currentPiece) {
        int newColumn = 0;
        switch (angle) {
            case 0:
                if (currentPiece == currentPiece1) {
                    newColumn = (currentColumn + 2);
                    System.out.println(newColumn);
                    break;
                } else if (currentPiece == currentPiece2) {
                    newColumn = (currentColumn + 1);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newColumn = (currentColumn );
                    break;
                } else if (currentPiece == currentPiece4) {
                    newColumn = (currentColumn - 1);
                    break;
                }
        }
        return newColumn;
    }
}
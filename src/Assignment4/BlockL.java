package Assignment4;

import java.util.Arrays;

public class BlockL extends BlockModel {
    String blockType = "L";

    BlockL(TetrisBoard tetrisBoard) {
        blockPosition = Arrays.copyOf(tetrisBoard.getTetrisBoard(), tetrisBoard.getTetrisBoard().length);
        setBlockPosition();
    }

    // UNIQUE FOR BLOCK
    public void setBlockPosition() {
        blockPosition[1][2] = currentPiece1;
        blockPosition[2][2] = currentPiece2;
        blockPosition[3][2] = currentPiece3;
        blockPosition[3][3] = currentPiece4;
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
            case 90:
                if (currentPiece == currentPiece1) {
                    System.out.println(currentRow + 2 + " row 1");
                    newRow = currentRow + 2;
                    break;
                } else if (currentPiece == currentPiece2) {
                    System.out.println(currentRow + 1 + "row 2");
                    newRow = currentRow + 1;
                    break;
                } else if (currentPiece == currentPiece3) {
                    System.out.println(currentRow + "row 3");
                    newRow = currentRow;
                    break;
                } else if (currentPiece == currentPiece4) {
                    System.out.println(currentRow -1 + "row 4");
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
            case 90:
                if (currentPiece == currentPiece1) {
                    System.out.println(currentColumn + "column 1");
                    newColumn = currentColumn;
                    break;
                } else if (currentPiece == currentPiece2) {
                    System.out.println(currentColumn +1  + "column 2");
                    newColumn = (currentColumn + 1);
                    break;
                } else if (currentPiece == currentPiece3) {
                    System.out.println(currentColumn +2 + "column 3");
                    newColumn = (currentColumn + 2);
                    break;
                } else if (currentPiece == currentPiece4) {
                    System.out.println(currentColumn +1 + "column 4");
                    newColumn = (currentColumn + 1);
                    break;
                }
        }
        return newColumn;
    }
}

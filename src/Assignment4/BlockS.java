package Assignment4;

import java.util.Arrays;

public class BlockS extends BlockModel {
    String blockType = "L";

    BlockS(TetrisBoard tetrisBoard) {
        blockPosition = Arrays.copyOf(tetrisBoard.getTetrisBoard(), tetrisBoard.getTetrisBoard().length);
        setBlockPosition();
    }

    // UNIQUE FOR BLOCK
    public void setBlockPosition() {
        blockPosition[1][1] = currentPiece1;
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
                    newRow = (currentRow + 1);
                    break;
                } else if (currentPiece == currentPiece2) {
                    newRow = (currentRow + 2);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newRow = (currentRow - 1);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newRow = (currentRow);
                    break;
                }
            case 90:
                if (currentPiece == currentPiece1) {
                    System.out.println(currentRow + 2 +" = row, piece 1");
                    newRow = currentRow - 1;
                    break;
                } else if (currentPiece == currentPiece2) {
                    System.out.println(currentRow + 1 + " = row, piece 2");
                    newRow = currentRow - 2;
                    break;
                } else if (currentPiece == currentPiece3) {
                    System.out.println(currentRow + " = row, piece 3");
                    newRow = currentRow + 1;
                    break;
                } else if (currentPiece == currentPiece4) {
                    System.out.println(currentRow - 1 + " = row, piece4");
                    newRow = (currentRow);
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
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece2) {
                    newColumn = (currentColumn - 1);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newColumn = (currentColumn - 1);
                    break;
                }
            case 90:
                if (currentPiece == currentPiece1) {
                    System.out.println(currentColumn + " = colum, piece 1");
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece2) {
                    System.out.println(currentColumn + 1 + " = colum, piece 2");
                    newColumn = (currentColumn + 1);
                    break;
                } else if (currentPiece == currentPiece3) {
                    System.out.println(currentColumn + 2 + " = colum, piece3");
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece4) {
                    System.out.println(currentColumn + 1 + " = colum, piece4");
                    newColumn = (currentColumn + 1);
                    break;
                }
        }
        return newColumn;
    }
}
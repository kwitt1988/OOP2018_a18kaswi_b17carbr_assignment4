package Assignment4.Blocks;

import Assignment4.TetrisBoard;

import java.util.Arrays;

class BlockLine extends BlockModel {
    String blockType = "Line";

    BlockLine(TetrisBoard tetrisBoard) {
        super.blockType = blockType;
        blockPosition = Arrays.copyOf(tetrisBoard.getTetrisBoard(), tetrisBoard.getTetrisBoard().length);
        setBlockPosition();
    }

    // UNIQUE FOR BLOCK
    public void setBlockPosition() {
        blockPosition[1][2] = currentPiece1;
        blockPosition[1][3] = currentPiece2;
        blockPosition[1][4] = currentPiece3;
        blockPosition[1][5] = currentPiece4;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public int rotateRow(int currentRow, String currentPiece) {
        int newRow = 0;
        switch (angle) {
            case 0:
                if (currentPiece == currentPiece1) {
                    newRow = currentRow;
                    break;
                } else if (currentPiece == currentPiece2) {
                    newRow = (currentRow + 1);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newRow = (currentRow + 2);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newRow = (currentRow + 3);
                    break;
                }
            case 90:
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
                    newRow = (currentRow - 3);
                    break;
                }
            case 180:
                if (currentPiece == currentPiece1) {
                    newRow = currentRow;
                    break;
                } else if (currentPiece == currentPiece2) {
                    newRow = (currentRow + 1);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newRow = (currentRow + 2);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newRow = (currentRow + 3);
                    break;
                }
            case 270:
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
                    newRow = (currentRow - 3);
                    break;
                }
        }
        return newRow;
    }

    @SuppressWarnings("Duplicates")
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
                    newColumn = (currentColumn - 2);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newColumn = (currentColumn - 3);
                    break;
                }
            case 90:
                if (currentPiece == currentPiece1) {
                    newColumn = currentColumn;
                    break;
                } else if (currentPiece == currentPiece2) {
                    newColumn = (currentColumn + 1);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newColumn = (currentColumn + 2);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newColumn = (currentColumn + 3);
                    break;
                }

            case 180:
                if (currentPiece == currentPiece1) {
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece2) {
                    newColumn = (currentColumn - 1);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newColumn = (currentColumn - 2);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newColumn = (currentColumn - 3);
                    break;
                }

            case 270:
                if (currentPiece == currentPiece1) {
                    newColumn = currentColumn;
                    break;
                } else if (currentPiece == currentPiece2) {
                    newColumn = (currentColumn + 1);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newColumn = (currentColumn + 2);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newColumn = (currentColumn + 3);
                    break;
                }
        }
        return newColumn;
    }
}
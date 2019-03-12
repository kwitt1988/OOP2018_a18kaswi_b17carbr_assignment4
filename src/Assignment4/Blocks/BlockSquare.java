package Assignment4.Blocks;

import Assignment4.TetrisBoard;

import java.util.Arrays;

class BlockSquare extends BlockModel {
    String blockType = "Square";

    protected BlockSquare(TetrisBoard tetrisBoard) {
        super.blockType = blockType;
        blockPosition = Arrays.copyOf(tetrisBoard.getTetrisBoard(), tetrisBoard.getTetrisBoard().length);
        setBlockPosition();
    }

    // UNIQUE FOR BLOCK
    public void setBlockPosition() {
        blockPosition[1][2] = currentPiece1;
        blockPosition[1][3] = currentPiece2;
        blockPosition[2][2] = currentPiece3;
        blockPosition[2][3] = currentPiece4;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public int rotateRow(int currentRow, String currentPiece) {
        int newRow = 0;
        switch (angle) {
            case 0:
                if (currentPiece == currentPiece1) {
                    newRow = currentRow + 1;
                    break;
                } else if (currentPiece == currentPiece2) {
                    newRow = currentRow + 1;
                    break;
                } else if (currentPiece == currentPiece3) {
                    newRow = currentRow + 1;
                    break;
                } else if (currentPiece == currentPiece4) {
                    newRow = currentRow + 1;
                    break;
                }
            case 90:
                if (currentPiece == currentPiece1) {
                    newRow = currentRow + 1;
                    break;
                } else if (currentPiece == currentPiece2) {
                    newRow = currentRow + 1;
                    break;
                } else if (currentPiece == currentPiece3) {
                    newRow = currentRow + 1;
                    break;
                } else if (currentPiece == currentPiece4) {
                    newRow = currentRow + 1;
                    break;
                }
            case 180:
                if (currentPiece == currentPiece1) {
                    newRow = currentRow + 1;
                    break;
                } else if (currentPiece == currentPiece2) {
                    newRow = currentRow + 1;
                    break;
                } else if (currentPiece == currentPiece3) {
                    newRow = currentRow + 1;
                    break;
                } else if (currentPiece == currentPiece4) {
                    newRow = currentRow + 1;
                    break;
                }
            case 270:
                if (currentPiece == currentPiece1) {
                    newRow = currentRow + 1;
                    break;
                } else if (currentPiece == currentPiece2) {
                    newRow = currentRow + 1;
                    break;
                } else if (currentPiece == currentPiece3) {
                    newRow = currentRow + 1;
                    break;
                } else if (currentPiece == currentPiece4) {
                    newRow = currentRow + 1;
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
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newColumn = (currentColumn);
                    break;
                }
            case 90:
                if (currentPiece == currentPiece1) {
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece2) {
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newColumn = (currentColumn);
                    break;
                }

            case 180:
                if (currentPiece == currentPiece1) {
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece2) {
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newColumn = (currentColumn);
                    break;
                }

            case 270:
                if (currentPiece == currentPiece1) {
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece2) {
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newColumn = (currentColumn);
                    break;
                }
        }
        return newColumn;
    }
}
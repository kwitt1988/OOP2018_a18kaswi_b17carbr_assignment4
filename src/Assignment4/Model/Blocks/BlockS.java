package Assignment4.Model.Blocks;

import Assignment4.Model.TetrisBoard;

import java.util.Arrays;
// The BlockL contains the representation of tetris blocks in form of where each sub piece should be placed in relation to each other.
// Provides methods on how to rotate each sub piece depending on the set angle
public class BlockS extends BlockModel {

    public BlockS(TetrisBoard tetrisBoard) {
        super.blockType = "S";

        blockPosition = Arrays.copyOf(tetrisBoard.getTetrisBoard(), tetrisBoard.getTetrisBoard().length);
        setBlockPosition();
    }

    // START PIECE FOR L BLOCK
    // Left represent row
    // Right represent column
    // UNIQUE FOR BLOCK
    private void setBlockPosition() {
        blockPosition[1][4] = currentPiece1;
        blockPosition[1][5] = currentPiece2;
        blockPosition[2][3] = currentPiece3;
        blockPosition[2][4] = currentPiece4;
    }

    // Method for rotation of the row based on the angle
    // Changes the row position of each sub pieces when called upon
    @SuppressWarnings("Duplicates")
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
                    newRow = (currentRow + 1);
                    break;
                } else if (currentPiece == currentPiece2) {
                    newRow = (currentRow);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newRow = (currentRow + 1);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newRow = (currentRow);
                    break;
                }
            case 180:
                if (currentPiece == currentPiece1) {
                    newRow = (currentRow - 1);
                    break;
                } else if (currentPiece == currentPiece2) {
                    newRow = (currentRow - 2);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newRow = (currentRow + 1);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newRow = (currentRow);
                    break;
                }
            case 270:
                if (currentPiece == currentPiece1) {
                    newRow = (currentRow - 1);
                    break;
                } else if (currentPiece == currentPiece2) {
                    newRow = (currentRow);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newRow = (currentRow - 1);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newRow = (currentRow);
                    break;
                }
        }
        if(validRowValue(newRow)){
            return newRow;
        }
        else return 0;
    }

    // Method for rotation of the column based on the angle
    // Changes the column position of each sub pieces when called upon
    @SuppressWarnings("Duplicates")
    @Override
    public int rotateColumn(int currentColumn, String currentPiece) {
        int newColumn = 0;
        switch (angle) {
            case 0:
                if (currentPiece == currentPiece1) {
                    newColumn = (currentColumn + 1);
                    break;
                } else if (currentPiece == currentPiece2) {
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newColumn = (currentColumn + 1);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newColumn = (currentColumn);
                    break;
                }
            case 90:
                if (currentPiece == currentPiece1) {
                    newColumn = (currentColumn - 1);
                    break;
                } else if (currentPiece == currentPiece2) {
                    newColumn = (currentColumn - 2);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newColumn = (currentColumn + 1);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newColumn = (currentColumn);
                    break;
                }

            case 180:
                if (currentPiece == currentPiece1) {
                    newColumn = (currentColumn - 1);
                    break;
                } else if (currentPiece == currentPiece2) {
                    newColumn = (currentColumn);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newColumn = (currentColumn - 1);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newColumn = (currentColumn);
                    break;
                }

            case 270:
                if (currentPiece == currentPiece1) {
                    newColumn = (currentColumn + 1);
                    break;
                } else if (currentPiece == currentPiece2) {
                    newColumn = (currentColumn + 2);
                    break;
                } else if (currentPiece == currentPiece3) {
                    newColumn = (currentColumn - 1);
                    break;
                } else if (currentPiece == currentPiece4) {
                    newColumn = (currentColumn);
                    break;
                }
        }
        if(validColumnValue(newColumn)){
            return newColumn;
        }
        return 0;
    }
}
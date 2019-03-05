package Assignment4;

public class BlockSquare {
    String[][] squareBlock = new String[19][8];
    String blockType = "Square";

    BlockSquare() {
        setSquareBlock();
    }

    void setSquareBlock() {
        squareBlock[0][1] = blockType;
        squareBlock[1][1] = blockType;
        squareBlock[2][1] = blockType;
        squareBlock[1][2] = blockType;
    }

    public String[][] getBlockPosition(){
        return squareBlock;
    }

    public void setBlockPosition(String[][] newBlockPosition){
        squareBlock = newBlockPosition;
    }

    private boolean checkValidRightMove(String[][] blockPosition){
        for (int row = 0; row < blockPosition.length; row++) {
            for (int column = 0; column < blockPosition[row].length; column++) {
                if(blockPosition[row][column] == "Square"){
                    if (TetrisBoard.tetrisBoard[row][column + 1] != " "){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public String[][] moveRight(String[][] oldBlockPosition) {
        String[][] newBlockPosition = new String[19][8];
        for (int row = 0; row < oldBlockPosition.length; row++) {
            for (int column = 0; column < oldBlockPosition[row].length - 1; column++) {
                newBlockPosition[row][column + 1] = oldBlockPosition[row][column];
            }
        }
        checkValidRightMove(newBlockPosition);
        return newBlockPosition;
    }
}


package Assignment4;

public class BlockSquare extends BlockModel {
    String[][] blockPosition = new String[18][8];
    String blockType = "Square";
    boolean lockBlock = false;

    BlockSquare() {
        blockPosition = TetrisBoard.tetrisBoard;
        setBlockPosition(0);
        moveDown();
    }

    public void moveDown(){
        String[][] newBlockPosition = new String[18][8];
        for (int row = 0; row < blockPosition.length - 1; row++) {
            for (int column = 0; column < blockPosition[row].length; column++) {
                if(blockPosition[row][column] == blockType){
                    newBlockPosition[row + 1][column] = blockPosition[row][column];
                }
            }
        }
               

        if(checkValidMoveDown(newBlockPosition)){
            blockPosition = newBlockPosition;
        } else if(checkValidMoveDown(newBlockPosition) == false){
            lockBlock = true;
        }
    }

    void setBlockPosition(int angle) {
        switch(angle){
            case 0:
                blockPosition[1][1] = blockType;
                blockPosition[1][2] = blockType;
                blockPosition[2][2] = blockType;
                blockPosition[3][2] = blockType;
                break;

            case 90:
                blockPosition[0][2] = blockType;
                blockPosition[1][2] = blockType;
                blockPosition[2][2] = blockType;
                blockPosition[3][2] = blockType;
        }

    }

    public String[][] getBlockPosition(){
        return blockPosition;
    }

    public void setBlockPosition(String[][] newBlockPosition){
        blockPosition = newBlockPosition;
    }

    public void rotateBlock(){
        setBlockPosition(90);
    }
}


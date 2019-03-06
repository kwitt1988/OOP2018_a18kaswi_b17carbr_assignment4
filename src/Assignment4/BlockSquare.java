package Assignment4;


import java.util.Arrays;

public class BlockSquare extends BlockModel {
    String[][] blockPosition;
    String blockType = "Square";
    boolean lockBlock = false;

    BlockSquare(TetrisBoard tetrisBoard) {
        blockPosition = Arrays.copyOf(tetrisBoard.getTetrisBoard(), tetrisBoard.getTetrisBoard().length);
        setBlockPosition(0);
    }

    public void moveDown(){
        String[][] newBlockPosition = new String[18][8];
        for (int row = 0; row < blockPosition.length - 1; row++) {
            for (int column = 0; column < blockPosition[row].length; column++) {
                if(blockPosition[row][column] == blockType){
                    newBlockPosition[row + 1][column] = blockPosition[row][column];
                } else if(blockPosition[row][column] == "CurrentBlock"){
                    newBlockPosition[row][column] = blockPosition[row][column];
                }
            }
        }
        if(checkValidMoveDown(blockPosition)){
            setBlockPosition(newBlockPosition);
        } else if(checkValidMoveDown(newBlockPosition) == false){
            lockBlock = true;
        }
    }

    public void moveLeft() {
        String[][] newBlockPosition = new String[18][8];
        for (int row = 0; row < blockPosition.length - 1; row++) {
            for (int column = 0; column < blockPosition[row].length - 1; column++) {
                if(row < 18 && blockPosition[row][column] == "Square" ){
                    newBlockPosition[row][column -1] = blockPosition[row][column];
                } else if(blockPosition[row][column] == "CurrentBlock"){
                    newBlockPosition[row][column] = blockPosition[row][column];
                }
            }
        }

        if(checkValidMoveLeft(blockPosition)) {
            setBlockPosition(newBlockPosition);
        } else moveDown();
    }

    public void moveRight() {
        String[][] newBlockPosition = new String[18][8];
        for (int row = 0; row < blockPosition.length - 1; row++) {
            for (int column = 0; column < blockPosition[row].length - 1; column++) {
                    if(row < 18 && blockPosition[row][column] == "Square" ){
                        newBlockPosition[row][column + 1] = blockPosition[row][column];
                    } else if(blockPosition[row][column] == "CurrentBlock"){
                        newBlockPosition[row][column] = blockPosition[row][column];
                    }
            }
        }

        if(checkValidMoveRight(blockPosition)) {
            setBlockPosition(newBlockPosition);
        } else moveDown();
    }

    void setBlockPosition(int angle) {
        switch(angle){
            case 0:
                blockPosition[2][2] = blockType;
                blockPosition[2][3] = blockType;
                blockPosition[2][4] = blockType;
                blockPosition[1][2] = blockType;
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


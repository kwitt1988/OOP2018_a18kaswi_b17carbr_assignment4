package Assignment4;


import java.util.Arrays;

public class BlockSquare extends BlockModel {
    String[][] blockPosition;
    String blockType = "Square";
    boolean lockBlock = false;

    BlockSquare(TetrisBoard tetrisBoard) {
        blockPosition = Arrays.copyOf(tetrisBoard.getTetrisBoard(), tetrisBoard.getTetrisBoard().length);
        setBlockPosition(12);
    }

    public void setLockBlock(boolean x){
        lockBlock = x;
    }

    public boolean getLockBlock(){
        return lockBlock;
    }

    public void moveDown(){
        String[][] newBlockPosition = new String[22][12];
        for (int row = 0; row < blockPosition.length; row++) {
            for (int column = 0; column < blockPosition[row].length ; column++) {
                if(blockPosition[row][column] == blockType){
                    newBlockPosition[row+1][column] = blockPosition[row][column];
                } else if(blockPosition[row][column] == "CurrentBlock"){
                    newBlockPosition[row][column] = blockPosition[row][column];
                }
                else if(blockPosition[row][column] == "-"){
                    newBlockPosition[row][column] = blockPosition[row][column];
                }
            }
        }
        if(checkValidMoveDown(blockPosition)){
            setBlockPosition(newBlockPosition);
        } else if(checkValidMoveDown(newBlockPosition) == false){
            setLockBlock(true);
        }
    }

    public void moveLeft() {
        String[][] newBlockPosition = new String[22][12];
        for (int row = 0; row < blockPosition.length; row++) {
            for (int column = 0; column < blockPosition[row].length; column++) {
                if(row < 22 && blockPosition[row][column] == "Square" ){
                    newBlockPosition[row][column -1] = blockPosition[row][column];
                } else if(blockPosition[row][column] == "CurrentBlock"){
                    newBlockPosition[row][column] = blockPosition[row][column];
                }
                else if(blockPosition[row][column] == "-"){
                    newBlockPosition[row][column] = blockPosition[row][column];
                }
            }
        }

        if(checkValidMoveLeft(blockPosition)) {
            setBlockPosition(newBlockPosition);
        } else moveDown();
    }

    public void moveRight() {
        System.out.println("FUUUUUCk");
        String[][] newBlockPosition = new String[22][12];
        for (int row = 0; row < blockPosition.length; row++) {
            for (int column = 0; column < blockPosition[row].length ; column++) {
                if(row < 22 && blockPosition[row][column] == "Square" ){
                    newBlockPosition[row][column + 1] = blockPosition[row][column];
                } else if(blockPosition[row][column] == "CurrentBlock"){
                    newBlockPosition[row][column] = blockPosition[row][column];
                }
                else if(blockPosition[row][column] == "-"){
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
            case 12:
                blockPosition[1][1] = blockType;
                blockPosition[1][1] = blockType;
                blockPosition[1][2] = blockType;
                blockPosition[1][3] = blockType;
                break;
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
                break;
        }


    }

    public String[][] getBlockPosition(){
        return blockPosition;
    }

    public void setBlockPosition(String[][] newBlockPosition){
        blockPosition = newBlockPosition;
    }


    public void rotateBlock(){

        //setBlockPosition(0);
    }
}

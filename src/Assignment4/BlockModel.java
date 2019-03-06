package Assignment4;

public class BlockModel implements TetrisBlockAlternative {
    String[][] blockPosition;
    private String blockType;

    BlockModel(){
    }


    @Override
    public String[][] getBlockPosition() {
        return blockPosition;
    }

    @Override
    public void moveLeft() {

    }



    @Override
    public void moveDropDown() {

    }

    @Override
    public void rotateBlock() {

    }

    private void checkValidMoveLeft() {

    }

    public boolean checkValidMoveRight(String[][] blockPosition){
        for (int row = 0; row < blockPosition.length; row++) {
            for (int column = 0; column < blockPosition[row].length - 1; column++) {
                if(blockPosition[row][column] == blockType){
                    if (blockPosition[row][column +1] != blockType){
                        return true;
                    } else if (column + 1 != 10){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkValidMoveDown(String[][] blockPosition){
        boolean validMove = true;
        for(int row = 0; row < blockPosition.length; row++) {
            for(int column = 0; column < blockPosition[row].length; column++){
                if(blockPosition[row][column] == "Square"){
                    if(row + 1 == 18){
                        validMove = false;
                    } else if(blockPosition[row +1][column] == "CurrentBlock"){
                        validMove = false;
                    }
                }
            }
        }
        return validMove;
    }

}

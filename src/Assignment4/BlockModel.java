package Assignment4;

public class BlockModel implements TetrisBlock {
    String[][] blockPosition;
    private String blockType;

    BlockModel(){
    }

    @Override
    public boolean getLockBlock() {
        return false;
    }

    @Override
    public void setLockBlock() {

    }

    @Override
    public void lockBlock() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public String[][] getBlockPosition() {
        return blockPosition;
    }


    @Override
    public void moveDropDown() {

    }

    @Override
    public void rotateBlock() {

    }

    public boolean checkValidMoveLeft(String[][] blockPosition) {
        boolean validMove = true;
        for(int row = 0; row < blockPosition.length; row++) {
            for(int column = 0; column < blockPosition[row].length - 1; column++){
                if(blockPosition[row][column] == "Square"){
                    if (column  == 0) {
                        System.out.println("false");
                        validMove = false;
                    }
                    else  if (blockPosition[row][column +1] == "CurrentBlock"){
                        validMove = false;
                    }
                }
            }
        }
        return validMove;
    }

    public boolean checkValidMoveRight(String[][] blockPosition){
        boolean validMove = true;
        for(int row = 0; row < blockPosition.length; row++) {
            for(int column = 0; column < blockPosition[row].length - 1; column++){
                if(blockPosition[row][column] == "Square"){
                    if (column + 1 == 9) {
                        System.out.println("false");
                        validMove = false;
                    }
                    else  if (blockPosition[row][column +1] == "CurrentBlock"){
                    validMove = false;
                    }
                }
            }
        }
        return validMove;
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

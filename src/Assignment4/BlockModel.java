package Assignment4;

public class BlockModel implements TetrisBlock {
    String[][] blockPosition;
    boolean lockBlock = false;
    public String blockType;

    BlockModel(){
    }

    @Override
    public void setLockBlock(boolean x){
        lockBlock = x;
    }

    @Override
    public boolean getLockBlock(){
        return lockBlock;
    }

    @Override
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
            setLockBlock(true);
        }
    }

    public void moveLeft() {
        String[][] newBlockPosition = new String[18][8];
        for (int row = 0; row < blockPosition.length - 1; row++) {
            for (int column = 0; column < blockPosition[row].length - 1; column++) {
                if(row < 18 && blockPosition[row][column] == blockType ){
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

    @Override
    public void moveRight() {
        String[][] newBlockPosition = new String[18][8];
        for (int row = 0; row < blockPosition.length - 1; row++) {
            for (int column = 0; column < blockPosition[row].length - 1; column++) {
                if(row < 18 && blockPosition[row][column] == blockType){
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

    @Override
    public String[][] getBlockPosition() {
        return blockPosition;
    }

    @Override
    public void setBlockPosition(String[][] newBlockPosition){
        blockPosition = newBlockPosition;
    }

    @Override
    public void moveDropDown() {

    }

    @Override
    public void rotateBlock() {

    }

    private boolean checkValidMoveLeft(String[][] blockPosition) {
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

    private boolean checkValidMoveRight(String[][] blockPosition){
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

    private boolean checkValidMoveDown(String[][] blockPosition){
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

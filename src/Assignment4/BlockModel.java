package Assignment4;

public abstract class BlockModel implements TetrisBlockAlternative {
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
    public String[][] moveRight(String[][] blockPosition) {
        String[][] newBlockPosition = new String[18][8];
        for (int row = 0; row < blockPosition.length; row++) {
            for (int column = 0; column < blockPosition[row].length - 1; column++) {
                newBlockPosition[row][column + 1] = blockPosition[row][column];
            }
        }
        if(checkValidMoveRight(newBlockPosition)){
            return newBlockPosition;
        } else return blockPosition;

    }

    @Override
    public void moveDropDown() {

    }

    @Override
    public void rotateBlock() {

    }

    private void checkValidMoveLeft() {

    }

    private boolean checkValidMoveRight(String[][] blockPosition){
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
        System.out.println("true");
        return false;
    }

    // MÅSTE KOLLA INVERTERAT

    public boolean checkValidMoveDown(String[][] blockPosition){
        boolean validMove = true;
        for(int row = 0; row < blockPosition.length; row++) {
            for(int column = 0; column < blockPosition[row].length; column++){
                if(blockPosition[row][column] == "Square"){
                    if(row + 1 == 18){
                        System.out.println("false");
                        validMove = false;
                        return validMove;
                    }
                }
            }
        }
        return validMove;
    }

}

package Assignment4;

public class BlockModel implements TetrisBlock {
    String[][] blockPosition;
    int angle;
    boolean lockBlock = false;
    public String currentPiece1 = "currentPiece1";
    public String currentPiece2 = "currentPiece2";
    public String currentPiece3 = "currentPiece3";
    public String currentPiece4 = "currentPiece4";

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
                if(blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
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
                if(row < 18 && blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                        || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
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
                if(row < 18 && blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                        || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
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


    public void rotateBlock(){
        rotateBlock1();
        rotateBlock2();
        rotateBlock3();
        rotateBlock4();
    }

    public void rotateBlock1() {
        for (int row = 0; row < blockPosition.length - 1; row++) {
            for (int column = 0; column < blockPosition[row].length; column++) {
                if(blockPosition[row][column] == currentPiece1){
                    String currentPiece = blockPosition[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    blockPosition[newRow][newColumn] = blockPosition[row][column];
                    blockPosition[row][column] = " ";
                    break;
                }
            }
        }
    }

    public void rotateBlock2() {
        for (int row = 0; row < blockPosition.length - 1; row++) {
            for (int column = 0; column < blockPosition[row].length; column++) {
                if(blockPosition[row][column] == currentPiece2){
                    String currentPiece = blockPosition[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    blockPosition[newRow][newColumn] = blockPosition[row][column];
                    blockPosition[row][column] = " ";
                    break;
                }
            }
        }
    }

    public void rotateBlock3() {
        for (int row = 0; row < blockPosition.length - 1; row++) {
            for (int column = 0; column < blockPosition[row].length; column++) {
                if(blockPosition[row][column] == currentPiece3){
                    String currentPiece = blockPosition[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    blockPosition[newRow][newColumn] = blockPosition[row][column];
                    blockPosition[row][column] = " ";
                    break;
                }
            }
        }
    }

    public void rotateBlock4() {
        for (int row = 0; row < blockPosition.length - 1; row++) {
            for (int column = 0; column < blockPosition[row].length; column++) {
                if(blockPosition[row][column] == currentPiece4){
                    String currentPiece = blockPosition[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    blockPosition[newRow][newColumn] = blockPosition[row][column];
                    blockPosition[row][column] = " ";
                    break;
                }
            }
        }
    }



    public int rotateRow(int currentRow, String currentPiece){
        return 0;
    }

    public int rotateColumn(int currentColumn, String currentPiece){
        return 0;
    }

    private boolean checkValidMoveLeft(String[][] blockPosition) {
        boolean validMove = true;
        for(int row = 0; row < blockPosition.length; row++) {
            for(int column = 0; column < blockPosition[row].length - 1; column++){
                if(blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                        || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
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
                if(blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                        || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
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
                if(blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                        || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
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

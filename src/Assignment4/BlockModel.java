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
        String[][] newBlockPosition = new String[22][12];
        for (int row = 0; row < blockPosition.length; row++) {
            for (int column = 0; column < blockPosition[row].length; column++) {
                if(blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                        || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
                    newBlockPosition[row + 1][column] = blockPosition[row][column];
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
                if(row < 22 && blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                        || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
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

    @Override
    public void moveRight() {
        String[][] newBlockPosition = new String[22][12];
        for (int row = 0; row < blockPosition.length; row++) {
            for (int column = 0; column < blockPosition[row].length; column++) {
                if(row < 22 && blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                        || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
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
        setAngle(angle);
    }

    public void setAngle(int currentAngle){
        switch(currentAngle){
            case 0: {
                currentAngle = 90;
                break;
            }
            case 90: {
                currentAngle = 180;
                break;
            }
            case 180: {
                currentAngle = 270;
                break;
            }
            case 270: {
                currentAngle = 0;
                break;
            }
        }
        angle = currentAngle;
    }

    @SuppressWarnings("Duplicates")
    public void rotateBlock1() {
        outer: for (int row = 0; row < blockPosition.length - 1; row++) {
            for (int column = 0; column < blockPosition[row].length; column++) {
                if(blockPosition[row][column] == currentPiece1){
                    String currentPiece = blockPosition[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    blockPosition[newRow][newColumn] = blockPosition[row][column];
                    blockPosition[row][column] = " ";
                    break outer;
                }
            }
        }
    }
    @SuppressWarnings("Duplicates")
    public void rotateBlock2() {
        outer: for (int row = 0; row < blockPosition.length - 1; row++) {
            for (int column = 0; column < blockPosition[row].length -1; column++) {
                if(blockPosition[row][column] == currentPiece2){
                    String currentPiece = blockPosition[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    blockPosition[newRow][newColumn] = blockPosition[row][column];
                    blockPosition[row][column] = " ";
                    break outer;
                }
            }
        }
    }

    @SuppressWarnings("Duplicates")
    public void rotateBlock3() {
        outer: for (int row = 0; row < blockPosition.length - 1; row++) {
            for (int column = 0; column < blockPosition[row].length -1; column++) {
                if(blockPosition[row][column] == currentPiece3){
                    String currentPiece = blockPosition[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    blockPosition[newRow][newColumn] = blockPosition[row][column];
                    blockPosition[row][column] = " ";
                    break outer;
                }
            }
        }
    }

    @SuppressWarnings("Duplicates")
    public void rotateBlock4() {
        outer: for (int row = 0; row < blockPosition.length - 1; row++) {
            for (int column = 0; column < blockPosition[row].length -1; column++) {
                if(blockPosition[row][column] == currentPiece4){
                    String currentPiece = blockPosition[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    blockPosition[newRow][newColumn] = blockPosition[row][column];
                    blockPosition[row][column] = " ";
                    break outer;
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
            for(int column = 0; column < blockPosition[row].length; column++){
                if(blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                        || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
                    if (blockPosition[row][column -1] == "-") {
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
            for(int column = 0; column < blockPosition[row].length; column++){
                if(blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                        || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
                    if (blockPosition[row][column +1] == "-") {
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
                    if(blockPosition[row +1][column] == "-"){
                        validMove = false;
                    } else if(blockPosition[row +1][column] == "CurrentBlock"){
                        validMove = false;
                    } else if(blockPosition[row][column +1] == "CurrentBlock"){
                        validMove = false;
                    }
                }
            }
        }
        return validMove;
    }
}


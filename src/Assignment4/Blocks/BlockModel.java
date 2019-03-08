package Assignment4.Blocks;

class BlockModel implements TetrisBlock {
    String[][] blockPosition;
    String blockType;

    int angle;
    boolean lockBlock = false;
    String currentPiece1 = "currentPiece1";
    String currentPiece2 = "currentPiece2";
    String currentPiece3 = "currentPiece3";
    String currentPiece4 = "currentPiece4";

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
    public void fallDown(){
        String[][] newBlockPosition = new String[22][12];
        for (int row = 0; row < blockPosition.length; row++) {
            for (int column = 0; column < blockPosition[row].length; column++) {
                if(blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                        || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
                    newBlockPosition[row + 1][column] = blockPosition[row][column];
                } else if(blockPosition[row][column] == "STUCKBLOCK"){
                    newBlockPosition[row][column] = blockPosition[row][column];
                }
                else if(blockPosition[row][column] == "-"){
                    newBlockPosition[row][column] = blockPosition[row][column];
                }
            }
        }
        if(checkValidMoveDown(blockPosition)){
            setBlockPosition(newBlockPosition);
        } else if(!checkValidMoveDown(newBlockPosition)){
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
                } else if(blockPosition[row][column] == "STUCKBLOCK"){
                    newBlockPosition[row][column] = blockPosition[row][column];
                }
                else if(blockPosition[row][column] == "-"){
                    newBlockPosition[row][column] = blockPosition[row][column];
                }
            }
        }

        if(checkValidMoveLeft(blockPosition)) {
            setBlockPosition(newBlockPosition);
        } else fallDown();
    }

    @Override
    public void moveRight() {
        String[][] newBlockPosition = new String[22][12];
        for (int row = 0; row < blockPosition.length; row++) {
            for (int column = 0; column < blockPosition[row].length; column++) {
                if(row < 22 && blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                        || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
                    newBlockPosition[row][column + 1] = blockPosition[row][column];
                } else if(blockPosition[row][column] == "STUCKBLOCK"){
                    newBlockPosition[row][column] = blockPosition[row][column];
                }
                else if(blockPosition[row][column] == "-"){
                    newBlockPosition[row][column] = blockPosition[row][column];
                }
            }
        }

        if(checkValidMoveRight(blockPosition)) {
            setBlockPosition(newBlockPosition);
        } else fallDown();
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
        while(checkValidMoveDown(blockPosition)){
            fallDown();
        }
    }

    public void rotateBlock(){
        String[][] newBlockPosition = copyOfOldBoard(blockPosition);
        rotateBlock1(newBlockPosition);
        rotateBlock2(newBlockPosition);
        rotateBlock3(newBlockPosition);
        rotateBlock4(newBlockPosition);
        setAngle(angle);
    }

    void setAngle(int currentAngle){
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

    public int rotateRow(int currentRow, String currentPiece){
        return 0;
    }

    public int rotateColumn(int currentColumn, String currentPiece){
        return 0;
    }

    private String[][] copyOfOldBoard(String[][] currentBoard){
        String[][] copy = new String[22][12];
        for(int row = 0; row < currentBoard.length - 1; row++){
            for(int column = 0; column < currentBoard[row].length; column++){
                copy[row][column] = currentBoard[row][column];
            }
        }
        return copy;
    }

    @SuppressWarnings("Duplicates")
    private void rotateBlock1(String[][] copy) {
        outer: for (int row = 0; row < copy.length - 1; row++) {
            for (int column = 0; column < copy[row].length; column++) {
                if(copy[row][column] == currentPiece1){
                    String currentPiece = copy[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    blockPosition[newRow][newColumn] = copy[row][column];
                    if(blockPosition[row][column].equals("currentPiece1")){
                        blockPosition[row][column] = " ";
                    }
                    break outer;
                }
            }
        }
    }

    @SuppressWarnings("Duplicates")
    private void rotateBlock2(String[][] copy) {
        outer: for (int row = 0; row < copy.length - 1; row++) {
            for (int column = 0; column < copy[row].length; column++) {
                if(copy[row][column] == currentPiece2){
                    String currentPiece = copy[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    blockPosition[newRow][newColumn] = copy[row][column];
                    if(blockPosition[row][column].equals("currentPiece2")){
                        blockPosition[row][column] = " ";
                    }
                    break outer;
                }
            }
        }
    }

    @SuppressWarnings("Duplicates")
    private void rotateBlock3(String[][] copy) {
        outer: for (int row = 0; row < copy.length - 1; row++) {
            for (int column = 0; column < copy[row].length; column++) {
                if(copy[row][column] == currentPiece3){
                    String currentPiece = copy[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    blockPosition[newRow][newColumn] = copy[row][column];
                    if(blockPosition[row][column].equals("currentPiece3")){
                        blockPosition[row][column] = " ";
                    }
                    break outer;
                }
            }
        }
    }

    @SuppressWarnings("Duplicates")
    private void rotateBlock4(String[][] copy) {
        outer: for (int row = 0; row < copy.length - 1; row++) {
            for (int column = 0; column < copy[row].length; column++) {
                if(copy[row][column] == currentPiece4){
                    String currentPiece = copy[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    blockPosition[newRow][newColumn] = copy[row][column];
                    if(blockPosition[row][column].equals("currentPiece4")){
                        blockPosition[row][column] = " ";
                    }
                    break outer;
                }
            }
        }
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
                    else  if (blockPosition[row][column -1] == "STUCKBLOCK"){
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
                    else  if (blockPosition[row][column +1] == "STUCKBLOCK"){
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
                    } else if(blockPosition[row +1][column] == "STUCKBLOCK"){
                        validMove = false;
                    } else if(blockPosition[row + 1][column] == "STUCKBLOCK"){
                        validMove = false;
                    }
                    else if(blockPosition[row][column] == "STUCKBLOCK"){
                        validMove = false;
                    }
                }
            }
        }
        return validMove;
    }
}
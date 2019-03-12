package Assignment4.Model.Blocks;

import java.util.Arrays;

class BlockModel implements TetrisBlock {
    String[][] currentBoard;
    String[][] finalBoard;
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
    public String[][] getCurrentBoard() {
        return currentBoard;
    }

    @Override
    public void setCurrentBoard(String[][] newBlockPosition){
        currentBoard = Arrays.copyOf(newBlockPosition, newBlockPosition.length);
    }


    public String getBlockType(){
        return blockType;
    }

    @Override
    public boolean getLockBlock(){
        return lockBlock;
    }

    @Override
    public void setLockBlock(boolean x){
        lockBlock = x;
    }


    @Override
    public void fallDown(){
        String[][] newBlockPosition = new String[22][12];
        for (int row = 0; row < currentBoard.length; row++) {
            for (int column = 0; column < currentBoard[row].length; column++) {
                if(currentBoard[row][column] == currentPiece1 || currentBoard[row][column] == currentPiece2
                        || currentBoard[row][column] == currentPiece3 || currentBoard[row][column] == currentPiece4){
                    newBlockPosition[row + 1][column] = currentBoard[row][column];
                } else if(currentBoard[row][column] == "STUCKBLOCK"){
                    newBlockPosition[row][column] = currentBoard[row][column];
                }
                else if(currentBoard[row][column] == "-"){
                    newBlockPosition[row][column] = currentBoard[row][column];
                }
            }
        }
        if(checkValidMoveDown(currentBoard)){
            setCurrentBoard(newBlockPosition);
        } else if(!checkValidMoveDown(newBlockPosition)){
            setLockBlock(true);
        }
    }

    public void moveLeft() {
        String[][] newBlockPosition = new String[22][12];
        for (int row = 0; row < currentBoard.length; row++) {
            for (int column = 0; column < currentBoard[row].length; column++) {
                if(currentBoard[row][column].equals(null)){
                    System.out.println("ERROR");
                }
                if(row < 22 && currentBoard[row][column] == currentPiece1 || currentBoard[row][column] == currentPiece2
                        || currentBoard[row][column] == currentPiece3 || currentBoard[row][column] == currentPiece4){
                    newBlockPosition[row][column -1] = currentBoard[row][column];
                } else if(currentBoard[row][column] == "STUCKBLOCK"){
                    newBlockPosition[row][column] = currentBoard[row][column];
                }
                else if(currentBoard[row][column] == "-"){
                    newBlockPosition[row][column] = currentBoard[row][column];
                }
            }
        }

        if(checkValidMoveLeft(currentBoard)) {
            setCurrentBoard(newBlockPosition);
        } else fallDown();
    }

    @Override
    public void moveRight() {
        String[][] newBlockPosition = new String[22][12];
        for (int row = 0; row < currentBoard.length; row++) {
            for (int column = 0; column < currentBoard[row].length; column++) {
                if(currentBoard[row][column].equals(null)){
                    System.out.println("ERROR");
                }
                if(row < 22 && currentBoard[row][column] == currentPiece1 || currentBoard[row][column] == currentPiece2
                        || currentBoard[row][column] == currentPiece3 || currentBoard[row][column] == currentPiece4){
                    newBlockPosition[row][column + 1] = currentBoard[row][column];
                } else if(currentBoard[row][column] == "STUCKBLOCK"){
                    newBlockPosition[row][column] = currentBoard[row][column];
                }
                else if(currentBoard[row][column] == "-"){
                    newBlockPosition[row][column] = currentBoard[row][column];
                }
            }
        }

        if(checkValidMoveRight(currentBoard)) {
            setCurrentBoard(newBlockPosition);
        } else fallDown();
    }

    @Override
    public void moveDropDown() {
        while(checkValidMoveDown(currentBoard)){
            fallDown();
        }
    }

    public void rotateBlock(){
        String[][] newBlockPosition = copyOfOldBoard(currentBoard);
        finalBoard = copyOfOldBoard(currentBoard);
        rotateBlock1(newBlockPosition);
        rotateBlock2(newBlockPosition);
        rotateBlock3(newBlockPosition);
        rotateBlock4(newBlockPosition);
        if(checkValidMoveRight(finalBoard) && checkValidMoveLeft(finalBoard) && checkValidMoveDown(finalBoard)){
            currentBoard = finalBoard;
            setAngle(angle);
        }
    }

    private String[][] copyOfOldBoard(String[][] currentBoard){
        String[][] copy = new String[22][12];
        for(int row = 0; row < currentBoard.length; row++){
            for(int column = 0; column < currentBoard[row].length; column++){
                copy[row][column] = currentBoard[row][column];
            }
        }
        return copy;
    }

    @SuppressWarnings("Duplicates")
    private void rotateBlock1(String[][] copy) {
        outer: for (int row = 0; row < copy.length; row++) {
            for (int column = 0; column < copy[row].length; column++) {
                if(copy[row][column] == currentPiece1){
                    String currentPiece = copy[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    finalBoard[newRow][newColumn] = copy[row][column];
                    if(finalBoard[row][column].equals("currentPiece1")){
                        finalBoard[row][column] = " ";
                    }
                    break outer;
                }
            }
        }
    }

    @SuppressWarnings("Duplicates")
    private void rotateBlock2(String[][] copy) {
        outer: for (int row = 0; row < copy.length; row++) {
            for (int column = 0; column < copy[row].length; column++) {
                if(copy[row][column] == currentPiece2){
                    String currentPiece = copy[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    finalBoard[newRow][newColumn] = copy[row][column];
                    if(finalBoard[row][column].equals("currentPiece2")){
                        finalBoard[row][column] = " ";
                    }
                    break outer;
                }
            }
        }
    }

    @SuppressWarnings("Duplicates")
    private void rotateBlock3(String[][] copy) {
        outer: for (int row = 0; row < copy.length; row++) {
            for (int column = 0; column < copy[row].length; column++) {
                if(copy[row][column] == currentPiece3){
                    String currentPiece = copy[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    finalBoard[newRow][newColumn] = copy[row][column];
                    if(finalBoard[row][column].equals("currentPiece3")){
                        finalBoard[row][column] = " ";
                    }
                    break outer;
                }
            }
        }
    }

    @SuppressWarnings("Duplicates")
    private void rotateBlock4(String[][] copy) {
        outer: for (int row = 0; row < copy.length; row++) {
            for (int column = 0; column < copy[row].length; column++) {
                if(copy[row][column] == currentPiece4){
                    String currentPiece = copy[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    finalBoard[newRow][newColumn] = copy[row][column];
                    if(finalBoard[row][column].equals("currentPiece4")){
                        finalBoard[row][column] = " ";
                    }
                    break outer;
                }
            }
        }
    }

    public boolean validColumnValue(int column){
        if(column < 11){
            return true;
        } else return false;
    }

    public boolean validRowValue(int row){
        if(row < 22){
            return true;
        }
        else return false;
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
            for (int column = 0; column < blockPosition[row].length; column++) {

                {
                    if (blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                            || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4) {

                        if (column > 11 ){
                            validMove = false;
                        }
                        if (blockPosition[row][column + 1] == "-") {
                            System.out.println("false");
                            validMove = false;
                        } else if (blockPosition[row][column + 1] == "STUCKBLOCK") {
                            validMove = false;
                        }
                    }

                }
                }
            }
            return validMove;
        }

    private boolean checkValidMoveDown(String[][] blockPosition){
        boolean validMove = true;
        outer: for(int row = 0; row < blockPosition.length; row++) {
            for(int column = 0; column < blockPosition[row].length; column++){
                if(blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                        || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
                    if(blockPosition[row +1][column] == "-"){
                        validMove = false;
                        setLockBlock(true);
                        break outer;
                    } else if(blockPosition[row +1][column] == "STUCKBLOCK"){
                        setLockBlock(true);
                        validMove = false;
                        break outer;
                    }
                }
            }
        }
        return validMove;
    }
}
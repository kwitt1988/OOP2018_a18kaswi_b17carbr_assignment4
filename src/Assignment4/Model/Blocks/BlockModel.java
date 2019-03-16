package Assignment4.Model.Blocks;

// The BlockModel hold the execution of all the of blocks behaviours, this
// includes being responsible for collision detection and movement in
// different directions, Rotation of blocks in regard to their current
// angle, getters and setters for blockType, setAngle and so on.

import Assignment4.Controller.TetrisController;
import Assignment4.Model.TetrisBlock;
import Assignment4.View.GuiGameView;

public class BlockModel implements TetrisBlock {
    int angle;
    String[][] blockPosition;
    String blockType;
    final String currentPiece1 = "currentPiece1";
    final String currentPiece2 = "currentPiece2";
    final String currentPiece3 = "currentPiece3";
    final String currentPiece4 = "currentPiece4";
    private String[][] finalPosition;
    private boolean lockBlock = false;
    private boolean validMove = true;

    // Return the current blockType String, such as Line, L etc. Used when deciding colour in the visual representation
    public String getBlockType(){
        return blockType;
    }

    private void setLockBlock(boolean x){
        lockBlock = x;
    }

    @Override
    public boolean getLockBlock(){
        return lockBlock;
    }

    // ---- Method for moving a piece downwards.
    // Looping through the array by each row and each corresponding column within that row until there is sub piece found.
    // Each sub piece is added to a local array representing the board with the value + 1 added to the row, this is to simulate movement downwards.
    // All other elements are then copied over to this local array.
    // Check movement Validation, i.e. if the next move downwards equals collision or not.
    // If true, copies the local board to the live one via setBlockPosition, essentially moving the whole piece one downwards.
    // If false then collision happened, the block gets locked.
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

    // ---- Method for moving a piece left.
    // Looping through the array by each row and each corresponding column within that row until there is sub piece found.
    // Each sub piece is added to a local array representing the board with the value - 1 added to the column, this is to simulate movement left.
    // All other elements are then copied over to this local array.
    // Check movement Validation, i.e. if the next move left equals collision or not.
    // If true, copies the local board to the live one via setBlockPosition, essentially moving the whole piece one step to the left.
    // If false then collision happened, does not move to the left, instead calls on the fallDown method and moves downwards instead if possible
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

    // ---- Method for moving a piece right.
    // Looping through the array by each row and each corresponding column within that row until there is sub piece found.
    // Each sub piece is added to a local array representing the board with the value + 1 added to the column, this is to simulate movement right.
    // All other elements are then copied over to this local array.
    // Check movement Validation, i.e. if the next move right equals collision or not.
    // If true, copies the local board to the live one via setBlockPosition, essentially moving the whole piece one step to the right.
    // If false then collision happened, does not move to the right, instead calls on the fallDown method and moves downwards instead if possible
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

    // Get the block, i.e. the board with the current block position
    @Override
    public String[][] getBlockPosition() {
        return blockPosition;
    }
    // Sets the block, i.e. sets the board with the new block position

    private void setBlockPosition(String[][] newBlockPosition){
        blockPosition = newBlockPosition;
    }
    // Calls fallDown method as long as movement downward is valid
    @Override
    public void moveDropDown() {
        while(checkValidMoveDown(blockPosition)){
            fallDown();
        }
    }

    // ---- Start method for rotation of the block
    // Creates a copy of the current board
    // Creates a copy of the current board that will hold the new positions after rotation
    // Calls methods that rotates each sub piece and passes in as argument a copy of the board
    // Completed piece rotation get validated and then set in action on the live board, and finally followed by shifting the angle one step ahead.
    public void rotateBlock(){
            String[][] newBlockPosition = copyOfOldBoard(blockPosition);
            finalPosition = copyOfOldBoard(blockPosition);
            rotateBlock1(newBlockPosition);
            rotateBlock2(newBlockPosition);
            rotateBlock3(newBlockPosition);
            rotateBlock4(newBlockPosition);
            if(validMove){
                blockPosition = finalPosition;
                setAngle(angle);
            }
            validMove = true;
    }

    // Creates a copy of the live board
    private String[][] copyOfOldBoard(String[][] currentBoard){
        String[][] copy = new String[22][12];
        for(int row = 0; row < currentBoard.length; row++){
            for(int column = 0; column < currentBoard[row].length; column++){
                copy[row][column] = currentBoard[row][column];
            }
        }
        return copy;
    }

    // ---- Rotation for the first sub piece
    // Looping through the array by each row and each corresponding column within that row until currentPiece1 is found
    // The row and corresponding column then gets individually rotated at then set within finalPosition array
    // Lastly the previous currentPiece1 entry get removed
    private void rotateBlock1(String[][] copy) {
        outer: for (int row = 0; row < copy.length - 1; row++) {
            for (int column = 0; column < copy[row].length; column++) {
                if(copy[row][column] == currentPiece1){
                    String currentPiece = copy[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    if(finalPosition[row][column].equals("currentPiece1")){
                        finalPosition[row][column] = " ";
                    }
                    finalPosition[newRow][newColumn] = copy[row][column];
                    break outer;
                }
            }
        }
    }
    // ---- Rotation for the second sub piece
    // Looping through the array by each row and each corresponding column within that row until currentPiece2 is found
    // The row and corresponding column then gets individually rotated at then set within finalPosition array
    // Lastly the previous currentPiece2 entry get removed
    private void rotateBlock2(String[][] copy) {
        outer: for (int row = 0; row < copy.length - 1; row++) {
            for (int column = 0; column < copy[row].length; column++) {
                if(copy[row][column] == currentPiece2){
                    String currentPiece = copy[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    if(finalPosition[row][column].equals("currentPiece2")){
                        finalPosition[row][column] = " ";
                    }
                    finalPosition[newRow][newColumn] = copy[row][column];
                    break outer;
                }
            }
        }
    }
    // ---- Rotation for the third sub piece
    // Looping through the array by each row and each corresponding column within that row until currentPiece3 is found
    // The row and corresponding column then gets individually rotated at then set within finalPosition array
    // Lastly the previous currentPiece3 entry get removed
    private void rotateBlock3(String[][] copy) {
        outer: for (int row = 0; row < copy.length - 1; row++) {
            for (int column = 0; column < copy[row].length; column++) {
                if(copy[row][column] == currentPiece3){
                    String currentPiece = copy[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    if(finalPosition[row][column].equals("currentPiece3")){
                        finalPosition[row][column] = " ";
                    }
                    finalPosition[newRow][newColumn] = copy[row][column];
                    break outer;
                }
            }
        }
    }
    // ---- Rotation for the fourth sub piece
    // Looping through the array by each row and each corresponding column within that row until currentPiece4 is found
    // The row and corresponding column then gets individually rotated at then set within finalPosition array
    // Lastly the previous currentPiece4 entry get removed
    private void rotateBlock4(String[][] copy) {
        outer: for (int row = 0; row < copy.length - 1; row++) {
            for (int column = 0; column < copy[row].length; column++) {
                if(copy[row][column] == currentPiece4){
                    String currentPiece = copy[row][column];
                    int newRow = rotateRow(row, currentPiece);
                    int newColumn = rotateColumn(column, currentPiece);
                    if(finalPosition[row][column].equals("currentPiece4")){
                        finalPosition[row][column] = " ";
                    }
                    finalPosition[newRow][newColumn] = copy[row][column];
                    break outer;
                }
            }
        }
    }

    // Check the bounds for an single piece.
    // If acceptable bound return true to place the piece.
    // If not acceptable set validMove for the block to false.
    // And return false to the specific piece.
    boolean validColumnValue(int column){
        if(column < 11 && column > 1){
            return true;
        }
        else {
            validMove = false;
            return false;
        }
    }

    boolean validRowValue(int row){
        if(row < 22 && row > 1){
            return true;
        }
        else {
            validMove = false;
            return false;
        }
    }

    // Sets the new angle, used doing rotation to decide what modifications to each row and column is needed for every sub piece
    private void setAngle(int currentAngle){
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


    int rotateRow(int currentRow, String currentPiece){
        return 0;
    }

    int rotateColumn(int currentColumn, String currentPiece){
        return 0;
    }

    // ---- Validation for movement to the left
    // Looping through the array by each row and each corresponding column within that row until each sub piece is found
    // One by one their located and check for collision
    // This is done by subtracting the current sub piece column by one, gets you the next location to the left the piece will move to
    // This new left movement is check for collision, if the new position equals "-" or "STUCKBLOCK", then return false, otherwise true
    private boolean checkValidMoveLeft(String[][] blockPosition) {
        boolean validMove = true;
        for(int row = 0; row < blockPosition.length; row++) {
            for(int column = 0; column < blockPosition[row].length; column++){
                if(blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                        || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4){
                    if (blockPosition[row][column -1] == "-") {
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

    // ---- Validation for movement to the right
    // Looping through the array by each row and each corresponding column within that row until each sub piece is found
    // One by one their located and check for collision
    // This is done by adding the current sub piece column by one, gets you the next location to the right the piece will move to
    // This new right movement is check for collision, if the new position equals "-" , "STUCKBLOCK" or beyond the column value 10 then return false, otherwise true
    private boolean checkValidMoveRight(String[][] blockPosition){
        boolean validMove = true;
        for(int row = 0; row < blockPosition.length; row++) {
            for (int column = 0; column < blockPosition[row].length; column++) {

                {
                    if (blockPosition[row][column] == currentPiece1 || blockPosition[row][column] == currentPiece2
                            || blockPosition[row][column] == currentPiece3 || blockPosition[row][column] == currentPiece4) {

                        if (column > 12 ){
                            validMove = false;
                        }
                        if (blockPosition[row][column + 1] == "-") {
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

    // ---- Validation for movement downwards
    // Looping through the array by each row and each corresponding column within that row until each sub piece is found
    // One by one their located and check for collision
    // This is done by subtracting the adding sub piece row by one, gets you the next location to the left the piece will move to
    // This new downwards movement is check for collision, if the new position equals "-" or "STUCKBLOCK", then return false, otherwise true
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

    void checkGameOver(){
        if(!checkValidMoveDown(blockPosition)){
            System.out.println("game over");
            TetrisController.stopGame();
            GuiGameView.gameOver();
        }
    }
}
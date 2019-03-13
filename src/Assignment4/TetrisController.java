package Assignment4;

import Assignment4.Blocks.BlockFactory;
import Assignment4.Blocks.TetrisBlock;
import java.util.TimerTask;

// The TetrisController is the cross section of the program, the controller
// Responsible for communications between different part of the program.
// Contain the gameLoop by which retrieves a block-object which it then plays out that objects life-cycle by using a timer.
// Handles the monitoring and execution of row clearing and all the  other procedures involving it, such as score evaluation.
// Provide the connect to different parts of the program, for example getters for getScore, getBlockType, getCurrentBoard and such alike.
public class TetrisController {
    private TetrisBoard tetrisBoard = new TetrisBoard();
    private BlockFactory blockFactory = new BlockFactory();
    private TetrisBlock newBlock = blockFactory.getBlock(tetrisBoard);
    private int numClears;
    private long score;
    private int lvl = 1;

    // Called upon during a new game, starts the gameLoop below
    public TetrisController(){
        gameLoop();
    }


    // ---- THE GameLoop
    // Loops the game with one one second intervals.
    // Calls on the active piece to move downwards on the board.
    // Adds the piece to the tetris board
    // If statement that check whether the active block has reached the end of its life cycle, i.e. it cannot move downwards anymore
    // if true then locks the block by giving it a new String tag representing the new state and also check whether can be cleared or not
    // Ending with a call one a new piece to be created
    public void gameLoop(){
        new java.util.Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                newBlock.fallDown();
                tetrisBoard.setTetrisBoardObject(newBlock);
                if(newBlock.getLockBlock()){
                    tetrisBoard.setTetrisBoardString(clearRows(lockBlock()));  // S
                    newBlock = blockFactory.getBlock(tetrisBoard);
                }
            }

        }, 1000*1,1000*1);
    }

    // returns the current active board from the TetrisBoard class
    public String[][] getCurrentBoard(){
        return tetrisBoard.getTetrisBoard();
    }

    // Method to check whether a row can be cleared or not
    // Loops through all rows, passes each row to isFull, which checks if all columns in that row is full or not
    // If true, then calls for that row to be deleted and sets those changes in a copy of the current board
    // adds + 1 to the number of cleared rows to be used later calculation of score
    public String[][] clearRows(String[][] Board){
        String[][] newBoard = Board;
        for(int row = 20; row > 1; row--){
                while(isFull(Board, row)){
                    numClears++;
                    newBoard = deleteRow(row, Board);

                }




        }

        return newBoard;

    }

    // Check whether a row is full or not, return false if not full, and true if full
    public Boolean isFull(String[][] Board, int row) {
        for (int column = 1; column < Board[row].length - 1; column++) {
            if (tetrisBoard.getTetrisBoard()[row][column] == " ") {
                return false;
            }
        }

        return true;
    }

    // Delete the full row by placing the one above over it
    // Also adds to the score based on number of clears
    public String[][] deleteRow(int row, String[][] Board ){
        for(int j=row-1; j > 1;j--){
            for(int i=1;i< 11;i++) {
                Board[j + 1][i] = tetrisBoard.getTetrisBoard()[j][i];
            }
        }

        switch(numClears){
            case 1:
                score += 100;
                break;
            case 2:
                score += 300;
                break;
            case 3:
                score += 500;
                break;
            case 4:
                score += 800;
                break;

        }
        lvl += 1;
        numClears  = 0;
        return Board;
    }
    // return the current score
    public long getScore(){
        return score;
    }
    // returns the current lvl
    public int getLvl(){
        return lvl;
    }
    // Calls upon the tetris piece to move to the Left
    public void moveLeft(){
        newBlock.moveLeft();
        tetrisBoard.setTetrisBoardObject(newBlock);
    }
    // Calls upon the tetris piece to move to the Right
    public void moveRight(){
        newBlock.moveRight();
        tetrisBoard.setTetrisBoardObject(newBlock);
    }
    // Calls upon the tetris piece to move downwards
    public void moveDown(){
        newBlock.fallDown();
        tetrisBoard.setTetrisBoardObject(newBlock);
    }
    // Calls upon the tetris piece to rotate
    public void rotateBlock(){
        newBlock.rotateBlock();
        tetrisBoard.setTetrisBoardObject(newBlock);
    }
    // Calls upon the tetris piece to instantly drop down
    public void dropDown(){
        newBlock.moveDropDown();
        tetrisBoard.setTetrisBoardObject(newBlock);
    }

    // Changes sub pieces tags onces they reached the end of their active cycle, i.e. they have been locked in place
    private String[][] lockBlock(){
        String[][] newBoard = new String[22][12];
        for(int row = 0; row < tetrisBoard.getTetrisBoard().length; row++){
            for(int column = 0; column < tetrisBoard.getTetrisBoard()[row].length; column++){
                if(tetrisBoard.getTetrisBoard()[row][column] == "currentPiece1" || tetrisBoard.getTetrisBoard()[row][column] == "currentPiece2" ||
                        tetrisBoard.getTetrisBoard()[row][column] == "currentPiece3" || tetrisBoard.getTetrisBoard()[row][column] == "currentPiece4"){
                    newBoard[row][column] = "STUCKBLOCK";
                } else newBoard = tetrisBoard.getTetrisBoard();
            }
        }
        return newBoard;
    }
    // Return the current blockType String, such as Line, L etc. Used when deciding colour in the visual representation
    public String getBlockType(){
        return newBlock.getBlockType();
    }
}
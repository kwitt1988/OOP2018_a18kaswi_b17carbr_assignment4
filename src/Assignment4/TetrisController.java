package Assignment4;

import Assignment4.Blocks.BlockFactory;
import Assignment4.Blocks.TetrisBlock;
import Assignment4.GUI.GuiGameView;

import java.util.TimerTask;

public class TetrisController {
    private TetrisBoard tetrisBoard = new TetrisBoard();
    private BlockFactory blockFactory = new BlockFactory();
    private TetrisBlock newBlock = blockFactory.getBlock(tetrisBoard);
    private Boolean gap;
    private int numClears;
    private long score;
    private int lvl = 1;

    public TetrisController(){
        gameLoop();
    }



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

    public String[][] getCurrentBoard(){
        return tetrisBoard.getTetrisBoard();
    }

    public String[][] clearRows(String[][] Board){
        String[][] newBoard = Board;
        gap = false;
        for(int row = 20; row > 1; row--){
            for(int column = 1; column < Board[row].length - 1; column++) {
                while(isFull(Board, row)){
                    numClears++;
                    newBoard = deleteRow(row, Board);

                }


            }

        }

        return newBoard;

    }

    public Boolean isFull(String[][] Board, int row) {
        for (int column = 1; column < Board[row].length - 1; column++) {
            if (tetrisBoard.getTetrisBoard()[row][column] == " ") {
                return false;
            }
        }

        return true;
    }


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

    public long getScore(){
        return score;
    }
    public int getLvl(){
        return lvl;
    }
    public void moveLeft(){
        newBlock.moveLeft();
        tetrisBoard.setTetrisBoardObject(newBlock);
    }

    public void moveRight(){
        newBlock.moveRight();
        tetrisBoard.setTetrisBoardObject(newBlock);
    }

    public void moveDown(){
        newBlock.fallDown();
        tetrisBoard.setTetrisBoardObject(newBlock);
    }

    public void rotateBlock(){
        newBlock.rotateBlock();
        tetrisBoard.setTetrisBoardObject(newBlock);
    }

    public void dropDown(){
        newBlock.moveDropDown();
        tetrisBoard.setTetrisBoardObject(newBlock);
    }

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

    public String getBlockType(){
        return newBlock.getBlockType();
    }
}
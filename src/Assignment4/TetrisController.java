package Assignment4;

import Assignment4.Blocks.BlockFactory;
import Assignment4.Blocks.TetrisBlock;

import java.util.TimerTask;

public class TetrisController {
    private TetrisBoard tetrisBoard = new TetrisBoard();
    private BlockFactory blockFactory = new BlockFactory();
    private TetrisBlock newBlock = blockFactory.getBlock(tetrisBoard);
    private Boolean gap;
    private int numClears;
    public boolean active;
    private long score;
    private int lvl = 500;


    public void setActive(){
        active = true;
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

        }, lvl*1,lvl*1);
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
        lvl -= 50;
        numClears  = 0;
        return Board;
    }
    public void numClears(){
        System.out.println("FIITTA");
        numClears++;
    }
    public long getScore(){
        return score;
    }

    public void moveLeft(){
        newBlock.moveLeft();
    }

    public void moveRight(){
        newBlock.moveRight();
    }

    public void moveDown(){
        newBlock.fallDown();
    }

    public void rotateBlock(){
        newBlock.rotateBlock();
    }

    public void dropDown(){
        newBlock.moveDropDown();
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
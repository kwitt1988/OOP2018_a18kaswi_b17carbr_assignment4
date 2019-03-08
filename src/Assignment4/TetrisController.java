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

        }, 300*1,300*1);
    }

    public String[][] getCurrentBoard(){
        return tetrisBoard.getTetrisBoard();
    }

    public String[][] clearRows(String[][] Board){
        String[][] newBoard = Board;

        gap = false;
        for(int row = 20; row > 1; row--){
            for(int column = 1; column < Board[row].length - 1; column++) {
                if(tetrisBoard.getTetrisBoard()[row][column] == " "){
                    gap = true;
                    System.out.println("ITS TRUE");
                    break;

                }
                System.out.println("Checking row :" + row + "and column :" + column + "To se if :" + gap);

            }
            if(!gap){
                newBoard = deleteRow(row, Board);
                row += 1;
                numClears +=1;



            }
        }
        return newBoard;

    }
    public String[][] deleteRow(int row, String[][] Board ){
        for(int j=row-1; j > 1;j--){
            for(int i=1;i< 11;i++)
               Board[j+1][i] = tetrisBoard.getTetrisBoard()[j][i];
        }

        return Board;
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
}
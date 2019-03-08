package Assignment4;

import Assignment4.Blocks.BlockFactory;
import Assignment4.Blocks.TetrisBlock;

import java.util.TimerTask;

public class TetrisController {
    private TetrisBoard tetrisBoard = new TetrisBoard();
    private BlockFactory blockFactory = new BlockFactory();
    private TetrisBlock newBlock = blockFactory.getBlock(tetrisBoard);

    public void gameLoop(){
        new java.util.Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                newBlock.fallDown();
                tetrisBoard.setTetrisBoardObject(newBlock);
                if(newBlock.getLockBlock()){
                    tetrisBoard.setTetrisBoardString(lockBlock());
                    newBlock = blockFactory.getBlock(tetrisBoard);
                }
            }

        }, 300*1,300*1);
    }

    public String[][] getCurrentBoard(){
        return tetrisBoard.getTetrisBoard();
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
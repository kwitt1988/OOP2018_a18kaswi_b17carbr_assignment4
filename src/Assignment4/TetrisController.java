package Assignment4;

import java.util.Arrays;
import java.util.TimerTask;

public class TetrisController {
    private TetrisBoard tetrisBoard = new TetrisBoard();
    private BlockFactory blockFactory = new BlockFactory();
    BlockSquare newBlock = new BlockSquare(tetrisBoard);


    public void gameLoop(){
        new java.util.Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                newBlock.moveDown();
                tetrisBoard.setTetrisBoardTest(newBlock);
                if(newBlock.lockBlock == true){
                    tetrisBoard.setTetrisBoard(lockBlock());
                    newBlock = new BlockSquare(tetrisBoard);
                }
            }

        }, 1000*1,1000*1);
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

    public String[][] lockBlock(){
        String[][] newBoard = new String[18][8];
        for(int row = 0; row < tetrisBoard.getTetrisBoard().length; row++){
            for(int column = 0; column < tetrisBoard.getTetrisBoard()[row].length; column++){
                if(tetrisBoard.getTetrisBoard()[row][column] == "Square") {
                    newBoard[row][column] = "CurrentBlock";
                } else newBoard = tetrisBoard.getTetrisBoard();
            }
        }
        return newBoard;
    }

}
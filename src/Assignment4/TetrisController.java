package Assignment4;

import java.util.TimerTask;

public class TetrisController {
    private TetrisBoard tetrisBoard = new TetrisBoard();
    private BlockFactory blockFactory = new BlockFactory();
    private TetrisBlock newBlock = new BlockL(tetrisBoard);

    public void gameLoop(){
        new java.util.Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                newBlock.moveDown();
                // BLIR KOOOKOOOO OM VI KÖR SETTETRIS FÖR STRING[][]
                tetrisBoard.setTetrisBoardObject(newBlock);
                if(newBlock.getLockBlock()){
                    tetrisBoard.setTetrisBoardString(lockBlock());
                    newBlock = blockFactory.getBlock(tetrisBoard);
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

    public void rotateBlock(){
        newBlock.rotateBlock();
    }

    private String[][] lockBlock(){
        String[][] newBoard = new String[18][8];
        for(int row = 0; row < tetrisBoard.getTetrisBoard().length; row++){
            for(int column = 0; column < tetrisBoard.getTetrisBoard()[row].length; column++){
                if(tetrisBoard.getTetrisBoard()[row][column] == "currentPiece1" || tetrisBoard.getTetrisBoard()[row][column] == "currentPiece2" ||
                        tetrisBoard.getTetrisBoard()[row][column] == "currentPiece3" || tetrisBoard.getTetrisBoard()[row][column] == "currentPiece4"){
                    newBoard[row][column] = "CurrentBlock";
                } else newBoard = tetrisBoard.getTetrisBoard();
            }
        }
        return newBoard;
    }
}
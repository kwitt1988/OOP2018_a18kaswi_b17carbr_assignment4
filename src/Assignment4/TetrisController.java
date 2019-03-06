package Assignment4;

import java.util.TimerTask;

public class TetrisController {
    private TetrisBoard tetrisBoard = new TetrisBoard();
    private BlockFactory blockFactory = new BlockFactory();
    private int incrementEverySec = 0;
    private boolean resetIncrement;
    private int movingShit = 0;
    private BlockSquare blockTest = new BlockSquare();
    BlockSquare newBlock = new BlockSquare();


    public void gameLoop(){
        new java.util.Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                incrementEverySec++;
                if(resetIncrement){
                    incrementEverySec = 0;
                    resetIncrement = false;
                }

                newBlock.moveDown();
                tetrisBoard.setTetrisBoardTest(newBlock);
                if(newBlock.lockBlock == true){
                    lockBlock();
                    newBlock = new BlockSquare();
                }
            }

        }, 1000*1,1000*1);
    }

    public void moveLeft(){
        movingShit -= 1;
        blockTest.rotateBlock();
    }

    public void moveRight(){
        movingShit += 1;
        String[][] newPosition = blockTest.moveRight(blockTest.getBlockPosition());
        blockTest.setBlockPosition(newPosition);
    }

    public void lockBlock(){
        String[][] newBoard = new String[18][8];
        for(int row = 0; row < TetrisBoard.tetrisBoard.length; row++){
            for(int column = 0; column < TetrisBoard.tetrisBoard[row].length; column++){
                if(TetrisBoard.tetrisBoard[row][column] == "Square") {
                    newBoard[row][column] = "CurrentBlock";
                } else newBoard = TetrisBoard.tetrisBoard;
            }
        }
        TetrisBoard.tetrisBoard = newBoard;

    }
    private void updateTetrisBoard(TetrisBlock activeBlock){
        tetrisBoard.setTetrisBoard(activeBlock.getYAxisMove(), activeBlock.getXAxisMove(), activeBlock.getYAxisRemove(), activeBlock.getXAxisRemove(), activeBlock.getBlockSubType());
        //tetrisBoard.drawTetrisBoard();
        this.resetIncrement = activeBlock.getEndPos();
    }
}
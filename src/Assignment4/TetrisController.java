package Assignment4;

import jdk.nashorn.internal.ir.Block;

import java.util.TimerTask;

public class TetrisController {
    private TetrisBoard tetrisBoard = new TetrisBoard();
    private BlockFactory blockFactory = new BlockFactory();
    private int incrementEverySec = 0;
    private boolean resetIncrement;
    private int movingShit = 0;
    private TetrisBlock currentBlock;
    private BlockSquare blockTest = new BlockSquare();


    public void gameLoop(){
        new java.util.Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                int checkMovement = movingShit;
                incrementEverySec++;
                if(resetIncrement){
                    incrementEverySec = 0;
                    resetIncrement = false;
                }
                createBlock(checkMovement);
            }
        }, 1000*1,1000*1);
    }

    public void moveLeft(){
        movingShit -= 1;
    }

    public void moveRight(){
        movingShit += 1;
        String[][] newPosition = new BlockSquare().moveRight(blockTest.getBlockPosition());
        blockTest.setBlockPosition(newPosition);
    }


    public void createBlock(int movement){
        tetrisBoard.setTetrisBoardTest(blockTest);
    }

    private void updateTetrisBoard(TetrisBlock activeBlock){
        tetrisBoard.setTetrisBoard(activeBlock.getYAxisMove(), activeBlock.getXAxisMove(), activeBlock.getYAxisRemove(), activeBlock.getXAxisRemove(), activeBlock.getBlockSubType());
        tetrisBoard.drawTetrisBoard();
        this.resetIncrement = activeBlock.getEndPos();
    }
}
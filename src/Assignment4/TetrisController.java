package Assignment4;


import java.util.TimerTask;

public class TetrisController {
    private TetrisBoard tetrisBoard = new TetrisBoard();
    private BlockFactory blockFactory = new BlockFactory();
    private int incrementEverySec = 0;
    private boolean resetIncrement;
    private int movingShit = 0;
    private int rotateBlock;
    private TetrisBlock currentBlock;

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
        if(movingShit <= 8 && movingShit >= 1) {
            movingShit -= 1;
        }
    }

    public void moveRight(){
        if(movingShit <= 6 && movingShit >= 0) {
            movingShit += 1;
        }
    }

    // Need to reset this to zero if a new block is added
    public void rotateBlock(){
        if(rotateBlock < 4) {
            rotateBlock += 1;
        }
        else{
            rotateBlock = 0;
        }
    }


    public void createBlock(int movement){
        int move = movement;
        TetrisBlock block = blockFactory.getBlock("I-BLOCK", "Ih", incrementEverySec + 1, 0, move, rotateBlock);
        currentBlock = block;
        updateTetrisBoard(currentBlock);
    }

    private void updateTetrisBoard(TetrisBlock activeBlock){
        tetrisBoard.setTetrisBoard(activeBlock.getYAxisMove(), activeBlock.getXAxisMove(), activeBlock.getYAxisRemove(), activeBlock.getXAxisRemove(), activeBlock.getBlockSubType());
        tetrisBoard.drawTetrisBoard();
        this.resetIncrement = activeBlock.getEndPos();
    }
}
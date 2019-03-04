package Assignment4;

import java.util.TimerTask;

public class GameController {
    private TetrisBoard tetrisBoard = new TetrisBoard();
    private BlockFactory blockFactory = new BlockFactory();
    private int incrementEverySec = 0;
    private boolean resetIncrement;
    private int movingShit = 0;

    public void gameLoop(){
        new java.util.Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                int checkMovement = movingShit;
                incrementEverySec++;
                System.out.println(resetIncrement);
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
    }


    // Kanske calla på block från GUIController
    // På så vis kan vi skicka med yAxis = +/- utifrån om vi flyttar höger eller vänster.
    // Vi skickar med movement, +1 för höger, -1 för vänster.


    public void createBlock(int movement){
        int move = movement;

        // Referens till det för nuvarande rörande blocket (skall egentligen skapa ett randomblock) (Här initierar vi positionen, borde bara göras en gång)
        TetrisBlock block = blockFactory.getBlock("I-BLOCK", "Iv", incrementEverySec + 1, 3, move);

        // Settar tetrisboarden??
        tetrisBoard.setTetrisBoard(block.getYAxisMove(), block.getXAxisMove(), block.getYAxisRemove(), block.getXAxisRemove(), block.getBlockSubType());

        // Tittar om det för nuvarande rörande blocket kommer till sin endposition
        this.resetIncrement = block.getEndPos();

        tetrisBoard.drawTetrisBoard(); // ONÖDIG FÖR DET FÄRDIGA SPELET
    }
}
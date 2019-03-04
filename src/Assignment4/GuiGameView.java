package Assignment4;

import javax.swing.*;
import java.awt.*;

public class GuiGameView extends GuiView{
    private JFrame gameFrame = new JFrame();
    private JPanel blockPanel = new JPanel();
    private static final JPanel[][] blockPanelArray = new JPanel[19][8];
    GameController runGame = new GameController();

    GuiGameView(){
        frameSettings(gameFrame, blockPanel, 800, 600);
        setBlockPanel();
        gameFrame.add(blockPanel);

        /// denna måste vara trådad 1000/60 fps
        // likadan looop som i inl3

        runGame.gameLoop();
        // KAN CALLA PÅ GAMELOOP.MOVERIGHT ETC
        while(true){
            compareArrays();
        }
    }

    void setBlockPanel(){
        for(int row = 0; row < blockPanelArray.length; row++){
                for(int column = 0; column < blockPanelArray[row].length; column++){
                    blockPanelArray[row][column] = new JPanel();
                    blockPanelArray[row][column].setBackground(Color.green);
                    blockPanel.add(blockPanelArray[row][column]);
                }
        }
    }

    void compareArrays(){
        String tetrisBoard[][] = TetrisBoard.getTetrisBoard();
        for(int row = 0; row < tetrisBoard.length; row++){
            for(int column = 0; column < tetrisBoard[row].length; column++){
                if(tetrisBoard[row][column].equals("Iv")){
                    blockPanelArray[row][column].setBackground(Color.blue);
                }
                else{
                    blockPanelArray[row][column].setBackground(Color.green);
                }
            }
        }
    }

    @Override
    void frameSettings(JFrame frame, JPanel mainPanel, int x, int y) {
        super.frameSettings(frame, mainPanel, x, y);
    }

    @Override
    void listeners() {

    }
}
package Assignment4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiGameView extends GuiView{
    private JFrame mainFrame = new JFrame();
    private JPanel mainPanel = new JPanel();
    private static final JPanel[][] blockPanelArray = new JPanel[19][8];
    TetrisController tetrisController = new TetrisController();


    GuiGameView(){
        frameSettings(mainFrame, mainPanel, 800, 600);
        setBlockPanel();
        mainFrame.add(mainPanel);
        tetrisController.gameLoop();
        while(true){
            compareArrays();
        }
    }

    void setBlockPanel(){
        for(int row = 0; row < blockPanelArray.length; row++){
                for(int column = 0; column < blockPanelArray[row].length; column++){
                    blockPanelArray[row][column] = new JPanel();
                    blockPanelArray[row][column].setBackground(Color.green);
                    mainPanel.add(blockPanelArray[row][column]);
                }
        }
        mainPanel.setLayout(new GridLayout(19, 8));
        mainPanel.setFocusable(true);
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
        mainPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int KeyCode = e.getKeyCode();
                if(KeyCode == KeyEvent.VK_E){
                    System.out.println("tja");

                }
                if(KeyCode == KeyEvent.VK_LEFT){
                    tetrisController.moveLeft();

                }
                if(KeyCode == KeyEvent.VK_RIGHT){
                    tetrisController.moveRight();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

}
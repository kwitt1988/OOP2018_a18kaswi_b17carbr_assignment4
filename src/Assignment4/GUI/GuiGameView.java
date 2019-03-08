package Assignment4.GUI;

import Assignment4.TetrisController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiGameView extends GuiView {
    private JFrame mainFrame = new JFrame();
    private JPanel mainPanel = new JPanel();
    private JPanel scorePanel = new JPanel();
    private JPanel[][] blockPanelArray = new JPanel[22][12];
    private TetrisController tetrisController = new TetrisController();
    private JButton startButton = new JButton("start");

    public GuiGameView(){

    }

    public void putBorder(){
        for(int row = 1; row < blockPanelArray.length - 1; row++){
            for(int column = 1; column < blockPanelArray[row].length - 1; column++){
                blockPanelArray[row][column].setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }
        }
    }

    public void startScreen(){
        frameSettings(mainFrame, mainPanel, 400, 800);
        setPanels();
        putBorder();
        tetrisController.gameLoop();
        while(true){
            compareArrays();
        }

    }

    private void setScorePanel(){
        scorePanel.setSize(800, 50);
        scorePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        scorePanel.add(startButton);
        scorePanel.add(new JLabel("SCORE: CALL ON SCORE HERE"));
        scorePanel.setBackground(Color.RED);
        scorePanel.setOpaque(true);
    }

    private void setPanels(){
        setBlockPanel();
        setScorePanel();
        mainFrame.add(scorePanel, BorderLayout.NORTH);
        mainPanel.setBackground(Color.BLACK);
        mainFrame.add(mainPanel, BorderLayout.CENTER);
    }

    private void colors(int y, int x){
        String blockType = tetrisController.getBlockType();
        switch(blockType){
            case "Line": blockPanelArray[y][x].setBackground(Color.orange);
            break;
            case "L": blockPanelArray[y][x].setBackground(Color.CYAN);
        }
    }

    @Override
    void listeners() {
        mainFrame.addKeyListener(new KeyListener()
        {
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
                if(KeyCode == KeyEvent.VK_UP) {
                    tetrisController.rotateBlock();
                }
                if(KeyCode == KeyEvent.VK_DOWN){
                    tetrisController.moveDown();
                }
                if(KeyCode == KeyEvent.VK_X){
                    tetrisController.dropDown();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    private void setBlockPanel(){
        for(int row = 0; row < blockPanelArray.length; row++){
            for(int column = 0; column < blockPanelArray[row].length; column++){
                blockPanelArray[row][column] = new JPanel();
                blockPanelArray[row][column].setBackground(Color.green);
                mainPanel.add(blockPanelArray[row][column]);
            }
        }
        mainPanel.setLayout(new GridLayout(22, 12));
        mainPanel.setFocusable(true);
        mainFrame.setFocusable(true);
    }

    private void compareArrays(){
        String tetrisBoard[][] = tetrisController.getCurrentBoard();
        for(int row = 0; row < tetrisBoard.length; row++){
            for(int column = 0; column < tetrisBoard[row].length; column++){
                if(tetrisBoard[row][column].equals("Iv")){
                    blockPanelArray[row][column].setBackground(Color.blue);
                }
                else if(tetrisBoard[row][column].equals("STUCKBLOCK")){
                    blockPanelArray[row][column].setBackground(Color.RED);
                }

                else if(tetrisBoard[row][column].startsWith("currentPiece")){
                    colors(row, column);
                }

                else if(tetrisBoard[row][column].equals("-")){
                    blockPanelArray[row][column].setBackground(Color.BLACK);
                }

                else if(tetrisBoard[row][column].equals("Square")){
                    blockPanelArray[row][column].setBackground(Color.PINK);
                }
                else{
                    blockPanelArray[row][column].setBackground(Color.green);
                }
            }
        }
    }
}
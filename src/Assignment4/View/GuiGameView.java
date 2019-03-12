package Assignment4.View;

import Assignment4.Controller.TetrisController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiGameView extends GuiView {
    private JFrame mainFrame = new JFrame();
    private JPanel mainPanel = new JPanel();
    private JPanel scorePanel = new JPanel();
    private JLabel scoreLabel = new JLabel();
    private JPanel[][] boardPanelArray = new JPanel[22][12];
    private TetrisController tetrisController = new TetrisController();
    private Timer timer = new Timer(20, new TimerListener());

    public GuiGameView(){
        frameSettings(mainFrame, mainPanel, 400, 800);
        setPanels();
        timer.start();
        System.out.println(tetrisController.getCurrentBoard().length);
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
                }

                if(KeyCode == KeyEvent.VK_LEFT){
                    tetrisController.moveLeft();
                    updateGUI();

                }
                if(KeyCode == KeyEvent.VK_RIGHT){
                    tetrisController.moveRight();
                    updateGUI();
                }
                if(KeyCode == KeyEvent.VK_UP) {
                    tetrisController.rotateBlock();
                    updateGUI();
                }
                if(KeyCode == KeyEvent.VK_DOWN){
                    tetrisController.moveDown();
                    updateGUI();
                }
                if(KeyCode == KeyEvent.VK_X){
                    tetrisController.dropDown();
                    updateGUI();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void updateGUI(){
        compareArrays();
        scoreLabel.setText("SCORE :" + tetrisController.getScore());
    }

    private void setScorePanel(){
        scorePanel.setSize(800, 50);
        scorePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        scorePanel.add(scoreLabel);
        scorePanel.setBackground(Color.RED);
        scorePanel.setOpaque(true);
    }

    private void setBlockPanel(){
        for(int row = 0; row < boardPanelArray.length; row++){
            for(int column = 0; column < boardPanelArray[row].length; column++){
                boardPanelArray[row][column] = new JPanel();
                boardPanelArray[row][column].setBackground(Color.green);
                mainPanel.add(boardPanelArray[row][column]);
            }
        }
        mainPanel.setLayout(new GridLayout(22, 12));
        mainPanel.setFocusable(true);
        mainFrame.setFocusable(true);
    }

    private void setPanels(){
        setBlockPanel();
        setScorePanel();
        for(int row = 1; row < boardPanelArray.length - 1; row++){
            for(int column = 1; column < boardPanelArray[row].length - 1; column++){
                boardPanelArray[row][column].setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }
        }
        mainFrame.add(scorePanel, BorderLayout.NORTH);
        mainPanel.setBackground(Color.BLACK);
        mainFrame.add(mainPanel, BorderLayout.CENTER);

    }

    private void colors(int y, int x){
        String blockType = tetrisController.getBlockType();
        switch(blockType){
            case "Line": boardPanelArray[y][x].setBackground(Color.orange);
            break;
            case "L": boardPanelArray[y][x].setBackground(Color.CYAN);
            break;
            case"S": boardPanelArray[y][x].setBackground(Color.orange);
        }
    }

    private void compareArrays(){
        String tetrisBoard[][] = tetrisController.getCurrentBoard();
        for(int row = 0; row < tetrisBoard.length; row++){
            for(int column = 0; column < tetrisBoard[row].length; column++){
                if(tetrisBoard[row][column].equals("Iv")){
                    boardPanelArray[row][column].setBackground(Color.blue);
                }
                else if(tetrisBoard[row][column].equals("STUCKBLOCK")){
                    boardPanelArray[row][column].setBackground(Color.RED);
                }

                else if(tetrisBoard[row][column].startsWith("currentPiece")){
                    colors(row, column);
                }

                else if(tetrisBoard[row][column].equals("-")){
                    boardPanelArray[row][column].setBackground(Color.BLACK);
                }

                else if(tetrisBoard[row][column].equals("Square")){
                    boardPanelArray[row][column].setBackground(Color.PINK);
                }
                else{
                    boardPanelArray[row][column].setBackground(Color.green);
                }
            }
        }
    }

    private class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            updateGUI();
        }
    }
}
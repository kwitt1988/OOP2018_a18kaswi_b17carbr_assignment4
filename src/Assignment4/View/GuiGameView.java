package Assignment4.View;

import Assignment4.Controller.TetrisController;
import Assignment4.Model.TetrisBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// The GuiGAmeView is responsible for providing a visual representation of the game to the user
public class GuiGameView extends GuiView {
    private final static JFrame mainFrame = new JFrame();
    private final JPanel mainPanel = new JPanel();
    private final JPanel scorePanel = new JPanel();
    private final JLabel scoreLabel = new JLabel();
    private final JPanel[][] blockPanelArray = new JPanel[22][12];
    private TetrisController tetrisController;
    private final Timer timer = new Timer(20, new TimerListener());
    JButton start = new JButton("start");
    JButton restart = new JButton("restart");

    // Calls on a method which starts the gameLoop in the tetrisController
    // Calls on gameScreen which starts the visual representation of the game and starts the timer above
    public GuiGameView(TetrisController gameController){
        tetrisController = gameController;
        gameScreen();
    }

    // Sets up and add the panel via GuiView, sets the size of the panel.
    // Calls on the method setPanels which sets up the block array representing the board and the score panel.
    // Starts the time above, which updates the visual representation of the game.
    public void gameScreen(){
        frameSettings(mainFrame, mainPanel, 400, 800);
        setPanels();
        putBorder();
        timer.start();
    }

    public void startGame() {
        keyboardListeners();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                tetrisController.gameLoop();
            }
        });
    }

    // Game-over initialized on the event-dispatcher thread.
    public static void gameOver() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(mainFrame, "Game Over");
            }
        });
    }

    public void restartGame(){
        keyboardListeners();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                tetrisController = new TetrisController();
                tetrisController.gameLoop();
            }
        });
    }

    // Calling the methods to setup the Score and block array panel.
    // adds the scorePanel to the frame.
    // Sets the background colour of the mainPanel and adds it to the frame.
    private void setPanels(){
        setBlockPanel();
        setScorePanel();
        mainFrame.add(scorePanel, BorderLayout.NORTH);
        mainPanel.setBackground(Color.BLACK);
        mainFrame.add(mainPanel, BorderLayout.CENTER);
    }

    // Sets up the array of JPanels which will correspond with the rows and columns within the TetrisBoard.
    // Used below to represent the tetris board visually for the user.
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

    // setting size, layout of the scorePanel, adding the scoreLabel such to it.
    private void setScorePanel(){
        scorePanel.setSize(800, 50);
        scorePanel.setLayout(new GridBagLayout());
        scorePanel.add(scoreLabel);
        start.setFocusable(false);
        scorePanel.add(start);
        restart.setFocusable(false);
        scorePanel.add(restart);
        scoreLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        scorePanel.setBackground(Color.RED);
        scorePanel.setOpaque(true);
    }

    //
    private void putBorder(){
        for(int row = 1; row < blockPanelArray.length - 1; row++){
            for(int column = 1; column < blockPanelArray[row].length - 1; column++){
                blockPanelArray[row][column].setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }
        }
    }

    // Method Used by compareArray to set unique colours to tetris pieces (SHOULD BE ONCE LOCKED ALSO)
    private void colors(int y, int x){
        String blockType = tetrisController.getBlockType();
        switch(blockType){
            case "Line": blockPanelArray[y][x].setBackground(Color.orange);
                break;
            case "L": blockPanelArray[y][x].setBackground(Color.CYAN);
                break;
            case "Z": blockPanelArray[y][x].setBackground(Color.orange);
                break;
            case "Square": blockPanelArray[y][x].setBackground(Color.orange);
                break;
            case "InvertedL": blockPanelArray[y][x].setBackground(Color.orange);
                break;
            case "S": blockPanelArray[y][x].setBackground(Color.orange);
                break;
            case "T": blockPanelArray[y][x].setBackground(Color.orange);
                break;
        }
    }

    // Updates the GUI, i.e. calls on a method that shows the current representation of the board visually for the user
    // Updates the current score of the game
    private void updateGUI(){
        compareArrays();
        scoreLabel.setText("SCORE :" + tetrisController.getScore());
    }

    // ---- Visual representation of live board
    // Mirrors the array of JPanels against the tetris board.
    // Depending on the content of the tetris board columns, the background of the corresponding JPanel changes colour to represent the content
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

    // Listener for keypresses, use for movement in left, right and downwards direction, also rotation. updates the GUI at the same time
    @Override
    void listeners() {


        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();

            }
        });
    }

    // Listeners for keyboard-events, starts when start-game is clicked.
    private void keyboardListeners(){
        mainFrame.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int KeyCode = e.getKeyCode();
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

    // Timer for updating the GUI, calls on the method bellow during the span of a game with a certain delay between ticks
    private class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            updateGUI();
        }
    }
}

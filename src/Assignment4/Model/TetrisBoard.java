package Assignment4.Model;


import java.util.Arrays;

public class TetrisBoard {
    // Here is the representation of the board, a two dimensional array of String
    private String tetrisBoard[][]={
            /* 0 */   {"-","-","-","-","-","-","-","-","-","-","-","-"},     // 22 * 12
            /* 1 */   {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 2 */   {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 3 */   {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 4 */   {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 5 */   {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 6 */   {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 7 */   {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 8 */   {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 9 */   {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 10 */  {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 11 */  {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 12 */  {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 13 */  {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 14 */  {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 15 */  {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 16 */  {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 17 */  {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 18 */  {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 19 */  {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 20 */  {"-"," "," "," "," "," "," "," "," "," "," ","-"},
            /* 21 */  {"-","-","-","-","-","-","-","-","-","-","-","-"}};

    // Return the current board
    public  String[][] getTetrisBoard(){
        return tetrisBoard;
    }
    // Sets the current board
    public void setTetrisBoardString(String[][] newBoard){
        tetrisBoard = Arrays.copyOf(newBoard, newBoard.length);
    }
    // Sets the current board
    public void setTetrisBoardObject(TetrisBlock block){
        for (int row = 0; row < block.getBlockPosition().length; row++){
            for (int column = 0; column < block.getBlockPosition()[row].length; column++){
                if(block.getBlockPosition()[row][column] == "currentPiece1"
                        || block.getBlockPosition()[row][column] == "currentPiece2"
                        || block.getBlockPosition()[row][column] == "currentPiece3"
                        || block.getBlockPosition()[row][column] == "currentPiece4") {
                    tetrisBoard[row][column] = block.getBlockPosition()[row][column];
                } else if(block.getBlockPosition()[row][column] == "STUCKBLOCK"){
                    tetrisBoard[row][column] = "STUCKBLOCK";
                } else if(block.getBlockPosition()[row][column] == "-"){
                    tetrisBoard[row][column] = "-";
                }
                else tetrisBoard[row][column] = " ";

            }
        }
    }
}
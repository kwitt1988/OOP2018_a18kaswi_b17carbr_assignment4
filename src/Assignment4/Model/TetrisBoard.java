package Assignment4.Model;


import Assignment4.Model.Blocks.TetrisBlock;

import java.util.Arrays;

public class TetrisBoard {
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

    public synchronized String[][] getTetrisBoard(){
        return tetrisBoard;
    }

    // Fungerar denna alls?
    public synchronized void setTetrisBoardString(String[][] newBoard){
        tetrisBoard = Arrays.copyOf(newBoard, newBoard.length);
    }

    public synchronized void setTetrisBoardObject(TetrisBlock block){
        for (int row = 0; row < block.getCurrentBoard().length; row++){
            for (int column = 0; column < block.getCurrentBoard()[row].length; column++){
                if(block.getCurrentBoard()[row][column] == "currentPiece1"
                        || block.getCurrentBoard()[row][column] == "currentPiece2"
                        || block.getCurrentBoard()[row][column] == "currentPiece3"
                        || block.getCurrentBoard()[row][column] == "currentPiece4") {
                    tetrisBoard[row][column] = block.getCurrentBoard()[row][column];
                } else if(block.getCurrentBoard()[row][column] == "STUCKBLOCK"){
                    tetrisBoard[row][column] = "STUCKBLOCK";
                } else if(block.getCurrentBoard()[row][column] == "-"){
                    tetrisBoard[row][column] = "-";
                }
                else tetrisBoard[row][column] = " ";

            }
        }
    }
}



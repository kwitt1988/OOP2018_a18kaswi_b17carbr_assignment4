package Assignment4;

import java.util.Arrays;

class TetrisBoard {
    public String tetrisBoard[][]={
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


    public String[][] getTetrisBoard(){
        return tetrisBoard;
    }

    public void setTetrisBoard(String[][] newBoard){
        for (int row = 0; row < newBoard.length; row++){
            for (int column = 0; column < newBoard[row].length; column++){
                tetrisBoard[row][column] = newBoard[row][column];
            }
        }
    }
    public void drawTetrisBoard() {
        for (int i=0;i<22;i++) {
            System.out.println(Arrays.toString(tetrisBoard[i]));
        }
        System.out.println();
    }

    public void setTetrisBoardTest(TetrisBlock block){
        for (int row = 0; row < block.getBlockPosition().length; row++){
            for (int column = 0; column < block.getBlockPosition()[row].length; column++){
                if(block.getBlockPosition()[row][column] == "Square") {
                    tetrisBoard[row][column] = block.getBlockPosition()[row][column];
                } else if(block.getBlockPosition()[row][column] == "CurrentBlock"){
                    tetrisBoard[row][column] = "CurrentBlock";
                } else if(block.getBlockPosition()[row][column] == "-"){
                    tetrisBoard[row][column] = "-";
                }
                else tetrisBoard[row][column] = " ";
            }
        }
    }
}



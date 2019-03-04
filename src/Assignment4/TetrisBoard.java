package Assignment4;


import java.util.ArrayList;
import java.util.Arrays;

class TetrisBoard {
    static final String tetrisBoard[][]={
            /* 0 */   {" "," "," "," "," "," "," "," "},
            /* 1 */   {" "," "," "," "," "," "," "," "},
            /* 2 */   {" "," "," "," "," "," "," "," "},
            /* 3 */   {" "," "," "," "," "," "," "," "},
            /* 4 */   {" "," "," "," "," "," "," "," "},
            /* 5 */   {" "," "," "," "," "," "," "," "},
            /* 6 */   {" "," "," "," "," "," "," "," "},
            /* 7 */   {" "," "," "," "," "," "," "," "},
            /* 8 */   {" "," "," "," "," "," "," "," "},
            /* 9 */   {" "," "," "," "," "," "," "," "},
            /* 10 */  {" "," "," "," "," "," "," "," "},
            /* 11 */  {" "," "," "," "," "," "," "," "},
            /* 12 */  {" "," "," "," "," "," "," "," "},
            /* 13 */  {" "," "," "," "," "," "," "," "},
            /* 14 */  {" "," "," "," "," "," "," "," "},
            /* 15 */  {" "," "," "," "," "," "," "," "},
            /* 16 */  {" "," "," "," "," "," "," "," "},
            /* 17 */  {" "," "," "," "," "," "," "," "},
            /* 18 */  {"E","E","E","E","E","E","E","E"}};

    public static String[][] getTetrisBoard() {
        return tetrisBoard;
    }

    public void drawTetrisBoard() {
        for (int i=0;i<19;i++) {
            System.out.println(Arrays.toString(tetrisBoard[i]));
        }
        System.out.println();
    }

    public void setTetrisBoard(ArrayList<Integer> yAxisMove, ArrayList<Integer> xAxisMove, ArrayList<Integer> yAxisRemove, ArrayList<Integer> xAxisRemove, String subBlockType){
        for(int i = 0; i < yAxisMove.size(); i++){
            tetrisBoard[yAxisMove.get(i)][xAxisMove.get(i)] = subBlockType;
        }
        for(int i = 0; i < yAxisRemove.size(); i++){
            tetrisBoard[yAxisRemove.get(i)][xAxisRemove.get(i)] = " ";
        }
    }
}


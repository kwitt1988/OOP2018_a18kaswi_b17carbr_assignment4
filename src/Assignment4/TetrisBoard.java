package Assignment4;

import java.util.ArrayList;
import java.util.Arrays;

class TetrisBoard {
    public static String tetrisBoard[][]={
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
            /* 18 */  {"-","-","-","-","-","-","-","-"}};

    public void drawTetrisBoard() {
        for (int i=0;i<19;i++) {
            System.out.println(Arrays.toString(tetrisBoard[i]));
        }
        System.out.println();
    }



    public void setTetrisBoard(ArrayList<Integer> yAxisMove, ArrayList<Integer> xAxisMove, ArrayList<Integer> yAxisRemove, ArrayList<Integer> xAxisRemove, String subBlockType){

        for(int i = 0; i < yAxisMove.size(); i++){
            System.out.println(yAxisMove.size());
            tetrisBoard[yAxisMove.get(i)][xAxisMove.get(i)] = subBlockType;
        }

        for(int i = 0; i < yAxisRemove.size(); i++){
            tetrisBoard[yAxisRemove.get(i)][xAxisRemove.get(i)] = " ";
        }
    }


    public void setTetrisBoardTest(BlockModel block){
        for (int row = 0; row < block.getBlockPosition().length; row++){
            for (int column = 0; column < block.getBlockPosition()[row].length; column++){
                if(block.getBlockPosition()[row][column] == "Square") {
                    tetrisBoard[row][column] = block.getBlockPosition()[row][column];
                } else tetrisBoard[row][column] = " ";
            }
        }
    }
}
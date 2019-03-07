package Assignment4;


class TetrisBoard {
    public BlockModel[][] asdf = new BlockModel[2][2];
    public String tetrisBoard[][]={
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


    public String[][] getTetrisBoard(){
        return tetrisBoard;
    }

    public void setTetrisBoardString(String[][] newBoard){
        for (int row = 0; row < newBoard.length; row++){
            for (int column = 0; column < newBoard[row].length; column++){
                    tetrisBoard[row][column] = newBoard[row][column];
            }
        }
    }

    public void setTetrisBoardObject(TetrisBlock block){
        for (int row = 0; row < block.getBlockPosition().length; row++){
            for (int column = 0; column < block.getBlockPosition()[row].length; column++){
                if(block.getBlockPosition()[row][column] == "currentPiece1" || block.getBlockPosition()[row][column] == "currentPiece2" ||
                block.getBlockPosition()[row][column] == "currentPiece3" || block.getBlockPosition()[row][column] == "currentPiece4") {
                    tetrisBoard[row][column] = block.getBlockPosition()[row][column];
                } else if(block.getBlockPosition()[row][column] == "CurrentBlock"){
                    tetrisBoard[row][column] = "CurrentBlock";
                } else tetrisBoard[row][column] = " ";

            }
        }
    }
}
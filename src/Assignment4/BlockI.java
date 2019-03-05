package Assignment4;

import java.util.ArrayList;

public class BlockI implements TetrisBlock {
    private ArrayList<Integer> yAxisMove = new ArrayList<>();
    private ArrayList<Integer> xAxisMove = new ArrayList<>();
    private ArrayList<Integer> yAxisRemove = new ArrayList<>();
    private ArrayList<Integer> xAxisRemove = new ArrayList<>();
    private ArrayList<Integer> previousMove;
    private int yAxisPos;
    private int xAxisPos;
    private int move;
    private boolean endPos = false;
    private String subBlockType;
    private String blockNumber;
    private String prevBlockNumber;


    public BlockI(int yAxis, int xAxis, String subBlockType, int movement, ArrayList<Integer> previousMove, int rotateBlock) {
        System.out.println(rotateBlock);
        if(rotateBlock != 0 && rotateBlock != 2 && subBlockType.equals("Iv")){
            this.subBlockType = "Ih";
        }
        else{
            this.subBlockType = "Iv";
        }
        this.move = movement;
        this.previousMove = previousMove;
        this.yAxisPos = yAxis;
        this.xAxisPos = xAxis;
        //this.subBlockType = subBlockType;
        this.blockNumber = Integer.toString((previousMove.size()-1));
        this.prevBlockNumber = Integer.toString((previousMove.size()-2));
        System.out.println(prevBlockNumber);
        createBlock();


    }

    public void createBlock() {
        if (subBlockType == "Ih") {
            if (TetrisBoard.tetrisBoard[yAxisPos + 1][xAxisPos] == " " && TetrisBoard.tetrisBoard[yAxisPos + 1][xAxisPos + 1] == " " && TetrisBoard.tetrisBoard[yAxisPos + 1][xAxisPos + 2] == " "
                    && TetrisBoard.tetrisBoard[yAxisPos + 1][xAxisPos + 3] == " " && TetrisBoard.tetrisBoard[yAxisPos + 1][xAxisPos + 4] == " ") {
                // Move section
                this.yAxisMove.add(yAxisPos + 1);
                this.yAxisMove.add(yAxisPos + 1);
                this.yAxisMove.add(yAxisPos + 1);
                this.yAxisMove.add(yAxisPos + 1);

                this.xAxisMove.add(xAxisPos + move);
                this.xAxisMove.add(xAxisPos + (move + 1));
                this.xAxisMove.add(xAxisPos + (move + 2));
                this.xAxisMove.add(xAxisPos + (move + 3));

                removeBlock();

            } else {
                this.endPos = true;

            }
        }
        if (subBlockType == "Iv") {
            if (TetrisBoard.tetrisBoard[yAxisPos + 3][xAxisPos + move] == " " ) {
                // Move section
                removeBlock();
                this.yAxisMove.add(yAxisPos);
                this.yAxisMove.add(yAxisPos + 1);
                this.yAxisMove.add(yAxisPos + 2);
                this.yAxisMove.add(yAxisPos + 3);

                this.xAxisMove.add(xAxisPos + move);
                this.xAxisMove.add(xAxisPos + move);
                this.xAxisMove.add(xAxisPos + move);
                this.xAxisMove.add(xAxisPos + move);


            }
            else {
                this.endPos = true;
        }


        }

    }
        public void removeBlock() {

                for(int i=0; i< TetrisBoard.tetrisBoard.length; i++) {
                    for(int j=0; j<TetrisBoard.tetrisBoard[i].length; j++) {
                        if(TetrisBoard.tetrisBoard[i][j].equals("Iv"+prevBlockNumber) || TetrisBoard.tetrisBoard[i][j].equals("Ih"+prevBlockNumber) ){
                            this.xAxisRemove.add(j);
                            this.yAxisRemove.add(i);
                       }
                    }
               }

            }


        @Override
        public int getYAxis () {
            return yAxisPos;
        }

        @Override
        public int getXAxis () {
            return xAxisPos;
        }

        @Override
        public ArrayList<Integer> getXAxisMove () {
            return xAxisMove;
        }

        @Override
        public ArrayList<Integer> getYAxisMove () {
            return yAxisMove;
        }

        @Override
        public ArrayList<Integer> getXAxisRemove () {
            return xAxisRemove;
        }

        @Override
        public ArrayList<Integer> getYAxisRemove () {
            return yAxisRemove;
        }
        public String getBlockSubType () {
            return subBlockType + blockNumber;
        }

        @Override
        public boolean getEndPos () {
            return endPos;
        }
    }

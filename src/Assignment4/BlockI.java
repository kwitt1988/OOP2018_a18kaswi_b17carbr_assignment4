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
    private int rotateBlock;
    private boolean endPos = false;
    private String subBlockType;
    private String blockNumber;
    private String prevBlockNumber;



    public BlockI(int yAxis, int xAxis, String subBlockType, int movement, ArrayList<Integer> previousMove, int rotateBlock) {
        this.rotateBlock = rotateBlock;
        this.move = movement;
        this.previousMove = previousMove;
        this.yAxisPos = yAxis;
        this.xAxisPos = xAxis;
        this.blockNumber = Integer.toString((previousMove.size()-1));
        this.prevBlockNumber = Integer.toString((previousMove.size()-2));
        rotateBlock(subBlockType);
        createBlock();


    }

    public void createBlock() {
        if (subBlockType == "Ih") {

            int changeMove;
            if(move >= 5){
                changeMove = 4;
            }
            else {
                changeMove = move;
            }
            System.out.println("Iv"+prevBlockNumber);

            if (TetrisBoard.tetrisBoard[yAxisPos + 1][xAxisPos + changeMove] == " " && TetrisBoard.tetrisBoard[yAxisPos + 1][xAxisPos + (changeMove + 1)] == " " && TetrisBoard.tetrisBoard[yAxisPos + 1][xAxisPos + (changeMove + 2)] == " "
                    && TetrisBoard.tetrisBoard[yAxisPos + 1][xAxisPos + (changeMove + 3)] == " " || (TetrisBoard.tetrisBoard[yAxisPos + 1][xAxisPos + changeMove ].equals("Iv"+prevBlockNumber))) {
                // Move section
                this.yAxisMove.add(yAxisPos );
                this.yAxisMove.add(yAxisPos );
                this.yAxisMove.add(yAxisPos );
                this.yAxisMove.add(yAxisPos );

                if(move >= 4){
                    this.xAxisMove.add(xAxisPos + changeMove);
                    this.xAxisMove.add(xAxisPos + (changeMove + 1));
                    this.xAxisMove.add(xAxisPos + (changeMove + 2));
                    this.xAxisMove.add(xAxisPos + (changeMove + 3));
                }
                else {
                    this.xAxisMove.add(xAxisPos + move);
                    this.xAxisMove.add(xAxisPos + (move + 1));
                    this.xAxisMove.add(xAxisPos + (move + 2));
                    this.xAxisMove.add(xAxisPos + (move + 3));
                }
                removeBlock();




            } else {
                System.out.println("HÄR VAR SKITEN");
                this.endPos = true;

            }
        }
        if (subBlockType == "Iv") {
            if (TetrisBoard.tetrisBoard[yAxisPos + 3][xAxisPos + move] == " ") {
                // Move section
                    this.yAxisMove.add(yAxisPos);
                    this.yAxisMove.add(yAxisPos + 1);
                    this.yAxisMove.add(yAxisPos + 2);
                    this.yAxisMove.add(yAxisPos + 3);

                    this.xAxisMove.add(xAxisPos + move);
                    this.xAxisMove.add(xAxisPos + move);
                    this.xAxisMove.add(xAxisPos + move);
                    this.xAxisMove.add(xAxisPos + move);

                    removeBlock();

            }
            else {
                System.out.println("CALLEED");
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

        public void rotateBlock(String subBlockType){


            if(rotateBlock != 0 && rotateBlock != 2 && subBlockType.equals("Iv")){
                this.subBlockType = "Ih";
            }
            else if(rotateBlock != 1 && rotateBlock != 3 && subBlockType.equals("Iv")){
                this.subBlockType = "Iv";
            }
            else if(rotateBlock != 0 && rotateBlock != 2 && subBlockType.equals("Ih")){
                this.subBlockType = "Iv";
            }
            else if(rotateBlock != 1 && rotateBlock != 3 && subBlockType.equals("Ih")){
                this. subBlockType = "Ih";
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

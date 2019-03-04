package Assignment4;

import java.util.ArrayList;

public class IBlock implements TetrisBlock {
    private ArrayList<Integer> yAxisMove = new ArrayList<>();
    private ArrayList<Integer> xAxisMove = new ArrayList<>();
    private ArrayList<Integer> yAxisRemove= new ArrayList<>();
    private ArrayList<Integer> xAxisRemove= new ArrayList<>();
    private int yAxisPos;
    private int xAxisPos;
    private boolean endPos = false;
    private String subBlockType;

    public IBlock(int yAxis, int xAxis, String subBlockType, int movement) {
        int move = movement;
        this.yAxisPos = yAxis;
        this.xAxisPos = xAxis;
        this.subBlockType = subBlockType;

        // I-BLOCK HORIZONTAL
        if(subBlockType == "Ih") {
            if (TetrisBoard.tetrisBoard[yAxis + 1][xAxis] == " " && TetrisBoard.tetrisBoard[yAxis + 1][xAxis + 1] == " " && TetrisBoard.tetrisBoard[yAxis + 1][xAxis + 2] == " "
                    && TetrisBoard.tetrisBoard[yAxis + 1][xAxis + 3] == " " && TetrisBoard.tetrisBoard[yAxis + 1][xAxis + 4] == " ") {
                // Move section
                this.yAxisMove.add(yAxis + 1);
                this.yAxisMove.add(yAxis + 1);
                this.yAxisMove.add(yAxis + 1);
                this.yAxisMove.add(yAxis + 1);

                this.xAxisMove.add(xAxis);
                this.xAxisMove.add(xAxis + 1);
                this.xAxisMove.add(xAxis + 2);
                this.xAxisMove.add(xAxis + 3);

                //Remove section
                this.yAxisRemove.add(yAxis);
                this.yAxisRemove.add(yAxis);
                this.yAxisRemove.add(yAxis);
                this.yAxisRemove.add(yAxis);

                this.xAxisRemove.add(xAxis);
                this.xAxisRemove.add(xAxis + 1);
                this.xAxisRemove.add(xAxis + 2);
                this.xAxisRemove.add(xAxis + 3);


            } else {
                this.endPos = true;
            }
        }
        // I-BLOCK VERTICAL
        if(subBlockType == "Iv") {
            if (TetrisBoard.tetrisBoard[yAxis + 3][xAxis] == " " ) {
                // Move section
                this.yAxisMove.add(yAxis);
                this.yAxisMove.add(yAxis + 1);
                this.yAxisMove.add(yAxis + 2);
                this.yAxisMove.add(yAxis + 3);
                // System.out.println(yAxisMove);

                this.xAxisMove.add(xAxis+move);
                this.xAxisMove.add(xAxis+move);
                this.xAxisMove.add(xAxis+move);
                this.xAxisMove.add(xAxis+move);

                //Remove section
                this.yAxisRemove.add(yAxis - 1);
                this.xAxisRemove.add(xAxis);

            } else {
                this.endPos = true;
            }
        }
        //new

    }
    @Override
    public int getYAxis(){
        return yAxisPos;
    }

    @Override
    public int getXAxis(){
        return xAxisPos;
    }

    @Override
    public ArrayList<Integer> getXAxisMove() {
        return xAxisMove;
    }

    @Override
    public ArrayList<Integer> getYAxisMove() {
        return yAxisMove;
    }

    @Override
    public ArrayList<Integer> getXAxisRemove() {
        return xAxisRemove;
    }

    @Override
    public ArrayList<Integer> getYAxisRemove() {
        return yAxisRemove;
    }
    public String getBlockSubType(){
        return subBlockType;
    }

    @Override
    public boolean getEndPos(){
        return endPos;
    }

    @Override
    public void rotateBlock() {
    }

    @Override
    public void moveBlockLeft() {


    }

    @Override
    public void moveBlockRight() {

    }
}
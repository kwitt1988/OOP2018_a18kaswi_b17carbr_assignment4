package Assignment4;

import java.util.ArrayList;

public class BlockI implements TetrisBlock {
    private ArrayList<Integer> yAxisMove = new ArrayList<>();
    private ArrayList<Integer> xAxisMove = new ArrayList<>();
    private ArrayList<Integer> yAxisRemove= new ArrayList<>();
    private ArrayList<Integer> xAxisRemove= new ArrayList<>();
    private ArrayList<Integer> previousMove = new ArrayList<>();
    private int yAxisPos;
    private int xAxisPos;
    private boolean endPos = false;
    private String subBlockType;

    public BlockI(int yAxis, int xAxis, String subBlockType, int movement, ArrayList<Integer> previousMove) {
        int move = movement;
        this.previousMove = previousMove;
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

                this.xAxisMove.add(xAxis + move);
                this.xAxisMove.add(xAxis + (move + 1));
                this.xAxisMove.add(xAxis + (move + 2));
                this.xAxisMove.add(xAxis + (move + 3));

                //Remove section
                //No movement
                if(!(previousMove.size() <= 1) && previousMove.get(previousMove.size()-1).equals(previousMove.get(previousMove.size()-2))) {
                    this.yAxisRemove.add(yAxis);
                    this.yAxisRemove.add(yAxis);
                    this.yAxisRemove.add(yAxis);
                    this.yAxisRemove.add(yAxis);

                    this.xAxisRemove.add(xAxis + move);
                    this.xAxisRemove.add(xAxis + (move + 1));
                    this.xAxisRemove.add(xAxis + (move + 2));
                    this.xAxisRemove.add(xAxis + (move + 3));
                }
                //Left movement
                if(!(previousMove.size() <= 1) && previousMove.get(previousMove.size()-1) < previousMove.get(previousMove.size()-2)){
                    this.yAxisRemove.add(yAxis);
                    this.yAxisRemove.add(yAxis);
                    this.yAxisRemove.add(yAxis);
                    this.yAxisRemove.add(yAxis);

                    this.xAxisRemove.add(xAxis + (move + 1));
                    this.xAxisRemove.add(xAxis + (move + 2));
                    this.xAxisRemove.add(xAxis + (move + 3));
                    this.xAxisRemove.add(xAxis + (move + 4));
                }
                //Right movement
                if(!(previousMove.size() <= 1) && previousMove.get(previousMove.size()-1) > previousMove.get(previousMove.size()-2)){
                    this.yAxisRemove.add(yAxis);
                    this.yAxisRemove.add(yAxis);
                    this.yAxisRemove.add(yAxis);
                    this.yAxisRemove.add(yAxis);

                    this.xAxisRemove.add(xAxis + (move - 1));
                    this.xAxisRemove.add(xAxis + move);
                    this.xAxisRemove.add(xAxis + (move + 1));
                    this.xAxisRemove.add(xAxis + (move + 2));
                }

            } else {
                this.endPos = true;
            }
        }
        // I-BLOCK VERTICAL
        if(subBlockType == "Iv") {
            if (TetrisBoard.tetrisBoard[yAxis + 3][xAxis + move] == " " ) {
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
                //No movement
                if(!(previousMove.size() <= 1) && previousMove.get(previousMove.size()-1).equals(previousMove.get(previousMove.size()-2))) {
                    this.yAxisRemove.add(yAxis - 1 );
                    this.xAxisRemove.add(xAxis + move);
                }
                //Left movement
                if(!(previousMove.size() <= 1) && previousMove.get(previousMove.size()-1) < previousMove.get(previousMove.size()-2)){
                    this.yAxisRemove.add(yAxis - 1);
                    this.yAxisRemove.add(yAxis);
                    this.yAxisRemove.add(yAxis + 1);
                    this.yAxisRemove.add(yAxis + 2);


                    this.xAxisRemove.add(xAxis + (move + 1));
                    this.xAxisRemove.add(xAxis + (move + 1));
                    this.xAxisRemove.add(xAxis + (move + 1));
                    this.xAxisRemove.add(xAxis + (move + 1));

                }
                //Right movement
                if(!(previousMove.size() <= 1) && previousMove.get(previousMove.size()-1) > previousMove.get(previousMove.size()-2)){
                    System.out.println("hello");
                    this.yAxisRemove.add(yAxis - 1);
                    this.yAxisRemove.add(yAxis);
                    this.yAxisRemove.add(yAxis + 1);
                    this.yAxisRemove.add(yAxis + 2);


                    this.xAxisRemove.add(xAxis + (move - 1));
                    this.xAxisRemove.add(xAxis + (move - 1));
                    this.xAxisRemove.add(xAxis + (move - 1));
                    this.xAxisRemove.add(xAxis + (move - 1));
                }


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
}
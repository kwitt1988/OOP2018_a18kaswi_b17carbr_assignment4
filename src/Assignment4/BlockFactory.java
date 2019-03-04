package Assignment4;

import java.util.ArrayList;

public class BlockFactory {
    private int yAxisPos;
    private int xAxisPos;
    private ArrayList<Integer> previousMove = new ArrayList<>();


    //use getBlock method to get object of type TetrisBlock
    // need to make this method random

    public TetrisBlock getBlock(String blockType, String subBlockType, int yAxis, int xAxis, int movement){
        previousMove.add(movement);

        if(blockType == null){
            return null;
        }
        if(blockType.equalsIgnoreCase("I-BLOCK")){
            IBlock current = new IBlock(yAxis, xAxis, subBlockType, movement, previousMove);setLocalValues(current.getYAxis(),current.getXAxis());
            return current;

        } else if(blockType.equalsIgnoreCase("L-BLOCK")){
            // return new

        } else if(blockType.equalsIgnoreCase("S-BLOCK")){
            //return new
        }

        return null;
    }

    public void setLocalValues(int yAxisPos, int xAxisPos){
        this.yAxisPos = yAxisPos;
        this.xAxisPos = xAxisPos;
    }
}

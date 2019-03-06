package Assignment4;

import java.util.ArrayList;

public class BlockFactory {
    private int yAxisPos;
    private int xAxisPos;
    private ArrayList<Integer> previousMove = new ArrayList<>();

    public TetrisBlock getBlock(String blockType, String subBlockType, int yAxis, int xAxis, int movement){
        return null;
    }

    public void setLocalValues(int yAxisPos, int xAxisPos){
        this.yAxisPos = yAxisPos;
        this.xAxisPos = xAxisPos;
    }
}

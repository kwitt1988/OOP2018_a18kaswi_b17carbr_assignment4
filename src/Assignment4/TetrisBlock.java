package Assignment4;

import java.util.ArrayList;

public interface TetrisBlock {
    int getYAxis();
    int getXAxis();
    String getBlockSubType();
    ArrayList<Integer> getXAxisMove();
    ArrayList<Integer> getYAxisMove();
    ArrayList<Integer> getXAxisRemove();
    ArrayList<Integer> getYAxisRemove();
    boolean getEndPos();
}
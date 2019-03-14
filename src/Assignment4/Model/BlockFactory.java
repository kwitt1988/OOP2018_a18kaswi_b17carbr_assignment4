package Assignment4.Model;

import Assignment4.Model.Blocks.*;

// The BlockFactory is responsible for supplying random blocks, encapsulates the creation of blocks away from all other parts of the program.
public class BlockFactory {

    public TetrisBlock getBlock(TetrisBoard board){
        return createRandomBlock(board);
    }

    private TetrisBlock createRandomBlock(TetrisBoard board){
        TetrisBlock newBlock = new BlockModel();
        int random = (int)(Math.random() * 7) + 1;
        switch (random){
            case 1: newBlock = new BlockInvertedL(board);
                break;
            case 2: newBlock = new BlockL(board);
                break;
            case 3: newBlock = new BlockLine(board);
                break;
            case 4: newBlock = new BlockS(board);
                break;
            case 5: newBlock = new BlockSquare(board);
                break;
            case 6: newBlock = new BlockT(board);
                break;
            case 7: newBlock = new BlockZ(board);

        }
        return newBlock;
    }
}
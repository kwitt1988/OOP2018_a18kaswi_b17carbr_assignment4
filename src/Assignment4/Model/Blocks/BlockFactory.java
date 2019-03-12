package Assignment4.Model.Blocks;


import Assignment4.Model.TetrisBoard;

public class BlockFactory {

    public TetrisBlock getBlock(TetrisBoard board){
        return createRandomBlock(board);
    }

    private TetrisBlock createRandomBlock(TetrisBoard board){
        TetrisBlock newBlock = new BlockModel();
        int random = (int)(Math.random() * 3) + 1;
        switch (random){
            case 1: newBlock = new BlockL(board);
                break;
            case 2: newBlock = new BlockL(board);
                break;
        }
        return newBlock;
    }
}

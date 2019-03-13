package Assignment4.Blocks;


import Assignment4.TetrisBoard;
// The BlockFactory is responsible for supplying random blocks, encapsulates the creation of blocks away from all other parts of the program.
public class BlockFactory {

    public TetrisBlock getBlock(TetrisBoard board){
        return createRandomBlock(board);
    }

    private TetrisBlock createRandomBlock(TetrisBoard board){
        TetrisBlock newBlock = new BlockModel();
        int random = (int)(Math.random() * 3) + 1;
        switch (random){
            case 1: newBlock = new BlockLine(board);
                break;
            case 2: newBlock = new BlockL(board);
                break;
            case 3: newBlock = new BlockL(board);
                break;

        }
        return newBlock;
    }
}
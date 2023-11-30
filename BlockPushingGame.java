package blockGame;

public class BlockPushingGame {
    private GameBoard gameBoard;
    private Player player;
    private Block block;

    public BlockPushingGame(int gridSize) {
        player = new Player();
        block = new Block(2, 2);  // Initial block position
    	
        gameBoard = new GameBoard(gridSize, player, block);
        gameBoard.updateGameBoard();
    }

    public static void main(String[] args) {
        new BlockPushingGame(5);
    }
}

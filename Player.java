package blockGame;

public class Player {
    private int x, y;
    private static final int JUMP_SIZE = 50;

    public Player() {
        // Initial player position
        x = JUMP_SIZE;
        y = JUMP_SIZE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
    	this.x = x;
    }
    
    public void setY(int y) {
    	this.y = y;
    }
}

package blockGame;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GameBoard extends JFrame {
    private static final int JUMP_SIZE = 50;
    private Player player;
    private Block block;

    public GameBoard(int gridSize, Player player, Block block) {
    	this.player = player;
    	this.block = block;
    	
        initializeBoard(gridSize);
        addKeyListener(new ArrowKeyListener());
        setFocusable(true);
        setSize(gridSize * JUMP_SIZE, gridSize * JUMP_SIZE);
        setLocationRelativeTo(null);
    }

    private void initializeBoard(int gridSize) {
        JFrame frame = new JFrame ("Block Pushing Game");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GameBoard(JUMP_SIZE * gridSize, player, block));
        frame.pack();
        frame.setVisible(true);
    }
    
    public void updateGameBoard() {
    	player.getX();
    	player.getY();
    	block.getX();
    	block.getY();
    }

    private class ArrowKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            switch (keyCode) {
                case KeyEvent.VK_UP:
                    player.setY(-JUMP_SIZE);
                    break;
                case KeyEvent.VK_DOWN:
                    player.setY(JUMP_SIZE);
                    break;
                case KeyEvent.VK_LEFT:
                	player.setX(-JUMP_SIZE);          
                	break;
                case KeyEvent.VK_RIGHT:
                    player.setX(JUMP_SIZE);
                    break;	
            }
            
            updateGameBoard();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

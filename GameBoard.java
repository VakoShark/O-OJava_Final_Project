package blockGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class GameBoard extends JFrame {
    private static final int TILE_SIZE = 50;
    private JButton[][] tiles;
    private Player player;
    private Block block;

    public GameBoard(int gridSize, Player player, Block block) {
    	this.player = player;
    	this.block = block;
    	
        setTitle("Block Pushing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(gridSize, gridSize));
        initializeBoard(gridSize);
        addKeyListener(new ArrowKeyListener());
        setFocusable(true);
        setSize(gridSize * TILE_SIZE, gridSize * TILE_SIZE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeBoard(int gridSize) {
        tiles = new JButton[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
                tiles[i][j] = button;
                add(button);
            }
        }
    }

    public void updateTile(int x, int y, String text) {
        tiles[x][y].setText(text);
    }
    
    public void updateGameBoard() {
        updateTile(player.getX(), player.getY(), "P");
        updateTile(block.getX(), block.getY(), "B");
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
                    player.move(-1, 0);
                    break;
                case KeyEvent.VK_DOWN:
                    player.move(1, 0);
                    break;
                case KeyEvent.VK_LEFT:
                	player.move(0, -1);          
                	break;
                case KeyEvent.VK_RIGHT:
                    player.move(0, 1);
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

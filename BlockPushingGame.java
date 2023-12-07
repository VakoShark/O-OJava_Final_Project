package blockGame;
//********************************************************************
//DirectionPanel.java       Author: Lewis/Loftus
//
//Represents the primary display panel for the Direction program.
//Modified to fit needs of block game
//********************************************************************
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BlockPushingGame extends JPanel
{
private final int WIDTH = 700, HEIGHT = 500;
private final int JUMP = 10;  // increment for image movement

private ImageIcon playerBlock, pushBlock, goalBlock;
private int x, y;
public int pushBlockX = 300;
public int pushBlockY = 250;
private int pushBlockXInitial = pushBlockX;
private int pushBlockYInitial = pushBlockY;
private int goalBlockX = 650;
private int goalBlockY = 450;

//Constructor: Sets up this panel and loads the images.
public BlockPushingGame()
{
  addKeyListener (new DirectionListener());

  x = 0;
  y = 0;

  playerBlock = new ImageIcon ("player_block.png");
	  
  setBackground (Color.black);
  setPreferredSize (new Dimension(WIDTH, HEIGHT));
  setFocusable(true);
  
  pushBlock = new ImageIcon("push_block.png");
  goalBlock = new ImageIcon("goal_block.png");
}

//Draws the image in the current location.
public void paintComponent (Graphics page)
{
  super.paintComponent (page);
  playerBlock.paintIcon (this, page, x, y);
  
  pushBlock.paintIcon(this, page, pushBlockX, pushBlockY);
  goalBlock.paintIcon(this, page, 650, 450);
}

//*****************************************************************
//  Represents the listener for keyboard activity.
//*****************************************************************
private class DirectionListener implements KeyListener
{
  //Responds to the user pressing arrow keys by adjusting the
  //image and image location accordingly.
	
	private int nextX, nextY;
	
  public void keyPressed (KeyEvent event)
  {  
	  nextX = x;
	  nextY = y;
	  
	 if (!victoryCondition(nextX, nextY)) {
	     switch (event.getKeyCode())
	     {
	        case KeyEvent.VK_UP:
	           nextY -= JUMP;
	           break;
	        case KeyEvent.VK_DOWN:
	           nextY += JUMP;
	           break;
	        case KeyEvent.VK_LEFT:
	           nextX -= JUMP;
	           break;
	        case KeyEvent.VK_RIGHT:
	           nextX += JUMP;
	           break;
	     }
	 }
	 else {
		 System.out.println("Congratulations, You Won!");
	 }
     
     if (!checkCollision(nextX, nextY)) {
    	 x = nextX;
    	 y = nextY;
     }
     if (wallCollision(nextX, nextY)) {
    	 x -= nextX;
    	 y -= nextY;
    	 pushBlockX = pushBlockXInitial;
    	 pushBlockY = pushBlockYInitial;
     }
     
     repaint();
  }
  
  //Provide empty definitions for unused event methods.
  public void keyTyped (KeyEvent event) {}
  public void keyReleased (KeyEvent event) {}
}

//Checks for collision between player block and pushable block
private boolean checkCollision(int newX, int newY) {
    // Check for collision with push block
    if (newX == pushBlockX && newY == pushBlockY) {
        // Check if the next position after pushing is within bounds
        int newPushBlockX = pushBlockX + (newX - x);
        int newPushBlockY = pushBlockY + (newY - y);
        if (newPushBlockX >= 0 && newPushBlockX < WIDTH &&
            newPushBlockY >= 0 && newPushBlockY < HEIGHT) {
            pushBlockX = newPushBlockX;
            pushBlockY = newPushBlockY;
            return true; // Collision successful, push_block moved
        }
    }
    return false; // No collision
}

//Creates collision effect on boundaries of screen
private boolean wallCollision(int newX, int newY) {
    // Check for collision with push block
    if (newX >= 670 || newX < 0 || newY >= 500 || newY < 0) {
        // Check if the next position after pushing is within bounds
        return true; // Collision successful, push_block moved
        }
    return false; // No collision
}

//Determines if victory condition is hit
private boolean victoryCondition(int newX, int newY) {
	if(pushBlockX == goalBlockX && pushBlockY == goalBlockY) {
		return true;
	}
	return false;
}
}

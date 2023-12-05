package blockGame;
//********************************************************************
//DirectionPanel.java       Author: Lewis/Loftus
//
//Represents the primary display panel for the Direction program.
//********************************************************************
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlockPushingGame extends JPanel
{
private final int WIDTH = 700, HEIGHT = 500;
private final int JUMP = 10;  // increment for image movement

private final int IMAGE_SIZE = 1;

private ImageIcon up, down, right, left, currentImage, pushBlock, goalBlock;
private int x, y;

//-----------------------------------------------------------------
//  Constructor: Sets up this panel and loads the images.
//-----------------------------------------------------------------
public BlockPushingGame()
{
  addKeyListener (new DirectionListener());

  x = 0;
  y = 0;

  up = new ImageIcon ("player_block.png");
  down = new ImageIcon ("player_block.png");
  left = new ImageIcon ("player_block.png");
  right = new ImageIcon ("player_block.png");

  currentImage = right;
	  
  setBackground (Color.black);
  setPreferredSize (new Dimension(WIDTH, HEIGHT));
  setFocusable(true);
  
  pushBlock = new ImageIcon("push_block.png");
  goalBlock = new ImageIcon("goal_block.png");
}

//-----------------------------------------------------------------
//  Draws the image in the current location.
//-----------------------------------------------------------------
public void paintComponent (Graphics page)
{
  super.paintComponent (page);
  currentImage.paintIcon (this, page, x, y);
  
  pushBlock.paintIcon(this, page, 150, 150);
  goalBlock.paintIcon(this, page, 650, 450);
}

//*****************************************************************
//  Represents the listener for keyboard activity.
//*****************************************************************
private class DirectionListener implements KeyListener
{
  //--------------------------------------------------------------
  //  Responds to the user pressing arrow keys by adjusting the
  //  image and image location accordingly.
  //--------------------------------------------------------------
  public void keyPressed (KeyEvent event)
  {
     switch (event.getKeyCode())
     {
        case KeyEvent.VK_UP:
           currentImage = up;
           y -= JUMP;
           break;
        case KeyEvent.VK_DOWN:
           currentImage = down;
           y += JUMP;
           break;
        case KeyEvent.VK_LEFT:
           currentImage = left;
           x -= JUMP;
           break;
        case KeyEvent.VK_RIGHT:
           currentImage = right;
           x += JUMP;
           break;
     }

     repaint();
  }

  //--------------------------------------------------------------
  //  Provide empty definitions for unused event methods.
  //--------------------------------------------------------------
  public void keyTyped (KeyEvent event) {}
  public void keyReleased (KeyEvent event) {}
}


}

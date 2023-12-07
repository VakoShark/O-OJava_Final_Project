package blockGame;

import java.util.ArrayList;

import javax.swing.JFrame;
//Class that contains the driver method for the entirety of the block game
public class main {
	
	//Make this into something that multiple classes can use
	//Each level will be it's own class
	private ArrayList<BlockPushingGame> levels = new ArrayList<BlockPushingGame>();


	public static void main(String[] args) {
	      JFrame frame = new JFrame ("Block Game");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	      frame.getContentPane().add (new BlockPushingGame());

	      frame.pack();
	      frame.setLocationRelativeTo(null);
	      frame.setVisible(true);	
	      }
}

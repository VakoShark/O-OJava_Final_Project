package blockGame;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFrame;
public class main {

	public static void main(String[] args) {
	      JFrame frame = new JFrame ("Block Game");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	      frame.getContentPane().add (new BlockPushingGame());

	      frame.pack();
	      frame.setVisible(true);	
	      }
/*		        String imageName = "block.png";

		        if (imageExists(imageName)) {
		            System.out.println("Image exists!");
		        } else {
		            System.out.println("Image does not exist.");
		        }
		    }

		    public static boolean imageExists(String imageName) {
		        // Get the current working directory
		        String currentDirectory = System.getProperty("user.dir");

		        // Create a Path object for the image file in the current directory
		        Path imagePath = FileSystems.getDefault().getPath(currentDirectory, imageName);

		        // Check if the file exists
		        return Files.exists(imagePath) && !Files.isDirectory(imagePath);
		    }*/
}

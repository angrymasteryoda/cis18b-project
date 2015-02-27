package towerdefenseproject;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class GameWindow extends JFrame{
	
	// The programs main frame
	public GameWindow(){
		new JFrame();
		this.setTitle("Tower Defense");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// DONATED CODE BY Alvin Alexander (http://alvinalexander.com/java/jframe-size-example-screen)
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height * 2 / 3;
		int width = screenSize.width * 2 / 3;
		// END DONATED CODE
		this.setSize(width,height);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		// Run Screen.java - Creates the whole game indside GameWindow
		Screen screen = new Screen(this);
		// Add screen class to GameWindow's JFrame (See Screen.java comments)
		this.add(screen);
	}
	
	// Main method
	public static void main(String[] args){
		new GameWindow();
	}
}
package towerdefenseproject;

import java.awt.Color;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.awt.Frame.NORMAL;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Toolkit;

// Extends - Allows us to print and draw on the jFrame (GameWindow)
// Runnable - Allows us to start and stop executing the run class
public class Screen extends JPanel implements Runnable {

	public Thread thread = new Thread(this);	// Main thread of the game > once started this is controled by running
	GameWindow frame;							// Load GameWindow > we need its generated size
	private int fps = 0;						// Frames Per Second (FPS)
	private int scene;							// Game scenes > 0 is main menu, levels will have their own numbers
	private boolean running = false;			// Game loaded > once loaded if false is deteceted again shutdown game
	private boolean paused = false;				// Game pasued
	private boolean fullScreen = false;			// Game set to fullscreen
	private boolean debug = false;				// Game debugger > On shows info on screen > TODO print or log values for debugging
	private boolean hand = false;				// Game mouse > Is the plwyer holding an object (tower) currently
	
	public Screen(GameWindow frame) {
		this.frame = frame;
		this.frame.addKeyListener(new KeyHandler(this));
		thread.start();	// Tell run to start
	}
	
	public void paintComponent(Graphics g){
		g.clearRect(0,0,this.frame.getWidth(),this.frame.getHeight());	// Clear last painted layer or we will suffer major lag
		
		// Main Menu - Keep 0 - 9 reserved for menus, levels start at 10
		// NOTE:	I removed the else statments because that is redundant
		//			Just make sure to ALWAYS set a vaild scene number
		//			[UPDATE] I Feel we may need to add th else statments back in?
		if (scene==0){
			g.setColor(Color.DARK_GRAY);
		}
		if (scene==10){
			g.setColor(Color.GREEN);
		}
		// Error scene
		if (scene<0){
			g.setColor(Color.RED);
		}
		g.fillRect(0,0,this.frame.getWidth(),this.frame.getHeight());
		
		if (debug==true){
			// Display FPS for debugging
			g.setColor(Color.BLACK);
			g.fillRect(12,5,65,20);
			g.setColor(Color.WHITE);
			g.drawString("FPS: "+fps,20,20);
		}
	}
	
	// Will only run when told to start
	public void run() {
		
		long lastFrame = System.currentTimeMillis();	// Tracker of our FPS > so we don't blow up the computer
		int frames = 0;									// Start counting FPS
		running = true;									// Game is loaded now
		scene = 0;										// Screen go to scene 0 (main menu)
		
		// As long as the user is playing, keep refreshing the game (FPS)
		while (running){
			
			repaint();
			frames++;	// Update FPS every millisecond
			
			if (System.currentTimeMillis()-1000 >= lastFrame){
				// TODO - If a player is playing and the clock passes midnight FPS will fail since system time will now start over at 0
				// TODO - Add an if statement that will catch this and reset things
				
				fps = frames;
				frames = 0;
				lastFrame = System.currentTimeMillis();
			}
			// Force the refresh to slow down
			try {
				Thread.sleep(10);	// I CHANGED THIS FROM 2 TO 10 SO FPS IS IN A RANGE UNDER 100 LIKE ACTUAL GAMES
									// THIS CHANGE WILL EFFECT THINGS LIKE ENEMY SPEED AND MOVEMENT
			} catch (InterruptedException e) {
				// TODO - This is just an error that is thrown if the sleep failed for some reason. Do we want to do anything with it?
				e.printStackTrace();
			}
		}
		// Player has ended the game
		if (running==false){
			System.exit(0);
		}
	}
	
	public class KeyTyped {
		
		public void keyESC() {
			if (fullScreen==true){
				keyF11();	// If the game is fullscreen treat ESC as fullscreen key
			} else {
				// TODO - Prompt the player to conform exit first
				running = false;
			}
		}

		public void keyF11() {
			if (fullScreen==false){
				fullScreen = true;
				frame.dispose();						// Remove the old frame
				frame.setExtendedState(MAXIMIZED_BOTH); // Go fullscreen
				frame.setUndecorated(true);				// Remove the window border and controls from view
				frame.setVisible(true);					// Recreate the frame with new size
				System.out.println("You are now fullscreen");
			} else {
				fullScreen = false;
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				int height = screenSize.height * 2 / 3;
				int width = screenSize.width * 2 / 3;
				frame.dispose();						// Remove the old frame
				frame.setExtendedState(NORMAL);			// Remove fullscreen
				frame.setUndecorated(false);			// Return window border and controls to view
				frame.setSize(width,height);			// Go 2/3 of the monitors size
				frame.setLocationRelativeTo(null);		// Center frame in monitor
				frame.setVisible(true);					// Recreate the frame with new size
				System.out.println("You are now back to normal: "+width+"W "+height+"H");
			}
		}
		
		public void keyDEL() {
			
		}

		public void keyBACK() {
			
		}

		public void keyENTER() {
			
		}

		public void keySHIFT() {
			
		}

		public void keySPACE() {
			
		}

		public void keyD() {
			if (debug==false){
				System.out.println("Debugger is turned on.");
				debug = true;
			} else {
				System.out.println("Debugger is now off.");
				debug = false;
			}
		}

		public void keyM() {
			
		}

		public void keyP() {
			
		}

		public void key0() {
			
		}

		public void key1() {
			
		}

		public void key2() {
			
		}

		public void key3() {
			
		}

		public void key4() {
			
		}

		public void key5() {
			
		}

		public void key6() {
			
		}

		public void key7() {
			
		}

		public void key8() {
			
		}

		public void key9() {
			
		}

		public void keyPAD0() {
			
		}

		public void keyPAD1() {
			
		}

		public void keyPAD2() {
			
		}

		public void keyPAD3() {
			
		}

		public void keyPAD4() {
			
		}

		public void keyPAD5() {
			
		}

		public void keyPAD6() {
			
		}

		public void keyPAD7() {
			
		}

		public void keyPAD8() {
			
		}

		public void keyPAD9() {
			
		}

	}
}
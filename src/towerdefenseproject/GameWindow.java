 package towerdefenseproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static towerdefenseproject.Screens.updateLayoutPanels;

public class GameWindow extends JFrame {
	
	public static boolean fullScreen = false;
	public static boolean maximized = false;
	public static int windowH;
	public static int windowW;
	public static int scene = 0;
	public static JFrame frame = new JFrame();
	public static Container pane;
	
	public GameWindow() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		windowH = screenSize.height * 2 / 3;
		windowW = screenSize.width * 2 / 3;
        //Create and set up the window
		frame.setTitle( "Tower Defense" );
		frame.setLayout(null);
		frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(windowW,windowH);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(new KeyHandler( this ));
		Screens.updateLayoutPanels();
		frame.setVisible(true);
    }
	
	public static void updateScreenSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		if (fullScreen==true){
			frame.dispose();  
			frame.setExtendedState(MAXIMIZED_BOTH);
			frame.setUndecorated(true);
			windowH = screenSize.height;
			windowW = screenSize.width;
			Screens.updateLayoutPanels();
			frame.setVisible(true);     
		} else if (maximized==true){
			// TODO - Do we want to allow this option? Its fullscreen but with the window border and controls still.
		} else {
			frame.dispose();
			frame.setExtendedState(NORMAL);
			frame.setResizable(false);
			frame.setUndecorated(false);
			windowH = screenSize.height * 2 / 3;
			windowW = screenSize.width * 2 / 3;
			frame.setSize(windowW,windowH);
			frame.setLocationRelativeTo(null);
			Screens.updateLayoutPanels();
			frame.setVisible(true);
		}
	}
	
	public class KeyTyped {

		public void keyESC() {
			if (fullScreen==true){
				keyF11();
			} else {
				// TODO - This instantly closes. Add warning pop up first. Maybe save game option?
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		}

		public void keyF11() {
			if (fullScreen==false){
				fullScreen = true;
				updateScreenSize();
			} else {
				fullScreen = false;
				updateScreenSize();
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
			frame.dispose();
			if (scene==0){
				scene = 10;
			} else {
				scene = 0;
			}
			updateLayoutPanels();
			frame.setVisible(true);
			System.out.println(scene);
		}

		public void keyD() {
			
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
	
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
		Screens.loadImages();
		new GameWindow();
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                gameGUI();
//            }
//        });
    }
}
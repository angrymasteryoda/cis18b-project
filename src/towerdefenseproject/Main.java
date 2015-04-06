/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefenseproject;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.awt.EventQueue.invokeLater;

/**
 * @author michael
 */
public class Main {
	private static int width = 800; //width of splash
	private static int height = 436; //height of splash
	private static long time = 3000L; //time for the splash screen


	/**
	 * centers the splash screen in the center
	 * @param frame window to center
	 * @param width width of window
	 * @param height height of window
	 */
	private static void centreWindow( Window frame, int width, int height ) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ( ( dimension.getWidth() - frame.getWidth() ) / 2 );
		int y = (int) ( ( dimension.getHeight() - frame.getHeight() ) / 2 );
		frame.setBounds( x - ( width / 2 ), y - ( height / 2 ), width, height );
	}

	public static void main( String[] args ) throws Exception {
		JWindow window = new JWindow();
		Image splash = null;
		Image splashResize = null;

		//if we fail to find image just boot app
		try {
			splash = ImageIO.read( new File( "res/tdc-logo-smaller.jpg" ) );
			splashResize = splash.getScaledInstance( width, height, java.awt.Image.SCALE_SMOOTH );

			window.getContentPane().add(
				new JLabel( "", new ImageIcon( splashResize ), SwingConstants.CENTER )
			);
			centreWindow( window, width, height );
			window.setVisible( true );
			try {
				Thread.sleep( time );
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
		} catch ( IOException ex ) {
			Logger.getLogger( Screens.class.getName() ).log( Level.SEVERE, null, ex );
		}


		invokeLater( new Runnable() {
			public void run() {
				MainFrame.getInstance().setVisible( true );
				//new MainFrame().setVisible(true);
			}
		} );
		window.dispose();
	}

}

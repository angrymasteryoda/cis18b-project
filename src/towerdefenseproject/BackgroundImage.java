package towerdefenseproject;

import javax.swing.*;
import java.awt.*;

/**
 * @author Michael
 */
public class BackgroundImage extends JPanel {
	private Image image = null;
	private int imageWidth;
	private int imageHeight;

	public BackgroundImage( Image image ) {
		this.image = image;
		this.imageWidth = image.getWidth( this ) / 2;
		this.imageHeight = image.getHeight( this ) / 2;
	}

	@Override
	public void paintComponent( Graphics g ) {
		super.paintComponent( g );
		if ( image != null ) {
			int x = this.getParent().getWidth() / 2 - imageWidth;
			int y = this.getParent().getHeight() / 2 - imageHeight;
			g.drawImage( image, x, y, this );
		}
	}

	public Image getImage() {
		return image;
	}

	public void setImage( Image image ) {
		this.image = image;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth( int imageWidth ) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight( int imageHeight ) {
		this.imageHeight = imageHeight;
	}
}

/**
 * @author Aarya Vijayaraghavan
 * @author Aiden Cheong
 */
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pellet {
	private BufferedImage pelletimg = null;
	private int xAxis = 0;
	private int yAxis = 0;
	private boolean isEaten = false;

	public Pellet(BufferedImage img, int x, int y) {
		this.pelletimg = img;
		this.xAxis = (x * 20) + 10;
		this.yAxis = (y * 20) + 10;
	}
	/**
	*@return BufferedImage pelletimg
	*/
	public BufferedImage getPelletimg() {
		return pelletimg;
	}
	/**
	*Sets the pellet image as a BufferedImage
	*@param BufferedImage pelletimg
	*/
	public void setPelletimg(BufferedImage pelletimg) {
		this.pelletimg = pelletimg;
	}
	/**
	*@return xAxis
	*/
	public int getxAxis() {
		return xAxis;
	}
	/**
	*Sets the xAxis of the pellet
	*@param int xAxis
	*/
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}
	/**
	*@return yAxis
	*/
	public int getyAxis() {
		return yAxis;
	}
	/**
	*Sets the y-axis of the sprite
	*@param int yAxis
	*/
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	/**
	*@return isEaten
	*/
	public boolean isEaten() {
		return isEaten;
	}
	/**
	*Sets the boolean isEaten to a value
	*@param boolean isEaten
	*/
	public void setEaten(boolean isEaten) {
		this.isEaten = isEaten;
	}
	/**
	*Creates a "hitbox" around the pellet for collision detection
	*@return Rectangle
	*/
	public Rectangle getBounds() {
		return new Rectangle(this.xAxis, this.yAxis, 3, 3);
	}
	/**
	*Checks for a collision with another sprite
	*@return boolean
	*/
	public boolean checkCollision(Sprite b) {
        return this.getBounds().intersects(b.getBounds());
    }
}

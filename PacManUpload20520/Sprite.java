/**
*This is the abstract sprite class for all the objects that get painted on screen
*@author Aarya Vijayaraghavan
*@author Aiden Cheong
*/
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Sprite {
	/**
	*Stores the x-coordinate of the sprite
	*/
	protected volatile int xAxis = 0;
	/**
	*Stores the y-coordinate of the sprite
	*/
	protected volatile int yAxis = 0;
	/**
	*Stores the width of the sprite
	*/
	protected volatile int width = 0;
	/**
	*Stores the height of the sprite
	*/
	protected volatile int height = 0;
	/**
	*Stores the sprite image
	*/
	protected volatile BufferedImage img = null;

	protected static final int moduloValue = 20;
	/**
	*@return width
	*/
	public int getWidth() {
		return width;
	}
	/**
	*Sets the width of the sprite
	*/
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	*@return height
	*/
	public int getHeight() {
		return height;
	}
	/**
	*Sets the height of the sprite
	*/
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	*@return xAxis
	*/
	public int getxAxis() {
		return xAxis;
	}
	/**
	*Sets the x-coordinate of the sprite
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
	*sets the y-coordinate of the sprite
	*/
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	/**
	 * Creates a "hitbox" around the sprite
	 * 
	 * @return Rectangle
	 */
	public abstract Rectangle getBounds();

	/**
	 * Checks if the sprite has collided with another entity
	 * 
	 * @param b
	 * @return
	 */
	public boolean checkCollision(Sprite b) {
		return this.getBounds().intersects(b.getBounds());
	}
}

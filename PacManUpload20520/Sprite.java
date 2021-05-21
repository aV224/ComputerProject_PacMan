import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Sprite {

	protected volatile int xAxis = 0;
	protected volatile int yAxis = 0;
	protected volatile int width = 0;
	protected volatile int height = 0;
	protected volatile BufferedImage img = null;

	protected static final int moduloValue = 20;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getxAxis() {
		return xAxis;
	}

	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}

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

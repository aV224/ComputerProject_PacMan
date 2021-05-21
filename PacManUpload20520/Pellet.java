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

	public BufferedImage getPelletimg() {
		return pelletimg;
	}

	public void setPelletimg(BufferedImage pelletimg) {
		this.pelletimg = pelletimg;
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

	public boolean isEaten() {
		return isEaten;
	}

	public void setEaten(boolean isEaten) {
		this.isEaten = isEaten;
	}

	public Rectangle getBounds() {
		return new Rectangle(this.xAxis, this.yAxis, 3, 3);
	}
	
	public boolean checkCollision(Sprite b) {
        return this.getBounds().intersects(b.getBounds());
    }
}
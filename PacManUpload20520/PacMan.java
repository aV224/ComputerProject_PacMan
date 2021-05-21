
/**
 * @author Aarya Vijayaraghavan
 * @author Aiden Cheong 
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PacMan extends Sprite {
	/**
	* wall stores the PacWall object for the game
	*/
	private PacWall wall = null;
	private int pointImage = 0;
	private int score = 0;

	/**
	 * These arrays contain each frame of pacman in right orientation, left orientation, 
	 * up orientation, and down orientation
	 */
	private BufferedImage[] imageRightArr = new BufferedImage[8];
	private BufferedImage[] imageLeftArr = new BufferedImage[8];
	private BufferedImage[] imageUpArr = new BufferedImage[8];
	private BufferedImage[] imageDownArr = new BufferedImage[8];
	private volatile BufferedImage[] imageCurrentArr = null;
	BufferedImage[] losingImages = new BufferedImage[7];
    private double losingImage = 0;
	/**
	* Constructor for Pac-Man
	* @param PacWall wall
	*/
	public PacMan(PacWall wall) {
		xAxis = 20;
		yAxis = 60;
		width = 10;
		height = 10;
		this.createImages();
		this.wall = wall;
	}

	enum actions {
		KEY_RIGHT, KEY_LEFT, KEY_UP, KEY_DOWN
	}
	/**
	*Stores the current action for Pac-Man
	*/
	private actions currAction;

	/**
	 * This sets the currentarr with the proper orientation of images
	 * @param action
	 */
	public void setNextAction(actions action) {
		if (action != currAction) {
			switch (action) {
			case KEY_RIGHT:
				imageCurrentArr = imageRightArr;
				break;
			case KEY_LEFT:
				imageCurrentArr = imageLeftArr;
				break;
			case KEY_UP:
				imageCurrentArr = imageUpArr;
				break;
			case KEY_DOWN:
				imageCurrentArr = imageDownArr;
				break;
			default:
				break;
			}
			;
		}
		currAction = action;
	}

	/**
	 * Returns the current direction
	 * @return
	 */
	public actions getNextAction() {
		return currAction;
	}
	/**
	*Loads a BufferedImage
	*@param String s
	*@return BufferedImage img
	*/
	public BufferedImage loadImage(String s) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(s));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
		return img;
	}
	/**
	*Creates the images for Pac-Man an adds them to the image arrays
	*/
	private void createImages() {
		for (int i = 0; i < imageRightArr.length; i++) {
			imageRightArr[i] = loadImage("pacman" + (i + 1) + ".png");
		}
		for (int i = 0; i < imageRightArr.length; i++) {
			imageDownArr[i] = this.rotateImage(imageRightArr[i], 90);
		}
		for (int i = 0; i < imageDownArr.length; i++) {
			imageLeftArr[i] = this.rotateImage(imageDownArr[i], 90);
		}
		for (int i = 0; i < imageLeftArr.length; i++) {
			imageUpArr[i] = this.rotateImage(imageLeftArr[i], 90);
		}
		/* Initializing the current image array with right moving images. */
		imageCurrentArr = imageRightArr;
		this.currAction = actions.KEY_RIGHT;
	}
	/**
	*Rotates the buffered image
	*@param BufferedImage imgin
	*@param double angle
	*/
	private BufferedImage rotateImage(BufferedImage imgin, double angle) {
		BufferedImage img = copyImage(imgin);
		final double rads = Math.toRadians(90);
		final double sin = Math.abs(Math.sin(rads));
		final double cos = Math.abs(Math.cos(rads));
		final int w = (int) Math.floor(img.getWidth() * cos + img.getHeight() * sin);
		final int h = (int) Math.floor(img.getHeight() * cos + img.getWidth() * sin);
		final BufferedImage rotatedImage = new BufferedImage(w, h, img.getType());
		final AffineTransform aft = new AffineTransform();
		aft.translate(w / 2, h / 2);
		aft.rotate(rads, 0, 0);
		aft.translate(-img.getWidth() / 2, -img.getHeight() / 2);
		final AffineTransformOp rotateOp = new AffineTransformOp(aft, AffineTransformOp.TYPE_BILINEAR);
		rotateOp.filter(img, rotatedImage);

		return rotatedImage;
	}
	/**
	*creates a copy of a BufferedImage
	*@param BufferedImage image
	*@return BufferedImage newimg
	*/
	private static final BufferedImage copyImage(BufferedImage image) {
		BufferedImage newimg = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		Graphics2D g2d = newimg.createGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();

		return newimg;
	}
	/**
	*@return score
	*/
	public int getScore() {
		return score;
	}
	/**
	*sets the score
	*@param int score
	*/
	public void setScore(int score) {
		this.score = score;
	}
	/**
	*paint method for Pac-Man. Displays it on to the panel
	*/
	public void paintPacMan(Graphics2D g2d) {
		g2d.drawImage(imageCurrentArr[pointImage], xAxis + 5, yAxis + 5, width, height, null);
		pointImage = ((pointImage + 1) >= imageCurrentArr.length) ? 0 : ++pointImage;
	}
	/**
	*Moves pacman right
	*/
	public void moveRight() {
		int tmpvar = 0;
		int relvar = 0;

		tmpvar = xAxis + 1;
		relvar = ((tmpvar % moduloValue) == 0) ? 0 : (moduloValue - (tmpvar % moduloValue));
		if (wall.isClear((tmpvar + relvar), yAxis) && ((yAxis % moduloValue) == 0)) {
			xAxis += 1;
			this.setNextAction(PacMan.actions.KEY_RIGHT);
		}
	}

	/**
	 * This moves PacMan left
	 */
	public void moveLeft() {
		int tmpvar = 0;

		if ((xAxis % moduloValue) == 0) {
			tmpvar = xAxis - 1;
		} else {
			tmpvar = xAxis - 1;
			tmpvar = tmpvar + (moduloValue - (tmpvar % moduloValue));
		}

		if (wall.isClear(tmpvar, yAxis) && ((yAxis % moduloValue) == 0)) {
			xAxis -= 1;
			this.setNextAction(PacMan.actions.KEY_LEFT);
		}
	}
	
	/**
	 * This moves PacMan up
	 */
	public void moveUp() {
		int tmpvar = 0;

		if ((yAxis % moduloValue) == 0) {
			tmpvar = yAxis - 1;
		} else {
			tmpvar = yAxis - 1;
			tmpvar = tmpvar + (moduloValue - (tmpvar % moduloValue));
		}
		if (wall.isClear(xAxis, tmpvar) && ((xAxis % moduloValue) == 0)) {
			yAxis -= 1;
			this.setNextAction(PacMan.actions.KEY_UP);
		}
	}
	
	/**
	 * This moves PacMan down
	 */
	public void moveDown() {
		int tmpvar = 0;
		int relvar = 0;

		tmpvar = yAxis + 1;
		relvar = ((tmpvar % moduloValue) == 0) ? 0 : (moduloValue - (tmpvar % moduloValue));
		if (wall.isClear(xAxis, (tmpvar + relvar)) && ((xAxis % moduloValue) == 0)) {
			yAxis += 1;
			this.setNextAction(PacMan.actions.KEY_DOWN);
		}
	}
	/**
	*Creates a "hitbox" around Pac-Man
	*/
	@Override
	public Rectangle getBounds() {
		return new Rectangle(xAxis, yAxis, 20, 20);
	}
}

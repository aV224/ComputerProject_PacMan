
/**
 * Blinky is your main enemy... This class extends Sprite and uses class PacMan to acquire 
 * the current location of PacMan and class Wall to maneuver around the maze
 * 
 * @author author: Aarya Vijayaraghavan
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Blinky extends Sprite {
	
	/**
	 * These fields will be initialed in the constructor. They provide
	 * Blinky with information
	 */
	private PacMan pacMan = null;
	private PacWall wall = null;

	enum directions {
		RIGHT, LEFT, UP, DOWN
	}

	private directions currDirection = directions.UP;

	/**
	 * Constructor for Blinky
	 * @param pacman
	 * @param wall
	 */
	public Blinky(PacMan pacman, PacWall wall) {
		try {
			img = ImageIO.read(new File("Blinky.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		xAxis = 260;
		yAxis = 340;
		width = 20;
		height = 20;
		this.pacMan = pacman;
		this.wall = wall;
	}

	/**
	 * With the Graphics2D object, it will paint Blinky at its location with size 20 by 20 (width and height)
	 * @param g2d
	 */
	public void paintGhost(Graphics2D g2d) {
		g2d.drawImage(img, xAxis, yAxis, width, height, null);
	}
	
	/**
	 * This method controls the behavior of Blinky. Blinky is the agressive ghost, heading straight for
	 * your current location. It will keep going forward until it hits a wall; from there, it will 
	 * figure whether turning left or right is the quickest way to get to PacMan. If only one side is
	 * clear, it will go that side. It returns true if Blinky hit PacMan.
	 * @return
	 */
	public boolean makeNextMove() {
		int targetx = pacMan.getxAxis();
		int targety = pacMan.getyAxis();
		directions dir = this.currDirection;
		int tmpvar = 0;
		int relvar = 0;

		int relxless = ((xAxis % moduloValue) == 0) ? (xAxis - 1)
				: ((xAxis - 1) + (moduloValue - (tmpvar % moduloValue)));
		int relxmore = (((xAxis + 1) % moduloValue) == 0) ? 0 : (moduloValue - ((xAxis + 1) % moduloValue));
		int relyless = ((yAxis % moduloValue) == 0) ? (yAxis - 1)
				: ((yAxis - 1) + (moduloValue - (tmpvar % moduloValue)));
		int relymore = relvar = (((yAxis + 1) % moduloValue) == 0) ? 0 : (moduloValue - ((yAxis + 1) % moduloValue));

		boolean xless = wall.isClear(relxless, yAxis);
		boolean xmore = wall.isClear(((xAxis + 1) + relxmore), yAxis);
		boolean yless = wall.isClear(xAxis, relyless);
		boolean ymore = wall.isClear(xAxis, ((yAxis + 1) + relymore));

		if (dir == directions.RIGHT) {
			tmpvar = xAxis + 1;
			relvar = ((tmpvar % moduloValue) == 0) ? 0 : (moduloValue - (tmpvar % moduloValue));
			if (wall.isClear((tmpvar + relvar), yAxis)) {
				xAxis += 1;
			} else if (yless && ymore) {
				if (targety > yAxis) {
					currDirection = directions.DOWN;
				} else if (targety < yAxis) {
					currDirection = directions.UP;
				}
			} else if (!(yless) && ymore) {
				currDirection = directions.DOWN;
			} else if (yless && !(ymore)) {
				currDirection = directions.UP;
			}
		} else if (dir == directions.LEFT) {
			if ((xAxis % moduloValue) == 0) {
				tmpvar = xAxis - 1;
			} else {
				tmpvar = xAxis - 1;
				tmpvar = tmpvar + (moduloValue - (tmpvar % moduloValue));
			}
			if (wall.isClear(tmpvar, yAxis)) {
				xAxis -= 1;
			} else if (yless && ymore) {
				if (targety > yAxis) {
					currDirection = directions.DOWN;
				} else if (targety < yAxis) {
					currDirection = directions.UP;
				}
			} else if (!(yless) && ymore) {
				currDirection = directions.DOWN;
			} else if (yless && !(ymore)) {
				currDirection = directions.UP;
			}
		} else if (dir == directions.UP) {
			if ((yAxis % moduloValue) == 0) {
				tmpvar = yAxis - 1;
			} else {
				tmpvar = yAxis - 1;
				tmpvar = tmpvar + (moduloValue - (tmpvar % moduloValue));
			}
			if (wall.isClear(xAxis, tmpvar)) {
				yAxis -= 1;
			} else if (xless && xmore) {
				if (targetx > xAxis) {
					currDirection = directions.RIGHT;
				} else if (targetx < xAxis) {
					currDirection = directions.LEFT;
				}
			} else if (!(xless) && xmore) {
				currDirection = directions.RIGHT;
			} else if (xless && !(xmore)) {
				currDirection = directions.LEFT;
			}
		} else if (dir == directions.DOWN) {
			tmpvar = yAxis + 1;
			relvar = ((tmpvar % moduloValue) == 0) ? 0 : (moduloValue - (tmpvar % moduloValue));
			if (wall.isClear(xAxis, (tmpvar + relvar))) {
				yAxis += 1;
			} else if (xless && xmore) {
				if (targetx > xAxis) {
					currDirection = directions.RIGHT;
				} else if (targetx < xAxis) {
					currDirection = directions.LEFT;
				}
			} else if (!(xless) && xmore) {
				currDirection = directions.RIGHT;
			} else if (xless && !(xmore)) {
				currDirection = directions.LEFT;
			}
		}
		return (checkCollision(pacMan));
	}
	
	/**
	 * This method will return a rectangle that is constructed around the Sprite. 
	 * It will be used for collision detection
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle(xAxis, yAxis, 20, 20);
	}
}
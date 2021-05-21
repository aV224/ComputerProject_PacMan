/**
 * PacWall is the class with all information relating to the maze. It contains the game matrix and methods to draw it 
 * and see if the wall is clear. 
 * 
 * @author Aarya Vijayaraghavan
 */

import java.awt.Color;
import java.awt.Graphics2D;

public class PacWall {
	
	/**
	 * This two-dimensional array contains the all information pertaining to the maze. A 3 means black area
	 * without pellets. A 0 means black area with pellets. A 1 means blue wall. 
	 */
	private int[][] gamematrix = { 
			
			{ 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
			{ 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 3, 1, 1, 3, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
			{ 3, 3, 3, 3, 3, 1, 0, 1, 1, 1, 1, 1, 3, 1, 1, 3, 1, 1, 1, 1, 1, 0, 1, 3, 3, 3, 3, 3 },
			{ 3, 3, 3, 3, 3, 1, 0, 1, 1, 1, 1, 1, 3, 1, 1, 3, 1, 1, 1, 1, 1, 0, 1, 3, 3, 3, 3, 3 },
			{ 3, 3, 3, 3, 3, 1, 0, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 0, 1, 3, 3, 3, 3, 3 },
			{ 3, 3, 3, 3, 3, 1, 0, 1, 1, 3, 1, 1, 1, 3, 3, 1, 1, 1, 3, 1, 1, 0, 1, 3, 3, 3, 3, 3 },
			{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
			{ 1, 3, 3, 3, 3, 3, 0, 3, 3, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 3, 3, 0, 3, 3, 3, 3, 3, 1 },
			{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 3, 1, 3, 3, 3, 3, 3, 3, 1, 3, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
			{ 3, 3, 3, 3, 3, 1, 0, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 0, 1, 3, 3, 3, 3, 3 },
			{ 3, 3, 3, 3, 3, 1, 0, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 0, 1, 3, 3, 3, 3, 3 },
			{ 3, 3, 3, 3, 3, 1, 0, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 0, 1, 3, 3, 3, 3, 3 },
			{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1 },
			{ 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
			{ 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
			
			};

	/**
	 * It returns the gamematrix
	 */
	public int[][] getGameMatrix() {
		return gamematrix;
	}
	
	/**
	 * This method parses through gamematrix, and then draws walls in areas that need them.
	 * @param panelwidth
	 * @param panelheight
	 * @param g2d
	 */
	public void drawWall(int panelwidth, int panelheight, Graphics2D g2d) {
		g2d.setColor(Color.BLUE);
		for (int i = 0; i < gamematrix.length; i++) {
			for (int j = 0; j < gamematrix[i].length; j++) {
				if (gamematrix[i][j] == 1) {
					int recw = panelwidth / gamematrix[i].length; /* This is how wide each block should be.. 100/5 means
																	 each rec is 20 long */
					int rech = panelheight / gamematrix.length;
					g2d.fillRect(j * recw, i * rech, recw, rech);
				}
			}
		}
	}
	
	/**
	 * This method first converts pixel coordinates into coordinates the matrix can recognize. After that, 
	 * it finds whether that area is free to move on or not
	 * @param x1
	 * @param y1
	 * @return
	 */
	public boolean isClear(int x1, int y1) {
		x1 = x1 / 20;
		y1 = y1 / 20;
		
		if (gamematrix[y1][x1] == 0) {
			return true;
		} else if (gamematrix[y1][x1] == 3) {
			return true;
		} else {
			return false;
		} 
	}
}

/**
* Clyde is one of the four ghosts extending Ghost
* @author Aarya Vijayaraghavan
*
*/

import java.awt.image.BufferedImage;
import java.awt.*;

	public class Clyde extends Ghost {
		
		/**
		 * Constructor for Clyde
		 * @param startx
		 * @param starty
		 * @param speed
		 * @param direction
		 */
		public Clyde(int startx, int starty, int speed, int direction) {
			super(startx, starty, speed, direction);
		}

		/**
		 * Clyde is a little timid.
		 * He will chase PacMan but when he gets too close, he will run away. 
		 */
		@Override
		public void chase() {
			// TODO Auto-generated method stub
			
		}
		
		/**
		 * All Ghosts will retreat to their respective corner of the map
		 * to give the player a short break
		 */
		@Override
		public void scatter() {
			// TODO Auto-generated method stub
			
		}
	
	
	
	}

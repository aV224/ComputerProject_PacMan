/**
* Inky is one of the four ghosts extending Ghost
* @author Aarya Vijayaraghavan
*
*/

import java.awt.image.BufferedImage;
import java.awt.*;

	public class Inky extends Ghost {
		
		/**
		 * Constructor for Inky
		 * @param startx
		 * @param starty
		 * @param speed
		 * @param direction
		 */
		public Inky(int startx, int starty, int speed, int direction) {
			super(startx, starty, speed, direction);
		}

		/**
		 * chase is unique to each Ghost. All Ghosts will get PacMans location and attack him. 
		 * However, each Ghost will do it in a different way. 
		 * Inky will be patrolling his own zone and will chase PacMan while he's in his zone
		 */
		@Override
		public void chase() {
			// TODO Auto-generated method stub
			
		}
		
		/**
		 * Scatter is unique to each Ghost. All Ghosts will retreat to their respective corner of the map
		 * to give the player a short break
		 */
		@Override
		public void scatter() {
			// TODO Auto-generated method stub
			
		}
	
	
	
	}

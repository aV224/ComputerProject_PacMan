/**
* Ghost is the abstract base class for all ghosts
* 
* @author Aarya Vijayaraghavan
*
*/
	
import java.awt.image.BufferedImage;
import java.awt.*;
	
		public abstract class Ghost extends Sprite {
			
			/**
			 * Is the ghost in chasing mode?
			 */
			protected boolean isChasing;
			/**
			 * Is the ghost in scatter mode?
			 */
			protected boolean isScattered;
			/**
			 * Is the ghost in scared mode(PacMan has eaten a power pellet and is coming to eat the Ghost)?
			 */
			protected boolean isScared;
			/**
			 * Is the ghost in eaten mode?
			 */
			protected boolean isEaten;
			/**
			 * Is the ghost in the cage?
			 */
			protected boolean isCaged;
			/**
			 * PacMan object
			 */
			//protected PacMan pacman; 
			
			/**
		     * Constructor for Ghost
		     * 
		     */
			public Ghost(int startx, int starty, int speed, int direction) {
				super(startx, starty, speed, direction);
			}
			
			/**
			 * gets isChasing
			 * @return
			 */
			public boolean isChasing() {
				return isChasing;
			}
			
			/**
			 * sets isChasing
			 * @param isChasing
			 */
			public void setChasing(boolean isChasing) {
				this.isChasing = isChasing;
			}
			
			/**
			 * gets isScattered
			 * @return
			 */
			public boolean isScattered() {
				return isScattered;
			}
			
			/**
			 * sets isScattered
			 * @param isScattered
			 */
			public void setScattered(boolean isScattered) {
				this.isScattered = isScattered;
			}
			
			/**
			 * gets isScared
			 * @return
			 */
			public boolean isScared() {
				return isScared;
			}
			
			/**
			 * sets isScared
			 * @param isScared
			 */
			public void setScared(boolean isScared) {
				this.isScared = isScared;
			}
			
			/**
			 * gets isEaten
			 * @return
			 */
			public boolean isEaten() {
				return isEaten;
			}
			
			/**
			 * sets isEaten
			 * @param isEaten
			 */
			public void setEaten(boolean isEaten) {
				this.isEaten = isEaten;
			}
			
			/**
			 * gets isCaged
			 * @return
			 */
			public boolean isCaged() {
				return isCaged;
			}

			/**
			 * sets isCaged
			 * @param isCaged
			 */
			public void setCaged(boolean isCaged) {
				this.isCaged = isCaged;
			}
			
			/**
			 * This method will be defined by the Ghost subclasses. The subclass Ghost will have its own unique way
			 * of chasing PacMan. 
			 */
			public abstract void chase();
			
			/**
			 * This method will be defined by the Ghost subclasses. The subclass Ghost will have it's own corner to scatter to
			 */
			public abstract void scatter();
			
			/**
			 * After getting eaten, Ghosts will turn into eyeballs and scurry back to the cage
			 */
			public void eaten() {
				;
			}
			
			/**
			 * After ghost is eaten, ghost will respawn in cage to rejoin the hunt
			 */
			public void respawninCage() {
				;
			}
			
			/**
			 * After PacMan eats a power pellet, ghost will randomly move while trying to run away
			 */
			public void scared() {
				;
			}
			
			
		}

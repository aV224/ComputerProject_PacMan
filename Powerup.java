/**
* This is the powerup class. When eaten, this will turn the ghosts into a frightened state
*@author Aiden Cheong
*/
import java.awt.image.BufferedImage;
public class Powerup extends Sprite{
    protected int eaten = 0;

    public Powerup(int x, int y, BufferedImage img) {
        super(x, y, img);
    }
    /**
    *If the powerup is eaten, 1 is added to eaten
    *@return eaten
    */
    public int isEaten(Sprite b) {
        if (this.checkCollision(b)) {
            eaten += 1;
        }
        return eaten;
    }
}

/**
*This is the pellet class (also known as the fruit class)
*@author Aiden Cheong
*/
import java.awt.image.BufferedImage;
public class Pellet extends Sprite{
    protected int eaten = 0;

    public Pellet(int x, int y, BufferedImage img) {
        super(x, y, img);
    }
    /**
    *If the pellet is eaten, 1 is added to eaten
    *@return eaten
    */
    public int isEaten(Sprite b) {
        if (this.checkCollision(b)) {
            eaten += 1;
        }
        return eaten;
    }
}

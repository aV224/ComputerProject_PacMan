
import java.awt.image.BufferedImage;
public class Powerup extends Sprite{
    protected int eaten = 0;

    public Powerup(int x, int y, BufferedImage img) {
        super(x, y, img);
    }

    public int isEaten(Sprite b) {
        if (this.checkCollision(b)) {
            eaten += 1;
        }
        return eaten;
    }
}

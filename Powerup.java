
import java.awt.image.BufferedImage;
public class Powerup extends Sprite{
    private boolean eaten;

    public Powerup(int x, int y, BufferedImage img) {
        super(x, y, img);
    }

    public boolean isEaten(Sprite b) {
        eaten = this.checkCollision(b);
        return eaten;
    }
}

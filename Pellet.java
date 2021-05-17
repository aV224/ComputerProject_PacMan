
import java.awt.image.BufferedImage;
public class Pellet extends Sprite{
    private int eaten;

    public Pellet(int x, int y, BufferedImage img) {
        super(x, y, img);
    }

    public boolean isEaten(Sprite b) {
        eaten = 0;
        if (this.checkCollision(b)) {
            eaten = 1;
        }
        return eaten;
    }
}

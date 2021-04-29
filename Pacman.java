import java.awt.image.BufferedImage;
public class Pacman extends Sprite {
    /**
     * startX holds the starting x coordinate
     */
    private final int startX = 0;
    /**
     * startY holds the starting y coordinate
     */
    private final int startY = 0;
    /**
     * lives stores the number of lives Pacman has
     */
    private int lives = 3;
    /**
     * constructor for pacman. (extends Sprite)
     */
    public Pacman(int a, int b, int d, int w, int h, BufferedImage i) {
        super(a, b, d, w, h, i);
    }
    /**
     * Queues turn for pacman. When the side is clear, it will turn
     */
    public void queueTurn() {
        //queues turn
    }
    /**
     * Moves pacman back to starting point
     */
    public void restart() {
        //moves pacman back to starting point
    }
    /**
     * Called when Pacman collides with a ghost. Subtracts a life from Pacman and does the wilting animation
     */
    public void lose() {
        lives -= 1;
        //lose animation
    }
}
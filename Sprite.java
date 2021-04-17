import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
public abstract class Sprite {
    BufferedImage image;
    double x;
    double y;
    int direction;
    protected Sprite(double a, double b, int d, BufferedImage i, JPanel p) { //This constructor will draw an image on to the inputted JPanel. a is the x coordinate, b is the y coordinate.
        x = a;
        y = b;
        direction = d;
        image = i;
        Graphics g = p.getGraphics();
        g.drawImage(this.image, (int)x, (int)y, p);
    }
}

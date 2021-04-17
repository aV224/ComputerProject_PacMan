import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
public abstract class Sprite {
    BufferedImage image;
    double x;
    double y;
    int direction;
    protected Sprite(double a, double b, int d, BufferedImage i, JPanel p) {
        x = a;
        y = b;
        direction = d;
        image = i;
        Graphics g = p.getGraphics();
        g.drawImage(this.image, (int)x, (int)y, p);
    }
}

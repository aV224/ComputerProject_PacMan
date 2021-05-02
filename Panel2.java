import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
public class Panel2 extends JPanel implements ActionListener, KeyListener {
    BufferedImage i = loadImage("OpenPacman.png");
    Pacman p = new Pacman(0, 0, i);
    private int xv = 0;
    private int yv = 0;
    Timer t = new Timer(5, this);
    public Panel2() {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        p.display(g);
    }
    public void actionPerformed(ActionEvent e) {
        repaint();
        p.setX(p.getX() + xv);
        p.setY(p.getY() + yv);
    }
    public BufferedImage loadImage(String s) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(s));
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return img;
    }
    public void keyTyped(KeyEvent e) {
        return;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            xv = 1;
            yv = 0;
        }
        if (key == KeyEvent.VK_LEFT) {
            xv = -1;
            yv = 0;
        }
        if (key == KeyEvent.VK_UP) {
            xv = 0;
            yv = -1;
        }
        if (key == KeyEvent.VK_DOWN) {
            xv = 0;
            yv = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        return;
    }
}


/**
* Sprite is the abstract base class for all sprite contexts
* Is an image that can be moved around
* @author Aarya Vijayaraghavan
* @author Aiden Cheong
*/

import java.awt.image.BufferedImage;
import java.awt.*;
public abstract class Sprite {
    /** 
     * image is the image that the sprite will load
     */
    BufferedImage image;
    /** 
     * xPos stores the x coordinate of the sprite
     */
    protected int xPos;
    /**
     * yPos stores the y coordinate of the sprite
     */
    protected int yPos;
    /**
    * speed stores the speed of the sprite
    */
    protected int speed;
    /**
     * WIDTH stores the width of the sprite
     */
    private final int WIDTH;
    /**
     * HEIGHT stores the height of the sprite
     */
    private final int HEIGHT;
    /**
     * direction stores either 0, 90, 180, or 270 which determines which direction the sprite is facing
     */
    protected int direction;
    /**
     * Constructor for the sprite
     * @param int a
     * @param int b
     * @param int d
     * @param int w
     * @ param int h
     * @param BufferedImage i 
     */
    public Sprite(int a, int b, int d, int w, int h, BufferedImage i) {
        xPos = a;
        yPos = b;
        direction = d;
        WIDTH = w;
        HEIGHT = h;
        image = i;
    }
    /**
     * sets the x coordinate
     * @param xPos
     */
    public void setX(int xPos){ 
        this.xPos = xPos;
    }
    /**
     * gets the x coordinate
     * @return 
     */
    public int getX(){
        return xPos;
    }
    /**
     * sets the y coordinate
     * @param yPos
     */
    public void setY(int yPos){
        this.yPos = yPos;
    }
    /**
     * gets the y coordinate
     * @return
     */
    public int getY(){
        return yPos;
    }
    /**
     * gets speed
     * @return
     */
    public int getSpeed() {
    	return speed;
    }
    /**
     * sets speed
     * @param speed
     */
    public void setSpeed(int speed) {
    	this.speed = speed;
    }
    /**
     * gets the width
     * @return
     */
    public int getWidth(){
        return WIDTH;
    } 
    /**
     * gets the height
     * @return
     */
    public int getHeight(){
        return HEIGHT;
    }
    /**
     * displays the sprite. You have to call it in the paintComponent() method in the panel.
     * @param g
     */
    public void display(Graphics g) {
        g.drawImage(this.image, xPos, yPos, null);
    }
    /**
     * Creates a "hitbox" around the sprite
     * @return Rectangle
    */
    public Rectangle getBounds() {
        return new Rectangle(this.xPos, this.yPos, this.WIDTH, this.HEIGHT);
    }
}

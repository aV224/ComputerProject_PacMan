/**
* Sprite is the abstract base class for all sprite contexts
* Is an image that can be moved around
* @author Aiden Cheong
*/

import java.awt.image.BufferedImage;
import java.awt.*;
public class Sprite {
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
    protected final int speed = 6;
    /**
     * width stores the width of the sprite imagea
     */
    private int width;
    /**
     * height stores the height of the sprite image
     */
    private int height;
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
    public Sprite(int x, int y, int w, int h, BufferedImage i) {
        xPos = x;
        yPos = y;
        width = w;
        height = h;
        image = i;
    }
    /**
     * sets the x coordinate
     * @param x
     */
    public void setX(int x){ 
        this.xPos = x;
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
     * @param y
     */
    public void setY(int y){
        this.yPos = y;
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
     * gets the width
     * @return
     */
    public int getWidth(){
        return width;
    } 
    /**
     * gets the height
     * @return
     */
    public int getHeight(){
        return height;
    }
    /**
     * Moves the sprite up
    */
    public void moveUp() {
        yPos -= 1;
    }
    /**
     * Moves the sprite down
    */
    public void moveDown() {
        yPos += 1;
    }
    /**
     * Moves the sprite right
    */
    public void moveRight() {
        xPos += 1;
    }
    /**
     * Moves the sprite left
    */
    public void moveLeft() {
        xPos -= 1;
    }
    /**
     * Rotates the sprite image
    */
    public void turn(int d) {
        direction = d;
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
        return new Rectangle(this.xPos, this.yPos, this.width, this.height);
    }
}

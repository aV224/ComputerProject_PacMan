
/**
* Sprite is the abstract base class for all sprite contexts
* Is an image that can be moved around
* @author Aarya Vijayaraghavan
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
     * WIDTH stores the width of the sprite
     */
    private final int WIDTH = 22;
    /**
     * HEIGHT stores the height of the sprite
     */
    private final int HEIGHT = 22;
    /**
     * direction stores either 0, 90, 180, or 270 which determines which direction the sprite is facing
     */
    protected int direction;
    /**
     * Constructor for the sprite
     * After the correct starting positions are found we shall initialize xPos and yPos with them
     */
    public Sprite() {
        ;
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
     * Moves the sprite up
    */
    public void moveUp() {
        turnLeft();
    }
    /**
     * Moves the sprite down
    */
    public void moveDown() {
        turnLeft();
    }
    /**
     * Moves the sprite right
    */
    public void moveRight() {
        turnRight();
    }
    /**
     * Moves the sprite left
    */
    public void moveLeft() {
        turnLeft();
    }
    /**
     * Turns left
    */
    public void turnLeft() {
        ;
    }
    /**
     * Turns right
    */
    public void turnRight() {
    	;
    }
    /**
     * Moves the sprite 1 unit left
    */
    public void turnAround() {
        turnLeft();
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

/**
* Sprite is the parent class for all sprite contexts
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
    BufferedImage imageRight;
    BufferedImage imageLeft;
    BufferedImage imageUp;
    BufferedImage imageDown;
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
     * @param BufferedImage i
     */
    public Sprite(int x, int y, BufferedImage i) {
        xPos = x;
        yPos = y;
        width = i.getWidth();
        height = i.getHeight();
        image = i;
        imageRight = image;
        imageDown = rotateImage(imageRight, 90);
        imageLeft = rotateImage(imageDown, 90);
        imageUp = rotateImage(imageLeft, 90);
        
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
    public BufferedImage rotateImage(BufferedImage img, double angle) {

        final double rads = Math.toRadians(90);
        final double sin = Math.abs(Math.sin(rads));
        final double cos = Math.abs(Math.cos(rads));
        final int w = (int) Math.floor(img.getWidth() * cos + img.getHeight() * sin);
        final int h = (int) Math.floor(img.getHeight() * cos + img.getWidth() * sin);
        final BufferedImage rotatedImage = new BufferedImage(w, h, img.getType());
        final AffineTransform at = new AffineTransform();
        at.translate(w / 2, h / 2);
        at.rotate(rads,0, 0);
        at.translate(-img.getWidth() / 2, -img.getHeight() / 2);
        final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        rotateOp.filter(img,rotatedImage);

        return rotatedImage;
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

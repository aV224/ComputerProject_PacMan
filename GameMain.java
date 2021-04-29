   /**
   * GameMain manipulates data and controls all panels, including those of the menus and the game
   * @author Max Wang
   */
   
   /* 
   * Imports
   * Swing GUI
   * Border Classes for Swing
   * Abstract Window Toolkit
   * Event
   * KeyEvent
   * BufferedImage
   * Point
   * File
   */
   
   import javax.swing.*;
   import javax.swing.border.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.event.KeyEvent;
   import java.awt.image.BufferedImage;
   import java.awt.Point.*;
   import java.io.File;
   
   
   public class GameMain
   {
      // main JPanel on which everything will be drawn, needs to be accessible to all methods
      // GameMain does not extend JPanel, since .remove() can not be used within GameMain if that were true
      private JPanel mainPanel;
      
      // Constants used in this class.
      private static final int MAIN_MENU = 0;
      private static final int GAME_SCREEN = 1;
      private static final int TOP_SCORES = 2;
      private static final int WIN_CARD = -1;
      private static final int LOSE_CARD = -2; 
      private static final int NOT_IN_GAME = 0;
      
      // An array consisting of the coordinate locations of all wall tiles. 
      private Point[] wallArray;
      
      // An array consisting of the coordinate locations of all dots.
      private Point[] dotArray;
      
      // An array consisting of the states of all dots; 1 is uneaten, 0 is uneaten.
      private boolean[] dotIsEaten;
      
      // An array consisting of the coordinate locations of all powerups.
      private Point[] bigDotArray;
      
      // An array consisting of the states of all powerups; 1 is uneaten, 0 is uneaten.
      private int[] bigDotIsEaten;
      
      // Poin containing location of the bonus item.
      private Point bonusLoc;
      
      // The variable which stores the state of the bonus item; 1 for uneaten and showing, 0 for uneaten and not showing, and -1 for eaten.
      private int bonusItem = 0;
      
      // The variable which remembers the level the game is on; positive values are used for levels, zero is used while not in game.
      private int currentLevel = 0;
      
      // Final image drawn to screen every frame.
      private BufferedImage mainImage;
      
      // A BufferedImage containing all tiles combined into one image file.
      private BufferedImage graphicsData;
      
      // A BufferedImage used to store image data for singular tiles used in the final display.
      private BufferedImage tile;
      
      // Graphics object for mainImage.
      private Graphics graphics;
      
      /**
      * Instantiates and customizes mainPanel, and begins the program at the main menu.
      */
      
      public void main(String[] args) 
      {
         setup();
      } 
      
      /**
      * Adds object to container when .add is not possible.
      */
      
      public void addToContainer(Container container)
      {
         // adds object
      }
      
      /**
      * Checks for whether two objects have coinciding locations.
      */
      
      private boolean checkCollision(Sprite a, Sprite b) 
      {
        return false;
      }
      
      /**
      * Renders display during the short time before, between, or after a game level.
      */
      
      public void displayTransition()
      {
         // sends to new game or main manu depending on type of transition
      }
      
      /**
      * Updates sprite locations and redraws game board.
      */
      
      public void gameUpdate()
      {
         // update all sprites and draws board
      }
      
      /**
      * Renders hall of fame.
      */
      
      public void hallOfFame()
      {
         String[] topPlayers = retrieveNames();
         int[] topScores = retrieveStats();
         // create a "return to main menu" button and "reset game" button, with main() and reset()
      }
      
      /**
      * Renders main menu.
      */
      
      public void menu()
      {
         // main menu has 3 buttons
         // button 1 is "Play Game", calls runGame()
         // button 2 is "Highscores", calls hallOfFame()
         // button 3 is "Exit Game", ends program
      }
      
      /**
      * Resets all game data and restarts game.
      */
     
      public void reset()
      {
         setup();
      }
      
      /**
      * Parses text file for powerup data.
      */
      
      public Point[] retrieveBigDot()
      {
         Point[] temp = {new Point(), new Point()};
         return temp;
      }
      
      /**
      * Parses text file for bonus item data.
      */
      
      public Point retrieveBonus()
      {
         Point temp = new Point();
         return temp;
      }
      
      /**
      * Parses text file for dot data.
      */
      
      public Point[] retrieveDot()
      {
         Point[] temp = {new Point(), new Point()};
         return temp;
      }
      
      /**
      * Parses text file for maze data.
      */
      
      public Point[] retrieveMaze()
      {
         Point[] temp = {new Point(), new Point()};
         return temp;
      }
      
      /**
      * Parses text file for highscore name data.
      */
       
      public String[] retrieveNames()
      {
         String[] temp = {"ABBY_", "BOB__", "CASSI"};
         return temp;
      }
      
      /**
      * Parses text file for highscores.
      */
      
      public int[] retrieveStats()
      {
         int[] temp = {1, 2, 3};
         return temp;
      }
      
      /**
      * Runs a stage of the game by iterating frames until a game-ending condition is reached.
      */
      
      public void runGame(int level)
      {
         // loops gameUpdate() until condition met
         gameUpdate();
         displayTransition();
      }
      
      /**
      * Sets up certain variables before game can start.
      */
      
      public void setup()
      {
         wallArray = retrieveMaze();
         dotArray = retrieveDot();
         bigDotArray = retrieveBigDot();
         
         // set dotIsEaten and bigDotIsEaten to arrays of equal size to dotArray and bigDotArray and both filled with zeros
         
         bonusLoc = retrieveBonus();
         menu();
      }
      
      /**
      * Creates a KeyListener which will take keyboard input from the player
      */
      private class PlayerKeyListener implements KeyListener {
         public void keyPressed(KeyEvent e) {
             // stuff
         }
         public void keyReleased(KeyEvent e) {
             // more stuff
         }
         public void keyTyped(KeyEvent e) {
             // more stuff
         }
      }

   }

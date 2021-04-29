   /**
   * GameMain manipulates data and controls all panels, including those of the menus and the game
   * @author Max Wang
   */
   
   /* 
   * Imports
   * Swing GUI
   * Border Classes for Swing
   * Abstract Window Toolkit
   * BufferedImage
   * File Class
   */
   
   import javax.swing.*;
   import javax.swing.border.*;
   import java.awt.*;
   import java.awt.image.BufferedImage;
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
      
      // The variable which remembers the level the game is on; positive values are used for levels, zero is used while not in game.
      private int currentLevel = 0;
      
      public static void main(String[] args) 
      {
         /**
         * Instantiates and customizes mainPanel, and begins the program at the main menu.
         */
         changeScreen(MAIN_MENU);
      } 
      
      public static void addToContainer(Container container)
      {
         /**
         * Adds object to container when .add is not possible.
         */
      }
      
      public static void displayTransition();
      {
         /**
         * 
         */
      }
      
      public static void drawBoard()
      {
         /**
         * Draws all necessary objects onto the screen.
         */
      }
      
      public static void gameUpdate()
      {
         /**
         * Updates sprite locations and redraws game board.
         */
      }
      
      public static void menu()
      {
         /**
         * 
         */
      }
      
      public static void reset()
      {
         /**
         * Resets all game data and restarts game.
         */
      }
      
      public static void retrieveMaze()
      {
         /**
         * Parses text file for maze and powerup data.
         */
      }
      
      public static void retrieveStats()
      {
         /**
         * Parses text file for highscores.
         */
      }
      
      public static void runGame(int level)
      {
         /**
         * Runs a stage of the game by iterating frames until a game-ending condition is reached.
         */
         
      }
   }

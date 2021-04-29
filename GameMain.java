   /**
   * GameMain manipulates data and controls all panels, including those of the menus and 
   
   /* 
   * imports
   * Swing GUI
   * Border Classes for Swing
   * Abstract Window Toolkit
   */
   
   import javax.swing.*;
   import javax.swing.border.*;
   import java.awt.*;
   
   
   public class GameMain
   {
      // main JPanel on which everything will be drawn, needs to be accessible to all methods
      // GameMain does not extend JPanel, since .remove() can not be used within GameMain if that were true
      private JPanel mainPanel;
      
      // constants used  to make 
      private static final int MAIN_MENU = 0;
      private static final int GAME_SCREEN = 1;
      private static final int TOP_SCORES = 2;
      private static final int WIN_CARD = 3;
      private static final int LOSE_CARD = 4; 
      
      public static void main(String[] args) 
      {
         // create a panel on which everything will happen
         
         JPanel mainPanel = new JPanel();
         // format panel here
         changeScreen(MAIN_MENU);
      } 
      
      public static void addToContainer(Container c)
      {
         /**
          * adds object to container when default .add is not possible
         */
      }
      
      public static void changeScreen(int n)
      {
         /**
          * use switch to change between MAIN_MENU, GAME_SCREEN, and TOP_SCORES panels
         */
      }
      
      public static void displayTransition(int n)
      {
         /**
         * transitions include level change (which includes starting/changing to lvl 1) and end card)
         */
      }
      
      public static void drawBoard()
      {
         /**
         *
         */
      }
      
      public static void gameUpdate()
      {
         /**
          * adds object to container when default .add is not possible
         */
      }
      
      public static void reset()
      {
         /**
          * used to hard reset game
         */
      }
      
      public static void runGame()
      {
         /**
         * runs game
         */
      }
   }

   /**
   * GameDriver contains the main method that starts the program.
   * @author Max Wang
   */
   
   /* 
   * Imports
   * Swing GUI
   * Abstract Window Toolkit
   */
   import javax.swing.*;
   import java.awt.*;
   
   public class GameDriver
   {
       public static void main(String[] args) 
      {
         /**
         * Instantiates a JFrame and a GameMain; GameMain will modify contents of JFrame.
         */
         JFrame frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         GameMain main = new GameMain();
         main.setup(frame);
         frame.setVisible(true);

      }  
   }

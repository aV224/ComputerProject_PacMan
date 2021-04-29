   // Max Wang
   // 4.28.21
   
   // import Swing GUI, Abstract Window Toolkit
   import javax.swing.*;
   import java.awt.*;
   
   public class GameDriver
   {
       public static void main(String[] args) 
      {
         JFrame frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         GameMain main = new GameMain();
         main.reset(frame);
         frame.setVisible(true);
      }  
   }

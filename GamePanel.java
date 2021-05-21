import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.Point.*;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class GamePanel {
  
   public static void main(String[] args) 
   {
      /**
      * Instantiates a JFrame and a GamePanel; GamePanel will modify contents of JFrame.
      */
      JFrame mainFrame = new JFrame();
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      menu(mainFrame);
   }   
    
      /**
      * Renders main menu.
      */
      
   public static void menu(JFrame frame)
   {
         // main menu has 2 buttons
         // button 1 is "Play Game", calls runGame()
         // button 2 is "Exit Game", ends program
      frame.setPreferredSize(new Dimension(200, 150));
      frame.setVisible(true);
      
      JPanel menuPanel = new JPanel();
      Dimension bd = new Dimension(100,25);
      
      menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
         
      JLabel titleLabel = new JLabel("PACMAN", SwingConstants.CENTER);
      titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      titleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
      titleLabel.setForeground(Color.black);
      menuPanel.add(titleLabel);
           
      JButton gameB = new JButton("Play");
      gameB.setFont(new Font("Dialog", Font.PLAIN, 15));
      gameB.setAlignmentX(Component.CENTER_ALIGNMENT);
      gameB.setMinimumSize(bd);
      gameB.setPreferredSize(bd);
      gameB.setMaximumSize(bd);
      menuPanel.add(gameB);
          
      JButton exitB = new JButton("Exit");
      exitB.setFont(new Font("Dialog", Font.PLAIN, 15));
      exitB.setAlignmentX(Component.CENTER_ALIGNMENT);
      exitB.setMinimumSize(bd);
      exitB.setPreferredSize(bd);
      exitB.setMaximumSize(bd);
      menuPanel.add(exitB);
   
      frame.add(menuPanel);
      frame.pack();
      
      gameB.addActionListener(
            new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent evt) {
                  frame.setVisible(false);
                  startGame(frame);
               }
            });
         
      exitB.addActionListener(
            new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent evt) {
                  System.exit(0);
               }
            });
   
   }     
   
   /**
   * Runs Game
   */ 
   
   public static void startGame(JFrame frame) {
      System.out.println("Starting a game!");
      JFrame pacFrame = new JFrame("Testing Wall");
      PacPanel pPanel = new PacPanel();
   
      pPanel.setPreferredSize(new Dimension(560, 700));
      pacFrame.add(pPanel);
      pacFrame.setSize(560, 700);
      pacFrame.setVisible(true);
      pacFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pacFrame.pack();
      
      while (true) {
         int result = pPanel.gameupdate();
         pacFrame.revalidate();
         pacFrame.repaint();
         System.out.println(result);
         if (result == -1) {
            System.out.println("Game Ended!!");
            break;
         } else if (result == 1) {
            System.out.println("Game won");
            break;
         }
         try {
            Thread.sleep(20);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
      
      JLabel endlbl = new JLabel();
      endlbl.setFont(new Font("Verdana", Font.PLAIN, 10));
      endlbl.setForeground(new Color(255, 0, 0));
      endlbl.setText("GAME OVER.. NICE TRY!");
      pPanel.add(endlbl);
      pPanel.repaint();
   }
}

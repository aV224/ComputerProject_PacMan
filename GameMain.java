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

public class GameMain {
   
   // main JPanel on which everything will be drawn, needs to be accessible to all methods
      // GameMain does not extend JPanel, since .remove() can not be used within GameMain if that were true
   private static JPanel mainPanel;
      
      /**
      * Creates a label with large bold letters to be used anywhere
      */
   
   private static void addATitle(String text, Container container) {
      JLabel label = new JLabel(text, SwingConstants.CENTER);
      label.setAlignmentX(Component.CENTER_ALIGNMENT);
      label.setFont(new Font("Dialog", Font.BOLD, 20));
      label.setForeground(Color.black);
      container.add(label);
   }
   
      /**
      * Creates a standard label to be used anywhere
      */
   
   private static void addALabel(String text, Container container) {
      JLabel label = new JLabel(text, SwingConstants.CENTER);
      label.setAlignmentX(Component.CENTER_ALIGNMENT);
      label.setFont(new Font("Dialog", Font.PLAIN, 12));
      label.setForeground(Color.black);
      container.add(label);
   }
      
      /**
      * Creates a vertical buffer to be used anywhere
      */
      
   private static void addVerticalBuffer(int height, Container container) {
      container.add(Box.createRigidArea(new Dimension(200, height)));
   }
      
      /**
      * Hub for redrawing screen
      */
      
   private void changeScreen(int screenNum, JFrame frame) 
   {
      switch(screenNum) {
         case 0:
            menu(frame);
            break;
         case 1:
            gameSetup(frame);
            break;
      }
      frame.setVisible(true);
   }
     
     /**
      * Sets up game board.
      */
      
   public void gameSetup(JFrame frame)
   {
      frame.removeAll();
      frame.invalidate();
      frame.validate();
      frame.revalidate();
      frame.repaint();
      startGame(frame);
   }
     
      /**
      * Renders main menu.
      */
      
   public void menu(JFrame frame)
   {
         // main menu has 2 buttons
         // button 1 is "Play Game", calls runGame()
         // button 2 is "Exit Game", ends program
     
      JPanel menuPanel = new JPanel();
      Dimension bd = new Dimension(100,25);
      
      menuPanel.removeAll();
      frame.invalidate();
      frame.validate();
      frame.revalidate();
      frame.repaint();
      frame.setContentPane(mainPanel);
      
      menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
         
      addVerticalBuffer(15, menuPanel);
         
      JLabel titleLabel = new JLabel("PACMAN", SwingConstants.CENTER);
      titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      titleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
      titleLabel.setForeground(Color.black);
      menuPanel.add(titleLabel);
         
      addVerticalBuffer(20, menuPanel);
         
      JButton gameB = new JButton("Play");
      gameB.setFont(new Font("Dialog", Font.PLAIN, 15));
      gameB.setAlignmentX(Component.CENTER_ALIGNMENT);
      gameB.setMinimumSize(bd);
      gameB.setPreferredSize(bd);
      gameB.setMaximumSize(bd);
      menuPanel.add(gameB);
         
      addVerticalBuffer(5, menuPanel);
         
      JButton exitB = new JButton("Exit");
      exitB.setFont(new Font("Dialog", Font.PLAIN, 15));
      exitB.setAlignmentX(Component.CENTER_ALIGNMENT);
      exitB.setMinimumSize(bd);
      exitB.setPreferredSize(bd);
      exitB.setMaximumSize(bd);
      menuPanel.add(exitB);
         
      addVerticalBuffer(15, menuPanel);
        
      mainPanel.add(menuPanel);
      frame.pack();
      
      gameB.addActionListener(
            new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent evt) {
                  menuPanel.removeAll();
                  mainPanel.remove(menuPanel);
                  frame.invalidate();
                  frame.validate();
                  frame.revalidate();
                  frame.repaint();
                  changeScreen(1, frame);
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
   * Sets up minor things before game can start.
   */
   
   public void setup(JFrame frame)
   {  
      mainPanel = new JPanel();
      frame.add(mainPanel);
      
      mainPanel.add(new JPanel());
      changeScreen(0, frame);
   }

   /**
   * Runs Game
   */ 
   
   public void startGame(JFrame frame) {
      frame.removeAll();
      
      PacPanel panel = new PacPanel();
   
      panel.setPreferredSize(new Dimension(560, 700));
      
      frame.setContentPane(panel);
      frame.invalidate();
      frame.validate();
      frame.revalidate();
      frame.repaint();
      frame.setPreferredSize(new Dimension(560, 700));
      frame.setVisible(true);
      frame.pack();
   
      while (true) {
         int result = panel.gameupdate();
         if (result == -1) {
            System.out.println("Game Ended!!");
            try {
               Thread.sleep(20);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            JLabel endlbl = new JLabel();
            endlbl.setFont(new Font("Verdana", Font.PLAIN, 10));
            endlbl.setForeground(new Color(255, 0, 0));
            endlbl.setText("GAME OVER.. NICE TRY!");
            panel.add(endlbl);
            panel.repaint();
            break;
         } else if (result == 1) {
            System.out.println("Game won");
            try {
               Thread.sleep(20);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            JLabel endlbl = new JLabel();
            endlbl.setFont(new Font("Verdana", Font.PLAIN, 10));
            endlbl.setForeground(new Color(255, 0, 0));
            endlbl.setText("GOOD JOB.. YOU WIN!");
            panel.add(endlbl);
            panel.repaint();
            break;

         }
      }
   
      try {
         Thread.sleep(5000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      
      panel.removeAll();
      mainPanel.remove(panel);
      mainPanel.revalidate();
      mainPanel.repaint();
      changeScreen(0, frame);
      
   }

}

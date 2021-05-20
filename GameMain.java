   /**
   * GameMain manipulates data and controls all panels, including those of the menus and the game
   * @author Max Wang
   */
   
   /* 
   * Import -
   * Swing GUI
   * Border Classes for Swing
   * Abstract Window Toolkit
   * Event
   * KeyEvent
   * BufferedImage
   * Point
   * BufferedWriter
   * FNF
   */
   
   import javax.swing.*;
   import javax.swing.border.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.event.KeyEvent;
   import java.awt.image.BufferedImage;
   import java.awt.Point.*;
   import java.io.BufferedWriter;
   import java.io.FileNotFoundException;
   
   
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
      
      // The variable which remembers the level the game is on; positive values are used for levels, zero is used while not in game.
      private int currentLevel = 0;
      
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
      * Adds object to container when .add is not possible.
      */
      
      public void addToContainer(Container container)
      {
         // adds object
      }
      
      /**
      * Hub for redrawing screen
      */
      
      private void changeScreen(int screenNum, JFrame frame, int lvl) 
      {
         switch(screenNum) {
            case 0:
               menu(frame);
               break;
            case 1:
               displayTransition(lvl, frame);
               break;
         }
         mainPanel.revalidate();
         mainPanel.repaint();
         frame.add(mainPanel);
         frame.setVisible(true);
      }

      
      /**
      * Renders display during the short time before, between, or after a game level.
      */
      
      public void displayTransition(int toLevel, JFrame frame)
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
      * Renders main menu.
      */
      
      public void menu(JFrame frame)
      {
         // main menu has 2 buttons
         // button 1 is "Play Game", calls runGame()
         // button 2 is "Exit Game", ends program
         
         JPanel menuPanel = new JPanel();
         Dimension bd = new Dimension(100,25);
      
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
                  changeScreen(1, frame, 1);
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
      * Runs a stage of the game.
      */
      
      public void runGame(int level, JFrame frame)
      {
         // loops gameUpdate() until condition met
         gameUpdate();
         changeScreen(0, frame, 0);
      }
      
      /**
      * Sets up minor things before game can start.
      */
      
      public void setup(JFrame frame)
      {  
         mainPanel = new JPanel();
         frame.add(mainPanel);
         
         mainPanel.add(new JPanel());
         changeScreen(0, frame, -1);
      }
   }

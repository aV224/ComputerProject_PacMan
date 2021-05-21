
/**
 * PacPanel is the organizer class. It will bring everything together to work as one unit
 * It extends JPanel and implements KeyListener
 * 
 * @author Aarya Vijayaraghavan
 * @author Aiden Cheong
 * @author Max Wang
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PacPanel extends JPanel implements KeyListener {
	private PacWall wall = null;
	private PacMan pacMan = null;
	private Blinky blinky = null;
	private Clyde clyde = null;
	private Pinky pinky = null;
	private Inky inky = null;
	private ArrayList<Pellet> pelletList = new ArrayList<Pellet>();
	private JLabel scorelbl = null;
	
	public PacPanel() {
		addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		setBackground(Color.BLACK);

		wall = new PacWall();
		pacMan = new PacMan(wall);
		blinky = new Blinky(pacMan, wall);
		clyde = new Clyde(pacMan, wall);
		pinky = new Pinky(pacMan, wall);
		inky = new Inky(pacMan, wall);
		this.createPellets();

		scorelbl = new JLabel();
		scorelbl.setFont(new Font("Verdana", Font.PLAIN, 20));
		scorelbl.setForeground(new Color(0, 0, 255));
		this.add(scorelbl);
	}
	/**
	*This is the paint method for all the componenets on the panel including the walls and sprites
	*/
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		wall.drawWall(this.getWidth(), this.getHeight(), g2d);
		pacMan.paintPacMan(g2d);
		this.drawPellets(g2d);
		blinky.paintGhost(g2d);
		clyde.paintGhost(g2d);
		pinky.paintGhost(g2d);
		inky.paintGhost(g2d);
	}
	
	/**
	 * This is the method that will be called by the game loop. It will let the ghosts out one by one, it will let 
	 * each ghost make their next move, and it will find if the game has been won or lost
	 * @return
	 */
	public int gameupdate() {
		if (pacMan.getScore() < 10) {
			if (blinky.makeNextMove()) {
				return -1;
			}
		} else if (pacMan.getScore() < 20) {
			if (blinky.makeNextMove() || pinky.makeNextMove()) {
				return -1;
			}
		} else if (pacMan.getScore() < 30) {
			if (blinky.makeNextMove() || pinky.makeNextMove() || inky.makeNextMove()) {
				return -1;
			}
		} else {
			if (blinky.makeNextMove() || pinky.makeNextMove() || inky.makeNextMove() || clyde.makeNextMove()) {
				return -1;
			}
		}

		boolean alleaten = true;
		for (int i = 0; i < pelletList.size(); i++) {
			if (!pelletList.get(i).isEaten()) {
				alleaten = false;
			}
		}

		if (alleaten == true) {
			return 1;
		}
		repaint();

		return 0;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	/**
	*When the key is pressed, it will tell pacman to move a certain direction
	*/
	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			pacMan.moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			pacMan.moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			pacMan.moveUp();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			pacMan.moveDown();
		}

		for (int i = 0; i < pelletList.size(); i++) {
			if (pelletList.get(i).checkCollision(pacMan)) {
				pelletList.get(i).setPelletimg(null);
				if (!pelletList.get(i).isEaten()) {
					pacMan.setScore(pacMan.getScore() + 1);
					scorelbl.setText("Score: " + pacMan.getScore());
					pelletList.get(i).setEaten(true);
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	/**
	 * It will figure which parts of the maze will need a pellet
	 */
	private void createPellets() {
		try {
			BufferedImage pelletimg = ImageIO.read(new File("Pellet.png"));
			int[][] gamematrix = wall.getGameMatrix();
			int index = 0;

			for (int i = 0; i < gamematrix.length; i++) {
				for (int j = 0; j < gamematrix[i].length; j++) {
					if (gamematrix[i][j] == 0) {
						pelletList.add(index, new Pellet(pelletimg, j, i));
						index++;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * It will draw the pellets with the information obtained in drawPellets.
	 * @param g2d
	 */
	private void drawPellets(Graphics2D g2d) {
		for (Pellet pellet : pelletList) {
			g2d.drawImage(pellet.getPelletimg(), pellet.getxAxis(), pellet.getyAxis(), 3, 3, null);
		}
	}	
}

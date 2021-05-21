import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Testing Wall");
		PacPanel panel = new PacPanel();

		panel.setPreferredSize(new Dimension(560, 700));
		frame.add(panel);
		frame.setSize(560, 700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

		while (true) {
			int result = panel.gameupdate();
			if (result == -1) {
				System.out.println("Game Ended!!");
				break;
			} else if (result == 1) {
				System.out.println("Game won");
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
		panel.add(endlbl);
		panel.repaint();
	}

}

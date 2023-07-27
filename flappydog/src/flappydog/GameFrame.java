package flappydog;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

	
	GameFrame() {
		
		this.setTitle("Flappy Dog");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new GamePanel());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
}

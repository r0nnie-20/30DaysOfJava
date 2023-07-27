package flappydog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	
	Thread gameThread;
	boolean running;
	Random random;
	static final int WIDTH = 800;
	static final int HEIGHT = 500;
	Dog dog;
	ArrayList<Pipe> pipes;
	final int PIPE_WIDTH = 100;
	
	GamePanel() {
		this.setBackground(Color.cyan);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.addKeyListener(new MKA());
		this.setFocusable(true);
		startGame();
		
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		render(g);
	}
	public void startGame() {
		gameThread = new Thread(this);
		random = new Random();
		pipes = new ArrayList<Pipe>();
		dog = new Dog(200,150,30,30);
		gameThread.start();
		running = true;
	}
	public void addPipe(int randomHeight) {
		pipes.add(new Pipe(this.getWidth(),0,PIPE_WIDTH,randomHeight));	
	}
	public void offScreenPipe() {
		for(int i = 0; i < pipes.size() - 1; i++) {
			if(pipes.get(i).x == -PIPE_WIDTH) {
				pipes.remove(i);
			}
		}
	}
	public void gameOver() {
		
	}
	
	public void collisions() {
		
		//check if bird collides upper or lower edges
		
		if(dog.y < 0) {
			dog.y = 0;
			dog.down = 0;
			running = false;
		}
		if(dog.y > this.HEIGHT - 30) {
			dog.down = 0;
			dog.up = 0;
			running = false;
		}
		
		for(Pipe p : pipes) {
			if(dog.intersects(p.getLowerPipeBounds())) {
				running = false;
			}
			if(dog.intersects(p.getUpperPipeBounds())) {
				running = false;
			}
		}
		
		offScreenPipe();
	}

	public void render(Graphics g) {
		// renders game objects
		for(Pipe p : pipes) {
			p.render(g);
		}
		dog.render(g);
	}
		
	public void update() {
		// update game objects
		dog.update();
		for(Pipe p : pipes) {
			p.update();
		}
	}
	@Override
	public void run() {
	
		long lastTime = System.currentTimeMillis();
		double amountOfTicks = 60.0;
		double ns = 100000000/amountOfTicks;
		double delta = 0;
		int frames = 0;
		while(running) {
			
			long currentTime = System.currentTimeMillis();
			delta += (currentTime - lastTime)/ns;
			if(delta >= 1) {
				delta--;
				frames++;
				if(frames == 160) {
					frames = 0;
					addPipe(random.nextInt(this.getHeight()/2));
				}
				lastTime = currentTime;
				update();
				collisions();
				repaint();
			}
		}
		
	}
	
	class MKA extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			dog.keyPressed(e);
		}
	}
	
	
	
}

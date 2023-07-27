package flappydog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Dog extends Rectangle {
	
	int down = 2;
	int up = 50;
	
	Dog(int x, int y, int width, int height){
		super(x,y,width,height);
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x, y, width, height);
	}
	public void update() {
		y += down;
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			y -= up; 
		}
	}
}

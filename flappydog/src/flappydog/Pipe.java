package flappydog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pipe extends Rectangle {
	
	int middleGap = 200;
	
	Pipe(int x, int y, int width, int height) {
		super(x,y,width,height);
	}
	public void render(Graphics g) {
		g.setColor(Color.green.darker());
		g.fillRect(x, y, width, height);
		
		g.setColor(Color.cyan);
		g.fillRect(x,height,width,middleGap);
		
		g.setColor(Color.green.darker());
		g.fillRect(x, height+middleGap, width, GamePanel.HEIGHT);
	}
	
	public Rectangle getLowerPipeBounds() {
		return new Rectangle(x, height+middleGap, width, GamePanel.HEIGHT);
	}
	public Rectangle getUpperPipeBounds() {
		return new Rectangle(x, y, width, height);
	}
	public void update() {
		x -= 2;
	}
	
}

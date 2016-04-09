package tankAlong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Weapon {

	public Rectangle getRect() {
		return new Rectangle(23, 252, 22, 222);
		}
	
	public void drawBlood(Graphics g,int x,int y) {
		g.setColor(Color.red);
		g.fillRect(x,y,19,19);

	}
	public void drawBomb(Graphics g,int x,int y) {
		g.setColor(Color.black);
		g.drawLine(x+15, y-6, x+15, y);
		g.fillOval(x,y,29,29);

	}
}

package tankAlong;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class CreateBullet {
	
	public Graphics g;
	public int i,x,y;
	int n=x,m=y;
	public Rectangle getRect(int a,int b,int w,int h) {
		return new Rectangle(a,b,25,25);
	}
	public Rectangle getRect1(int c,int d,int w,int h) {
		return new Rectangle(c,d,25,25);
	}
	public boolean isHit(int a,int b,int w1,int h1,int c,int d,int w2,int h2) {
		return this.getRect(a,b,w1,h1).intersects(this.getRect1(c,d,w2,h2));
	}
	public void paint(Graphics g,int x,int y,int w) {
		
		if(w==0){
			java.awt.Image image = new ImageIcon("images/missileL.gif").getImage();
			g.drawImage(image,x+6, y+22,null);
			this.x = x+6;
			this.y = y+22;
		}
		if(w==1){
			java.awt.Image image = new ImageIcon("images/missileD.gif").getImage();
			g.drawImage(image, x+18, y+30,null);
			this.x = x+18;
			this.y = y+30;
		}
		if(w==2){
			java.awt.Image image = new ImageIcon("images/missileR.gif").getImage();
			g.drawImage(image, x+29, y+22,null);
			this.x = x+29;
			this.y = y+22;
		}
		if(w==3){
			java.awt.Image image = new ImageIcon("images/missileU.gif").getImage();
			g.drawImage(image, x+20, y+6,null);
			this.x = x+20;
			this.y = y+6;
		}
	}
}

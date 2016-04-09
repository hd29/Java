package tankAlong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class CreatTank{
	CreateBullet bullet = new CreateBullet();
    int k=0,w,w1,d;
	public int i;
	public int j;
	int x, y, c=0;
    Graphics g;
    int tankmun=0;
    Thread thread = new Thread();
    boolean noFire=false;
    Weapon weapon = new Weapon();
public void paint(Graphics g,int x,int y,int w,int m) {
	
	if(k!=1)
	k=(int)(Math.random()*4);
	if(w==0){
		java.awt.Image image = new ImageIcon("images/tankL.gif").getImage();
		g.setColor(Color.red);
		g.drawImage(image, x, y,null);
		if(m==0&&k==1){
		fire(g, x, y, w,k);
		}
	}
	if(w==1){
		java.awt.Image image = new ImageIcon("images/tankD.gif").getImage();
		g.setColor(Color.red);
		g.drawImage(image, x, y,null);
		if(m==0&&k==1)
		fire(g, x, y, w,k);
	}
	if(w==2){
		java.awt.Image image = new ImageIcon("images/tankR.gif").getImage();
		g.setColor(Color.red);
		g.drawImage(image, x, y,null);
		if(m==0&&k==1)
		fire(g, x, y, w,k);
	}
	if(w==3){
		java.awt.Image image = new ImageIcon("images/tankU.gif").getImage();
		g.setColor(Color.red);
		g.drawImage(image, x, y,null);
		if(m==0&&k==1)
		fire(g, x, y, w,k);
	}

	}

public void fire(Graphics g,int x,int y,int w,int k) {
	   if(k==0){
			w1=w;
			this.i=x;
			this.j=y;
		}
		if(k==1){
			if((i>580||i<0||j>580||j<0)||noFire){
				k=0;
				this.i=x;
				this.j=y;
				noFire=false;
			}
			if(i==x&&j==y){
				w1=w;
			}
			
			bullet.paint(g, i, j, w1);
			if(w1==0){
				this.i=this.i-25;
			}
			if(w1==1){
				this.j=this.j+25;
			}
			if(w1==2){
				this.i=this.i+25;
			}
			if(w1==3){
				this.j=this.j-25;
			}
		}
      }

      public boolean noFire() {
    	  noFire = true;
//    	  java.awt.Image image = new ImageIcon("images/2.gif").getImage();
//  		  g.drawImage(image, x, y,null);
    	  return noFire;
	}


    public Rectangle getRect() {
	return new Rectangle(i, j, 12, 12);
	}
//    public boolean isHit() {
//		return this.getRect().intersects(this.getRect1());
//	}
}                                                      

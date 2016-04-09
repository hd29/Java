package tankServer;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bullet {
	
	int bulletX;
	int bulletY;
	int bulletD;
	int good;
	
	static Image imageBulletD = new ImageIcon("images/missileD.gif").getImage();
	static Image imageBulletU = new ImageIcon("images/missileU.gif").getImage();
	static Image imageBulletL = new ImageIcon("images/missileL.gif").getImage();
	static Image imageBulletR = new ImageIcon("images/missileR.gif").getImage();
	
	public Bullet(int bulletX,int bulletY,int bulletD,int good) {
		this.bulletX = bulletX;
		this.bulletY = bulletY;
		this.bulletD = bulletD;
		this.good = good;
	}
	
}

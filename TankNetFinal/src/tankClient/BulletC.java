package tankClient;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class BulletC {
	
	static ArrayList<BulletCDate> bulletCList = new ArrayList<BulletCDate>();
	
	static Image imageBulletD = new ImageIcon("images/missileD.gif").getImage();
	static Image imageBulletU = new ImageIcon("images/missileU.gif").getImage();
	static Image imageBulletL = new ImageIcon("images/missileL.gif").getImage();
	static Image imageBulletR = new ImageIcon("images/missileR.gif").getImage();
	
	static int bulletX ;
	static int bulletY ;
	
	static ArrayList<MapChanged> mapChangedL = new ArrayList<MapChanged>();
	
	public static void paintBullet(Graphics g) {		
		for (int i = 0; i < bulletCList.size(); i++) {
			
			if(bulletCList.get(i).bulletD == 0){
				
				bulletX = bulletCList.get(i).bulletX - 7;
				bulletY = bulletCList.get(i).bulletY + 18;
				
				g.drawImage(imageBulletL, bulletX,bulletY, 10, 5, null);
				bulletCList.get(i).bulletX = bulletCList.get(i).bulletX - 1;
			}else if(bulletCList.get(i).bulletD == 1){
				
				bulletX = bulletCList.get(i).bulletX + 14;
				bulletY = bulletCList.get(i).bulletY + 40;
				
				g.drawImage(imageBulletU, bulletX,bulletY, 12, 10, null);
				bulletCList.get(i).bulletY = bulletCList.get(i).bulletY + 1;
			}else if(bulletCList.get(i).bulletD == 2){
				bulletX = bulletCList.get(i).bulletX + 40;
				bulletY = bulletCList.get(i).bulletY + 18;
				
				g.drawImage(imageBulletR, bulletX,bulletY, 10, 5, null);
				bulletCList.get(i).bulletX = bulletCList.get(i).bulletX + 1;
			}else if(bulletCList.get(i).bulletD == 3){
				bulletX = bulletCList.get(i).bulletX + 15;
				bulletY = bulletCList.get(i).bulletY - 10;
				
				g.drawImage(imageBulletD, bulletX,bulletY, 12, 10, null);
				bulletCList.get(i).bulletY = bulletCList.get(i).bulletY - 1;
			}
			
			if(bulletX < 600 && bulletX > -1
					&& bulletY < 600 && bulletY > 0){
				
				if(hit(bulletX,bulletY,
						bulletCList.get(i).good)){
					//Map.map1[bulletCList.get(i).bulletY/40]
					//[bulletCList.get(i).bulletX/40] = 0;
					bulletCList.remove(i);
				}
			
			}else {
				bulletCList.remove(i);
			}
			
				
		}
	
	}
	
	static boolean Hited = false;
	
	public static boolean hit(int bulletX,int bulletY,int good) {
		Hited = false;
		
		if(Map.map1[bulletY/40][bulletX/40] != 0 
				|| hitedBadTank(bulletX,bulletY,good)){
			
			Map.map1[bulletY/40][bulletX/40] = 0;
			mapChangedL.add(new MapChanged(bulletY/40, bulletX/40));
			Hited = true;
			
		}else {
			Hited = false;
		}
		
		return Hited;
	
	}
	
	static boolean hitedBadTank = false;
	
	public static boolean hitedBadTank(int bulletX,int bulletY,int good) {
		
		hitedBadTank = false;
		
		if(good == 1){
			
			if(Rectangle(bulletX, bulletY,12, 12).intersects
					(BadTank.tankX1, BadTank.tankY1, 40, 40)
					&& BadTank.tankL1){
				hitedBadTank = true;
				BadTank.tankL1 = false;
			}else if(Rectangle(bulletX, bulletY,12, 12).intersects
					(BadTank.tankX2, BadTank.tankY2, 40, 40)
					&& BadTank.tankL2){
				hitedBadTank = true;
				BadTank.tankL2 = false;

			}else if(Rectangle(bulletX, bulletY,12, 12).intersects
					(BadTank.tankX3, BadTank.tankY3, 40, 40)
					&& BadTank.tankL3){
				hitedBadTank = true;
				BadTank.tankL3 = false;

			}else if(Rectangle(bulletX, bulletY,12, 12).intersects
					(BadTank.tankX4, BadTank.tankY4, 40, 40)
					&& BadTank.tankL4){
				hitedBadTank = true;
				BadTank.tankL4 = false;

			}else{
				hitedBadTank = false;
			}
		
		}else if(good == 0){
			
			if(Rectangle(bulletX, bulletY,12, 12).intersects
					(MyTank.myTankLocatX, MyTank.myTankLocatY, 40, 40)
					&& MyTank.myTankL){
				hitedBadTank = true;
				MyTank.myTankL = false;
				System.out.println(MyTank.myTankL);
			}else if(Rectangle(bulletX, bulletY,12, 12).intersects
					(MyTank.myFriendTankX, MyTank.myFriendTankY, 40, 40)
					&& MyTank.myFriendTankL){
				hitedBadTank = true;
				MyTank.myFriendTankL = false;
				
			}
		}
		
		return hitedBadTank;
	}
	
	public static Rectangle Rectangle(int x,int y,int w,int h) {
		return new Rectangle(x, y, w, h);
	}
}

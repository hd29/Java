package tankClient;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class MyTank {
	

	   static int myTankLocatX;
	   static int myTankLocatY;
	   static int myTankLocatD;
	   static boolean myTankL = false;
		
	   static int myFriendTankX;
	   static int myFriendTankY;
	   static int myFriendTankD;
	   static boolean myFriendTankL = false;
	   
	   static String myTankX = null;
	   
	   
	   Image imageL = new ImageIcon("images/lake.png").getImage();
	   Image imageS = new ImageIcon("images/steel.png").getImage();
	   Image imageB = new ImageIcon("images/lbrick.png").getImage();
	   static Image imageTD = new ImageIcon("images/tankD.gif").getImage();
	   static Image imageTU = new ImageIcon("images/tankU.gif").getImage();
	   static Image imageTL = new ImageIcon("images/tankL.gif").getImage();
	   static Image imageTR = new ImageIcon("images/tankR.gif").getImage();

	
	public static void paintMyTank(Graphics g){
		  
		if(MyTank.myTankX.equals("Client1")){
			   
			   if(MyTank.myTankL){
				   g.setColor(Color.red);
				   g.fillRect(myTankLocatX, myTankLocatY, 40, 40);
			   }

			   if(MyTank.myFriendTankL){
				   g.setColor(Color.yellow);
				   g.fillRect(myFriendTankX, myFriendTankY, 40, 40);
			   }
			   
		   }else {
			   
			   if(MyTank.myTankL){
				   g.setColor(Color.yellow);
				   g.fillRect(myTankLocatX, myTankLocatY, 40, 40);
			   }

			   if(MyTank.myFriendTankL){
				   g.setColor(Color.red);
				   g.fillRect(myFriendTankX, myFriendTankY, 40, 40);
			   }
			   
		   }

		if(MyTank.myTankL){
			if(myTankLocatD == 0){
				g.drawImage(imageTL, myTankLocatX, myTankLocatY, 40, 40, null);
			}else if(myTankLocatD == 1){
				g.drawImage(imageTD, myTankLocatX, myTankLocatY, 40, 40, null);
			}else if(myTankLocatD == 2){
				g.drawImage(imageTR, myTankLocatX, myTankLocatY, 40, 40, null);
			}else if(myTankLocatD == 3){
				g.drawImage(imageTU, myTankLocatX, myTankLocatY, 40, 40, null);
			}
		}
		
		if(MyTank.myFriendTankL){
			if(myFriendTankD == 0){
				g.drawImage(imageTL, myFriendTankX, myFriendTankY, 40, 40, null);
			}else if(myFriendTankD == 1){
				g.drawImage(imageTD, myFriendTankX, myFriendTankY, 40, 40, null);
			}else if(myFriendTankD == 2){
				g.drawImage(imageTR, myFriendTankX, myFriendTankY, 40, 40, null);
			}else if(myFriendTankD == 3){
				g.drawImage(imageTU, myFriendTankX, myFriendTankY, 40, 40, null);
			}
		}
	}

}

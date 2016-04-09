package tankClient;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class BadTank {
	
	static int tankX1 ;
	static int tankY1 ;
	static int tankX2 ;
	static int tankY2 ;
	static int tankX3 ;
	static int tankY3 ;
	static int tankX4 ;
	static int tankY4 ;
	
	static int tankR1 = 0;
	static int tankR2 = 0;
	static int tankR3 = 0;
	static int tankR4 = 0;
	
	static boolean tankL1 = true;
	static boolean tankL2 = true;
	static boolean tankL3 = true;
	static boolean tankL4 = true;
	
	static Image imageTD = new ImageIcon("images/tankD.gif").getImage();
	static Image imageTU = new ImageIcon("images/tankU.gif").getImage();
	static Image imageTL = new ImageIcon("images/tankL.gif").getImage();
	static Image imageTR = new ImageIcon("images/tankR.gif").getImage();

	static ArrayList<PaintBadTankDataC> badTankL = new ArrayList<PaintBadTankDataC>();
	
	public static void paintEnemyTank(Graphics g) {
		
		if(tankL1){
			
			if(tankR1 == 0)
				g.drawImage(imageTL, tankX1, tankY1, 40, 40, null);
			else if(tankR1 == 1)
				g.drawImage(imageTD, tankX1, tankY1, 40, 40, null);
			else if(tankR1 == 2)
				g.drawImage(imageTR, tankX1, tankY1, 40, 40, null);
			else if(tankR1 == 3)
				g.drawImage(imageTU, tankX1, tankY1, 40, 40, null);
		}
		
		if(tankL2){
			
			if(tankR2 == 0)
				g.drawImage(imageTL, tankX2, tankY2, 40, 40, null);
			else if(tankR2 == 1)
				g.drawImage(imageTD, tankX2, tankY2, 40, 40, null);
			else if(tankR2 == 2)
				g.drawImage(imageTR, tankX2, tankY2, 40, 40, null);
			else if(tankR2 == 3)
				g.drawImage(imageTU, tankX2, tankY2, 40, 40, null);
		}
		
		if(tankL3){
			if(tankR3 == 0)
				g.drawImage(imageTL, tankX3, tankY3, 40, 40, null);
			else if(tankR3 == 1)
				g.drawImage(imageTD, tankX3, tankY3, 40, 40, null);
			else if(tankR3 == 2)
				g.drawImage(imageTR, tankX3, tankY3, 40, 40, null);
			else if(tankR3 == 3)
				g.drawImage(imageTU, tankX3, tankY3, 40, 40, null);
		}
		
		if(tankL4){
			if(tankR4 == 0)
				g.drawImage(imageTL, tankX4, tankY4, 40, 40, null);
			else if(tankR4 == 1)
				g.drawImage(imageTD, tankX4, tankY4, 40, 40, null);
			else if(tankR4 == 2)
				g.drawImage(imageTR, tankX4, tankY4, 40, 40, null);
			else if(tankR4 == 3)
				g.drawImage(imageTU, tankX4, tankY4, 40, 40, null);
		}
		
	}
}

package tankClient;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;



public class Map {
	
	static Image imageL = new ImageIcon("images/lake.png").getImage();
	static Image imageS = new ImageIcon("images/steel.png").getImage();
	static Image imageB = new ImageIcon("images/lbrick.png").getImage();
	
	static int [][] map1 = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,1,0,3,3,3,3,3,0,0,0},
			{0,0,1,1,1,1,0,2,2,2,2,2,0,0,0},
			{0,0,1,1,1,1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,3,3,0},
			{0,0,0,0,0,0,0,1,1,1,1,1,3,3,0},
			{0,0,3,3,3,3,3,3,3,3,3,3,3,3,0},
			{0,0,0,0,0,0,0,0,0,0,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,0,2,1,1,1,1,2,2,2,2,3,1,1,0},
			{0,0,2,3,3,3,3,3,3,3,3,3,3,3,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	public static void paintMap(Graphics g) {
		for (int i = 0; i < map1.length; i++) {
			for (int j = 0; j < map1.length; j++) {
				if(map1[i][j]==1){
					g.drawImage(imageL, j*40, i*40, 40, 40, null);
				}
				if(map1[i][j]==2){
					g.drawImage(imageS, j*40, i*40, 40, 40, null);
				}
				if(map1[i][j]==3){
					g.drawImage(imageB, j*40, i*40, 40, 40, null);
				}
			}
			
		}
	}
}

package tankServer;

import java.net.Socket;
import java.util.ArrayList;

public class Game {
	
	int gameNum;
    int friendtankX1;
	int friendtankY1;
	int friendtankD1;
	int friendtankL1;
	int friendtankX2;
	int friendtankY2;
	int friendtankD2;
	int friendtankL2;
	
	BadTankData btd;
	Map map;
	
	Socket player1 = null;
	Socket player2 = null;
	
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	
	boolean filled = false;
	
	public Game(int gameNum,Map map,BadTankData btd,Socket player1,Socket player2,boolean filled) {
		
		this.gameNum = gameNum;
		this.map = map;
		this.btd = btd;
		this.player1 = player1;
		this.player2 = player2;
		this.filled = filled;
		
		this.friendtankX1 = 50;
		this.friendtankY1 = 400;
		this.friendtankD1 = 3;
		this.friendtankL1 = 0;
		this.friendtankX2 = 250;
		this.friendtankY2 = 400;
		this.friendtankD2 = 3;
		this.friendtankL2 = 0;
	}

  
}

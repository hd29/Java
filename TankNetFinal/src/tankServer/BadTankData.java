package tankServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class BadTankData {

	int tankX1 = 100;
	int tankY1 = 10;
	int tankX2 = 200;
	int tankY2 = 140;
	int tankX3 = 300;
	int tankY3 = 240;
	int tankX4 = 400;
	int tankY4 = 340;
	int tankR1 = 1;
	int tankR2 = 1;
	int tankR3 = 1;
	int tankR4 = 1;

	int tankRD1 = 0;
	int tankRD2 = 0;
	int tankRD3 = 0;
	int tankRD4 = 0;

	int tankRF1 = 0;
	int tankRF2 = 0;
	int tankRF3 = 0;
	int tankRF4 = 0;

	int tankRB1 = 0;
	int tankRB2 = 0;
	int tankRB3 = 0;
	int tankRB4 = 0;

	int tankAL1 = 9;
	int tankAL2 = 9;
	int tankAL3 = 9;
	int tankAL4 = 9;
	int gameNum;

	boolean tankL1 = true;
	boolean tankL2 = true;
	boolean tankL3 = true;
	boolean tankL4 = true;

	Socket socket;

	public BadTankData(int gameNum) {
		this.gameNum = gameNum;
		
	}

	public void tankRandomLocation() {

		if(tankL1){
			tankRF1 = (int)(Math.random()*9);
		}else{
			tankAL1 = (int)(Math.random()*20);

		}

		if(tankL2){
			tankRF2 = (int)(Math.random()*9);
		}else{ 
			tankAL2 = (int)(Math.random()*20);
		}

		if(tankL3)
			tankRF3 = (int)(Math.random()*9);
		else 
			tankAL3 = (int)(Math.random()*20);

		if(tankL4)
			tankRF4 = (int)(Math.random()*9);
		else 
			tankAL4 = (int)(Math.random()*20);

		if(tankAL1 == 0){
			tankL1 = true;
			tankAL1 = 9;
		}

		if(tankAL2 == 0){
			tankL2 = true;
			tankAL2 = 9;
		}

		if(tankAL3 == 0){
			tankL3 = true;
			tankAL3 = 9;
		}

		if(tankAL4 == 0){
			tankL4 = true;
			tankAL4 = 9;
		}

		if(tankRF1 == 0 && tankL1){
			AcceptClientThread.gameList.get(gameNum).bulletList.add(
					new Bullet(tankX1, tankY1, tankRD1, 0));
		}

		if(tankRF2 == 0 && tankL2){
			AcceptClientThread.gameList.get(gameNum).bulletList.add(
					new Bullet(tankX2, tankY2, tankRD2, 0));
		}
		if(tankRF3 == 0 && tankL3){
			AcceptClientThread.gameList.get(gameNum).bulletList.add(
					new Bullet(tankX3, tankY3, tankRD3, 0));
		}
		if(tankRF4 == 0 && tankL4){
			AcceptClientThread.gameList.get(gameNum).bulletList.add(
					new Bullet(tankX4, tankY4, tankRD4, 0));
		}

		if(tankRB1 == 0){
			tankRD1 = (int)(Math.random()*4);
			tankRB1 = (int)(Math.random()*6)+2;
		}
		if(tankRB2 == 0){
			tankRD2 = (int)(Math.random()*4); 
			tankRB2 = (int)(Math.random()*6)+2; 
		}

		if(tankRB3 == 0){
			tankRD3 = (int)(Math.random()*4); 
			tankRB3 = (int)(Math.random()*6)+2; 
		}

		if(tankRB4 == 0){
			tankRD4 = (int)(Math.random()*4); 
			tankRB4 = (int)(Math.random()*6)+2; 
		}

		if(tankRD1 == 0 && tankR1 == 0){
			if(tankX1 > 0){
				//				 «∑Ò”–’œ∞≠
				if(moveable(tankX1 - 10, tankY1,tankRD1)){
					tankX1 = tankX1 - 10;
					tankRB1 --;
				}else{
					tankRB1 = 0;
				}

			}else {
				tankRB1 = 0;
			}
		}else if(tankRD1 == 1 && tankR1 == 1){
			if(tankY1 < 460){

				if(moveable(tankX1 , tankY1 + 10,tankRD1)){
					tankY1 = tankY1 + 10;
					tankRB1 --;
				}else{
					tankRB1 = 0;
				}

			}else {
				tankRB1 = 0;
			}
		}else if(tankRD1 == 2 && tankR1 == 2){
			if(tankX1 < 460){

				if(moveable(tankX1 + 10, tankY1,tankRD1)){
					tankX1 = tankX1 + 10;
					tankRB1 --;
				}else{
					tankRB1 = 0;
				}

			}else {
				tankRB1 = 0;
			}
		}else if(tankRD1 == 3 && tankR1 == 3){

			if(tankY1 > 20){
				if(moveable(tankX1, tankY1 - 10,tankRD1)){
					tankY1 = tankY1 - 10;
					tankRB1 --;
				}else{
					tankRB1 = 0;
				}
			}else {
				tankRB1 = 0;
			}

		}else {
			tankR1 = tankRD1;
		}

		if(tankRD2 == 0 && tankR2 == 0){

			if(tankX2 > 0){
				if(moveable(tankX2 - 10, tankY2,tankRD2)){
					tankX2 = tankX2 - 10;
					tankRB2 --;
				}else {
					tankRB2 = 0;
				}
			}else {
				tankRB2 = 0;
			}
		}else if(tankRD2 == 1 && tankR2 == 1){
			if(tankY2 < 460){
				if(moveable(tankX2, tankY2 + 10,tankRD2)){
					tankY2 = tankY2 + 10;
					tankRB2 --;
				}else {
					tankRB2 = 0;
				}

			}else {
				tankRB2 = 0;
			}
		}else if(tankRD2 == 2 && tankR2 == 2){
			if(tankX2 < 460){
				if(moveable(tankX2 + 10, tankY2,tankRD2)){
					tankX2 = tankX2 + 10;
					tankRB2 --;
				}else {
					tankRB2 = 0;
				}

			}else {
				tankRB2 = 0;
			}
		}else if(tankRD2 == 3 && tankR2 == 3){
			if(tankY2 > 20){
				if(moveable(tankX2, tankY2 - 10,tankRD2)){
					tankY2 = tankY2 - 10;
					tankRB2 --;
				}else {
					tankRB2 = 0;
				}

			}else {
				tankRB2 = 0;
			}
		}else{
			tankR2 = tankRD2;
		}

		if(tankRD3 == 0 && tankR3 == 0){
			if(tankX3 > 0){
				if(moveable(tankX3 - 10, tankY3,tankRD3)){
					tankX3 = tankX3 - 10;
					tankRB3 --;
				}else {
					tankRB3 = 0;
				}

			}else {
				tankRB3 = 0;
			}
		}else if(tankRD3 == 1 && tankR3 == 1){
			if(tankY3 < 460){
				if(moveable(tankX3, tankY3 + 10,tankRD3)){
					tankY3 = tankY3 + 10;
					tankRB3 --;
				}else {
					tankRB3 = 0;
				}

			}else {
				tankRB3 = 0;
			}
		}else if(tankRD3 == 2 && tankR3 == 2){
			if(tankX3 < 460){
				if(moveable(tankX3 + 10, tankY3,tankRD3)){
					tankX3 = tankX3 + 10;
					tankRB3 --;
				}else {
					tankRB3 = 0;
				}

			}else {
				tankRB3 = 0;
			}

		}else if(tankRD3 == 3 && tankR3 == 3){
			if(tankY3 > 20){
				if(moveable(tankX3, tankY3 - 10,tankRD3)){
					tankY3 = tankY3 - 10;
					tankRB3 --;
				}else {
					tankRB3 = 0;
				}

			}else {
				tankRB3 = 0;
			}
		}else{
			tankR3 = tankRD3;
		}

		if(tankRD4 == 0 && tankR4 == 0){
			if(tankX4 > 10){
				if(moveable(tankX4 - 10, tankY4,tankRD4)){
					tankX4 = tankX4 - 10;
					tankRB4 --;
				}else {
					tankRB4 = 0;
				}

			}else {
				tankRB4 = 0;
			}
		}else if(tankRD4 == 1 && tankR4 == 1){
			if(tankY4 < 460){
				if(moveable(tankX4, tankY4 + 10,tankRD4)){
					tankY4 = tankY4 + 10;
					tankRB4 --;
				}else {
					tankRB4 = 0;
				}

			}else {
				tankRB4 = 0;
			}
		}else if(tankRD4 == 2 && tankR4 == 2){
			if(tankX4 < 460){
				if(moveable(tankX4 + 10, tankY4,tankRD4)){
					tankX4 = tankX4 + 10;
					tankRB4 --;
				}else {
					tankRB4 = 0;
				}

			}else{
				tankRB4 = 0;
			}
		}else if(tankRD4 == 3 && tankR4 == 3){
			if(tankY4 > 20){
				if(moveable(tankX4, tankY4 - 10,tankRD4)){
					tankY4 = tankY4 - 10;
					tankRB4 --;
				}else {
					tankRB4 = 0;
				}

			}else {
				tankRB4 = 0;
			}
		}else{
			tankR4 = tankRD4;
		}

	}

	public static boolean moveable(int tankX,int tankY,int tankRD1) {

		if(tankRD1 == 0){
			if(tankY%40 == 0 && Map.map1[tankY/40][tankX/40] == 0){

				return true;

			}else if(Map.map1[tankY/40][tankX/40] == 0
					&& Map.map1[tankY/40 + 1][tankX/40] == 0){

				return true;

			}else{

				return false;
			}
		}else if(tankRD1 == 1){

			if(tankY%40 == 0){
				if(tankX%40 == 0 && Map.map1[tankY/40][tankX/40] == 0){
					return true;
				}else if(tankX%40 != 0 && Map.map1[tankY/40][tankX/40] == 0
						&& Map.map1[tankY/40][tankX/40 + 1] == 0){
					return true;
				}else {
					return false;
				}

			}else if(tankX%40 == 0 && Map.map1[tankY/40 + 1][tankX/40] == 0){

				return true;

			}else if(Map.map1[tankY/40 + 1][tankX/40] == 0
					&& Map.map1[tankY/40 + 1][tankX/40 + 1] == 0){

				return true;

			}else{

				return false;
			}
		}else if(tankRD1 == 2){
			if(tankX%40 == 0){
				if(tankY%40 == 0 && Map.map1[tankY/40][tankX/40] == 0){
					return true;
				}else if(tankY%40 != 0 && Map.map1[tankY/40][tankX/40] == 0
						&& Map.map1[tankY/40 + 1][tankX/40] == 0){
					return true;
				}else {
					return false;
				}

			}else if(tankY%40 == 0 && Map.map1[tankY/40][tankX/40 + 1] == 0){

				return true;

			}else if(Map.map1[tankY/40][tankX/40 + 1] == 0
					&& Map.map1[tankY/40 + 1][tankX/40 + 1] == 0){

				return true;

			}else{

				return false;
			}
		}else if(tankRD1 == 3){
			if(tankX%40 == 0 && Map.map1[tankY/40][tankX/40] == 0){

				return true;

			}else if(Map.map1[tankY/40][tankX/40] == 0
					&& Map.map1[tankY/40][tankX/40 + 1] == 0){

				return true;

			}else{

				return false;
			}
		}else{
			return false;
		}		
	}
	PrintWriter pw;

	public void sendMsg() {
		//		AcceptClientThread.gameList.get(gameNum).btd.tankRandomLocation();
		tankRandomLocation();
		socket = AcceptClientThread.gameList.get(gameNum).player1;
		if(socket != null && !socket.isClosed()){
			try {
				pw = new PrintWriter(socket.getOutputStream());
				pw.println("badTank"+","+tankX1+","
						+tankY1+","+tankR1+","
						+tankX2+","+tankY2+","
						+tankR2+","+tankX3+","
						+tankY3+","+tankR3+","
						+tankX4+","+tankY4+","
						+tankR4+","+tankL1+","
						+tankL2+","+tankL3+","
						+tankL4+","
						+AcceptClientThread.clientList.size());
				pw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		socket = AcceptClientThread.gameList.get(gameNum).player2;
		if(socket != null && !socket.isClosed()){
			try {
				pw = new PrintWriter(socket.getOutputStream());
				pw.println("badTank"+","+tankX1+","
						+tankY1+","+tankR1+","
						+tankX2+","+tankY2+","
						+tankR2+","+tankX3+","
						+tankY3+","+tankR3+","
						+tankX4+","+tankY4+","
						+tankR4+","+tankL1+","
						+tankL2+","+tankL3+","
						+tankL4+","
						+AcceptClientThread.clientList.size());
				pw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}
}

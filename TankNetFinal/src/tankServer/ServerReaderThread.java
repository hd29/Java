package tankServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ServerReaderThread extends Thread {
	Socket socket;
    Scanner sc = new Scanner(System.in);
	
	static int friendtankX1 = 50;
	static int friendtankY1 = 400;
	static int friendtankD1 = 3;
	static int friendtankL1 = 0;
	static int friendtankX2 = 250;
	static int friendtankY2 = 400;
	static int friendtankD2 = 3;
	static int friendtankL2 = 0;
	
	public ServerReaderThread(Socket socket) {
		this.socket = socket;
	}
	@Override
    public void run() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		while (true){
			String[] str;
			try {
				str = br.readLine().split(",");
//				AcceptClientThread.gameList.get(Integer.parseInt(str[2])).player1;
				if(str[0].equals("Client1")){
					//客户端1发来消息Client1
					if(str[1].equals("a")){
						//向左移动dddddddddddd
						System.out.println(Integer.parseInt(str[2]));
						if(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD1 == 0 
								&& AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX1 > 0){
							
							if(BadTankData.moveable(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX1 - 10 , 
									AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY1 , 0)){
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX1 
								= AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX1 - 10;
							}else {
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD1 = 0;
							}
						}else {
							AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD1 = 0;
						}
					}else if (str[1].equals("d")){
						//向右移动
						if(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD1 == 2 
								&& AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX1 < 560){
							if(BadTankData.moveable(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX1 + 10 , 
									AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY1 , 2)){
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX1 
								= AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX1 + 10;
							}else {
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD1 = 2;
							}
						}else {
							AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD1 = 2;
						}
						
					}else if (str[1].equals("w")){
						//向上移动
						if(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD1 == 3 
								&& AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY1 > 20){
							if(BadTankData.moveable(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX1 ,
									AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY1 - 10, 3)){
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY1 
								= AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY1 - 10;
							}else{
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD1 = 3;

							}
						}else {
							AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD1 = 3;
						}
						
					}else if (str[1].equals("s")){
						//向下移动
						if(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD1 == 1 
								&& AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY1 < 560){
							if(BadTankData.moveable(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX1,
									AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY1  + 10  , 1)){
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY1 
								= AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY1 + 10;
							}else {
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD1 = 1;
							}
						}else {
							AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD1 = 1;
						}
					}else if (str[1].equals("k")){
						//开火
						AcceptClientThread.gameList.get(Integer.parseInt(str[2]))
						.bulletList.add(
								new Bullet(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX1, 
										AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY1,
										AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD1,1));
						
					}else if (str[1].equals("online")){
						//在线
						AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankL1 = 1;
					}else if (str[1].equals("noOnline")){
						//在线
						AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankL1 = 0;
					}
				}else if(str[0].equals("Client2")){
					//客户端2发来消息
					if(str[1].equals("a")){
						//向左移动
						if(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD2 == 0 
								&& AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX2 > 0){
							if(BadTankData.moveable(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX2 - 10, 
									AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY2, 0)){
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX2 = 
										AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX2 - 10;
							}else {
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD2 = 0;
							}
						}else {
							AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD2 = 0;
						}

					}else if (str[1].equals("d")){
						//向右移动
						if(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD2 == 2 
								&& AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX2 < 560){
							if(BadTankData.moveable(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX2 + 10, 
									AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY2, 2)){
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX2 
								= AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX2 + 10;
							}else {
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD2 = 2;
							}
						}else {
							AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD2 = 2;
						}
						
					}else if (str[1].equals("w")){
						
						//向上移动
						if(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD2 == 3 
								&& AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY2 > 20){
							if(BadTankData.moveable(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX2, 
									AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY2 - 10, 3)){
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY2 = 
										AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY2 - 10;
							}else {
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD2 = 3;
							}
						}else {
							AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD2 = 3;
						}

					}else if (str[1].equals("s")){
						//向下移动
						if(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD2 == 1 
								&& AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY2 < 560){
							if(BadTankData.moveable(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX2, 
									AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY2 + 10, 1)){
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY2 
								= AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY2 + 10;
							}else {
								AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD2 = 1;
							}
						}else {
							AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD2 = 1;
						}

						
					}else if (str[1].equals("k")){
						//开火
						AcceptClientThread.gameList.get(Integer.parseInt(str[2])).bulletList.add(
								new Bullet(AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankX2, 
										AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankY2,
										AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankD2,1));
						
					}else if (str[1].equals("online")){
						//在线
						AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankL2 = 1;
						
					}else if (str[1].equals("noOnline")){
						//在线
						AcceptClientThread.gameList.get(Integer.parseInt(str[2])).friendtankL2 = 0;
					}
					
				}else if(str[0].equals("perishX")){
					
					if (str[1].equals("1")){
						//BadTabk1 is died
						AcceptClientThread.gameList.get(
								Integer.parseInt(str[2])).btd.tankL1 = false;
					}else if(str[1].equals("2")){
						//BadTabk2 is died
						AcceptClientThread.gameList.get(
								Integer.parseInt(str[2])).btd.tankL2 = false;
					}else if(str[1].equals("3")){
						//BadTabk3 is died
						AcceptClientThread.gameList.get(
								Integer.parseInt(str[2])).btd.tankL3 = false;
					}else if(str[1].equals("4")){
						//BadTabk4 is died
						AcceptClientThread.gameList.get(
								Integer.parseInt(str[2])).btd.tankL4 = false;
					}
				}else if(str[0].equals("map")){
					Map.map1[Integer.parseInt(str[1])]
							[Integer.parseInt(str[2])] = 0;
					
				}
			} catch (IOException e) {
				//e.printStackTrace();
				AcceptClientThread.clientList.remove(socket);
				try {
					br.close();
					socket.close();
					break;
				} catch (IOException e1) {
					//e1.printStackTrace();
				}
			}
			
			
		}
		
	}
}

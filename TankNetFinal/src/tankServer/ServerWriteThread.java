package tankServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class ServerWriteThread extends Thread{
	Vector<Socket> clientList;

	static ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	//static ArrayList<BadTankData> badTankL = new ArrayList<BadTankData>();


	int count = 0;

	int j=10;
	public ServerWriteThread(Vector<Socket> clientList) {
		this.clientList = clientList;
	}
	@Override
	public void run() {
		while (true) {
			while (true){
				try {
					sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//发送敌方坦克的位置信息
				count++;
				//遍历所有游戏
				for (int i = 0; i < AcceptClientThread.gameList.size(); i++) {
					sendMsgToFriend(AcceptClientThread.gameList.get(i).gameNum ,
							"friendTank"+","
									+AcceptClientThread.gameList.get(i).friendtankX1+","
									+AcceptClientThread.gameList.get(i).friendtankY1+","
									+AcceptClientThread.gameList.get(i).friendtankX2+","
									+AcceptClientThread.gameList.get(i).friendtankY2+","
									+AcceptClientThread.gameList.get(i).friendtankD1+","
									+AcceptClientThread.gameList.get(i).friendtankD2);

					sendMsgToFriend(AcceptClientThread.gameList.get(i).gameNum,
							"online"+"," +AcceptClientThread.gameList.get(i).friendtankL1+","
									+AcceptClientThread.gameList.get(i).friendtankL2);



					for (int j = 0; j < AcceptClientThread.gameList.get(i).bulletList.size(); j++) {

						try {
							sendMsgToFriend(AcceptClientThread.gameList.get(i).gameNum,
									"bullet"+","
											+AcceptClientThread.gameList.get(i).bulletList.get(j).bulletX+","
											+AcceptClientThread.gameList.get(i).bulletList.get(j).bulletY+","
											+AcceptClientThread.gameList.get(i).bulletList.get(j).bulletD+","
											+AcceptClientThread.gameList.get(i).bulletList.get(j).good);
						} catch (Exception e) {
							System.out.println("子弹异常");

						}

					}
					AcceptClientThread.gameList.get(i).bulletList.clear();

					if(count > 60){
						for (int j = 0; j < AcceptClientThread.gameList.size(); j++) {
							AcceptClientThread.gameList.get(j).btd.sendMsg();
							count = 0;
						}
					}

				}			
			

		}
	}
}

public  void sendMsgToFriend(int gameNum,String str) {
	socket = AcceptClientThread.gameList.get(gameNum).player1;
	if(!socket.isClosed()){
		try {
			pw = new PrintWriter(socket.getOutputStream());
			pw.println(str);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	socket = AcceptClientThread.gameList.get(gameNum).player2;
	if(socket != null && !socket.isClosed()){
		try {
			pw = new PrintWriter(socket.getOutputStream());
			pw.println(str);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

Socket socket;
PrintWriter pw;
public  void sendMsgToClient(String str) {

	for (Iterator<Socket> iterator = clientList.iterator();iterator.hasNext();) {
		socket = iterator.next();

		try {
			pw = new PrintWriter(socket.getOutputStream());
			pw.println(str);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
//	}

}

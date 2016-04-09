package tankServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class AcceptClientThread extends Thread{
	ServerSocket ss;

	public static Vector<Socket> clientList = new Vector<Socket>();

	boolean added;

	static Socket socket = null;
	int gameNum = 1;

	static ArrayList<Game> gameList = new ArrayList<Game>();

	PrintWriter pw;

	public AcceptClientThread(ServerSocket ss) {
		this.ss = ss;
	}
	@Override
	public void run() {
		while (true) {
			try {
				socket = ss.accept();

				clientList.add(socket);

				addGame();

				sendGameNum();

				ServerReaderThread srt = new ServerReaderThread(socket);
				srt.start();

				ServerWriteThread swt = new ServerWriteThread(clientList);
				swt.start();

			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	}

	public void sendGameNum() {
		for (int i = 0; i < AcceptClientThread.gameList.size(); i++) {
			if(!AcceptClientThread.gameList.get(i).player1.isClosed()){
				socket = AcceptClientThread.gameList.get(i).player1;
				try {
					pw = new PrintWriter(socket.getOutputStream());
					pw.println("gameNum"+","+AcceptClientThread.gameList.get(i).gameNum);
					pw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if(AcceptClientThread.gameList.get(i).player2 != null
					&& !AcceptClientThread.gameList.get(i).player2.isClosed()){
				socket = AcceptClientThread.gameList.get(i).player2;
				try {
					pw = new PrintWriter(socket.getOutputStream());
					pw.println("gameNum"+","+AcceptClientThread.gameList.get(i).gameNum);
					pw.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void addGame() {
		
		added = false;

		if(gameList.size() > 0){
		for (int i = 0; i < gameList.size(); i++) {
			if (!gameList.get(i).filled) {
				gameList.get(i).player2 = socket;
				gameList.get(i).filled = true;
				added = true;
			}
		}
		}

		if(!added){
			gameList.add(new Game(gameList.size(), new Map(),
					new BadTankData(gameList.size()), socket, null, false));
		}

	}

}

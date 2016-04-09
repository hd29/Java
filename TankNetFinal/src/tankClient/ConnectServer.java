package tankClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectServer {
	
	Socket socket = new Socket("localhost",12345) ;
	PrintWriter pw = new PrintWriter(socket.getOutputStream());
	
	boolean perishX1 = false;
	boolean perishX2 = false;
	boolean perishX3 = false;
	boolean perishX4 = false;
	
	boolean sended1 = false;
	boolean sended2 = false;
	boolean sended3 = false;
	boolean sended4 = false;
	boolean mySended1 = false;
	boolean mySended2 = false;
	
	static boolean new1 = true;
	static boolean new2 = true;
	static boolean new3 = true;
	static boolean new4 = true;
	static boolean myNew1 = true;
	static boolean myNew2 = true;
	
	public ConnectServer() throws UnknownHostException, IOException {
		
		ClientReaderThread crt = new ClientReaderThread(socket);
		crt.start();	
		
		selectClient();
		
		}
	
	public void readFromServer() {
		ClientReaderThread crt = new ClientReaderThread(socket);
		crt.start();	
	}

	public void selectClient() throws UnknownHostException, IOException {
		
//		TankClient.IP = socket.getInetAddress();
		TankClient.IP = socket.getLocalAddress();
		TankClient.port = socket.getLocalPort();
		
		if(socket.getLocalPort()%2 == 1){
			MyTank.myTankX = "Client1";
			MyTank.myTankL = true;
			
			pw.println("Client1" + "," + "online"
					+ "," + TankClient.gameNum);
			pw.flush();
		}else{ 
			MyTank.myTankX = "Client2";
			MyTank.myFriendTankL = true;
			//sendToServer("online");
			//System.out.println(2222);
			
			pw.println("Client2" + "," + "online"
					+ "," + TankClient.gameNum);
			pw.flush();
		}
	
	}
	
	public void sendToServer(String com) {
		
		pw.println(MyTank.myTankX + "," + com + "," 
		+ TankClient.gameNum);
		pw.flush();
	}
	
	public void sendBadTanKState() {
		
		if(myNew1){
			mySended1 = false;
			myNew1 = false;
		}
		
		if(myNew2){
			mySended2 = false;
			myNew2 = false;
		}
		
		if(!MyTank.myTankL && !mySended1){
			pw.println("Client1"+ "," + "noOnline"
					 + "," + TankClient.gameNum);
			pw.flush();
			mySended1 = true;
		}
		if(!MyTank.myFriendTankL && !mySended2){
			pw.println("Client2"+ "," + "noOnline"
					+ "," + TankClient.gameNum);
			pw.flush();
			mySended2 = true;
		}

		
		if(new1){
			sended1 = false;
			new1 = false;
		}
		
		if(new2){
			sended2 = false;
			new2 = false;
		}
		
		if(new3){
			sended3 = false;
			new3 = false;
		}
		
		if(new4){
			sended4 = false;
			new4 = false;
		}
		
		
		if(BadTank.tankL1){
			perishX1 = false;
		}else{
			perishX1 = true;
		}
		
		if(BadTank.tankL2){
			perishX2 = false;
		}else{
			perishX2 = true;
		}
		
		if(BadTank.tankL3){
			perishX3 = false;
		}else{
			perishX3 = true;
		}
		
		if(BadTank.tankL4){
			perishX4 = false;
		}else{
			perishX4 = true;
		}
		
		
		if(perishX1 && !sended1){
			pw.println("perishX"+ "," + "1"
					+ "," + TankClient.gameNum);
			pw.flush();
			sended1 = true;
		}
		
		if(perishX2 && !sended2){
			pw.println("perishX"+ "," + 2
					+ "," + TankClient.gameNum);
			pw.flush();
			sended2 =true;
		}
		
		if(perishX3 && !sended3){
			pw.println("perishX"+ "," + "3"
					+ "," + TankClient.gameNum);
			pw.flush();
			sended3 =true;
		}
		
		if(perishX4 && !sended4){
			pw.println("perishX"+ "," + 4
					+ "," + TankClient.gameNum);
			pw.flush();
			sended4 =true;
		}
		sendMap();
	}
	
	public void sendMap() {
		if(BulletC.mapChangedL.size() > 0){
			for (int i = 0; i < BulletC.mapChangedL.size(); i++) {
				pw.println("map"+ "," + BulletC.mapChangedL.get(i).mapX
						+ ","+ BulletC.mapChangedL.get(i).mapY
						+ "," + TankClient.gameNum);
				pw.flush();
			}
			BulletC.mapChangedL.clear();
		}
	}
}

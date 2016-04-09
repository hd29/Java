package tankClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ClientReaderThread extends Thread {
	Socket socket;
    Scanner sc = new Scanner(System.in);
	public ClientReaderThread(Socket socket) {
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
				 if(str[0].equals("gameNum")){
					 TankClient.gameNum = Integer.parseInt(str[1]);
				 }
				 
				 if(str[0].equals("badTank")){
					 BadTank.tankX1 = Integer.parseInt(str[1]);
					 BadTank.tankY1 = Integer.parseInt(str[2]);
					 BadTank.tankR1 = Integer.parseInt(str[3]);
					 BadTank.tankX2 = Integer.parseInt(str[4]);
					 BadTank.tankY2 = Integer.parseInt(str[5]);
					 BadTank.tankR2 = Integer.parseInt(str[6]);
					 BadTank.tankX3 = Integer.parseInt(str[7]);
					 BadTank.tankY3 = Integer.parseInt(str[8]);
					 BadTank.tankR3 = Integer.parseInt(str[9]);
					 BadTank.tankX4 = Integer.parseInt(str[10]);
					 BadTank.tankY4 = Integer.parseInt(str[11]);
					 BadTank.tankR4 = Integer.parseInt(str[12]);
					
					 if(str[13].equals("false")){
						 BadTank.tankL1 = false;
					 }else {
						 BadTank.tankL1 = true;
						 ConnectServer.new1 = true;
					 } 
					
					 if(str[14].equals("false")){
						 BadTank.tankL2 = false;
					 }else{
						 BadTank.tankL2 = true;
						 ConnectServer.new2 = true;
					 }
						 
					 if(str[15].equals("false")){
						 BadTank.tankL3 = false;
					 }else{ 
						 BadTank.tankL3 = true;
						 ConnectServer.new3 = true;
					 }
					
					 if(str[16].equals("false")){
						 BadTank.tankL4 = false;
					 }else{ 
						 BadTank.tankL4 = true;
						 ConnectServer.new4 = true; 
					 }
					 TankClient.totle = Integer.parseInt(str[17]);
					 
				 }else if(str[0].equals("friendTank")){
					 MyTank.myTankLocatX = Integer.parseInt(str[1]); 
					 MyTank.myTankLocatY = Integer.parseInt(str[2]);
					 MyTank.myFriendTankX = Integer.parseInt(str[3]);
					 MyTank.myFriendTankY = Integer.parseInt(str[4]);
					 MyTank.myTankLocatD = Integer.parseInt(str[5]);
					 MyTank.myFriendTankD = Integer.parseInt(str[6]);
				 }else if(str[0].equals("bullet")){

					 BulletC.bulletCList.add(new BulletCDate(Integer.parseInt(str[1]), 
							 Integer.parseInt(str[2]), 
							 Integer.parseInt(str[3]),
							 Integer.parseInt(str[4])));
				}else if(str[0].equals("online")){
					
					if(Integer.parseInt(str[1]) == 0){
						MyTank.myTankL = false;
						ConnectServer.myNew1 = true; 
					 }else{ 
						 MyTank.myTankL = true;
					 }
					
					if(Integer.parseInt(str[2]) == 0){
						MyTank.myFriendTankL = false;
						ConnectServer.myNew2 = true; 
					}else{ 
						MyTank.myFriendTankL = true;
					}
					
				}
				 
			} catch (IOException e) {
				//e.printStackTrace();
				
			}
			
			
		}
		
	}
}

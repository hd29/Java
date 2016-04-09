package tankServer;

import java.io.IOException;
import java.net.ServerSocket;

public class TankInfo {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(12345);

		AcceptClientThread act = new AcceptClientThread(ss);
		act.start();

//		ServerWriteThread swt = new ServerWriteThread(clientList);
//		swt.start();
	}


}

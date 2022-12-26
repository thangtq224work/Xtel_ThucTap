package javacoreAdvance.network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.UUID;

public class socketClient {
	public static void main(String[] args) {
		try {

			while (true) {
				Socket socket = new Socket();
				socket.connect(new InetSocketAddress("localhost", 2022), 500);
				DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
				System.err.println("Send : ");
				dataOutputStream.writeUTF(UUID.randomUUID().toString());
				dataOutputStream.flush();
//				if("stop".equals(new Scanner(System.in).nextLine()) || socket.isConnected()== false) {
//					dataOutputStream.close();
//					break;
//				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				socket.close();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

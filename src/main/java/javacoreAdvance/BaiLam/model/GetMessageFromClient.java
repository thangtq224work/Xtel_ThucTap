package javacoreAdvance.BaiLam.model;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class GetMessageFromClient implements Runnable {
	Socket socket;
	DataInputStream dataInputStream;

	public GetMessageFromClient(Socket socket) {
		try {
			this.socket = socket;
			dataInputStream = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {

			try {
				if (socket.isClosed()) {
					break;
				}
				String message = dataInputStream.readUTF();
				if (message.trim().equals("quit")) {
					System.err.println("Client da ket thuc cuoc hoi thoai");
					break;
				}
				System.out.println("Client say : " + message);

			} catch (Exception e) {
				break;
			}

		}
		try {
			dataInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

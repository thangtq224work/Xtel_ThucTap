package javacoreAdvance.BaiLam.model;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class GetMessageFromServer implements Runnable {
	Socket socket;
	DataInputStream dataInputStream;
	public boolean stop = false;

	public GetMessageFromServer(Socket socket) {

		this.socket = socket;
		try {
			dataInputStream = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		while (!stop) {

			try {
				if (socket.isClosed()) {
					break;
				}
				String message = dataInputStream.readUTF();
				System.out.println("Server say : " + message);
			} catch (Exception e) {
				break;
			}
		}
		try {
			dataInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

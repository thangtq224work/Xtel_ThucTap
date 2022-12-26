package javacoreAdvance.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class socketServer {
	public static void main(String[] args) {
		boolean check = true;
		try {
			ServerSocket server = new ServerSocket(2022);
			server.setSoTimeout(1000);// chỉ định sau khoảng thời gian nếu không có dữ liệu sẽ ném lỗi
			while (check) {
				Socket socket = server.accept();
				System.err.println(socket != null);
				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
				DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
				System.out.println("Client : " + dataInputStream.readUTF());
				dataInputStream.close();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

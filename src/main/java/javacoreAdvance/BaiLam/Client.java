package javacoreAdvance.BaiLam;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javacoreAdvance.BaiLam.model.GetMessageFromServer;
import javacoreAdvance.BaiLam.model.MyConfig;

public class Client {
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger();
		MyConfig config = new MyConfig();
		Socket socket = null;
		try {

			System.err.println("Nhap 'quit' de ket thuc");
			socket = new Socket();
//			socket.c
			socket.connect(new InetSocketAddress(config.getIp(), config.getPort()), config.getConnectionTimeOut());
			GetMessageFromServer fromClient = new GetMessageFromServer(socket);
			new Thread(fromClient).start();
			Scanner sc = new Scanner(System.in);
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			while (true) {
				String response = sc.nextLine();

				if (socket.isConnected()) {

					if (!response.trim().isBlank()) {
						try {
							dataOutputStream.writeUTF(response);
							dataOutputStream.flush();
							if (response.trim().equals("quit")) {
								break;
							}
						} catch (Exception e) {
							System.err.println("Server ket thuc cuoc hoi thoai");
							logger.info("ket thuc cuoc hoi thoai");
							break;
						}
					}
				}
			}
			fromClient.stop = true;
			dataOutputStream.close();
		} catch (IOException e) {
			logger.error(e.toString());
			System.err.println("Ket noi that bai");

		} finally {

			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}
}

package javacoreAdvance.BaiLam;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javacoreAdvance.BaiLam.model.GetMessageFromClient;
import javacoreAdvance.BaiLam.model.MyConfig;

public class Server {
	public static void main(String[] args) {

		Logger logger = LogManager.getLogger();
		MyConfig config = new MyConfig();

		try {
			ServerSocket server = new ServerSocket(config.getPort());
			System.err.println("Server dang cho ket noi");
			Socket socket = server.accept();
			server.setSoTimeout(config.getReceiveTimeOut());
			System.err.println("Da ket noi voi client");
			new Thread(new GetMessageFromClient(socket)).start();
			Scanner sc = new Scanner(System.in);
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			while (true) {

				String response = sc.nextLine();

				if (!response.trim().isBlank()) {
					try {
						dataOutputStream.writeUTF(response);
						dataOutputStream.flush();
					} catch (Exception e) {
						break;
					}
				}
			}
			sc.close();
			server.close();
		} catch (IOException e) {
			logger.error(e.toString());
		}

	}
}

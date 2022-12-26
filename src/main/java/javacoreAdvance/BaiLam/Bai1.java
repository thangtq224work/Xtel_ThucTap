package javacoreAdvance.BaiLam;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javacoreAdvance.BaiLam.model.MyThread;

public class Bai1 {
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger();
		Scanner sc = new Scanner(System.in);
		System.out.println("Type 'stop' to stop program");
		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread);
		thread.start();
		if ("stop".equals(sc.nextLine())) {
			myThread.exit = true;
			try {
				myThread.getfileWriter().close();
			} catch (Exception e) {
				logger.warn(e.toString());
			}
		}
	}
}

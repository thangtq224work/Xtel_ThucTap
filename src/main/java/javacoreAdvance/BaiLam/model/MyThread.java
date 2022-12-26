package javacoreAdvance.BaiLam.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread implements Runnable {
	public boolean exit = false;
	FileWriter fileWriter = null;
	private Random random = null;
	private static Logger logger = LogManager.getLogger();

	public MyThread() {
		try {
			fileWriter = new FileWriter("bai1ad.txt", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		random = new Random();
	}

	@Override
	public void run() {
		while (!exit) {
			synchronized (this) {
				writeData(random.nextInt(0, 200));
				try {

//					Thread.currentThread().sleep(1000);
					Thread.sleep(1000);
//					this.wait(1000);
				} catch (Exception e) {
					logger.error(e.toString());
				}
			}
		}
	}

	private void writeData(int input) {
		System.err.println(input);
		try {
			fileWriter.append(input + " ");
		} catch (IOException e) {
			logger.error(e.toString());
		}

	}

	public FileWriter getfileWriter() {
		return fileWriter;
	}
}

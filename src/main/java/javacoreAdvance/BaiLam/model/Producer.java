package javacoreAdvance.BaiLam.model;

import java.util.Date;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Producer implements Runnable {
	private Queue<Message> queue;
	private Random random;
	private static Logger logger = LogManager.getLogger();
//	private int size;
//	private Thread comsumer;

	public Producer(Queue<Message> queue) {
		this.queue = queue;
		random = new Random();
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				try {
					if (queue.size() == 5) {
						System.err.println(Thread.currentThread().getName() + " : " + "queue is full");
						queue.wait();
					} else {
						Message message = new Message(random.nextInt(0, 200), UUID.randomUUID().toString(), new Date());
						queue.add(message);
						System.err.println(Thread.currentThread().getName() + " : " + message + " has created");
						queue.wait(random.nextInt(500, 5000));
						queue.notify();
					}
				} catch (InterruptedException e) {
					logger.error(e.toString());
				}
			}
//			}
		}

	}
}

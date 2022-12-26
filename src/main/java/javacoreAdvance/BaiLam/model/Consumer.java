package javacoreAdvance.BaiLam.model;

import java.util.Queue;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Consumer implements Runnable {
	private Queue<Message> queue;
	private Random random;

	private static Logger logger = LogManager.getLogger();
	public Consumer(Queue<Message> queue) {
		this.queue = queue;
		random = new Random();
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				try {
					if (queue.size() == 0) {
						System.err.println(Thread.currentThread().getName() + " : " + "queue is empty");
						queue.wait();
					} else {
						System.err.println(Thread.currentThread().getName() + " : " + "Handling : " + queue.poll());
						queue.wait(random.nextInt(500, 5000));
						queue.notify();
					}
				} catch (InterruptedException e) {
					logger.error(e.toString());
				}
			}
		}

	}
}

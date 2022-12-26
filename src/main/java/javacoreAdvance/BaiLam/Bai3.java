package javacoreAdvance.BaiLam;

import java.util.LinkedList;
import java.util.Queue;

import javacoreAdvance.BaiLam.model.Consumer;
import javacoreAdvance.BaiLam.model.Message;
import javacoreAdvance.BaiLam.model.Producer;

public class Bai3 {

	public static void main(String[] args) {
//		Queue<Message> queue = new ArrayBlockingQueue<>(5);
		Queue<Message> queue = new LinkedList<>() {
			public synchronized boolean add(Message e) {
				if (this.size() == 5) {
					return false;
				}
				this.addLast(e);
				return true;
			}

			@Override
			public synchronized int size() {
				// TODO Auto-generated method stub
				return super.size();
			}
		};
		queue.add(new Message(1, "1", null));
		queue.add(new Message(1, "1", null));
		queue.add(new Message(1, "1", null));
//		queue.add(new Message(1, "1", null));
//		queue.add(new Message(1, "1", null));
//		queue.add(new Message(1, "1", null));
//		queue.add(new Message(1, "1", null));
		// một đối tượng chạy trên nhiều luồng. -> chia sẻ tài nguyên
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		new Thread(producer, "producer 1").start();
		new Thread(producer, "producer 2").start();
		new Thread(consumer, "consumer 1").start();
	}
}

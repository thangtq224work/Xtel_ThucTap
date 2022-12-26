package javacoreAdvance;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	public static void main(String[] args) {
		int core = 3;
		int size = 5;
		long keepAlive = 20000;
		TimeUnit unit = TimeUnit.SECONDS;
		BlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(20);
		RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(core, size, keepAlive, unit, arrayBlockingQueue);
		for (int i = 0; i < 30; i++) {
			threadPoolExecutor.execute(new Run("thread" +i));
		}
		threadPoolExecutor.shutdown();
	}
}
class Run extends Thread{
	public Run(String name) {
		super(name);
	}
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(this.getName()+" : "+i);
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.err.println("Tiến trình" + this.getName() +" đã hoàn thành");
		
	}
}

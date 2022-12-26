package javacoreAdvance.BaiLam.model;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MyThreadB2 extends TimerTask {
	private Random random = null;
	private Date end;
	Timer timer = null;

	public MyThreadB2(int n, Timer timer) {
		super();
		this.timer = timer;
//		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.SECOND, n*30);
//		end = calendar.getTime();
		end = new Date(new Date().getTime() + n * 1000 * 60);
		random = new Random();
	}

	@Override
	public void run() {
		System.out.println(random.nextInt(0, 200));
		if (new Date().equals(end) || new Date().after(end)) {
			timer.cancel();
			System.out.println(timer.purge());
			 // loai bo canceled tasks khoi timer's task queue
//			neu ko su dung se dc GC don dep. ->
		}
	}
}

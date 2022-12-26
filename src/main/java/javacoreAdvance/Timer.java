package javacoreAdvance;

import java.util.TimerTask;

public class Timer {
	public static void main(String[] args) {
		java.util.Timer timer = new java.util.Timer();
		TimerTask task = new MyTask();
		timer.schedule(task, 2000, 5000);
//		timer.sc
	}
}

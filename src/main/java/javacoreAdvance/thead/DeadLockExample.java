package javacoreAdvance.thead;

public class DeadLockExample {
	public static void main(String[] args) {
		String data1 = "thread1";
		String data2 = "thread2";

		Thread thread = new Thread() {
			@Override
			public void run() {
				// khoa data1
				synchronized (data1) {
					System.err.println(this.getName() + " looked " + data1);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.err.println("Waiting" + data2);
					synchronized (data2) {
						System.err.println(this.getName() + " looked " + data2);
					}
				}

			}
		};

		Thread thread2 = new Thread() {
			@Override
			public void run() {
				// khoa data2
				synchronized (data2) {
					System.err.println(this.getName() + ": looked " + data2);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.err.println("Waiting" + data1);
					synchronized (data1) {
						System.err.println(this.getName() + ": looked " + data1);
					}
				}

			}
		};
		thread.setName("Thread A ");
		thread2.setName("Thread B ");
		thread.start();
		thread2.start();

	}
}

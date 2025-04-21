package kh.join;

public class MyThread1 extends Thread {
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		for(long i = 0; i < 1_000_000_000L; i++) {}
		
	}
}

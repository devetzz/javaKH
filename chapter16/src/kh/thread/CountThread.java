package kh.thread;

public class CountThread extends Thread {
	@Override
	public void run() {
		String[] count = {"하나", "둘", "셋", "넷","다섯"};
		for(int i = 0; i < 5; i++) {
			System.out.println(count[i]);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

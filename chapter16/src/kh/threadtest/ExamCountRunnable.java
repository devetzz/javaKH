package kh.threadtest;

public class ExamCountRunnable implements Runnable{
	@Override
	public void run() {
		String[] count = {"원","투","쓰리","포","파이브"};
		for(int i = 0; i < 5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
			System.out.println(count[i]);
		}
	}
}

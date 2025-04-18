package kh.threadtest;

public class ExamCountThread extends Thread{
	@Override
	public void run() {
		String[] count = {"하나","둘","셋","넷","다섯"};
		for(int i = 0; i < 5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
			System.out.println(count[i]);
		}
	}
}

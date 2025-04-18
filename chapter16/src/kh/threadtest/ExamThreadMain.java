package kh.threadtest;

public class ExamThreadMain {

	public static void main(String[] args) {
		// 1단계
		ExamCountThread ct = new ExamCountThread();
		ExamCount2Thread ct2 = new ExamCount2Thread();
		
		ct.start();
//		ct2.start();
		// 2단계
		ExamCountRunnable cr = new ExamCountRunnable();
		Thread t = new Thread(cr);
		
//		t.start();

		// 3단계
		Thread t2 = new Thread(new Runnable() {
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
		});
		
//		t2.start();
		
		// 4단계
		Thread t3 = new Thread(() -> {
			String[] count = {"원","투","쓰리","포","파이브"};
			for(int i = 0; i < 5; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {}
				System.out.println(count[i]);
			}
		});
		
		t3.start();
		
	}

}

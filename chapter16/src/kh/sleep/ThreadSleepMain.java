package kh.sleep;

public class ThreadSleepMain {

	public static void main(String[] args) throws InterruptedException {
		// MyThread 의 Time_Waiting 상태 점검
		MyThread thread = new MyThread();
		thread.start();
		
		Thread.sleep(100);
		System.out.printf("thread state %s\n", thread.getState());
		
		// thread Time waiting -> 0.1초 후에 interrupt 걸어서 실행상태를 만들어보자
		thread.interrupt();
		Thread.sleep(100);
		System.out.printf("thread state %s\n", thread.getState());
		
		System.out.println("Main thread end");
	}

}

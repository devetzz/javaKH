package kh.join;

public class JoinMain {

	public static void main(String[] args) throws InterruptedException {
		// 두개 쓰레드 작동
		MyThread1 myThread1 = new MyThread1();
		MyThread2 myThread2 = new MyThread2(myThread1);
		
		myThread1.start();
		myThread2.start();
		
		Thread.sleep(100); // 메인쓰레드
		
		System.out.printf("myThread1 state %s\n", myThread1.getState());
		System.out.printf("myThread2 state %s\n", myThread2.getState());
		
		myThread2.interrupt();
		Thread.sleep(100);
		System.out.printf("myThread1 state %s\n", myThread1.getState());
		System.out.printf("myThread2 state %s\n", myThread2.getState());
				
		
		System.out.println("Main thread end");
	}

}

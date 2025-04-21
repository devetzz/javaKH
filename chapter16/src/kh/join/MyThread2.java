package kh.join;

public class MyThread2 extends Thread {
	// 변수
	MyThread1 myThread1;

	// 생성자
	public MyThread2(MyThread1 myThread1) {
		this.myThread1 = myThread1;
	}
	
	// 함수
	// MyThread1 에게 3초동안 양보 + 작업이 끝날경우 자신이 작업
	@Override
	public void run() {
		try {
			myThread1.join(3000);
		} catch (InterruptedException e) {
			System.out.println("join 중 main에서 interrupt 발생");
		}
		
		for(long i = 0; i < 1_000_000_000L; i++) {}
	}
}

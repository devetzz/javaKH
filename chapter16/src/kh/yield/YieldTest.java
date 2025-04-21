package kh.yield;

public class YieldTest {

	public static void main(String[] args) {
		// 1번방식 쓰레드 2개 생성
		MyThread thread1 = new MyThread();
		MyThread thread2 = new MyThread();
		
		// 쓰레드 이름 부여
		thread1.setName("홍길동 1번 쓰레드");
		thread2.setName("저길동 2번 쓰레드");
		
		// 독립 쓰레드, 데몬 쓰레드
		thread1.setDaemon(true);
		thread2.setDaemon(true);

		// 쓰레드1번 yield 시키고 2번만 작동
		thread1.yieldFlag = true;
		thread2.yieldFlag = false;
		
		// 쓰레드 시작
		thread1.start();
		thread2.start();
		
		// 메인 쓰레드를 6초동안 작동
		for(int i = 0; i < 6; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			thread1.yieldFlag =! thread1.yieldFlag;
			thread2.yieldFlag =! thread2.yieldFlag;
		}
		
		System.out.println("main thread end");
		
	}

}

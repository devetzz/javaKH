package kh.blocked;

public class MyBlockTest {
	// 변수
	MyClass mc = new MyClass();
	Thread t1;
	Thread t2;
	Thread t3;
	// 생성자
	
	public MyBlockTest() {
		mc = new MyClass();
		t1 = new Thread() {
			@Override
			public void run() {
				mc.syncMethod();
			}
		};
		t1.setName("1번 쓰레드");
		t2 = new Thread() {
			@Override
			public void run() {
				mc.syncMethod();
			}
		};
		t2.setName("2번 쓰레드");
		t3 = new Thread() {
			@Override
			public void run() {
				mc.syncMethod();
			}
		};
		t3.setName("3번 쓰레드");
	}
	
	// 함수
	public void startAll() {
		t1.start();
		t2.start();
		t3.start();
	}
	// 내부클래스
	class MyClass{
		public synchronized void syncMethod() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
			System.out.printf("현재 쓰레드는 누굴까? %s \n", Thread.currentThread().getName());
			System.out.printf("thread1 -> %s\n", t1.getState());
			System.out.printf("thread2 -> %s\n", t2.getState());
			System.out.printf("thread3 -> %s\n", t3.getState());
			for(long i = 0 ; i < 1_000_000_000L; i++) {}
		}
	}
	
}

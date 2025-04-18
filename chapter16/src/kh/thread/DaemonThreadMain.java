package kh.thread;

public class DaemonThreadMain {

	public static void main(String[] args) throws InterruptedException {
		// 자식쓰레드 1초마다 1~9까지 숫자를 카운트 한다.
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 9; i++){
					System.out.printf("Child count %d \n", i+1);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {}
				}
				System.out.println("Child end");
			}
		});

		// 자식 데몬스레드 만들기
		thread.setDaemon(true);
		thread.start();
		// 메인쓰레드 1초마다 1~5 숫자를 카운트 한다.
		for(int i = 0; i < 5; i++){
			System.out.printf("Main count %d \n", i+1);
			Thread.sleep(1000);
		}
		// 메인쓰레드 종료
		System.out.println("Main End");

	}

}

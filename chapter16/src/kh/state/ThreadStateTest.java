package kh.state;

public class ThreadStateTest {

	public static void main(String[] args) {
		// 상태도를 new, runnable, terminate 상태를 체크한다
		// Thread 는 3,4번 방식으로 진행
		
		// 변수 선언
		Thread.State state = null;
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for(long i = 0; i < 1_000_000_000L; i++) {
					
				}
			}
		});
		
		state = thread.getState();
		System.out.printf("Thread state %s\n", state);
		
		
		thread.start();
		System.out.printf("Thread state %s\n", thread.getState());
		
		// 종료상태 출력
		// 메인 쓰레드가 thread 끝날때까지 양보할게 그리고 그다음 내가 실행할게
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.out.println("thread가 종료되었음을 알려주는 인터럽트");
			e.printStackTrace();
		}
		
		
		
		System.out.printf("Thread state %s\n", thread.getState());
		// 종료
		System.out.println("End");
		
	}

}

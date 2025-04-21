package kh.yield;

// 쓰레드 1번방식
public class MyThread extends Thread {
	// 변수
	boolean yieldFlag;
	
	// 디폴트생성자
	
	// 함수
	@Override
	public void run() {
		while(true) {
			if(yieldFlag == true) {
				// 할당된 cpu 시간을 다른 쓰레드에게 양보
				Thread.yield();
			}else {
				System.out.printf("%s 쓰레드 실행 중\n", this.getName());
				for(long i = 0; i < 1_000_000_000L; i++) {
					
				}
			}
		}//while
	}//run
}

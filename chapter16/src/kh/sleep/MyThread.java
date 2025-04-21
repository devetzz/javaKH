package kh.sleep;

public class MyThread extends Thread{
	
	@Override
	public void run() {
		// 3초동안 sleep을 하고 도중에 interrupt를 걸어주면 일을 진행
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("3초동안 sleep 중에 누군가 intrerrupt를 발생시켜 깨어난 상태");
		}
		for(long i = 0; i < 1_000_000_000L; i++) {}
		
		
		System.out.printf("%s 쓰레드 종료", getName());
	}
}

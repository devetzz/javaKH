package kh.thread;

import java.awt.Toolkit;

public class MainThread {

	public static void main(String[] args) {
		// 변수 선언
		// 1단계
		SoundThread st = new SoundThread();
		CountThread ct = new CountThread();
		// 2단계
		SoundRunnable sr = new SoundRunnable();
		Thread thread = new Thread(sr);
		// 3단계 (편리성 추구 : class 설계 없이 쓰레드 구현 > 임시객체)
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Toolkit toolkit= Toolkit.getDefaultToolkit();
				for(int i = 0 ; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {}
				}
			}
		});
		// 4단계 (편리성+@ : 내용은 중요하지 않고 실행, 화살표 함수, 람다식)
		Thread thread3 = new Thread(()-> {
			Toolkit toolkit= Toolkit.getDefaultToolkit();
			for(int i = 0 ; i < 5; i++) {
				toolkit.beep();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		});
		// 5단계 (임시객체, 람다식, 부자관계)
		Runnable runnable = ()-> {
			Toolkit toolkit= Toolkit.getDefaultToolkit();
			for(int i = 0 ; i < 5; i++) {
				toolkit.beep();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		};
		Thread thread4 = new Thread(runnable);
		
		// 메인쓰레드 (주쓰레드가 할일 => main()에 코딩)
		// 숫자를 센다
//		st.start();
		ct.start();
//		thread.start();
//		thread2.start();
//		thread3.start();
		thread4.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		
		System.out.println("End");
	}

}

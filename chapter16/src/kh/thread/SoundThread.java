package kh.thread;

import java.awt.Toolkit;

// 1번 방식 쓰레드 (상속)
// 첫번째 쓰레드가 하는 일 (1초 간격으로 소리 출력)
public class SoundThread extends Thread{
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
	
	
}

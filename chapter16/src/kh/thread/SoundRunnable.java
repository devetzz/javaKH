package kh.thread;

import java.awt.Toolkit;

public class SoundRunnable implements Runnable{

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

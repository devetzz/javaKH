package kh.waiting;

public class WaitingThreadMain {

	public static void main(String[] args) {
		// DataBox 객체화
		DataBox dataBox = new DataBox();
		// 두개의 쓰레드 만들어서 DataBox 공유하며 setData, getData
		Thread t1 = new Thread() {
			public void run() {
				for(int i = 0; i < 10; i++) {
					try {
						dataBox.setData(i);
					} catch (InterruptedException e) {}
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				for(int i = 0; i < 10; i++) {
					try {
						int data = dataBox.getData();
					} catch (InterruptedException e) {}
				}
			}
		};
		
		t1.start();
		t2.start();
	}

}

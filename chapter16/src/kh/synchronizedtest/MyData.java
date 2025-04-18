package kh.synchronizedtest;

// 공유데이터를 사용하는 쓰레드는 기존값이 data에 1을 더하여 값 출력하는 기능
public class MyData {
	// 변수
	private static MyData instance = new MyData();
	private int data;

	// 생성자
	private MyData() {
		this.data = 3;
	}

	// 함수
	public static MyData getInstance() {
		return instance;
	}
	public int getData() {
		return data;
	}

	public void plusData() {
		// 블럭동기화
		synchronized(this) {
			int mydata = this.data;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			this.data = mydata + 1;
		}
	}
}

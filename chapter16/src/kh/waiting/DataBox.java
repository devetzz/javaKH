package kh.waiting;

public class DataBox {
	// 변수
	int data;
	boolean isEmpty = true;

	// 생성자
	
	// 함수(값을 입력하는 함수, 값을 출력하는 함수)
	public synchronized int getData() throws InterruptedException {
		if(isEmpty) {
			wait();
		}
		isEmpty = true;
		System.out.println("출력 데이터: " + data);
		Thread.sleep(300);
		notify();
		return data;
	}
	
	public synchronized void setData(int data) throws InterruptedException {
		if(!isEmpty) {
			wait();
		}
		isEmpty = false;
		this.data = data;
		Thread.sleep(300);
		System.out.println("입력 데이터: " + data);
		notify();
	}
	
	
}

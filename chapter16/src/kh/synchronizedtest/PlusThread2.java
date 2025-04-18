package kh.synchronizedtest;

// 1번 방식 쓰레드
// 1)공유 데이터를 갖는다. 2)공유데이터에 1을 증가시키는 함수를 콜한다. 3)증가된 값을 출력한다.
public class PlusThread2 extends Thread{
	// 변수
	private MyData myData;
	
	// 생성자
	public PlusThread2(MyData myData) {
		super();
		this.myData = myData;
	}
	
	// 함수
	@Override
	public void run() {
		// 2)
		this.myData.plusData();
		// 3)
		System.out.printf("%s 쓰레드 실행 결과 > %d 이다\n",this.getName(), this.myData.getData());
	}

}

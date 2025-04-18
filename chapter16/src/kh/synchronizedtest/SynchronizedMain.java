package kh.synchronizedtest;

public class SynchronizedMain {

	public static void main(String[] args) {
		MyData myData = MyData.getInstance();
		
		// 쓰레드를 작동시켜서 실행
		PlusThread pt1 = new PlusThread(myData);
		// 쓰레드를 한개 더 작동시켜서 실행
		PlusThread2 pt2 = new PlusThread2(myData);
		
		pt1.start();
		pt2.start();
		
		// 종료
		System.out.println("Main End");
		
	}

}

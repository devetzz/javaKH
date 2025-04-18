package kh.setpriority;

public class MainThread {

	public static void main(String[] args) {
		// 메인쓰레드 객체를 가져와서 우선순위, 이름이 무엇인지 체크해보기
		Thread mainThread = Thread.currentThread();
		System.out.printf("메인쓰레드 이름 %s\n", mainThread.getName());
		System.out.printf("메인쓰레드 우선순위 %d\n", mainThread.getPriority());
		// 두개의 쓰레드를 만든다
		// (9개는 priority 기본값을 설정하고 1개는 최우선순위를 부여한다)
		for(int i = 0; i < 10; i++) {
			MyFirstThread mt = new MyFirstThread();
//			mt.setName((i+1)+"번 동진");
			if(i == 9) {
				mt.setPriority(Thread.MAX_PRIORITY);
			}
			mt.start();
		}
		
		
		// 종료
		System.out.println("Main End");
	}

}

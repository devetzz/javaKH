package khedu.bomb;

public class Building extends Bomb {

	// 변수
	
	// 생성자
	public Building() {
		super();
	}

	
	// 함수
	public static void aaa() {
		System.out.println("Building 정적 멤버 함수 입니다.");
	}
	
	@Override
	public void explodeBomb() {
		System.out.println("빌딩이 무너집니다!");
	}
	
	
	// 내부클래스
}

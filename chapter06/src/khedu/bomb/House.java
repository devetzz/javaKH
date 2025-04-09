package khedu.bomb;

public class House extends Bomb {

	// 변수
	
	// 생성자
	public House() {
		super();
	}

	
	// 함수
	public static void aaa() {
		System.out.println("House 정적 멤버 함수 입니다.");
	}
	
	@Override
	public void explodeBomb() {
		System.out.println("집이 불타오릅니다!");
	}
	
	
	// 내부클래스
}

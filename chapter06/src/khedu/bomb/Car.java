package khedu.bomb;

public class Car extends Bomb {

	// 변수
	
	// 생성자
	public Car() {
		super();
	}

	
	// 함수
	public static void aaa() {
		System.out.println("Car 정적 멤버 함수 입니다.");
	}
	
	@Override
	public void explodeBomb() {
		System.out.println("차가 폭발합니다!");
	}
	
	
	// 내부클래스
}

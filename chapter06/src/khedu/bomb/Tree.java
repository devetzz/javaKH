package khedu.bomb;

public class Tree extends Bomb {

	// 변수
	
	// 생성자
	public Tree() {
		super();
	}

	
	// 함수
	public static void aaa() {
		System.out.println("Tree 정적 멤버 함수 입니다.");
	}
	
	@Override
	public void explodeBomb() {
		System.out.println("나무가 불타오릅니다!");
	}
	
	
	// 내부클래스
}

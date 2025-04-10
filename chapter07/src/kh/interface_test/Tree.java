package kh.interface_test;

public class Tree implements Bomb {

	// 생성자
	public Tree() {
		super();
	}

	
	@Override
	public void explodeBomb() {
		System.out.println("나무가 불타오릅니다.");
	}
	
}

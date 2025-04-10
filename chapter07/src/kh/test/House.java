package kh.test;

public class House extends Bomb {

	// 생성자
	public House() {
		super();
	}

	@Override
	public void explodeBomb() {
		System.out.println("집이 불타오릅니다.");
	}
	
}

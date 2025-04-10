package kh.interface_test;

public class Building extends Object implements Bomb {

	// Object의 생성자이다.
	public Building() {
		super();
	}


	@Override
	public void explodeBomb() {
		System.out.println("빌딩이 무너집니다.");
	}

	@Override
	public void printBrand() {
		System.out.println("빌딩의 디폴트 메소드");
	}
}

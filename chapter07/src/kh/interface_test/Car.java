package kh.interface_test;

public class Car implements Bomb {

	
	public Car() {
		super();
	}

	@Override
	public void explodeBomb() {
		System.out.println("차가 폭발했습니다.");
	}

	@Override
	public void printBrand() {
		System.out.println("차의 디폴트 메소드");
	}

}

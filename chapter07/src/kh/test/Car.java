package kh.test;

public class Car extends Bomb {

	
	public Car() {
		super();
	}

	@Override
	public void explodeBomb() {
		System.out.println("차가 폭발했습니다.");
	}

}

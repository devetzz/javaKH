package kh.test;

public class Building extends Bomb {

	public Building() {
		super();
	}

	@Override
	public void explodeBomb() {
		System.out.println("건물이 무너집니다.");
	}

}

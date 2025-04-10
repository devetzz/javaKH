package kh.interface_test;

public interface Bomb {
	// 추상 메소드
	public abstract void explodeBomb();
	
	public default void printBrand() {
		System.out.println("Bomb default Method");
	}
	
}

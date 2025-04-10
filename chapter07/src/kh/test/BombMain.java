package kh.test;

public class BombMain {

	public static void main(String[] args) {
		// 객체 배열
		Bomb[] bArray = new Bomb[4];
		// upCasting (다형성 구현을 위해 사용)
		bArray[0] = new Building();
		bArray[1] = new Car();
		bArray[2] = new Tree();
		bArray[3] = new House();
		
		for(int i = 0; i < bArray.length; i++) {
			bArray[i].explodeBomb();
		}
		
		
		// 종료
		System.out.println("End");
		
	}

}

package khedu.c_class;

// 부모
public class Car extends Object {
	// 멤버 변수
	public int speed;
	
	// 생성자
	public Car() {
		this(0);
	}

	public Car(int speed) {
		super();
		this.speed = speed;
	}

	
	// 멤버 함수
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public static void aaa() {
		
	}
}
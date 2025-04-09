package khedu.c_class;

public class ElectricCar extends Car {
	// 멤버 변수
	private int battery;
	
	// 생성자
	public ElectricCar() {
		this(0,0);
	}
	
	public ElectricCar(int battery, int speed) {
		super(speed);
		this.battery = battery;
	}
	
	public void PrintFunc() {
		System.out.printf("자식영역에서 부모 speed = %d\n",speed);
		System.out.printf("자식영역에서 부모 speed = %d\n",this.getSpeed());
		Car.aaa();
	}

	// 멤버 함수
	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}
	
}

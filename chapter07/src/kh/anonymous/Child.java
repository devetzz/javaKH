package kh.anonymous;

//인터페이스 => 상속(자녀 클래스) => 오버라이딩 => 다형성 구현
public class Child implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("자식이 turnOn 했습니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("자식이 turnOff 했습니다.");
	}

}

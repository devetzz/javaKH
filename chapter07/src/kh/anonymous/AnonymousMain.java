package kh.anonymous;

public class AnonymousMain {

	public static void main(String[] args) {
		// 인터페이스 => 상속(자녀 클래스) => 오버라이딩 => 다형성 구현
		// 부자 관계
		RemoteControl rc = new Child();
		// 다형성 구현
		rc.turnOn();
		rc.turnOff();
		
		// 임시(자녀) 객체(익명 클래스) : 다형성 구현 (자녀 클래스 없이, 부자 관계 없이)
		RemoteControl rc2 = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("임시 객체가 turnOn 했습니다.");
			}
			
			@Override
			public void turnOff() {
				System.out.println("임시 객체가 turnOff 했습니다.");
			}
		};

		rc2.turnOn();
		rc2.turnOff();
		
		
		// 종료
		System.out.println("End");
	}

}

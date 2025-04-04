package kr.khedu.c_class;

public class Single extends Object {
	// 멤버 변수(정적 변수, 인스턴스 변수)
	private static Single single = new Single();
	
	// 생성자
	private Single() {}
	
	// 멤버 함수(정적 함수, 인스턴스 함수)
	public static Single getSingle() {
		return single;
	}
/*
	@Override
	public String toString() {
		return "ToString 오버라이딩 한거야";
	}
	*/
		
}

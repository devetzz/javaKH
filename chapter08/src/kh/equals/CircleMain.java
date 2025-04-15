package kh.equals;

public class CircleMain {

	public static void main(String[] args) {
		// Circle 객체의 주소값 출력
		Circle circle1 = new Circle(10.0f, "Black1");
		Circle circle2 = new Circle(10.1f, "Black2");
		// Circle 객체 2개를 비교 (==, equals)
		System.out.printf("%s\n", circle1==circle2);
		System.out.printf("%s\n", circle1.equals(circle2));
		
		
	}

}

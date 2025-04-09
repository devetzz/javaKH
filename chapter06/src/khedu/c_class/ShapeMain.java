package khedu.c_class;

public class ShapeMain {

	public static void main(String[] args) {
		Circle circle = new Circle(10);
		
		// upCasting
		Shape shape2 = circle;	// 자식의 영역에 부모의 영역도 포함되어 있기 때문에 가능
		shape2.draw();	// 오버라이딩이 되어 있어서 자식이 선언한 함수 호출
		shape2.draw2();	// 오버라이딩이 되어 있지 않아 자신의 함수 호출
		
		Shape shape3 = new Shape(0);
		
		// downCasting
		if(shape2 instanceof Circle) {
			Circle circle2 = (Circle) shape2;
			circle2.drawPrint();
		}
		
		if(shape3 instanceof Circle) {
			Circle circle3 = (Circle)shape3;
			circle3.drawPrint();
		}
	}

}

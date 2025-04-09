package khedu.c_class;

public class Circle extends Shape {

	// 멤버 변수
	
	// 생성자
	public Circle(int no) {
		super(no);
	}
	
	
	// 멤버 함수
	@Override
	public void draw() {
		System.out.println("Circle draw");
	}
	public void drawPrint() {
		super.draw();
	}
}

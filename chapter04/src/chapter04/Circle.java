package chapter04;

public class Circle extends Object{
	// 멤버 변수(반지름, 색상, 원주율)
	private double radius;
	private String color;
	public static final double PI = 3.141592;
	
	// 반지름 저장
	public boolean setRadius(double radius) {
		if(radius <= 0.0 || radius >= 100.0) {
			System.out.println("정신차려!");
			return false;
		}
		this.radius = radius;
		return true;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}


	// 멤버 함수(원의 면적)
	public double getArea() {
		double area = PI * Math.pow(radius, 2.0);
		return area;
	}
	
}

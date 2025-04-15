package kh.equals;

public class Circle {
	// 변수 (반지름, 원주율, 선색상)
	private double radius;
	public static final float PI = 3.141592F;
	private String color;
	
	// 생성자
	public Circle() {
		this(0.0, null);
	}
	public Circle(double radius, String color) {
		super();
		this.radius = radius;
		this.color = color;
	}

	// 멤버함수
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	// 오버라이딩
	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Circle)) {
			return false;
		}
		Circle circle = (Circle)obj;
		
		return this.radius == circle.radius;
	}
	
}

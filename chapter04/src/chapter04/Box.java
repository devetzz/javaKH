package chapter04;

public class Box {
	// 멤버 변수(캡슐화)
	private int width;
	private int height;
	private int length;
	
	
	// 멤버 함수
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	// 출력 함수
	@Override
	public String toString() {
		return "Box [width=" + width + ", height=" + height + ", length=" + length + "]";
	}
}

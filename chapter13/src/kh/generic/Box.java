package kh.generic;

public class Box<T> {
	// 변수
	private T object;
	
	// 생성자
	public Box() {
		this(null);
	}
	public Box(T object) {
		super();
		this.object = object;
	}
	
	// 함수
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	
}

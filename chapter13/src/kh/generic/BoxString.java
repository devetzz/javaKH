package kh.generic;

public class BoxString {
	// 변수
	private String name;
	
	// 생성자
	public BoxString() {
		this(null);
	}
	public BoxString(String name) {
		super();
		this.name = name;
	}
	
	// 함수
	public String getAge() {
		return name;
	}
	public void setAge(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "BoxString [name=" + name + "]";
	}
	
	
	
}

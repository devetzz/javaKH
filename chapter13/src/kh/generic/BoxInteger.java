package kh.generic;

public class BoxInteger {
	// 변수
	private Integer age;
	
	// 생성자
	public BoxInteger() {
		this(0);
	}
	public BoxInteger(Integer age) {
		super();
		this.age = age;
	}
	
	// 함수
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "BoxInteger [age=" + age + "]";
	}
	
	
	
}

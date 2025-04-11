package kh.phone06step;

public class Phone extends Object{
	// 멤버 변수
	private String name;
	private String phoneNum;
	
	// 생성자
	public Phone() {
		this(null, null);
	}

	public Phone(String name, String phoneNum) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
	}

	// 멤버 함수
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "name=" + name + ", phoneNum=" + phoneNum;
	}
	
}

package kh.phone07step;

public class Phone extends Object{
	// 멤버 변수
	private int type;
	private String name;
	private String phoneNum;
	

	// 생성자
	public Phone() {
		this(null, null);
	}

	public Phone(String name, String phoneNum) {
		this(0, name, phoneNum);
	}
	public Phone(int type, String name, String phoneNum) {
		super();
		this.type = type;
		this.name = name;
		this.phoneNum = phoneNum;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
		return "Phone [type=" + type + ", name=" + name + ", phoneNum=" + phoneNum + "]";
	}

	
}

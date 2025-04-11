package kh.phone04step;

public class PhoneInfo extends Object{
	// 멤버 변수
	private String name;
	private String phoneNum;
	private int age;
	private char gender;
	
	// 생성자
	public PhoneInfo() {
		this(null, null, 0, '\0');
	}

	public PhoneInfo(String name, String phoneNum, int age, char gender) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.age = age;
		this.gender = gender;
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
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "PhoneInfo [name=" + name + ", phoneNum=" + phoneNum + ", age=" + age + ", gender=" + gender + "]";
	}
}

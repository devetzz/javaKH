package kh.phone07step;

public class PhoneInfo extends Phone{
	// 멤버 변수
	private int age;
	private char gender;
	
	// 생성자
	public PhoneInfo() {
		this(null, null, 0, '\0');
	}

	public PhoneInfo(String name, String phoneNum, int age, char gender) {
		super(name, phoneNum);
		this.age = age;
		this.gender = gender;
	}

	// 멤버 함수
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
		return "PhoneInfo [name=" + this.getName() + ", phoneNum=" + this.getPhoneNum() + ", age=" + age + ", gender=" + gender + "]";
	}
}

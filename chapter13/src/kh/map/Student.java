package kh.map;

public class Student {
	// 변수
	private int no;
	private String phone;
	// 생성자
	public Student() {
		this(0, null);
	}
	public Student(int no, String phone) {
		super();
		this.no = no;
		this.phone = phone;
	}
	// 함수
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Student [no=" + no + ", phone=" + phone + "]";
	}
	// 내부클래스
	
}

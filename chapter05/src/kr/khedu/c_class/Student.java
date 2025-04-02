package kr.khedu.c_class;

public class Student {
	// 멤버 변수(캡슐화)
	private String name;
	private int age;
	private char gender;
	private int kor;
	private int eng;
	private int total;
	private double avg;
	private String grade;
	
	// 생성자(오버로딩)
	// 디폴트 생성자
	public Student() {
		this(null,0,'\0',0,0);
	}
	// 메서드 생성자
	public Student(String name, int age, char gender, int kor, int eng) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.kor = kor;
		this.eng = eng;
	}
	
	// 멤버 함수
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	// 출력 함수(멤버변수 출력하는 기능)
	@Override
	public String toString() {
		return "Student [이름 : " + name + ", 나이 : " + age + ", 성별 : " + gender + ", 국어 : " + kor + ", 영어 : " + eng
				+ ", 총합 : " + total + ", 평균 : " + avg + ", 등급 : " + grade + "]";
	}
	
}

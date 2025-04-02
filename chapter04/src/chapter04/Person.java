package chapter04;

public class Person extends Object {
	// 멤버 변수(캡슐화) : 계정, 이름, 나이, 성별
	private String id;
	private String name;
	private int age;
	private char gender;

	// 생성자 함수 (디폴트생성자, 메소드생성자)
	public Person() {
		this(null, null, 0, '\0');
	}
	
	public Person(String id, String name, int age, char gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	
	// 멤버 함수 (getter, setter, calculator)
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
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


	// 출력 함수
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

}

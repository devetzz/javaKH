package selftraning;

public class FilePractice {
	// 멤버 변수 (이름, 부서, 급여, 등급, 보너스포인트, 총급여)
	private String name;
	private String dept;
	private int salary;
	private char grade;
	private double bonus;
	private double total;
	
	// 생성자
	public FilePractice() {
		this(null, null, 0, '\0');
	}
	public FilePractice(String name, String dept, int salary, char grade) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.grade = grade;
	}
	
	// 멤버 함수
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	// 출력 함수
	@Override
	public String toString() {
		return "Employee [" + name + " " + dept + " " + salary + " " 
							+ grade + " " + bonus + " " + total + "]";
	}
	
	
}

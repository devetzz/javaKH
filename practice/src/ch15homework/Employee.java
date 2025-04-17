package ch15homework;

import java.util.Objects;

public class Employee implements Comparable {
	// 멤버 변수 (사번, 이름, 부서, 급여, 등급, 보너스포인트, 총급여)
	private int id;
	private String name;
	private String dept;
	private int salary;
	private char grade;
	private double bonus;
	private double total;
	
	// 생성자
	public Employee() {
		this(0, null, null, 0, '\0');
	}
	public Employee(String name, String dept, int salary, char grade) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.grade = grade;
	}
	public Employee(int id, String name, String dept, int salary, char grade) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.grade = grade;
	}
	
	// 멤버 함수
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
		return "Employee [" + id + " " + name + " " + dept + " " + salary + " " 
							+ grade + " " + bonus + " " + total + "]";
	}
	@Override
	public int compareTo(Object o) {
		// 부모 영역에 자식이 있는지 확인
		Employee emp = null;
		if(o instanceof Employee) {
			emp = (Employee)o;
		}
		if(this.total> emp.getTotal()) {
			return 1;
		}else if (this.total < emp.getTotal()) {
			return -1;
		}else {
			return 0;
		}
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Employee)) {
			return false;
		}
		Employee emp = (Employee)obj;
		return this.name.equals(emp.name);
	}
	
	
}

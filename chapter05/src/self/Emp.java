package self;

public class Emp {
	// 멈버 변수
	private String name;
	private String dept;
	private int money;
	private char grade;
	private double bonusPoint;
	private double totalMoney;
	
	// 생성자
	// 디폴트 생성자
	public Emp() {
		this(null, null, 0, '\0');
	}
	// 메서드 생성자
	public Emp(String name, String dept, int money, char grade) {
		this.name = name;
		this.dept = dept;
		this.money = money;
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
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public double getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(double bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	
	// 출력 함수
	@Override
	public String toString() {
		return "Emp [이름 : " + name + ", 부서 : " + dept + ", 급여 : " + money + ", 등급 : " + grade + ", 보너스 포인트 : "
				+ bonusPoint + ", 총급여 : " + totalMoney + "]";
	}
	
	
}

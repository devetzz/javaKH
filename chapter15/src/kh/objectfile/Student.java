package kh.objectfile;

import java.io.Serializable;

public class Student implements Serializable{
	// 변수
	private String name;
	private int num;
	// 생성자
	public Student() {
		this(null, 0);
	}
	public Student(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}
	
	// 함수
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", num=" + num + "]";
	}
	
}

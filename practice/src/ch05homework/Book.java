package ch05homework;

public class Book {
	
	// 멤버 변수
	private String bookName;
	private double bookScore;
	
	// 생성자
	public Book() {
	}

	public Book(String bookName, double bookScore) {
		this.bookName = bookName;
		this.bookScore = bookScore;
	}

	

	// 멤버 함수
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public double getBookScore() {
		return bookScore;
	}
	
	public void setBookScore(double bookScore) {
		this.bookScore = bookScore;
	}
	
	@Override
	public String toString() {
		return "책정보 [책이름 : " + bookName + ", 평점 : " + bookScore + "]";
	}
	
}

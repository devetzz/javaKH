package ch05homework;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BookMain {

	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 변수 선언
		boolean stopFlag = false;
		int no = 0;
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		
		while(!stopFlag) {
			String name = null;
			double score = 0.0;
			
			menuPrint();
			
			no = inputNo();
			
			// 반복문
			switch(no) {
			case 1:
				// 책 등록
				System.out.println("1. 책 등록");
				do {
					System.out.print("제목 : ");
					name = scan.nextLine();
					boolean isNameCheck = Pattern.matches("^[a-zA-Z|가-힣|0-9]{1,20}$", name);
					if(isNameCheck == true) {
						break;
					}
					System.out.println("올바른 제목을 입력하세요.");
				}while(true);
				
				do {
					System.out.print("평점 : ");
					score = Double.parseDouble(scan.nextLine());
					boolean isScoreCheck = Pattern.matches("^(\\d{0,1})(\\.{1}\\d{0,1})?$", String.valueOf(score));
					if(isScoreCheck == true) {
						break;
					}
					System.out.println("평점은 실수를 입력해야 합니다.");
				}while(true);
				
				Book book = new Book(name, score);
				bookList.add(book);
				
				break;
			case 2:
				// 책 검색
				System.out.print("검색할 책 이름 : ");
				String searchBook = scan.nextLine();
				boolean isSearch = false;
				// ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
				for(int i = 0; i < bookList.size(); i++) {
					if(bookList.get(i).getBookName().equals(searchBook)) {
						isSearch = true;
						System.out.println(bookList.get(i).toString());
					}
				}
				if(isSearch == false) {
					System.out.println("검색한 책이 존재하지 않습니다.");
				}
				break;
			case 3:
				// 책 출력
				for (int i = 0; i < bookList.size(); i++) {
					System.out.println(bookList.get(i).toString());
				}
				break;
			case 4:
				// 책 삭제
				System.out.print("삭제할 책 이름 : ");
				String deleteBook = scan.nextLine();
				boolean isDelete = false;
				for(int i = 0; i < bookList.size(); i++) {
					if(bookList.get(i).getBookName().equals(deleteBook)) {
						isDelete = true;
						bookList.remove(i);
					}
				}
				if (isDelete == false) {
					System.out.println("삭제할 책이 존재하지 않습니다.");
				}
				break;
			case 5:
				// 책 수정
				System.out.print("수정할 책 이름 : ");
				String modifyBook = scan.nextLine();
				boolean isModify = false;
				for(int i = 0; i < bookList.size(); i++) {
					if(bookList.get(i).getBookName().equals(modifyBook)) {
						do {
							System.out.print("수정할 제목 : ");
							name = scan.nextLine();
							boolean isNameCheck = Pattern.matches("^[a-zA-Z|가-힣|0-9]{1,20}$", name);
							if(isNameCheck == true) {
								break;
							}
							System.out.println("올바른 제목을 입력하세요.");
						}while(true);
						
						do {
							System.out.print("수정할 평점 : ");
							score = Double.parseDouble(scan.nextLine());
							boolean isScoreCheck = Pattern.matches("^(\\d{0,1})(\\.{1}\\d{0,1})?$", String.valueOf(score));
							if(isScoreCheck == true) {
								break;
							}
							System.out.println("평점은 실수를 입력해야 합니다.");
						}while(true);
						
						bookList.get(i).setBookName(name);
						bookList.get(i).setBookScore(score);
						isModify = true;
						System.out.println("수정이 완료되었습니다.");
					}
				}
				if(isModify == false) {
					System.out.println("수정할 책이 존재하지 않습니다.");
				}
				break;
			case 6:
				// 종료
				System.out.println("종료합니다.");
				stopFlag = true;
				scan.close();
				break;
			default: break;
			}
			
		}

	}

	
	private static int inputNo() {
		int choice = 0;
		do {
			System.out.print("메뉴 번호 입력 > ");
			choice = Integer.parseInt(scan.nextLine());
			boolean isChoiceCheck = Pattern.matches("^[1-6]{1}$", String.valueOf(choice));
			if(isChoiceCheck == true) {
				break;
			}
			System.out.println("메뉴를 정확히 입력하세요(1~6)");
		}while(true);
		
		return choice;
	}


	public static void menuPrint() {
		// 메뉴
		System.out.println("★★★★★★★★★ MENU ★★★★★★★★★");
		System.out.println("★ \t1. 책 입력\t ★");
		System.out.println("★ \t2. 책 검색\t ★");
		System.out.println("★ \t3. 책 출력\t ★");
		System.out.println("★ \t4. 책 삭제\t ★");
		System.out.println("★ \t5. 책 수정\t ★");
		System.out.println("★ \t6. 종료\t\t ★");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★");
	}
}

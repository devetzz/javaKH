package chapter04;

import java.util.Scanner;

public class PersonMain {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// 변수 선언
		boolean stopFlag = false;
		// 객체 생성
		Person person = new Person(null, null, 0, ' ');

		// 반복문
		while (!stopFlag) {
			menuDisplay();
			
			// 번호 선택(패턴 검색, 조건) 무한반복문
			int no = 0;
			do {
				no = Integer.parseInt(scan.nextLine());
				if(1 <= no && no <= 3) {
					break;
				}
				System.out.println("1~3번 중에 선택하세요!");
			}while(true);
			
			// 제어문 : 1. 개인 정보 입력, 2. 개인 정보 출력, 3. 종료
			switch (no) {
			case 1:
				// 입력 : 개인 정보
				String id = "gildong";
				String name = "홍길동";
				int age = 17;
				char gender = '남';
				person.setId(id);
				person.setName(name);
				person.setAge(age);
				person.setGender(gender);
				System.out.println("개인 정보 입력 완료!");
				break;
			case 2:
				// 출력 : 개인 정보
				System.out.println(person.toString());
				System.out.println(person);
				break;
			case 3:
				// 반복문 : 종료
				stopFlag = true;
				break;
			default:
				System.out.println("1~3번 번호를 선택하세요.");
				break;
			}

		}
		

		// 종료
		scan.close();
		System.out.println("End");

	}
	
	public static void menuDisplay() {
		// 입력 : 메뉴 선택
		System.out.println("★★★★★★★★★ MENU ★★★★★★★★★");
		System.out.println("★ \t1. 개인 정보 입력\t ★");
		System.out.println("★ \t2. 개인 정보 출력\t ★");
		System.out.println("★ \t3. 종료\t\t ★");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★");
		System.out.print("1~3 번호 선택 > ");
	}

}

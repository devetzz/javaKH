package chapter03;

import java.util.ArrayList;
import java.util.Scanner;

public class ExamStudentArrayList {

	public static void main(String[] args) {
		menuPrint();
		
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Integer> age = new ArrayList<Integer>();
		ArrayList<Character> gender = new ArrayList<Character>();
		ArrayList<Integer> kor = new ArrayList<Integer>();
		ArrayList<Integer> eng = new ArrayList<Integer>();
		ArrayList<Integer> total = new ArrayList<Integer>();
		ArrayList<Double> avr = new ArrayList<Double>();
		ArrayList<String> grade = new ArrayList<String>();
		
		
		Scanner scan = new Scanner(System.in);
		
		char num = 0;
		num = scan.nextLine().charAt(0);
		
		switch(num) {
		case 1: 
			// 1. 학생 입력
			while(true) {
				System.out.print("학생 이름 입력 : ");
				name.add(scan.nextLine());
				
				char yn = 0;
				System.out.print("계속(y/n) : ");
				yn = scan.nextLine().charAt(0);
				if (yn == 'n' || yn == 'N') {
					break;
				}else if(yn == 'y' || yn == 'Y') {
					continue;
				}else {
					System.out.println("y 또는 n을 입력해주세요!!");
				}
			}
			break;
		case 2: 
			break;
		case 3: 
			break;
		case 4: 
			break;
		default: 
			break;
		}
		
		// 2. 학생 출력
		for (int i = 0; i < name.size();i++) {
			System.out.printf("학생 이름 : %s\t", name.get(i));
			System.out.printf("학생 나이 : %d\t", age.get(i));
			System.out.printf("학생 성별 : %c\t", gender.get(i));
			System.out.printf("학생 국어 : %d\t", kor.get(i));
			System.out.printf("학생 영어 : %d\t", eng.get(i));
			System.out.printf("학생 총점 : %d\t", total.get(i));
			System.out.printf("학생 평균 : %.1f\t", avr.get(i));
			System.out.printf("학생 등급 : %s\n", grade.get(i));
		}
		
		// 3. 학생 계산
		for (int i = 0; i < name.size();i++) {
			
			
//			System.out.printf("학생 이름 : %s\t", name.get(i));
//			System.out.printf("학생 나이 : %d\t", age.get(i));
//			System.out.printf("학생 성별 : %c\t", gender.get(i));
//			System.out.printf("학생 국어 : %d\t", kor.get(i));
//			System.out.printf("학생 영어 : %d\t", eng.get(i));
//			System.out.printf("학생 총점 : %d\t", total.get(i));
//			System.out.printf("학생 평균 : %.1f\t", avr.get(i));
//			System.out.printf("학생 등급 : %s\n", grade.get(i));
		}
		
		// 4. 학생 검색
		
		// 5. 종료
		
		
		
		
		scan.close();

	}
	
	public static void menuPrint() {
		// 메뉴
		System.out.println("******MENU******");
		System.out.println("1. 학생입력");
		System.out.println("2. 학생출력");
		System.out.println("3. 학생계산");
		System.out.println("4. 학생검색");
		System.out.println("5. 종료");
		System.out.println("****************");
		
		System.out.print("선택(1~5) > ");
	}

}

package kr.khedu.c_class;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentArrayMain {

	public static Scanner scan = new Scanner(System.in);
	public static final int COUNT = 1;
	public static String[] menu = {"","학생입력","학생출력","학생계산","학생검색","종료"};
	public static void main(String[] args) {
		// 변수 선언
		boolean stopFlag = false;
		// 객체 배열 (학생 3명)
		Student[] stuArray = new Student[COUNT];
		
		// 반복문
		while(!stopFlag) {
			// 입력 : 메뉴 선택
			menuPrint();
			
			// 제어문 : 1. 학생 정보 입력, 2. 학생 정보 출력, 3. 학생 정보 계산, 4. 학생 정보 검색, 5. 종료 
			int no = inputNo();
			
			switch(menu[no]) {
			case "학생입력": 
				// 입력 : 3명의 정보를 받는다
				for(int i = 0; i < stuArray.length; i++) {
					System.out.printf("%d번 이름 입력 : ", i+1);
					String name = scan.nextLine();
					System.out.printf("%d번 나이 입력 : ", i+1);
					int age = Integer.parseInt(scan.nextLine());
					System.out.printf("%d번 성별 입력 : ", i+1);
					char gender  = (scan.nextLine().charAt(0));
					System.out.printf("%d번 국어 점수 입력 : ", i+1);
					int kor = Integer.parseInt(scan.nextLine());
					System.out.printf("%d번 영어 점수 입력 : ", i+1);
					int eng = Integer.parseInt(scan.nextLine());
					
					stuArray[i] = new Student(name, age, gender, kor, eng);
				}
				
				break;
			case "학생출력": 
				// 출력
				for(int i = 0; i < stuArray.length; i++) {
					System.out.println(stuArray[i].toString());
				}
				break;
			case "학생계산": 
				// 계산 : 총점, 평균, 계산
				for(int i = 0; i < stuArray.length; i++) {
					int total = stuArray[i].getKor() + stuArray[i].getEng();
					stuArray[i].setTotal(total);
					
					double avg = stuArray[i].getTotal() / 2.0;
					stuArray[i].setAvg(avg);
					
					String grade;
					if (100 >= avg && avg >= 95) {
						grade = "A+";
					} else if (95 > avg && avg >= 90) {
						grade = "A";
					} else if (90 > avg && avg >= 85) {
						grade = "B+";
					} else if (85 > avg && avg >= 80) {
						grade = "B";
					} else if (80 > avg && avg >= 75) {
						grade = "C+";
					} else if (75 > avg && avg >= 70) {
						grade = "C";
					} else if (70 > avg && avg >= 65) {
						grade = "D+";
					} else if (65 > avg && avg >= 60) {
						grade = "D";
					} else {
						grade = "F";
					}
					
					stuArray[i].setGrade(grade);
					System.out.println("점수 계산 완료");
				}
				break;
			case "학생검색": 
				// 검색
				System.out.print("검색할 학생 이름 : ");
				String searchName = scan.nextLine();
				boolean searchFlag = false;
				for(int i = 0; i < stuArray.length; i++) {
					if(stuArray[i].getName().equals(searchName)) {
						System.out.println(stuArray[i].toString());
						searchFlag = true;
					}
				}
				if (searchFlag == false) {
					System.out.printf("%s 학생은 존재하지 않습니다.\n", searchName);
				}
				break;
			case "종료": 
				// 반복문 : 종료
				stopFlag = true;
				break;
			default: 
				break;
			}
		
		
		}
		
		// 종료
		scan.close();
		System.out.println("End");
		
		
	}
	public static void menuPrint() {
		// 메뉴
		System.out.println("★★★★★★★★★ MENU ★★★★★★★★★");
		System.out.println("★ \t1. 학생입력\t ★");
		System.out.println("★ \t2. 학생출력\t ★");
		System.out.println("★ \t3. 학생계산\t ★");
		System.out.println("★ \t4. 학생검색\t ★");
		System.out.println("★ \t5. 종료\t\t ★");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★");
		
		System.out.print("선택(1~5) > ");
	}
	
	public static int inputNo() {
        int choice = 0 ;

        while (true) {
             System.out.print("메뉴 번호 입력: ");
             String input = scan.nextLine();
             boolean isInputCheck = Pattern.matches("^[1-5]$", input);
             if(isInputCheck){
                 choice = Integer.parseInt(input);
                 break;
             }
             System.out.println("유효한 번호를 입력해주세요");
        }
        return choice;
    }
}
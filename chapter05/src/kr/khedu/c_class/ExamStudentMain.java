package kr.khedu.c_class;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ExamStudentMain {
	public static final int COUNT = 2;
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// 변수선언
		boolean stopFlag = false;
		Student stuArr[] = new Student[COUNT];
		// 무한 반복
		while(!stopFlag) {
			// 메뉴 선택
			menuPrint();
			int no = inputNo();
			
			switch(no) {
			case 1:
				// 입력
				for(int i = 0; i < stuArr.length; i++) {
					System.out.print("학생 이름 입력 : ");
					String name = scan.nextLine();
					System.out.print("학생 나이 입력 : ");
					int age = Integer.parseInt(scan.nextLine());
					System.out.print("학생 성별 입력 : ");
					char gender = scan.nextLine().charAt(0);
					System.out.print("학생 국어 입력 : ");
					int kor = Integer.parseInt(scan.nextLine());
					System.out.print("학생 영어 입력 : ");
					int eng = Integer.parseInt(scan.nextLine());
					
					stuArr[i] = new Student(name, age, gender, kor, eng);
				}
				
				break;
			case 2: 
				// 출력
				for(int i = 0; i < stuArr.length; i++) {
					System.out.println(stuArr[i].toString());
				}
				break;
			case 3: 
				// 계산
				for(int i = 0; i < stuArr.length; i++) {
					stuArr[i].setTotal(stuArr[i].getKor()+stuArr[i].getEng());
					stuArr[i].setAvg(stuArr[i].getTotal() / 2.0);
					
					double avg = stuArr[i].getAvg();
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
					
					stuArr[i].setGrade(grade);
					
				}
				System.out.println("계산이 완료되었습니다.");
				break;
			case 4: 
				// 검색
				String searchName = null;
				System.out.print("검색할 학생명 입력 : ");
				searchName = scan.nextLine();
				boolean searchFlag = false;
				for(int i = 0; i < stuArr.length; i++) {
					if(stuArr[i].getName().equals(searchName) == true) {
						System.out.println(stuArr[i].toString());
						searchFlag = true;
					}
				}
				if(searchFlag == false) {
					System.out.printf("%s 학생은 존재하지 않습니다.\n",searchName);
				}
				break;
			case 5: 
				// 종료
				stopFlag = true;
				System.out.println("종료합니다.");
				scan.close();
				break;
			default: 
				break;
			}
			
			
		}
		
		

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

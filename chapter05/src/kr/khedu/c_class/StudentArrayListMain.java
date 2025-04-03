package kr.khedu.c_class;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentArrayListMain {

	public static Scanner scan = new Scanner(System.in);
	public static final int COUNT = 3;
	public static String[] menu = {"","학생입력","학생출력","학생계산","학생검색","학생삭제","학생MAX","학생MIN","종료"};
	public static void main(String[] args) {
		// 변수 선언
		boolean stopFlag = false;
		// 객체 배열 (학생 3명)
		//Student[] stuArray = new Student[COUNT];
		/*** ArrayList<> => <>안에는 클래스만 와야한다. 래퍼(Wrapper)타입 ***/
		ArrayList<Student> stuList = new ArrayList<Student>();
		
		// 반복문
		while(!stopFlag) {
			// 입력 : 메뉴 선택
			menuPrint();
			
			// 제어문 : 1. 학생 정보 입력, 2. 학생 정보 출력, 3. 학생 정보 계산, 4. 학생 정보 검색, 5. 종료 
			int no = inputNo();
			
			switch(menu[no]) {
			case "학생입력": 
				// 입력 : 3명의 정보를 받는다
					System.out.printf("이름 입력 : ");
					String name = scan.nextLine();
					System.out.printf("나이 입력 : ");
					int age = Integer.parseInt(scan.nextLine());
					System.out.printf("성별 입력 : ");
					char gender  = (scan.nextLine().charAt(0));
					System.out.printf("국어 점수 입력 : ");
					int kor = Integer.parseInt(scan.nextLine());
					System.out.printf("영어 점수 입력 : ");
					int eng = Integer.parseInt(scan.nextLine());
					
					Student student = new Student(name, age, gender, kor, eng);
					stuList.add(student);
					//stuArray[i] = new Student(name, age, gender, kor, eng);
					
					System.out.println("입력 완료.");
				
				break;
			case "학생출력": 
				// 출력
				for(int i = 0; i < stuList.size(); i++) {
					System.out.println(stuList.get(i).toString());
				}
				break;
			case "학생계산": 
				// 계산 : 총점, 평균, 계산
				for(int i = 0; i < stuList.size(); i++) {
					int total = stuList.get(i).getKor() + stuList.get(i).getEng();
					stuList.get(i).setTotal(total);
					
					double avg = stuList.get(i).getTotal() / 2.0;
					stuList.get(i).setAvg(avg);
					
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
					
					stuList.get(i).setGrade(grade);
				}
				System.out.println("점수 계산 완료");
				break;
			case "학생검색": 
				// 검색
				System.out.print("검색할 학생 이름 : ");
				String searchName = scan.nextLine();
				boolean searchFlag = false;
				for(int i = 0; i < stuList.size(); i++) {
					if(stuList.get(i).getName().equals(searchName)) {
						System.out.println(stuList.get(i).toString());
						searchFlag = true;
					}
				}
				if (searchFlag == false) {
					System.out.printf("%s 학생은 존재하지 않습니다.\n", searchName);
				}
				break;
			/*case "학생정렬":
				// 정렬
				System.out.printf("정렬 오름차순(1)/내림차순(2) : ");
				int sort = Integer.parseInt(scan.nextLine());
				if(sort == 1) {
					// 오름차순
					Student imsi = null;
					for(int j = 0; j < stuList.size()-1; j++) {
						for(int i = 0; i < stuList.size()-(j+1); i++) {
							if(stuList.get(i).getTotal() > stuList.get((stuList.size()-1)-j).getTotal()) {
								imsi = stuList.get((stuList.size()-1)-j);
								stuList.get((stuList.size()-1)-j) = stuList.get(i);
								stuList.get(i) = imsi;
							}
						}
					}
					System.out.println("오름차순 정렬 완료");
				}else {
					// 내림차순
					Student imsi = null;
					for(int j = 0; j < stuList.size()-1; j++) {
						for(int i = 0; i < stuList.size()-(j+1); i++) {
							if(stuList.get(i).getTotal() < stuArray[(stuList.size()-1)-j].getTotal()) {
								imsi = stuArray[(stuList.size()-1)-j];
								stuArray[(stuList.size()-1)-j] = stuList.get(i);
								stuList.get(i) = imsi;
							}
						}
					}
					System.out.println("내림차순 정렬 완료");
				}
				break;*/
			case "학생삭제":
				System.out.print("삭제할 이름 입력 : ");
				String removeName = scan.nextLine();
				boolean removeFlag = false;
				for(int i = 0; i < stuList.size(); i++) {
					if (stuList.get(i).getName().equals(removeName)) {
						stuList.remove(i);
						removeFlag = true;
					}
				}
				if(removeFlag == false) {
					System.out.println("삭제할 학생이 존재하지 않습니다.");
				}else {
					System.out.println("삭제 완료!");
				}
				break;
			case "학생MAX":
				int max = Integer.MIN_VALUE;
				int index = -1;
				for(int i = 0; i < stuList.size(); i++) {
					if(stuList.get(i).getTotal() > max) {
						max = stuList.get(i).getTotal();
						index = i;
					}
				}
				System.out.printf("1등은 %s 입니다.\n",stuList.get(index));
				break;
			case "학생MIN":
				int min = Integer.MAX_VALUE;
				int index2 = -1;
				for(int i = 0; i < stuList.size(); i++) {
					if(stuList.get(i).getTotal() < min) {
						max = stuList.get(i).getTotal();
						index2 = i;
					}
				}
				System.out.printf("1등은 %s 입니다.\n",stuList.get(index2));
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
		System.out.println("★ \t5. 학생삭제\t ★");
		System.out.println("★ \t6. 학생MAX\t ★");
		System.out.println("★ \t7. 학생MIN\t ★");
		System.out.println("★ \t8. 종료\t\t ★");
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★");
		
		System.out.print("선택(1~8) > ");
	}
	
	public static int inputNo() {
        int choice = 0 ;

        while (true) {
             System.out.print("메뉴 번호 입력: ");
             String input = scan.nextLine();
             boolean isInputCheck = Pattern.matches("^[1-8]$", input);
             if(isInputCheck){
                 choice = Integer.parseInt(input);
                 break;
             }
             System.out.println("유효한 번호를 입력해주세요");
        }
        return choice;
    }
}
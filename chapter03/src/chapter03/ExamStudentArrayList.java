package chapter03;

import java.util.ArrayList;
import java.util.Scanner;

public class ExamStudentArrayList {
	public static final int COUNT = 1;

	public static void main(String[] args) {
		
		ArrayList<String> nameArr = new ArrayList<String>();
		ArrayList<Integer> ageArr = new ArrayList<Integer>();
		ArrayList<Character> genderArr = new ArrayList<Character>();
		ArrayList<Integer> korArr = new ArrayList<Integer>();
		ArrayList<Integer> engArr = new ArrayList<Integer>();
		ArrayList<Integer> totalArr = new ArrayList<Integer>();
		ArrayList<Double> avrArr = new ArrayList<Double>();
		ArrayList<String> gradeArr = new ArrayList<String>();
		boolean stopFlag = false;
		
		Scanner scan = new Scanner(System.in);
		
		while(!stopFlag) {
			menuPrint();
			
			int num = 0;
			num = Integer.parseInt(scan.nextLine());
			
			switch(num) {
			case 1: 
				// 1. 학생 입력
				while(true) {
					System.out.print("학생 이름 입력 : ");
					nameArr.add(scan.nextLine());
					System.out.print("학생 나이 입력 : ");
					ageArr.add(Integer.parseInt(scan.nextLine()));
					System.out.print("학생 성별 입력 : ");
					genderArr.add(scan.nextLine().charAt(0));
					System.out.print("국어 성적 입력 : ");
					korArr.add(Integer.parseInt(scan.nextLine()));
					System.out.print("영어 성적 입력 : ");
					engArr.add(Integer.parseInt(scan.nextLine()));
					
					char yn = 0;
					
					do {
						System.out.print("계속(y/n) : ");
						yn = scan.nextLine().charAt(0);
						if (yn == 'n' || yn == 'N' || yn == 'y' || yn == 'Y') {
							break;
						}
						System.out.println("y 또는 n을 입력해야 합니다.");
					}while(true);
					if(yn == 'n' || yn == 'N') {
						break;
					}
				}
				break;
			case 2: 
				// 2. 학생 출력
				for (int i = 0; i < nameArr.size();i++) {
					System.out.printf("| 학생 이름 : %s\t", nameArr.get(i));
					System.out.printf("| 학생 나이 : %d\t", ageArr.get(i));
					System.out.printf("| 학생 성별 : %c\t", genderArr.get(i));
					System.out.printf("| 학생 국어 : %d\t", korArr.get(i));
					System.out.printf("| 학생 영어 : %d\t", engArr.get(i));
					if (totalArr.isEmpty()) {
						System.out.printf("| 학생 총점 : %d\t", 0);
					}else {
						System.out.printf("| 학생 총점 : %d\t", totalArr.get(i));
					}
					if (avrArr.isEmpty()) {
						System.out.printf("| 학생 평균 : %.1f\t", 0.0);
					}else {
						System.out.printf("| 학생 평균 : %.1f\t", avrArr.get(i));
					}
					if (gradeArr.isEmpty()) {
						System.out.printf("| 학생 등급 : %s\n", 0);
					}else {
						System.out.printf("| 학생 등급 : %s\n", gradeArr.get(i));
					}
				}
				break;
			case 3: 
				// 3. 학생 계산
				for (int i = 0; i < nameArr.size();i++) {
					
					// 왜 에러가 나는 걸까 Index 0 out of bounds for length 0
					totalArr.add(korArr.get(i)+engArr.get(i));
					avrArr.add((double) totalArr.get(i)/2.0);
					
					if (avrArr.get(i) >= 95) {
						gradeArr.add(i, "A+");
					}else if(avrArr.get(i) >= 90) {
						gradeArr.add(i, "A");
					}else if(avrArr.get(i) >= 85) {
						gradeArr.add(i, "B+");
					}else if(avrArr.get(i) >= 80) {
						gradeArr.add(i, "B");
					}else if(avrArr.get(i) >= 75) {
						gradeArr.add(i, "C+");
					}else if(avrArr.get(i) >= 70) {
						gradeArr.add(i, "C");
					}else if(avrArr.get(i) >= 65) {
						gradeArr.add(i, "D+");
					}else if(avrArr.get(i) >= 60) {
						gradeArr.add(i, "D");
					}else {
						gradeArr.add(i, "F");
					}
				}
				break;
			case 4: 
				// 4. 학생 검색
				// 검색할 학생을 입력 > nameArr배열에서 해당 이름과 일치하는 학생 검색하여 true일 경우 > 정보 출력 > 계속여부 > 반복
				do {
					String searchName = "";
					System.out.print("검색할 학생 이름 : ");
					searchName = scan.nextLine();
					
					
					if(nameArr.contains(searchName)) {
						int index = nameArr.indexOf(searchName);
						
						System.out.printf("| 학생 이름 : %s\t", nameArr.get(index));
						System.out.printf("| 학생 나이 : %d\t", ageArr.get(index));
						System.out.printf("| 학생 성별 : %c\t", genderArr.get(index));
						System.out.printf("| 학생 국어 : %d\t", korArr.get(index));
						System.out.printf("| 학생 영어 : %d\t", engArr.get(index));
						if (totalArr.isEmpty()) {
							System.out.printf("| 학생 총점 : %d\t", 0);
						}else {
							System.out.printf("| 학생 총점 : %d\t", totalArr.get(index));
						}
						if (avrArr.isEmpty()) {
							System.out.printf("| 학생 평균 : %.1f\t", 0.0);
						}else {
							System.out.printf("| 학생 평균 : %.1f\t", avrArr.get(index));
						}
						if (gradeArr.isEmpty()) {
							System.out.printf("| 학생 등급 : %s\n", 0);
						}else {
							System.out.printf("| 학생 등급 : %s\n", gradeArr.get(index));
						}
					}
					
					
					char yn = 0;
					
					do {
						System.out.print("계속(y/n) : ");
						yn = scan.nextLine().charAt(0);
						if (yn == 'n' || yn == 'N' || yn == 'y' || yn == 'Y') {
							break;
						}
						System.out.println("y 또는 n을 입력해야 합니다.");
					}while(true);
					if(yn == 'n' || yn == 'N') {
						break;
					}
					
				}while(true);
				
				break;
			default: 
				// 5. 종료
				System.out.println("★★★★★★★★★ End ★★★★★★★★★");
				stopFlag = true;
				scan.close();
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

}

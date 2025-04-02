package chapter04;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentMain {

	public static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		
		// 1.학생성적프로그램 작성 (10명정도)
		// 학생정보: 이름, 나이, 성별, 국어, 영어, 총점, 평균, 등급 배열로 저장
		Student student = new Student();
		
		int num = 0;
		boolean stopFlag = false;

		while (!stopFlag) {
			menuDisplay();
			
			// 선택
			num = inputNo();
			
			switch (num) {
			
			case 1:
				// 이름 입력
				student.setName(inputName());
				// 나이 입력
				student.setAge(inputAge());
				// 성별 입력
				student.setGender(inputGender());
				
				// 점수 입력
				int kor = inputScore("국어");
				student.setKor(kor);
				int eng = inputScore("영어"); 
				student.setEng(eng);
				
				break;
			case 2:
				System.out.println(student.toString());
				break;
			case 3:
				int total = student.getKor() + student.getEng();
				student.setTotal(total);
				double avg = student.getTotal() / 2.0;
				student.setAvg(avg);
				
				double _avg = student.getAvg();
				
				if (100 >= _avg && _avg >= 95) {
					student.setGrade("A+");
				} else if (95 > _avg && _avg >= 90) {
					student.setGrade("A");
				} else if (90 > _avg && _avg >= 85) {
					student.setGrade("B+");
				} else if (85 > _avg && _avg >= 80) {
					student.setGrade("B");
				} else if (80 > _avg && _avg >= 75) {
					student.setGrade("C+");
				} else if (75 > _avg && _avg >= 70) {
					student.setGrade("C");
				} else if (70 > _avg && _avg >= 65) {
					student.setGrade("D+");
				} else if (65 > _avg && _avg >= 60) {
					student.setGrade("D");
				} else {
					student.setGrade("F");
				}
				System.out.println("점수 계산 완료");
				break;
			case 4:
				System.out.print("검색할 학생 이름입력: ");
				String search = s.nextLine();
				boolean isSearched = false;
				
				if (!isSearched) {
					System.out.println(search + "이름을 가진 학생을 찾을 수 없습니다.");
				}
				break;
			default:
				stopFlag = true;
				s.close();
				break;
			}
		}
		
		System.out.println("The End");
	}
	
	public static void menuDisplay() {
		// 메뉴생성(학생입력, 학생출력, 학생계산, 학생검색(이름))
		System.out.println("=================");
		System.out.println("1.학생정보 입력");
		System.out.println("2.학생정보 출력");
		System.out.println("3.학생점수 계산");
		System.out.println("4.학생검색");
		System.out.println("5.종료");
		System.out.println("=================");
	}
	
	public static int inputNo() {
		int choice = 0;
		while (true) {
			System.out.print("메뉴 번호 입력: ");
			String input = s.nextLine();
			boolean isInputCheck = Pattern.matches("^[1-5]$", input);
			if (isInputCheck) {
				choice = Integer.parseInt(input);
				break;
			}
			System.out.println("유효한 번호를 입력해주세요");
		}
		return choice;
	}
	
	
	// 점수 입력
	public static int inputScore(String subjectName) {
		int score = 0;
		while (true) {
			System.out.print(subjectName + " : ");
			String data = s.nextLine();
			boolean isInputCheck = Pattern.matches("^[0-9]{1,3}$", data);
			score = Integer.parseInt(data);
			if (isInputCheck && score <= 100) {
				break;
			}
			System.out.println("유효한 값을 입력해주세요");
		}
		return score;
	}
	
	// 이름 입력
	public static String inputName() {
		String name = null;
		while (true) {
			System.out.print("이름: ");
			name = s.nextLine();
			boolean isInputCheck = Pattern.matches("^[가-힣]{2,4}$", name);
			if (isInputCheck) {
				break;
			}
			System.out.println("유효한 값을 입력해주세요");
		}
		return name;
	}
	
	// 나이 입력
	public static int inputAge() {
		int age = 0;
		while (true) {
			System.out.print("나이: ");
			String data = s.nextLine();
			boolean isInputCheck = Pattern.matches("^[0-9]{1,3}$", data);
			if (isInputCheck) {
				age = Integer.parseInt(data);
				break;
			}
			System.out.println("유효한 값을 입력해주세요");
		}
		return age;
	}
	
	public static char inputGender() {
		char gender = ' ';
		while (true) {
			System.out.print("성별(m/f): ");
			String input = s.nextLine().toLowerCase();
			boolean isInputCheck = Pattern.matches("^[m,f]$", input);
			if (isInputCheck) {
				gender = input.charAt(0);
				break;
			}
			System.out.println("유효한 값을 입력해주세요");
		}
		return gender;
	}
}

package chapter03;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ExamPattrenGrade {

	public static void main(String[] args) {
		// 성명과 국어, 영어, 수학 점수를 입력 받아서 패턴 검색(잘못 입력되면 다시 입력 받기)
		// 총점, 평균, 등급(switch, else if 둘다 만들기) 대화식 무한 반복으로 이쁘게 만들기

		Scanner scan = new Scanner(System.in);

		while (true) {
			
			String name = null;
			int korScore = 0;
			int engScore = 0;
			int mathScore = 0;
			
			// 입력
			do {
				System.out.println("========================================");
				System.out.print("성명을 입력하시오 : ");
				name = scan.nextLine();
				boolean isNameCheck = Pattern.matches("^[가-힣]{2,4}$", String.valueOf(name));
				if(isNameCheck == true) {
					break;
				}
				System.out.println("한글 성명을 입력하시오!!");
			}while(true);
				
			do {
				System.out.print("국어 성적을 입력하시오 : ");
				korScore = Integer.parseInt(scan.nextLine());
				// 패턴 검색
				boolean isKorScoreCheck = Pattern.matches("^[0-9]{1,3}$", String.valueOf(korScore));
				if (isKorScoreCheck == true && korScore <= 100) {
					break;
				}
				System.out.println("정상적인 점수를 입력하시오!!");
			}while(true);

			
			do {
				System.out.print("영어 성적을 입력하시오 : ");
				engScore = Integer.parseInt(scan.nextLine());
				// 패턴 검색
				boolean isEngScoreCheck = Pattern.matches("^[0-9]{1,3}$", String.valueOf(engScore));
				if (isEngScoreCheck == true && engScore <= 100) {
					break;
				}
				System.out.println("정상적인 점수를 입력하시오!!");
			}while(true);

			do {
				System.out.print("수학 성적을 입력하시오 : ");
				mathScore = Integer.parseInt(scan.nextLine());
				// 패턴 검색
				boolean isMathScoreCheck = Pattern.matches("^[0-9]{1,3}$", String.valueOf(mathScore));
				if (isMathScoreCheck == true && mathScore <= 100) {
					// 정상 입력 시 반복문 빠져 나감.
					break;
				}
				System.out.println("정상적인 점수를 입력하시오!!");
			}while(true);
				
			
			
			// 연산, 출력
			System.out.printf("총점 : %.2f\n", (double)korScore+engScore+mathScore);
			System.out.printf("평균 : %.2f\n", (double)(korScore+engScore+mathScore)/3);

			
			char yn = 0;
			do {
				System.out.print("계속하시겠습니까?(y/n) : ");
				yn = scan.nextLine().charAt(0);
				if (yn == 'n' || yn == 'N' || yn == 'y' || yn == 'Y') {
					break;
				}
				System.out.println("정상적인 값을 입력하시오!!");
			}while(true);
			if(yn == 'n' || yn == 'N') {
				scan.close();
				break;
			}
			
			
			
			
//			do {
//				
//			}while(true);
			
			
			
			

//			if (score >= 90) {
//				grade = 'A';
//			} else if (score >= 80) {
//				grade = 'B';
//			} else if (score >= 70) {
//				grade = 'C';
//			} else if (score >= 60) {
//				grade = 'D';
//			} else {
//				grade = 'F';
//			}

		}
	}

}

package chapter03;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TestStudentScore {

	public static void main(String[] args) {
		// 입력
		Scanner scan = new Scanner(System.in);

		while (true) {

			String name = null;
			int kor = 0;
			int eng = 0;
			int math = 0;
			int sum = 0;
			double average = 0.0;
			char grade = 0;

			do {
				System.out.print("성명 : ");
				name = scan.nextLine();

				boolean isNameCheck = Pattern.matches("^[가-힣]{2,4}$", name);
				if (isNameCheck == true) {
					break;
				}
				System.out.println("정확히 입력하세요!!(2~4글자)");
			} while (true);

			do {
				System.out.print("국어 점수 : ");
				kor = Integer.parseInt(scan.nextLine());

				boolean isKorCheck = Pattern.matches("^[0-9]{1,3}$", String.valueOf(kor));
				if (isKorCheck == true) {
					break;
				}
				System.out.println("정확히 입력하세요!!(0~100)");
			} while (true);

			do {
				System.out.print("영어 점수 : ");
				eng = Integer.parseInt(scan.nextLine());

				boolean isEngCheck = Pattern.matches("^[0-9]{1,3}$", String.valueOf(eng));
				if (isEngCheck == true) {
					break;
				}
				System.out.println("정확히 입력하세요!!(0~100)");
			} while (true);

			do {
				System.out.print("수학 점수 : ");
				math = Integer.parseInt(scan.nextLine());

				boolean isMathCheck = Pattern.matches("^[0-9]{1,3}$", String.valueOf(math));
				if (isMathCheck == true) {
					break;
				}
				System.out.println("정확히 입력하세요!!(0~100)");
			} while (true);

			sum = kor + eng + math;
			average = (double) (kor + eng + math) / 3;

			if (average >= 90) {
				grade = 'A';
			} else if (average >= 80) {
				grade = 'B';
			} else if (average >= 70) {
				grade = 'C';
			} else if (average >= 60) {
				grade = 'D';
			} else {
				grade = 'F';
			}

			System.out.printf("%s 학생의 총점 : %d\n", name, sum);
			System.out.printf("%s 학생의 평균 : %.2f\n", name, average);
			System.out.printf("%s 학생의 등급 : %c\n", name, grade);

			char yn = 0;
			do {
				System.out.print("계속하시겠습니까?(y/n) : ");
				yn = scan.nextLine().charAt(0);
				if (yn == 'n' || yn == 'N' || yn == 'y' || yn == 'Y') {
					break;
				}
				System.out.println("정상적인 값을 입력하시오!!");
			} while (true);
			if (yn == 'n' || yn == 'N') {
				scan.close();
				break;
			}

		}

	}

}

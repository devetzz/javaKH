package chapter02;

import java.util.Scanner;

public class Exam10Energe {

	public static void main(String[] args) {
		// 변수 선언 및 입력
		Scanner scan = new Scanner(System.in);

		// 반복문 입력 (for : 카운트에따라 반복, while : 무한반복, do-while : 최초 1번은 무조건 실행)
		for (; true;) {

			// 값 체크
			int kg = 0;
			do {
				// 값 입력
				System.out.print("물체의 무게를 입력하시오(킬로그램) : ");
				kg = Integer.parseInt(scan.nextLine());
				System.out.print("kg");
				if (0 <= kg && kg <= Integer.MAX_VALUE) {
					break;
				}
				System.out.println("정신차려!");
			} while (true);

			int speed = 0;
			do {
				// 값 입력
				System.out.print("물체의 속도를 입력하시오(미터/초) : ");
				speed = Integer.parseInt(scan.nextLine());
				if (0 <= speed && speed <= Integer.MAX_VALUE) {
					break;
				}
				System.out.println("정신차려!");
			} while (true);
			
			// 하고자하는 내용을 실행하면 된다.
			double energe = 0.5 * (double)kg * Math.pow(speed, 2.0);
			
			System.out.printf("물체는 %.1f (줄)의 에너지를 가지고 있다.\n", energe);
			

			// 계속 진행 체크
			char yn = 0;
			do {
				// 값 입력
				System.out.print("계속(y/n) : ");
				yn = scan.nextLine().charAt(0);
				if (yn == 'n' || yn == 'N' || yn == 'y' || yn == 'Y')
					break;
				System.out.println("정신차려!");
			} while (true);

			if (yn == 'n' || yn == 'N') {
				scan.close();
				break;

			}
		}

	}

}

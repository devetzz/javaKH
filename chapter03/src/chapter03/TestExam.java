package chapter03;

import java.util.Scanner;

public class TestExam {

	public static void main(String[] args) {
		// 3장 8번 문제
		// 사용자로부터 구의 반지름을 입력 받아서 부피를 계산하여 출력하는 프로그램
		final double PI = 3.141592;
		Scanner scan = new Scanner(System.in);

		// 반복 시작
		while (true) {
			double r = 0.0;
			System.out.print("구의 반지름 : ");
			r = Double.parseDouble(scan.nextLine());
			// 반지름 값 확인
			do {
				if (0 <= r || r <= Double.MAX_VALUE) {
					break;
				}
			} while (true);
			
			// 계산
			double volume = 0.0;
			volume = 4.0 / 3.0 * PI * (Math.pow(r,3));
			System.out.printf("구의 부피 : %f\n", volume);
			
			
			// 계속 진행 여부 판단
			char yn = 0;
			do {
				System.out.print("계속하시겠습니까?(y/n) : ");
				yn = scan.nextLine().charAt(0);
				
				if (yn == 'y' || yn == 'Y' || yn == 'n' || yn == 'N') {
					break;
				}
				System.out.println("정상적인 값을 넣으세요!!");
			}while(true);
			
			if(yn == 'n' || yn == 'N') {
				scan.close();
				System.out.println("종료합니다.");
				break;
			}
			

		}

	}

}

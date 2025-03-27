package chapter02;

import java.util.Scanner;

public class LightDistance {

	public static void main(String[] args) {
		// 빛이 n일 동안 이동한 거리, 일 수 입력 받아서 결과 출력
		// 거리 = 속도 x 시간
		final double LIGHT_SPEED = 3e5; // 300000.0
		final int DAY_PER_SEC = 60 * 60 * 24; // 반복되는 연산은 상수 처리 해라!
		int day = 0;
		double distance = 0.0;
		boolean stopFlag = false;

		Scanner sc = new Scanner(System.in);

		for (; !stopFlag;) {

			do {
				System.out.print("일 수 입력 : ");
				day = Integer.parseInt(sc.nextLine());

				// 0 <= day <= 2^31-1 (Math.pow(2,31)-1)
				// 연산이 복잡하니 함수로 대체
				/*
				 * if (0 <= day && day <= (int) (Math.pow(2.0, 31.0) - 1.0)) { break; }
				 */
				if (0 <= day && day <= Integer.MAX_VALUE) {
					break;
				}

				System.out.println("((Warning))정확한 일 수를 입력하세요!!");
			} while (true);

			distance = LIGHT_SPEED * day * DAY_PER_SEC;
			System.out.printf("빛이 %d일 동안 이동한 거리는 %.2fKm 입니다.\n", day, distance);

			do {
				char yn = 0;
				System.out.print("계속하시겠습니까?(Y/N) : ");
				yn = (sc.nextLine()).charAt(0);
				if (yn == 'y' || yn == 'Y') {
					stopFlag = false;
					break;
				} else if (yn == 'n' || yn == 'N') {
					stopFlag = true;
					sc.close();
					break;
				} else {
					System.out.println("((Warning))y, Y, n, N 중에 입력하세요!!");
				}
			} while (true);

		}

		System.out.println("==========Finish==========");

	}

}

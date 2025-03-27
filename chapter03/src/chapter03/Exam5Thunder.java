package chapter03;

import java.util.Scanner;

public class Exam5Thunder {

	public static void main(String[] args) {
		// 사용자가 번개로부터 얼마나 멀리 떨어져 있는지를 계산하는 프로그램
		// 천둥은 공기를 통해 초당 약 340m를 이동한다.
		// 빛은 순간적으로 도착한다고 가정
		int time = 0;
		int distance = 0;
		final int THUNDER_SPEED = 340;
		Scanner scan = new Scanner(System.in);

		// 무한 반복문 시작
		while (true) {
			// 사용자로부터 입력 받기
			while (true) {
				System.out.print("시간 간격을 입력하시오(단위: 초) : ");
				time = Integer.parseInt(scan.nextLine());

				if (0 <= time || time <= Integer.MAX_VALUE) {
					break;
				} else {
					System.out.println("정상적인 시간을 입력하시오!!");
				}
			}

			// 거리 계산 및 출력
			distance = THUNDER_SPEED * time;
			System.out.printf("번개가 발생한 곳까지의 거리 : %dm\n", distance);

			// 계속 여부 확인
			char yn = 0;
			do {

				System.out.print("계속 하시겠습니까?(Y/N) : ");
				yn = scan.nextLine().charAt(0);

				if (yn == 'y' || yn == 'Y' || yn == 'n' || yn == 'N') {
					break;
				}
				System.out.println("정상적인 값을 입력하시오!!");

			} while (true);

			if (yn == 'n' || yn == 'N') {
				scan.close();
				System.out.println("====================Finish====================");
				break;
			}
		}

	}

}

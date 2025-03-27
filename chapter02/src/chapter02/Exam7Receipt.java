package chapter02;

import java.util.Scanner;

public class Exam7Receipt {

	public static void main(String[] args) {
		// 구입한 상품의 가격과 받은 금액을 입력하여 부가세와 잔돈을 출력하는 프로그램
		// 4단계 : 직접 입력 받아서 대화식 무한 반복을 통해 출력
		Scanner scan = new Scanner(System.in);

		// 반복 시작
		while (true) {
			// 입력
			int money = 0;
			int price = 0;
			do {
				System.out.print("받은 돈 : ");
				money = Integer.parseInt(scan.nextLine());
				
				if (0 <= money || money <= Integer.MAX_VALUE) {
					break;
				}
				System.out.println("정상적인 금액을 입력하세요!!");
			} while (true);
			
			do {
				System.out.print("상품 가격 : ");
				price = Integer.parseInt(scan.nextLine());
				
				if (0 <= price || price <= Integer.MAX_VALUE) {
					break;
				}
				System.out.println("정상적인 금액을 입력하세요!!");
			} while (true);
			
			// 연산
			
			// 출력
			if (money < price) {
				System.out.println("금액이 부족합니다.");
				// 계속 하시겠냐고 넘어가기
			}else {
				System.out.printf("부가세 : %d\n", price / 10);
				System.out.printf("잔돈 : %d\n", money - price);
			}
			
			char yn = 0;
			// 계속 여부 확인
			do {
				System.out.print("계속하시겠습니까?(y/n) : ");
				yn = scan.nextLine().charAt(0);
				
				if(yn == 'y' || yn == 'Y' || yn == 'n' || yn == 'N') {
					break;
				}
				System.out.println("n 또는 y만 입력하세요!!");
			}while(true);
			// n, N일 경우 종료
			if (yn == 'n' || yn == 'N') {
				System.out.println("====================Finish====================");
				scan.close();
				break;
			}
			
		}
	}
}

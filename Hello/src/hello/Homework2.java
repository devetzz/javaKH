package hello;

import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
		// 사용자로부터 두 개의 정수를 입력 받아서 합, 차, 평균, 큰 수, 작은 수 계산하여 출력
		int num1 =0;
		int num2 =0;
		boolean stopFlag = false;
		
		Scanner scan = new Scanner(System.in);
		
		// 대화식 무한 반복
		for( ; !stopFlag; ) {
			// 입력
			System.out.println("두 개의 정수를 입력하세요.");
			System.out.print("x : ");
			num1 = Integer.parseInt(scan.nextLine());
			System.out.print("y : ");
			num2 = Integer.parseInt(scan.nextLine());
			
			// 출력
			System.out.printf("투 수의 합 : %d\n", num1+num2);
			System.out.printf("투 수의 차 : %d\n", num1-num2);
			System.out.printf("투 수의 곱 : %d\n", num1*num2);
			System.out.printf("투 수의 평균 : %.1f\n", (double)(num1+num2)/2);
			if (num1 < num2) {
				System.out.printf("큰 수 : %d\n", num2);
				System.out.printf("작은 수 : %d\n", num1);	
			}else {
				System.out.printf("큰 수 : %d\n", num1);
				System.out.printf("작은 수 : %d\n", num2);
			}
			
			char yn = 0;
			System.out.print("계속 하시겠습니까?(y/n) : ");
			yn = (scan.nextLine().charAt(0));
			if (yn == 'y' || yn == 'Y') {
				stopFlag = false;
			}else {
				stopFlag = true;
				scan.close();
			}
		}
		
	}

}

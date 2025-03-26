package chapter01;

import java.util.Scanner;


public class CalculationInputFor {

	public static void main(String[] args) {
		// 입력
		int number1 = 0;
		int number2 = 0;
		boolean stopFlag = false;
		
		Scanner scan = new Scanner(System.in);

		// 반복
		for( ; !stopFlag; ) {
			System.out.print("Input nunber1 : ");
			number1 = Integer.parseInt(scan.nextLine());
			System.out.print("Input nunber2 : ");
			number2 = Integer.parseInt(scan.nextLine());
			// 연산
			
			// 출력
			System.out.printf("%d + %d = %d\n", number1, number2, number1 + number2);
			System.out.printf("%d - %d = %d\n", number1, number2, number1 - number2);
			System.out.printf("%d * %d = %d\n", number1, number2, number1 * number2);
			System.out.printf("%d / %d = %d\n", number1, number2, number1 / number2);
			
			char yn = 0;
			
			System.out.printf("계속 하시겠습니까? (y/n)");
			yn = (scan.nextLine()).charAt(0);
			if (yn == 'y' || yn == 'Y') {
				stopFlag = false;
			}else {
				stopFlag = true;
				scan.close();
			}
			//삼항연산자 (짧은 if문 대신 사용 가능)
			//stopFlag = (yn == 'y' || yn == 'Y')?(true):(false);
			
			System.out.println("==============================");
	
		}
		
		
		System.out.println("The end");
	}

}

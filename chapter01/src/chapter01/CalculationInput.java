package chapter01;

import java.util.Scanner;

public class CalculationInput {

	public static void main(String[] args) {
		// 입력
		int number1 = 0;
		int number2 = 0;
		
		Scanner scan = new Scanner(System.in);

		
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

		scan.close();
		System.out.println("The end");
	}

}

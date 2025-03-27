package chapter02;

import java.util.Scanner;

public class Temperature {

	public static void main(String[] args) {
		// 변수 선언 및 입력
		Scanner scan = new Scanner(System.in);
		double fahrenheit = 0.0;
		double celsius = 0.0;
//		double result = 0.0;

		// 반복문 입력 (for : 카운트에따라 반복, while : 무한반복, do-while : 최초 1번은 무조건 실행)
		while (true) {
			// 메뉴
			System.out.println("=====================================");
			System.out.println("1. 화씨->섭씨");
			System.out.println("2. 섭씨->화씨");
			System.out.println("=====================================");
			
			// 메뉴 번호 체크
			int no = 0;
			do {
				// 값 입력
				System.out.print("번호를 선택하시오: ");
				no = Integer.parseInt(scan.nextLine());
				if (1 <= no && no <= 2) {
					break;
				}
				System.out.println("정신차려!");
			} while (true);

			// 하고자하는 내용을 실행하면 된다.
			if(no == 1) {
				System.out.print("화씨온도를 입력하시오: ");
				fahrenheit = Double.parseDouble(scan.nextLine());
				celsius = (fahrenheit-32)/1.8;
				System.out.printf("화씨 %.2f를 섭씨로 변환한 값 : %.2f\n", fahrenheit, celsius);
			}else {
				System.out.print("섭씨온도를 입력하시오: ");
				celsius = Double.parseDouble(scan.nextLine());
				fahrenheit = 9.0/5.0*celsius + 32.0;
				System.out.printf("섭씨 %.2f를 화씨로 변환한 값 : %.2f\n", celsius, fahrenheit);
			}

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

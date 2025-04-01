package chapter04;

import java.util.Scanner;

public class CircleMain {

	public static void main(String[] args) {
		// 변수 선언(참조 타입)
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			Circle circle = new Circle();
			// 입력(반지름, 빨간색)
			System.out.print("반지름 입력 : ");
			double radius = Double.parseDouble(scan.nextLine());
			circle.setRadius(radius);
			
			System.out.print("색상 입력 : ");
			String color = scan.nextLine();
			circle.setColor(color);
			
			// 연산
			double area = circle.getArea();
			
			// 출력
			System.out.printf("반지름 : %.2f, 원의 면적 : %.2f, 원의 색상 : %s\n", circle.getRadius(), area, circle.getColor());
			
			// 계속 유무
			char yn = 0;
			do {
				// 값 입력
				System.out.print("계속(y/n)");
				yn = scan.nextLine().charAt(0);
				if(yn == 'n' || yn == 'N' || yn == 'y' || yn == 'Y')
					break;
				System.out.println("정신차려!");
			}while(true);
			
			if(yn == 'n' || yn == 'N') {
				scan.close();
				break;
				
			}
		}
		
		// 종료
		scan.close();
		System.out.println("End");

	}

}

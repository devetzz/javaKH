package chapter04;

import java.util.Scanner;

public class BoxMain {

	public static void main(String[] args) {
		// 변수 선언(참조 타입)
		Scanner scan = new Scanner(System.in);

		// 반복문
		while (true) {
			Box box = new Box();

			// 입력
			System.out.print("Input Width : ");
			int width = Integer.parseInt(scan.nextLine());
			box.setWidth(width);
			System.out.print("Input Width : ");
			int length = Integer.parseInt(scan.nextLine());
			box.setLength(length);
			System.out.print("Input Width : ");
			int height = Integer.parseInt(scan.nextLine());
			box.setHeight(height);

			// 출력
			System.out.printf("박스의 체적은 %d 입니다.\n", box.getWidth()*box.getLength()*box.getHeight());

			// 계속 유무
			char yn = 0;
			do {
				// 값 입력
				System.out.print("계속(y/n)");
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

		// 종료
		scan.close();
		System.out.println("End");

	}

}

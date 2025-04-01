package chapter04;

import java.util.Scanner;

public class DesktopLampMain {

	public static void main(String[] args) {
		// 변수 선언(참조 타입)
		Scanner scan = new Scanner(System.in);
		
		// 반복문
		while(true) {
			DesktopLamp desktopLamp = new DesktopLamp();

			// 캡슐화 정책 위반
			//desktoplamp.isOn() = false;
			
			
			// 입력(반지름, 빨간색)
			System.out.print("전원 On / Off : ");
			// 입력한 값 모두 대문자로 치환
			String onOff = scan.nextLine().toUpperCase();

			if(onOff.toUpperCase().equals("ON")) {
				desktopLamp.setOn(true);
			}else {
				desktopLamp.setOn(false);
			}
			
			// 출력
			System.out.printf("현재 램프의 상태는 %s 입니다.\n", String.valueOf(desktopLamp.getOn()));
			
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

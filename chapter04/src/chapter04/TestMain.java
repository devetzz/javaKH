package chapter04;

import java.util.Scanner;

public class TestMain {

	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 변수 선언
		boolean stopFlag = false;
		
		// 반복문
		while(!stopFlag) {
			// 입력 : 메뉴 선택
			
			
			// 제어문 : 1. 계좌 정보 입력, 2. 계좌 정보 출력, 3. 입금, 4. 인출, 5. 종료
			int no = 1;
			switch(no) {
			case 1: 
				// 입력 : 계좌 정보
				break;
			case 2: 
				// 출력 : 계좌 정보
				break;
			case 3: 
				// 입력 : 계좌 입금
				break;
			case 4: 
				// 입력 : 계좌 인출
				break;
			case 5: 
				// 반복문 : 종료
				stopFlag = true;
				break;
			default: 
				break;
			}
		
		
		}
		
		// 종료
		scan.close();
		System.out.println("End");
		
		
	}

}

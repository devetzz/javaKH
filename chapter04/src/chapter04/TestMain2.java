package chapter04;

import java.util.Scanner;

public class TestMain2 {

	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 변수 선언
		boolean stopFlag = false;
		// 반복문
		while(!stopFlag) {
			//입력 출력 연산
			int no = 1;
			switch(no) {
			case 1: 
				// 입력
				break;
			case 2: 
				// 출력
				break;
			case 3: 
				// 입금 
				break;
			case 4: 
				// 인출
				break;
			case 5: 
				// 종료
				stopFlag = true;
				scan.close();
				break;
			default: 
				break;
			}
			
		}
		
		// 종료
		System.out.println("End");
	}

}

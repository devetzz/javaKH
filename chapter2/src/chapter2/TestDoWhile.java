package chapter2;

import java.util.Scanner;

public class TestDoWhile {

	public static void main(String[] args) {
		char response = 0;
		boolean stopFlag = false;
		
		Scanner scan = new Scanner(System.in);
		// 반복문
		for( ; !stopFlag; ) {
			System.out.println("반복문을 실행중입니다.");
			boolean flag = false;
			do{
				System.out.print("종료하시겠습니까?(Y/N) : ");
				response = (scan.nextLine()).charAt(0);
				if(response == 'Y' || response == 'y') {
					stopFlag = true;
					flag = true;
					scan.close();
				}else if(response == 'N' || response == 'n') {
					stopFlag = false;
					flag = true;
				}else {
					System.out.println("장난치지마세요.");
				}
				
			}while(!flag);	
		}
		

	}
}
